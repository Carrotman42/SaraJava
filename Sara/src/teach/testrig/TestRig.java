package teach.testrig;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import teach.testrig.TestCase.Test;
import teach.testrig.testTypes.SaraQuestion;

public class TestRig {
   
   /**
    * @param args
    * @throws IOException
    * @throws IllegalAccessException
    * @throws InstantiationException
    * @throws ClassNotFoundException
    * @throws URISyntaxException
    */
   public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
      Hashtable<String, TestCase> ht = getTests("tests_and_solutions.txt");
      
      testTestCases(ht);
   }
   
   private static Hashtable<String, TestCase> getTests(String solFile) throws IOException {
      RandomAccessFile raf = new RandomAccessFile(new File(solFile), "r");
      Hashtable<String, TestCase> ret = new Hashtable<>();
      
      String questionClassName;
      while ((questionClassName = nextViableLine(raf)) != null) {
         String argtype = nextViableLine(raf);
         String restype = nextViableLine(raf);
         ArrayList<Test> tests = new ArrayList<>();
         
         String l;
         while (!(l = nextImmediateLine(raf)).equals("done")) {
            tests.add(new Test(TypeHelper.scan(argtype, l),
                  TypeHelper.scan(restype, nextImmediateLine(raf))));
         }
         
         ret.put(questionClassName, new TestCase(tests));
      }
      
      return ret;
   }
   
   /**
    * Same as nextViableLine(RandomAccessFile) but doesn't ignore empty lines.
    * 
    * @param r File to read
    * @return The next line that isn't a comment
    * @throws IOException
    */
   private static String nextImmediateLine(RandomAccessFile r) throws IOException {
      String l;
      
      while ((l = r.readLine()) != null && l.startsWith("//")) {
         //Reading file done in loop condition!
      }
      
      return l;
   }
   
   private static String nextViableLine(RandomAccessFile r) throws IOException {
      String l;
      
      while ((l = r.readLine()) != null && ((l = l.trim()).length() == 0 || l.startsWith("//"))) {
         //Reading file done in loop condition!
      }
      
      return l;
   }
   
   private static void testTestCases(Hashtable<String, TestCase> tests) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
      Enumeration<String> en = tests.keys();
      while (en.hasMoreElements()) {
         String name = en.nextElement();
         TestCase test = tests.get(name);
         
         test((SaraQuestion)Class.forName(name).newInstance(), name, test);
      }
   }
   
   private static void test(SaraQuestion q, String name, TestCase test) {
      if (q.testSolution()) {
         System.out.println("About to test class \"" + name + "\":");
         int passed = test.test(q, true);
         System.out.println("\n\tPassed " + passed + "/" + test.testCount());
      }else{
         System.out.println("Skipped question \"" + name + "\"");
      }
   }
   
   @SuppressWarnings("unused")
   private static void testAllClasses(Hashtable<String, TestCase> tests) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, URISyntaxException {
      Class<SaraQuestion>[] clazzez = TestRig.<SaraQuestion>getClasses("teach.solve_these");
      
      for (Class<SaraQuestion> clazz : clazzez)  {
         SaraQuestion q = clazz.newInstance();

         String name;
         TestCase test = tests.get(name = clazz.getName());
         if (test == null) {
            System.out.println("Error: Could not find test case for class \"" + name + "\"\n\tIgnoring this solution.");
         }else{
            test(q,name,test);
         }
      }
   }
   
   
   /**
    * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
    *
    * @param packageName The base package
    * @return The classes
    * @throws ClassNotFoundException
    * @throws IOException
    * @throws URISyntaxException
    */
   @SuppressWarnings("unchecked")
   private static <E> Class<E>[] getClasses(String packageName)
         throws ClassNotFoundException, IOException, URISyntaxException {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      assert classLoader != null;
      String path = packageName.replace('.', '/');
      Enumeration<URL> resources = classLoader.getResources(path);
      List<File> dirs = new ArrayList<File>();
      while (resources.hasMoreElements()) {
         URL resource = resources.nextElement();
         dirs.add(new File(resource.toURI()));
      }
      ArrayList<Class<E>> classes = new ArrayList<Class<E>>();
      for (File directory : dirs) {
         classes.addAll(TestRig.<E>findClasses(directory, packageName));
      }
      return classes.toArray((Class<E>[])new Class[classes.size()]);
   }
   
   /**
    * Recursive method used to find all classes in a given directory and subdirs.
    *
    * @param directory   The base directory
    * @param packageName The package name for classes found inside the base directory
    * @return The classes
    * @throws ClassNotFoundException
    */
   @SuppressWarnings("unchecked")
   private static <E> List<Class<E>> findClasses(File directory, String packageName) throws ClassNotFoundException {
      List<Class<E>> classes = new ArrayList<Class<E>>();
      if (!directory.exists()) {
         return classes;
      }
      File[] files = directory.listFiles();
      for (File file : files) {
         if (file.isDirectory()) {
            assert !file.getName().contains(".");
            classes.addAll(TestRig.<E>findClasses(file, packageName + "." + file.getName()));
         } else if (file.getName().endsWith(".class")) {
            classes.add((Class<E>)Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
         }
      }
      return classes;
   }
}
