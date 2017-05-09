/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.io;

/**
 * 类ReflectTestModuleClass.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月12日 下午5:23:16
 */
public class ReflectTestModuleClass {

	private String str1 = "the first string";
	private String str2;

	public void method1() {
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}

	public void method3(String method3) {
		System.out.println(method3);
	}

	public static void method4() {
		System.out.println("method4");
	}

}
