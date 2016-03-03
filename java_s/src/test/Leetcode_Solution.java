package test;
import java.util.*;
public class Leetcode_Solution {
	public static boolean containDuplicate(int[] nums){
		HashSet<Integer> numbers=new HashSet<Integer>();
		for(int i:nums){
			if(!numbers.add(i)){return true;}
		}
		return false;
		
	}
	
	public static void main (String[] args) {
		int[] nums={12,2,3,12,4,5};
		
		boolean x=containDuplicate(nums);
		System.out.println(x);
		
	}
}
