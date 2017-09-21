package lab1final;


/**
 * CS 2003 - Lab 1
 * Code to find the maximum integer in a given file
 * NOTE:
 * there are bugs including those causing compilation errors and
 * resulting in runtime logical problems
 *
 * @Jaime Nunez
 * @8/31/17
 * @Version 1
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

//This lab is also associated with Lab 4
//This is because it has been uploaded to GitHub
//This is a test to make sure it worked
public class Lab1a {
    
    /**stores the data retrived from the file */
    Vector <Integer> intVector; 
    /** variable used to compute the run-time */
    long startTime, endTime, totalTime;
    /** Constructor: computes the running time and call readFile
     * method
     */
    public Lab1a() {
	startTime = System.currentTimeMillis();
	readFile();
	endTime = System.currentTimeMillis();    
	totalTime = endTime - startTime;
	System.out.println("total time taken: " + totalTime + " milliseconds");
    }

    /* Method description here */
    public void readFile() {
	try {
	    File inputFile = new File("Lab1a.dat");
	    Scanner input = new Scanner(inputFile);
	    intVector = new Vector<Integer>();
	    //initialize all of the variables you will use in the readFile method
	    int max = 0;
	    int elt = 0;
	    int count=0;
	    // store all elements in a vector
	    //while the input file has another integer
	    //while ((elt = input.nextInt())!= null) {
	    while (input.hasNextInt()){
	    	elt = input.nextInt();
	    	count++;
	    	intVector.addElement(elt);
	    }
	    // print on the terminal each elements of intVector
	    System.out.printf("There are %d integers in the input file:\n",count);
	    for (int value: intVector)
	    {
	    	System.out.printf("%d ",value);
		    System.out.println(); //after each value is printed, go to a new line
	    }
		
	    
	    // Find the max   
	    for(int i=0;i<intVector.size();i++){ //should start with increment 0 
	    	int value=intVector.get(i);
	    	if(value > max) //if value is larger than the previous max, it should become the new max
	    		max = value;
	    }

	    //output results
	    System.out.printf("The maximum integer in the input file is %d\n",max);
	    input.close();
	} 
	catch (IOException e) {
	    System.err.println("IOException in reading input file!!!");
	}	
    } //end readFile()
    
    /** main : creates an Object Lab1a */
    public static void main(String args[]) {
	Lab1a elLab = new Lab1a();
    } //end main
    
} //end class Lab1a
