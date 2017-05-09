package com.alibaba.classload;

/**
 * 类LoaderTest.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年7月18日 上午11:14:43 测试类，
 * 
 * 1.LoaderTest默认构造函数会设置AppClassLoader为parent，
 * 测试时执行loadClass1方法会发现HighRichHandsome类是委托AppClassLoader加载的，所以AppClassLoader可以访问到，不会出错；
 * 执行loadClass2方法就会发生错误，因为我们直接使用MyClassLoader加载HighRichHandsome类，而不是委托给parent加载， 
 * 根据class loader命名空间规则
 * （简单来讲，每个class loader都有自己唯一的命名空间，每个class loader 只能访问自己命名空间中的类，
 * 如果一个类是委托parent加载的，那么加载后，这个类就类似共享的，parent和child都可以访问到这个类，
 * 因为parent是不会委托child加载类的，所以child加载的类parent访问不到），
 * 子加载器的命名空间包含了parent加载的所有类，反过来则不成立，
 * LoaderTest类是AppClassLoader加载的，所以其看不见由MyClassLoader加载的HighRichHandsome类，
 * 但Person接口是可以访问的，所以赋给Person类型不会出错。
 * 
 * 2.一个class可以被不同的class loader重复加载，但同一个class只能被同一个class loader加载一次，
 */
public class LoaderTest {

    public static void main(String[] args) throws Exception {
        // 加上param -verbose
        System.out.println("HelloWorld!");
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * 查看父类加载器
     */
    private static void test1() {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类装载器:" + appClassLoader);
        ClassLoader extensionClassLoader = appClassLoader.getParent();
        System.out.println("系统类装载器的父类加载器——扩展类加载器:" + extensionClassLoader);
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println("扩展类加载器的父类加载器——引导类加载器:" + bootstrapClassLoader);
    }
    
    /**
     * 父类classloader
     * @throws Exception
     */
    private static void test2() throws Exception{
        MyClassLoader loader = new MyClassLoader();
        Class<?> c = loader.loadClass("com.alibaba.classload.HighRichHandsome");
        System.out.println("Loaded by :" + c.getClassLoader());

        Person p = (Person) c.newInstance();
        p.say();

        HighRichHandsome man = (HighRichHandsome) c.newInstance();
        man.say();    
    }
    /**
     * 自己的classloader
     * @throws Exception
     */
    private static void test3() throws Exception{
        MyClassLoader loader = new MyClassLoader();
        Class<?> c = loader.findClass("com.alibaba.classload.HighRichHandsome");
        System.out.println("Loaded by :" + c.getClassLoader());
        
        Person p = (Person) c.newInstance();
        p.say();
        
        //注释下面两行则不报错
        HighRichHandsome man = (HighRichHandsome) c.newInstance();
        man.say();    
    }
    
    /**
     * 对象只加载一次，返回true
     */
    private static void test4() {
        ClassLoader c1 = LoaderTest.class.getClassLoader();
        LoaderTest loadtest = new LoaderTest();
        ClassLoader c2 = loadtest.getClass().getClassLoader();
        System.out.println("c1.equals(c2):"+c1.equals(c2));
    }

}
