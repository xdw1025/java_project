package test;
import java.util.*;
public class Leetcode_Solution {
	public static boolean containDuplicate(int[] nums){
		HashSet<Integer> numbers=new HashSet<Integer>();
		for(int i:nums){
			if(!numbers.add(i)){return true;}
		}
		return false;
		//判断一个数组里是否有重复的数
	}
	
	
	public static int titleToNumber(String s) {
		int result = 0; 
		for (int i = 0; i < s.length(); i++) 
		{ result = result * 26 + (s.charAt(i) - 'A' + 1); } 
		return result;
		//将一个26进制的数转换为十进制的数，A->1 B->2...Z->26 AA->27 AB->28
       
    }

	public static int majorityElement(int[] nums) {
		int n=nums.length;
		Arrays.sort(nums);
		return nums[n/2];
    //输出一个数组中出现次数超过一半的数
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
	        //判断一个数是不是happyNumber ex 19 is a happy number
	        //1^2 + 9^2 = 82
	        		//8^2 + 2^2 = 68
	        		//6^2 + 8^2 = 100
	        		//1^2 + 0^2 + 0^2 = 1 结果为1即为happyNumber   要不会进入一个数 c重复的循环
	    }
	 
	  public int hammingWeight(int n) {
	         int res = 0;
	    while(n!=0)
	    {
	        n &= n - 1;
	        ++ res;
	    }
	    return res;
	    //For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
	    //so the function should return 3.
	    }
	  
	  public class Solution {
		    public boolean isPowerOfTwo(int n) {
		            return n > 0 && ((n & (n - 1)) == 0 );
		    }
		    //判断是不是2的次方，如1 2 4 8 16，这里将n看做二进制。
		}
	  
	  public static int myAtoi(String str){
		  
		  str=str.trim();
		 if(str==null||str.length()<1)
			 return 0;
		 char flag='+';
		 int i=0;
		 if(str.charAt(0)=='-'){
			 flag='-';
			 i++;
		 }else if(str.charAt(0)=='+'){
			 i++;
		 } 
		 double res=0;
		 while(str.length()>i&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
			 res=res*10+(str.charAt(i)-'0');//这一块 看看是怎么得出结果的
			 i++;
		}
		 
		 if(flag=='-') res=-res;
		 if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		 if (res < Integer.MIN_VALUE)  return Integer.MIN_VALUE;
		   
		    return (int)res;
	  }
	  public boolean isUgly(int num) {
	        if(num<=0) return false;
	        if(num==1) return true;
	        while(num>=2&&num%2==0) {num=num/2;}
	        while(num>=3&&num%3==0) {num=num/3;}
	        while(num>=5&&num%5==0) {num=num/5;}
	        return(num==1);
	    }//判断一个数是否是ugly number 
	  //Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	  //For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	  public static int countPrimes(int n){
		  boolean[] biaoji = new boolean[n];
		  if (n <= 2)
				return 0;
			for (int i = 2; i < n; i++)
				biaoji[i] = true;
		 
			for (int i = 2; i <= Math.sqrt(n - 1); i++) {
				if (biaoji[i]) {
					for (int j = i * i; j < n; j += i)
						biaoji[j] = false;
				}
			}
		 
			int count = 0;
			for (int i = 2; i < n; i++) {
				if (biaoji[i])
					count++;
			}
		 
			return count;
	  }
	  
	  public static boolean is_prime(int n)
	  {
		    if(n<2)
		        return false;
		    for (int i=2;i*i<=n;i++)
		    {
		        if(n % i == 0)
		            return false;
		    }
		    return true;
		}
	public static void main (String[] args) {
		int n=120;
		int res=0;
		for(int i=2;i<n;i++){
			if((is_prime(i))) res++;
		}
		System.out.println(res);
		
	}
}
