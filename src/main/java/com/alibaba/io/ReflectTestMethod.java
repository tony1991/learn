/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.io;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类ReflectTestMethod.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月12日 下午5:22:59
 */
public class ReflectTestMethod {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		ReflectTestModuleClass reflectTestModuleClass = new ReflectTestModuleClass();
		// 反射首先都必须得到对象的class
		// 获取对象的类
		Class checkUpdateClass = reflectTestModuleClass.getClass();
		System.out.println("获取实例对象所属类的类名------------------------------");
		System.out.println("CheckUpdate 的类名：" + checkUpdateClass);
		// 获取类的所有方法
		Method[] methods = reflectTestModuleClass.getClass()
				.getDeclaredMethods();
		System.out.println("获取实例对象所属类的所有方法------------------------------");
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		// 获取所有属性
		Field[] fields = reflectTestModuleClass.getClass().getDeclaredFields();
		System.out.println("获取实例对象所属类的属性------------------------------");
		for (Field field : fields) {
			System.out.println(field.getName());

		}
		// 获取名为str1的属性
		try {
			Field field = reflectTestModuleClass.getClass().getDeclaredField(
					"str1");
			System.out.println("获取实例对象所属类的某个属性------------------------------");
			System.out.println(field.getName());
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 获取所有annotations
		Annotation[] annotations = reflectTestModuleClass.getClass()
				.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("获取实例对象所属类的注解------------------------------");
			System.out.println(annotation.toString());
		}
		// 创建新实例
		Constructor constructor;
		try {
			constructor = reflectTestModuleClass.getClass().getConstructor();
			Object obj = constructor.newInstance();
			System.out.println("创建一个新的实例------------------------------");
			System.out.println(obj.toString());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 反射调用类的方法-通过类名和参数
		Class ownerClass = reflectTestModuleClass.getClass();// 首先还是必须得到这个对象的Class。
		try {
			Method method = ownerClass.getMethod("method1");// 调用无参方法
			System.out.println(method.isAccessible());
			method.invoke(reflectTestModuleClass, null);
			// 反射调用类的方法-通过参数
			Method method2 = ownerClass.getMethod("method3", String.class);
			method2.invoke(reflectTestModuleClass, "has args");
			// 反射射调用类的静态方法
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 反射加载类
		try {
			Class load = Class
					.forName("com.alibaba.io.ReflectTestModuleClass");
			ReflectTestModuleClass rtmc = (ReflectTestModuleClass) load
					.newInstance();
			rtmc.method1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
