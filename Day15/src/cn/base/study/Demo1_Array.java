package cn.base.study;

import cn.base.bean.Student;

public class Demo1_Array {
	public static void main(String[] args) {
		// int[] arr=new int[5]; 基本数据类型数组
		Student[] students = new Student[50]; // 引用类型数组
		students[0] = new Student("wang", 20);
		students[1] = new Student("chen", 36);
		students[2] = new Student("hua", 50);
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
		System.out.println("okay");
	}
}
