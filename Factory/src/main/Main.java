package main;

import factory.Factory;
import factory.Product;

public class Main {
	public static void main(String[] args) {		
		Factory.getInstance();
		Product p1 = Factory.createProduct("Apple");
		Product p2 = Factory.createProduct("Orange");
		Product p3 = Factory.createProduct("Banana");
		Product p4 = Factory.createProduct("Cabbage");
		
		System.out.println(p1.getClass());
		System.out.println(p2.getClass());
		System.out.println(p3.getClass());
		System.out.println(p4.getClass());
	}
}
