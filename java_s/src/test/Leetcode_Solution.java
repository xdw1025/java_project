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
	        		//1^2 + 0^2 + 0^2 = 1 ���Ϊ1��ΪhappyNumber   Ҫ�������һ���� c�ظ���ѭ��
	    }
	 
	  public int hammingWeight(int n) {
	         int res = 0;
	    while(n!=0)
	    {
	        n &= n - 1;
	        ++ res;
	    }
	    return res;
	    //For example, the 32-bit integer ��11' has binary representation 00000000000000000000000000001011, 
	    //so the function should return 3.
	    }
	  
	  public class Solution {
		    public boolean isPowerOfTwo(int n) {
		            return n > 0 && ((n & (n - 1)) == 0 );
		    }
		    //�ж��ǲ���2�Ĵη�����1 2 4 8 16�����ｫn���������ơ�
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
			 res=res*10+(str.charAt(i)-'0');//��һ�� ��������ô�ó������
			 i++;
		}
		 
		 if(flag=='-') res=-res;
		 if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		 if (res < Integer.MIN_VALUE)  return Integer.MIN_VALUE;
		   
		    return (int)res;
	  }
	  public static boolean isUgly(int num) {
	        if(num<=0) return false;
	        if(num==1) return true;
	        while(num>=2&&num%2==0) {num=num/2;}
	        while(num>=3&&num%3==0) {num=num/3;}
	        while(num>=5&&num%5==0) {num=num/5;}
	        return(num==1);
	    }//�ж�һ�����Ƿ���ugly number 
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
	  } //����С��n�������ĸ���
	  
	 public static int nthUglyNumber(int n) {
		 if(n<=0) return 0;
		 int i2=0, i3=0, i5=0;
		    int[] k = new int[n];
		    k[0] = 1;
		    for (int i=1; i<n; i++) {
		        k[i] = Math.min(k[i2]*2, Math.min(k[i3]*3, k[i5]*5));
		        if (k[i]%2 == 0) i2++;
		        if (k[i]%3 == 0) i3++;
		        if (k[i]%5 == 0) i5++;
		    }

		    return k[n-1];
	    }//�ҳ���n��uglyNumber
	 
	 public static int nthSuperUglyNumber(int n, int[] primes) {
	        if(n<=0) return 0;
	        int len = primes.length;
	        int[] index = new int[len]; 
	        int[] res = new int[n];
	        res[0] = 1;
	        for(int i=1; i<n; i++) {
	            int min = Integer.MAX_VALUE;
	            for(int j=0; j<len; j++){
	                min = Math.min(res[index[j]]*primes[j], min);
	            }
	            res[i] = min;
	            for (int j=0; j<len; j++) {
	                if(res[i]%primes[j]==0) index[j]++;
	            }

	        }

	        return res[n-1];
	    }//super uglyNumber,����һ������primes,����������
	 public static String reverseWords(String s){
		 String[] parts = s.trim().split("\\s+");
		 String out = "";
		 if (parts.length > 0) {
		     for (int i = parts.length - 1; i > 0; i--) {
		         out += parts[i] + " ";
		     }
		     out += parts[0];
		 }
		 return out;
	 }//��ת�ַ��� ��������ַ�˳�򲻱�
	 
	 public static int reverse(int x){
		 long result =0;
	        while(x != 0)
	        {
	            result = (result*10) + (x%10);
	            if(result > Integer.MAX_VALUE) return 0;
	            if(result < Integer.MIN_VALUE) return 0;
	            x = x/10;
	        }
	        return (int)result;
	 } //��ת���� ��123�����321
	 
	 public int climbStairs(int n){
		 if(n==0||n==1||n==2)return n;
		 int[] res=new int[n];
		 res[0]=1;
		 res[1]=2;
		 for(int i=2;i<n;i++){
			 res[i]=res[i-1]+res[i-2];
		 }
		 return res[n-1];
	 } //��¥���� ÿ�ο�����1����2�� n��¥�������� ʵΪ쳲���������
	 
	  public static int removeElement(int[] A, int elem) {
		  int start = 0;
		  int n=A.length;
		          for(int i = 0; i < n; i++)
		               if (elem != A[i])
		              {
		                  A[start++] = A[i];
		              }
		             
		         return start;
	    }//��һ��������ָ����Ԫ���Ƴ�
	  
	  public static boolean isIsomorphic(String s, String t) {  
	       int[] m1=new int[256];
	       int[] m2=new int[256];
	       int n=s.length();
	       for(int i=0;i<n;i++){
	    	   if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
	    	   m1[s.charAt(i)]=i+1;
	    	   m2[t.charAt(i)]=i+1;
	       }
	       return true;
	    }  //ͬ���ַ�������
	  public static boolean isIsomorphic2(String s, String t) {  
	       char[] cmp=new char[256];
	       boolean[] flag=new boolean[256];
	       if (s.length() != t.length())
				return false;
			for (int i = 0; i < s.length(); i++)
			{
				if (!(cmp[s.charAt(i)])&&(flag[t.charAt(i)]==false))
				{
					cmp[s.charAt(i)] = t.charAt(i);
					flag[t.charAt(i)] = true;
				}
				
				else if (cmp[s.charAt(i)] != t.charAt(i))
					return false;
			}
			return true;
	  }
		
	public static void main (String[] args) {
		
		isIsomorphic("pdfgr","title");
	}
}
