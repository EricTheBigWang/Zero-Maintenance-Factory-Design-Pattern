package main;

import factory.Factory;
import factory.Product;

/**
 * A zero maintenance factory design pattern.
 * 
 * How to use:
 *     Define a class inside the factory.product package. 
 *     The class inherits from product.
 *     Create the object in the main class.
 *     run Main.java
 * 
 * Sample exercise:
 *     The Cabbage class doesn't exist.
 *     Create a Cabbage class inside the factory package. 
 *     The Cabbage inherits from product.
 *     After, the code runs flawlessly.
 * 
 * @author Wang Yi Feng
 */

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
