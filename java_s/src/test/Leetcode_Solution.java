package test;
import java.util.*;
public class Leetcode_Solution {
	public static boolean containDuplicate(int[] nums){
		HashSet<Integer> numbers=new HashSet<Integer>();
		for(int i:nums){
			if(!numbers.add(i)){return true;}
		}
		return false;
		//�ж�һ���������Ƿ����ظ�����
	}
	
	
	public static int titleToNumber(String s) {
		int result = 0; 
		for (int i = 0; i < s.length(); i++) 
		{ result = result * 26 + (s.charAt(i) - 'A' + 1); } 
		return result;
		//��һ��26���Ƶ���ת��Ϊʮ���Ƶ�����A->1 B->2...Z->26 AA->27 AB->28
       
    }

	public static int majorityElement(int[] nums) {
		int n=nums.length;
		Arrays.sort(nums);
		return nums[n/2];
    //���һ�������г��ִ�������һ�����
	}
	
	 public static boolean isHappy(int n) {
	        Set<Integer> numberSet = new HashSet<Integer>();
	         
	        while (n!=1){
	            if (numberSet.add(n)==false){
	                return false;
	            }
	            char[] chars = String.valueOf(n).toCharArray();
	            int total = 0;
	            for (Character ch: chars){
	                total += Math.pow(Integer.parseInt(ch+""),2);
	            }
	            n = total;
	        }
	        return true;
	        //�ж�һ�����ǲ���happyNumber ex 19 is a happy number
	        //1^2 + 9^2 = 82
	        		//8^2 + 2^2 = 68
	        		//6^2 + 8^2 = 100
	        		//1^2 + 0^2 + 0^2 = 1 ���Ϊ1   Ҫ�������һ�����ظ���ѭ��
	    }

	public static void main (String[] args) {
		int n=87;
		boolean x;
		x=isHappy(n);
		System.out.println(x);
		
	}
}
