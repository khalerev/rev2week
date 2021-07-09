package com.kha.abstract_classescom.kha.abstract_test;

import com.kha.abstract_classes.Person;
import com.kha.abstract_classes.Developer;

public class TestPerson {
	public static void main(String[] args) {
		Person adam = new Developer();
		
		adam.setName("Adam");
		System.out.println(adam.getName());
	}
}
