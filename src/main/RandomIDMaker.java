package main;

import java.util.*;

public class RandomIDMaker {
	
	public static HashSet<Integer> storedIDs = new HashSet<Integer>();
	
	private final int MAX_VALUE = 999999;
	private final int MIN_VALUE = 0;
	
	public int generateIDNumber(){
	    double x = (Math.random() * ((MAX_VALUE - MIN_VALUE) + 1)) + MIN_VALUE;
	    int finalID = (int) Math.floor(x);
	    
	    // Regenerate if ID exists
	    while (RandomIDMaker.storedIDs.contains(finalID)) {
	    	x = (Math.random() * ((MAX_VALUE - MIN_VALUE) + 1)) + MIN_VALUE;
		    finalID = (int) Math.floor(x);
	    }
	    
	    RandomIDMaker.storedIDs.add(finalID);
	    return (int) Math.floor(x);
	}
	
	public void removeIDNumber(int id) {
		RandomIDMaker.storedIDs.remove(id);
	}
}
