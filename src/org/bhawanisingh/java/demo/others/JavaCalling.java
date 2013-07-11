package org.bhawanisingh.java.demo.others;

/**
 * Class to show how objects are passed in function while calling.
 * In java, the objects are passed neither by call by value nor call by reference.
 * They are passed by "Passing the value of reference ID of the object".
 * Thats why java shows some weird behavior (if you are coming from c & c++ then this behavior is
 * surely weird) in function calling.
 * In order to understand java passes the value(copy) of the memory address (reference ID) where
 * object is stored. If the changes are made on the object the the changes will be reflected to the
 * main object. If the variable holding the copy of reference ID of the object gets the reference ID
 * of another object then the changes made will not affect the original object.
 * 
 * This behavior of java's function invocation is simulated in this class. Please watch and compare
 * the different parts of the output carefully in order to understand.
 */

public class JavaCalling {

	private String name;
	private int code;

	/**
	 * Default constructor
	 */
	public JavaCalling() {
		this.name = "Bhawani";
		this.code = 99;
	}

	public JavaCalling(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public void callByReference(JavaCalling calling) {
		System.out.println("\n\nName is : " + calling.name + "\t Code is : " + calling.code + "\n Object is :" + calling);
		calling.name = "Call By Reference";
		calling.code = 40;
		System.out.println("\nName is : " + calling.name + "\t Code is : " + calling.code + "\n Object is :" + calling);
	}

	public void callByValue(JavaCalling calling) {
		System.out.println("\n\nName is : " + calling.name + "\t Code is : " + calling.code + "\n Object is :" + calling);
		calling = new JavaCalling("Call By Value", 45);
		System.out.println("\nName is : " + calling.name + "\t Code is : " + calling.code + "\n Object is :" + calling);
	}

	public static void main(String[] args) {
		JavaCalling javaCalling = new JavaCalling();
		System.out.println("Original Values are :");
		System.out.println("Name is : " + javaCalling.name + "\t Code is : " + javaCalling.code + "\n Object is :" + javaCalling);

		System.out.println("\n\nValues Before callByValue() Invocation :");
		System.out.println("Name is : " + javaCalling.name + "\t Code is : " + javaCalling.code + "\n Object is :" + javaCalling);

		javaCalling.callByValue(javaCalling);

		System.out.println("\n\nValues After callByValue() Invocation :");
		System.out.println("Name is : " + javaCalling.name + "\t Code is : " + javaCalling.code + "\n Object is :" + javaCalling);

		System.out.println("\n\nValues Before callByReference() Invocation :");
		System.out.println("Name is : " + javaCalling.name + "\t Code is : " + javaCalling.code + "\n Object is :" + javaCalling);

		javaCalling.callByReference(javaCalling);

		System.out.println("\n\nValues After callByReference() Invocation :");
		System.out.println("Name is : " + javaCalling.name + "\t Code is : " + javaCalling.code + "\n Object is :" + javaCalling);
	}

}
