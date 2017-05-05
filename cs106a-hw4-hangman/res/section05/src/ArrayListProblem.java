/*
 * CS 106A, Section 5 Pre-section problem
 */

import acm.program.*;
import java.util.*;

public class ArrayListProblem extends ConsoleProgram {
	public void run() {
		ArrayList<Double> list1 = new ArrayList<Double>();
		list1.add(1.0);
		list1.add(3.0);
		list1.add(2.5);
		list1.add(5.0);
		list1.add(-4.0);
		list1.add(7.5);
		double mean1 = mean(list1);
		println("Mean 1 is " + mean1);   // should be 2.5
		
		ArrayList<Double> list2 = new ArrayList<Double>();
		list2.add(82.54);
		list2.add(13.68);
		list2.add(664.75);
		list2.add(-25.0);
		list2.add(0.0);
		list2.add(82.54);
		list2.add(0.0001);
		list2.add(9999.99);
		list2.add(106.0);
		list2.add(-3.33);
		double mean2 = mean(list2);
		println("Mean 2 is " + mean2);   // should be 1092.11701
		
		ArrayList<Double> list3 = new ArrayList<Double>();
		list3.add(42.5);
		double mean3 = mean(list3);
		println("Mean 3 is " + mean3);   // should be 42.5
		
		ArrayList<Double> empty = new ArrayList<Double>();
		double mean4 = mean(empty);
		println("Mean 4 is " + mean4);   // should be 0.0
	}
	
	public double mean(ArrayList<Double> list) {
		double mean = 0.0;
		double sum = 0.0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		if (list.size() > 0) {
		mean = sum / list.size();
		} else {
			mean = 0.0;
		}
		return mean;
	}
	
}