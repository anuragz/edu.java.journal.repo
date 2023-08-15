package edu.java.journal.basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		//array 
		Integer[] nums = {1,2,3,4,5};		
		Stream<Integer> arrStreams = Arrays.stream(nums);
				
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		System.out.println("Original list:"+ numbers);
					
		Stream<Integer> myStream = numbers.stream();
		Optional<Integer> minVal = myStream.min(Integer::compare);
		
		if(minVal.isPresent()) {
			System.out.println("Min value:"+ minVal.get());
		}
		
		myStream = numbers.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if(maxVal.isPresent()) {
			System.out.println("Max value:"+ maxVal.get());
		}
		
		myStream = numbers.stream();
		List<Integer> l = myStream.sorted().collect(Collectors.toList());
		System.out.println(l);
	}
}
