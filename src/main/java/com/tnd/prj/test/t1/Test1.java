package com.tnd.prj.test.t1;

public class Test1 {
    public static void main(String[] args) {
        // feature/20241121 modified this file.
    	
    	// conflicts will occur
        // feature/test modified this file.
    	String test1 = "test1";
    	String test2 = "test2";
    }
    
    public void test() {
    	System.out.println("feature/test modified this file");
    	// test1
    }

    public static void test01() {
        System.out.println("Hello World");
    }

    public static void test02() {
        System.out.println("Hello World");
    }

    public static void test03() {
        System.out.println("Hello World");
    }

    public static void test04() {
        System.out.println("Hello World feature/20241127");
    }
}
