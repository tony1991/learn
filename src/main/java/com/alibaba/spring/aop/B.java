package com.alibaba.spring.aop;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * 类B.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年7月12日 下午4:49:51
 * JBOSS采用的好像是javassist http://jetway.iteye.com/blog/475306
 * http://www.ibm.com/developerworks/cn/java/j-dyn0916/ 
 * Javassist 使用 javassist.ClassPool 类跟踪和控制所操作的类，类似于JVM的ClassLoader
 * http://blog.csdn.net/luanlouis/article/details/24589193 好文
 */
public class B {

    public static void main(String[] args) {
        try {
            createClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
         * try { updateClass(); } catch (Exception e) { e.printStackTrace(); }
         */
    }

    private static void updateClass() throws Exception {
        // A a = new A();
        // a.method();
        // 用于取得字节码类，必须在当前的classpath中，使用全称
        CtClass ctClass = ClassPool.getDefault().get("com.alibaba.test.Aop.A");
        // 需要修改的方法名称
        String mname = "method";
        CtMethod mold = ctClass.getDeclaredMethod(mname);
        // 修改原有的方法名称
        String nname = mname + "$impl";
        mold.setName(nname);
        // 创建新的方法，复制原来的方法
        CtMethod mnew = CtNewMethod.copy(mold, mname, ctClass, null);
        // 主要的注入代码
        StringBuffer body = new StringBuffer();
        body.append("{\nlong start = System.currentTimeMillis();\n");
        // 调用原有代码，类似于method();($$)表示所有的参数
        body.append(nname + "($$);\n");
        body.append("System.out.println(\"Call to method " + mname
                    + " took \" +\n (System.currentTimeMillis()-start) + " + "\" ms.\");\n");

        body.append("}");
        // 替换新方法
        mnew.setBody(body.toString());
        // 增加新方法
        ctClass.addMethod(mnew);
        // 类已经更改，注意不能使用A a=new A();，因为在同一个classloader中，不允许装载同一个类两次
        A a = (A) ctClass.toClass().newInstance();
        a.method();
    }

    private static void createClass() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        // 创建Programmer类
        CtClass cc = pool.makeClass("com.alibaba.Programmer");
        // 定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        // 插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        // 保存生成的字节码
        cc.writeFile("/Users/tony/javassistTest");
    }
}
