package lab1final;

/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @Jaime Nunez
 * @8/31/17
 * @Version 1
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

/**
 * @author jin418
 *
 */
public class Lab1b {
    
    // data members
	//to calculate an average i need the total value and number of values in the average calculation
	double totalSum = 0;
	double average = 0;
	double currentValue = 0;
	int totalElements = 0;
	//Vector to store the data from Lab1b.data
	Vector <Double> doubleVector;

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file "<code>filename</code>" and computes the
     * average of the elements.
     @param filename name of the file containing doubles.
    */
    public Lab1b(String filename) {
	readFile(filename);
    }

    /** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file 
     * @param filename name of the file containing the doubles 
     */
    public void readFile(String filename) {
    	//  -- TO COMPLETE -- Method description here 
    	//This reads in the doubles from the file, puts it into a vector and calculate the average of all the values
    	// Using Lab1a readFile method as inspiration
    try{
    	File inputFile = new File("Lab1b.dat");
    	Scanner readTheInputs = new Scanner(inputFile);
    	doubleVector = new Vector<Double>();
    	
    	while(readTheInputs.hasNextDouble()){
    		currentValue = readTheInputs.nextDouble();
    		doubleVector.addElement(currentValue);
    		//totalSum += currentValue;
    		totalElements++;
    	}
    	
	    // print on the terminal each elements of intVector
	    System.out.printf("There are %d doubles in the input file:\n",totalElements);
	    for (double value: doubleVector)
	    {
	    	System.out.printf("%f ",value);
		    System.out.println(); //after each value is printed, go to a new line
	    }
		
	    
	    // Find the average   
    	//average = (totalSum/totalElements);
	    //Below is a reminder of what the instance variables I can work with are
		//double totalSum = 0;
		//double average = 0;
		//double currentValue = 0;
		//int totalElements = 0;
	    for(int i=0;i<doubleVector.size();i++){ //should start with increment 0 
	    	currentValue = doubleVector.get(i);
	    	totalSum += currentValue;
	    }
	    average = (totalSum/totalElements);

	    //output results
	    System.out.printf("The average of all the values in the input file is %f\n",average);
	    readTheInputs.close();
    }
    catch (IOException e){
	    System.err.println("IOException in reading input file!!!");
	}//end readFile()
    }
    	

    
/*    	This was my initial attempt to read the file and calculate the average
 * 		Scanner readTheInputs = new Scanner(filename);
    	//for(int i = 0; i < how many tokens in file; i++)
    	{
    		double value = readTheInputs.nextDouble();
    		totalSum += value; 
    		totalElements++;
    	}
    	readTheInputs.close();
    	average = (totalSum/totalElements);
    } //end readFile()
*/    
    

    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String args[]) {
    	//This was my original attempt at Lab1b getting the user to ask for the input
		//Scanner console = new Scanner(System.in);
		//System.out.print("Please enter the name of the data file: ");
		//String fileName = console.next();
		//args[0] = fileName;
		//console.close();
		//Lab1b theLab = new Lab1b("Lab1b.dat");
		// EMAIL QUESTIONS TO TA @ niushuonan@126.com
		
    //Don't need the constructor because it will execute in the else statement
	//Lab1b theLab = new Lab1b(fileName);
	if (args.length == 0)
	{
	    System.err.println("enter the data file name!");
	    
	}
	else
		//the constructor arguments type is String so are we passing a reference to the file name
	    new Lab1b(args[0]);
    } //end main
    
} //end class Lab1b
