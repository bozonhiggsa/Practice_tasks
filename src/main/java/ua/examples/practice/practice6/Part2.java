package ua.examples.practice.practice6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
	
	private static final int MAX_ELEMENTS = 10_000;
	private static final int K = 7;
	
	public static void remove1(List<Object> list, int k) {

		int number = k;
		while(list.size() > 1){
			int tempSize = list.size();
			while(true){
				if(number >= tempSize){
					number = number - tempSize;
					break;
				}
				list.set(number, null);
				number = number + k;
			}
			for(int n = (tempSize - 1); n >= 0; n--){
				if(list.get(n) == null){
					list.remove(n);
				}
			}
		}
	}
	
	public static void remove2(List<Object> list, int k) {

		int number = k;
		while(list.size() > 1){
			Iterator<Object> iterator = list.iterator();
			int tempSize = list.size();
			while(true){
				if(number >= tempSize){
					number = number - tempSize;
					break;
				}
				list.set(number, null);
				number = number + k;
			}
			while(iterator.hasNext()){
				if(iterator.next() == null){
					iterator.remove();
				}
			}
		}
	}
	
	public static List<Object> init(List<Object> list) {

		for(int i = 0; i < MAX_ELEMENTS; i++){
			list.add(new Object());
		}
		return list;
	}
	
	public static void main(String[] args) {

		List<Object> arrayList = init(new ArrayList<>());
		List<Object> linkedList = init(new LinkedList<>());

		System.out.println("=========== Indexed");
		long start1 = System.currentTimeMillis();
		remove1(arrayList, K);
		long stop1 = System.currentTimeMillis();
		System.out.println("Time for ArrayList = " + (stop1 - start1));

		long start2 = System.currentTimeMillis();
		remove1(linkedList, K);
		long stop2 = System.currentTimeMillis();
		System.out.println("Time for LinkedList = " + (stop2 - start2));
		
		System.out.println("=========== Iterable");
		arrayList = init(new ArrayList<>());
		linkedList = init(new LinkedList<>());

		long start3 = System.currentTimeMillis();
		remove2(arrayList, K);
		long stop3 = System.currentTimeMillis();
		System.out.println("Time for ArrayList = " + (stop3 - start3));

		long start4 = System.currentTimeMillis();
		remove2(linkedList, K);
		long stop4 = System.currentTimeMillis();
		System.out.println("Time for LinkedList = " + (stop4 - start4));
	}
}