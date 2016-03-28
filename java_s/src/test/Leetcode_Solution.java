package test;
import java.lang.reflect.Array;
import java.nio.file.attribute.DosFileAttributes;
import java.util.*;

import javax.print.attribute.standard.RequestingUserName;
public class Leetcode_Solution {
	
	public static void input(){
		 Scanner input = new Scanner(System.in);
		  
		  while (input.hasNext()) {
		   int n = input.nextInt();
		   int ability = input.nextInt();
		   int[] monsters = new int[n];
		   for (int i = 0; i < n; i++) {
		    monsters[i] = input.nextInt();
		   }
	}
	}
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
	  public static boolean isUgly(int num) {
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
	  } //计数小于n的素数的个数
	  
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
	    }//找出第n个uglyNumber
	 
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
	    }//super uglyNumber,给定一个数组primes,里面是因数
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
	 }//反转字符串 但里面的字符顺序不变
	 
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
	 } //反转数字 如123则输出321
	 
	 public int climbStairs(int n){
		 if(n==0||n==1||n==2)return n;
		 int[] res=new int[n];
		 res[0]=1;
		 res[1]=2;
		 for(int i=2;i<n;i++){
			 res[i]=res[i-1]+res[i-2];
		 }
		 return res[n-1];
	 } //爬楼问题 每次可以爬1步或2步 n层楼多少爬法 实为斐波那契数列
	 
	  public static int removeElement(int[] A, int elem) {
		  int start = 0;
		  int n=A.length;
		          for(int i = 0; i < n; i++)
		               if (elem != A[i])
		              {
		                  A[start++] = A[i];
		              }
		             
		         return start;
	    }//将一个数组中指定的元素移除
	  
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
	    }  //同构字符串问题
	  public static boolean isIsomorphic2(String s, String t) {  
	       char[] cmp=new char[256];
	       boolean[] flag=new boolean[256];
	       if (s.length() != t.length())
				return false;
			for (int i = 0; i < s.length(); i++)
			{
				if ((cmp[s.charAt(i)]==0)&&(flag[t.charAt(i)]==false))
				{
					cmp[s.charAt(i)] = t.charAt(i);
					flag[t.charAt(i)] = true;
				}
				
				else if (cmp[s.charAt(i)] != t.charAt(i))
					return false;
			}
			return true;
	  }//同构字符串 
	  
		public static int rob(int[] num){
			  if (num.length == 0) return 0;
		        
		        int[] money = new int[num.length + 1];
		        money[0] = 0;
		        money[1] = num[0];
		        
		        for (int i = 2; i <= num.length; i++) {
		        	money[i] = Math.max(money[i - 1], money[i - 2] + num[i - 1]);
		        }
		        
		        return money[num.length];
		}//198抢劫问题 实质是计算一个数组不相邻的数加起来的最大值
		
		public static int compareVersion(String version1, String version2) {  
	        if(version1 == null || version2 ==null) return 0;  
	          
	        String[] v1 = version1.split("\\.");  
	        String[] v2 = version2.split("\\.");  
	          
	        int n1 = v1.length;  
	        int n2 = v2.length;  
	          
	        int i=0;  
	          
	        while(i<n1 || i<n2) {  
	            int x1 = i<n1 ? Integer.parseInt(v1[i]) : 0;  
	            int x2 = i<n2 ? Integer.parseInt(v2[i]) : 0;  
	            if(x1 > x2) return 1;  
	            else if(x1 < x2) return -1;  
	            else ++i;
	        }  
	          
	        return 0;
	     }//165比较版本号大小 比如1.2<1.3 12.3.4>2.5之类
		
		 public int firstBadVersion(int n) {
	         int start = 1, end = n;
	    while (start < end) {
	        int mid = start + (end-start) / 2;
	        if (!isBadVersion(mid)) start = mid + 1;
	        else end = mid;               
	    }        
	    return start;
	        }//二分查找
		 public boolean isBadVersion(int n){
			 return true;
		 }
		 
		 public static int maxSubArray(int[] nums) {
		        int sum=0,max=nums[0];
		        for(int i=0;i<nums.length;i++){
		            if(sum>=0) sum+=nums[i];
		            else sum=nums[i];
		            if (sum>max) max=sum;
		        }
		        return max;
		    }//53求连续子数组的最大和；For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
		// the contiguous subarray [4,−1,2,1] 
		  public static boolean isPalindrome(int x) {
		       int res=0;
		            while(x!=0){
		                res=res*10+x%10;
		                x=x/10;
		            }
		            if(res==x) return true;
		            else return false;
		        }
		  public static String reverse3(String s) {
			  char[] array = s.toCharArray();
			  String reverse = "";
			  for (int i = array.length - 1; i >= 0; i--)
			   reverse += array[i];
			  
			  return reverse;
			 }
		  public static int reverseBits(int n) {
		        String a=Integer.toBinaryString(n);
		        String x=reverse3(a);
		        
		        	int b=Integer.parseInt(x, 2);
		        
		 return b;
		    }
		  public class TreeNode {
			       int val;
			       TreeNode left;
			       TreeNode right;
			       TreeNode(int x) { val = x; }
			   }
		  
		  public TreeNode invertTree(TreeNode root) {
		      TreeNode temp;
		       if(root==null) return null;
		        if(root.left!=null||root.right!=null){
		            temp=root.left;
		            root.left=root.right;
		            root.right=temp;
		        }
		        invertTree(root.left);
		        invertTree(root.right);
		        return root;
		    }//反转二叉树 
		  
		  public TreeNode invertTree2(TreeNode root) {
		        if(root == null) return null;
		        TreeNode tmp = root.left;
		        root.left = invertTree(root.right);
		        root.right = invertTree(tmp);
		        return root;
		    }
		  
		  
		  public boolean isSymmetric(TreeNode root) {
			    return root==null || isSymmetricHelp(root.left, root.right);
			}

			private boolean isSymmetricHelp(TreeNode left, TreeNode right){
			    if(left==null || right==null)
			        return left==right;
			    if(left.val!=right.val)
			        return false;
			    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
			}//判断一个二叉树是否是自己的镜像
		  
			 public int sumNumbers(TreeNode root) {
				    return sum(root, 0);
				}

				public int sum(TreeNode n, int s){
				    if (n == null) return 0;
				    if (n.right == null && n.left == null) return s*10 + n.val;
				    return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
				}// 129. Sum Root to Leaf Numbers
				
				  public static void rotate(int[] nums, int k) {
				        k=k%nums.length;
				        reversenum(nums,0,nums.length-1);
				        reversenum(nums,0,k-1);
				        reversenum(nums,k,nums.length-1);
				      
				    }
				  
				  public static void reversenum(int[] nums,int start,int end){
					  while(start<end){
						  ArrayList List=new ArrayList();
						  List.size();
						  int tmp=nums[start];
						  nums[start]=nums[end];
						  nums[end]=tmp;
						  start++;
						  end--;
					  }
				  }//189 翻转数组
				  private Queue<Long> small = new PriorityQueue(),
	                        large = new PriorityQueue();

	    public void addNum(int num) {
	        large.add((long) num);
	        small.add(-large.poll());
	        if (large.size() < small.size())
	            large.add(-small.poll());
	    }

	    public double findMedian() {
	        return large.size() > small.size()
	               ? large.peek()
	               : (large.peek() - small.peek()) / 2.0;
	    }//295. Find Median from Data Stream
	    
	    public static void maxProduct(String[] words) {
	        char[] chars=new char[100];
	        int[] re=new int[100];
	        for(int i = 0; i < words.length; i++){
	            for(char c: words[i].toCharArray()){
	               re[i] |= 1 << (c - 'a');
	            }
	        }
	       
	    }//部分 未完成
	    
	    
	    
	     public class ListNode {
	    	     int val;
	    	     ListNode next;
	    	     ListNode(int x) { val = x; }
	    	 }
	        public ListNode removeNthFromEnd(ListNode head, int n) {

	       ListNode start = new ListNode(0);
	       ListNode slow = start, fast = start;
	       slow.next = head;

	       //Move fast in front so that the gap between slow and fast becomes n
	       for(int i=1; i<=n+1; i++)   {
	           fast = fast.next;
	       }
	       //Move fast to the end, maintaining the gap
	       while(fast != null) {
	           slow = slow.next;
	           fast = fast.next;
	       }
	       //Skip the desired node
	       slow.next = slow.next.next;
	       return start.next;
	   } //19 Remove Nth Node From End of List
	        
	        public String longestCommonPrefix(String[] strs) {
	            int n=strs.length;
	            if(n==0) return "";
	            String prefix=strs[0];
	            for(int i=0;i<n;i++){
	                if(prefix.length()==0||strs[i].length()==0) return "";
	                int len=prefix.length()<strs[i].length()?prefix.length():strs[i].length();
	                int j=0;
	                for(j=0;j<len;j++){
	                    if(prefix.charAt(j)!=strs[i].charAt(j)) break;
	                }
	                prefix=prefix.substring(0,j);
	            }
	            return prefix;
	        }//14. Longest Common Prefix 字符串数组中的最长公共前缀
	        /*思路是这样的：
	        2个字符串的最长公共前缀，其长度肯定不会超过最短的字符串的长度，设最短的字符串长度为n，那么只要比较这2个字符串的前n个字符即可。
	        如此得出这2个字符串的最长公共前缀prefix后，再拿prefix作为新的字符串和数组中的下一个字符串比较，方法同上。
	        需要注意的是，如果数组中的某个字符串长度为0，或者求得的当前最长公共前缀的长度为0，就直接返回空字串。*/
	        
	        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	            int left = 0;
	            ListNode dummy = new ListNode(0), tail = dummy;

	            // iterate two list, add each position until 2 lists are finished && left equals to 0
	            while(!(l1 == null && l2 == null && left == 0)){
	                // is number1 finished?
	                int add1 = l1 != null ? l1.val : 0;
	                // is number2 finished?
	                int add2 = l2 != null ? l2.val : 0;
	                int sum = add1 + add2 + left;
	                left = sum / 10;
	                ListNode newNode = new ListNode(sum % 10);
	                tail.next = newNode;
	                tail = newNode;

	                if(l1 != null) l1 = l1.next;
	                if(l2 != null) l2 = l2.next;
	            }

	            return dummy.next;
	        }//2 Add Two Numbers 将2个数相加，这2个数以链表的形式给出 且顺序是反向的 注意进位
	        
	        public static int lengthOfLongestSubstring(String s) {
	        	int n = s.length();  
	        	  int i = 0, j = 0; 
	        	  Set<Character> t=new HashSet<>();
	        	  char[] arr=s.toCharArray();
	        	  int maxLen = 0; 
	        	  int count=0;
	        	  while(j<n){
	        		  if(t.add(arr[j])){j++;}
	        		
	        		  else {maxLen=j-i;i=i+maxLen;}
	        	  }
	        	  return maxLen;
	            }
	        
	        public static int huawei(int[] num){
	        	int n=num.length;
	        	int res=0;
	        	Arrays.sort(num);
	        	if(num[0]>=60) res=60;
	        	else if(num[4]%10==0){
	        		res=num[4];
	        	}
	        	else{
	        		res=num[4]-(num[4]%10);
	        	}
	        	
	        	return res;
	        }
	        
	        
	        public static void huawei1(){
	        	int n=0;
	        	int res=0;
	        	Scanner cin = new Scanner(System.in);
	        	n=cin.nextInt();
	        		for(int i=1;;i++){
	        			if(i*i<=n) 
	        			res++;
	        			else break;
	        		}
	        		System.out.println(res);
	        	
	        }
	        
	       public static List<List<Integer>> subsets(int[] nums){
	    	   List<List<Integer>> res=new ArrayList<>();
	    	   if(nums==null||nums.length==0) return res;
	    	   Arrays.sort(nums);
	    	   res.add(new ArrayList<>());
	    	   for(int n:nums){
	    		   int tmplen=res.size();
	    		   for(int i=0;i<tmplen;i++){
	    			   List<Integer> clone=new ArrayList<>(res.get(i));
	    			   clone.add(n); 
	    			   res.add(clone);
	    		   }
	    	   }
	    	   
	    	   return res;
	    	   }
	       
	       public static int countBitDiff(int m, int n) {
	    	   int tmp=m^n;
	    	   int count=0;
	    	  while(tmp!=0){
	    		   count=count+(tmp&1);
	    		   tmp=tmp>>1;
	    		   
	    	   }
	   			return count;
	       }
	       
	       public static boolean isValid(String s) {
	           Stack<Character> sk=new Stack<>();
	           char c;
	           for(int i=0;i<s.length();i++){
	        	   if(s.charAt(i)=='('){
	        		   sk.push('(');
	        	   }
	        	   if(s.charAt(i)==')'){
	        		   if(!sk.isEmpty()&&sk.pop()=='(')
	        			   continue;
	        		   else return false;
	        	   }
	           
	           if (s.charAt(i) == '[') {  
	                sk.push('[');  
	            }  
	            if (s.charAt(i) == ']') {  
	                if (!sk.isEmpty() && sk.pop() == '[')  
	                    continue;  
	                else  
	                    return false;  
	            }  
	            if (s.charAt(i) == '{') {  
	                sk.push('{');  
	            }  
	            if (s.charAt(i) == '}') {  
	                if (!sk.isEmpty() && sk.pop() == '{')  
	                    continue;  
	                else  
	                    return false;  
	            }  
	            
	       }
	           if (sk.isEmpty())  
	                return true;  
	            else  
	                return false; 
	       }//20 括号匹配问题 
	       
	       public static int[] sor(int[] a){
	    	   for (int i = 0; i < a.length; i++) {
	    		               for(int j = 0; j<a.length-i-1; j++){
	    		            
	    		                   if(a[j]<a[j+1]){
	    		                      int temp = a[j];
	    		                        a[j] = a[j+1];
	    		                       a[j+1] = temp;
	    		                   }
	    		               }
	    		          }
	    	    return a;
	    	}
	       public static int hIndex(int[] citations) {
	          citations=sor(citations);
	           int min=0;
	           int len=citations.length;
	           if(len==0) return 0;
	           int[] max=new int[len];
	           for(int i=1;i<len+1;i++){
	        	   min=Math.min(citations[i-1], i);
	        	   max[i-1]=min;
	           }
	          max=sor(max);
	           return max[0];
	       }//274 H-Index   思想是max[min[f(i),i]]
	  
	   
	       	public static int getGCD(int a, int b) {
	               int max = Math.max(a, b);
	               int min = Math.min(a, b);
	               if(min == 0)
	               return max;
	               return getGCD(min, max % min);
	       	}//最大公约数
	       	
	       	
	        public static int[] countBits(int num) {
	            int len=num;
	            int[] res=new int[len+1];
	            for(int i=0;i<len+1;i++){
	                int tmp=i;
	                for(int j=0;j<32;j++){
	                    if((tmp&1)==1) res[i]++;
	                    tmp=tmp>>1;
	                }
	            }
	            return res;
	        }
	       	
	    public static int lengthOfLastWord(String s) {
	        int res=0;
	        String[] parts = s.trim().split("\\s+");
	        int n=parts.length;
	        res=parts[n-1].length();
	        
	        return res;
	        
	        }
	    	/* For example, 
	    		Given s = "Hello World",
	    			return 5.*/
	    
	    
	    public  static int searchInsert(int[] A, int target) {
	        int low = 0, high = A.length-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(A[mid] == target) return mid;
	            else if(A[mid] > target) high = mid-1;
	            else low = mid+1;
	        }
	        return low;
	    }
	        
	    public double myPow(double x, int n) {
	        if (n == 0) return 1.0;
	    double half = myPow(x, n/2);
	    if (n%2 == 0)
	    {
	        return half*half;
	    }
	    else if (n>0)
	    {
	        return half*half*x;
	    }
	    else
	    {
	        return half/x*half;
	    }
	        
	    }//重新实现pow函数，有时间复杂度的要求
	    
	    public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result=new ArrayList<>();
            int n=nums.length;
            int k=0;
           Arrays.sort(nums);
           for(int i=0;i<n;i++){
               if(i!=0&&nums[i]==nums[i-1]) continue;
               int p=i+1,q=n-1,sum=0;
               while(p<q){
                   sum=nums[i]+nums[p]+nums[q];
                   if(sum==0){
                       result.add(Arrays.asList(nums[i], nums[p], nums[q]));
                   
                    while (p < q && nums[p] == nums[p+1]) p++;
                    while (p < q && nums[q] == nums[q-1]) q--;
                    p++; q--;
                   }
                    else if(sum<0){p++;}
                    else {q--;}
               }
           }
           
           return result;
   
}//15  3sum Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
	   
	    
	    public static boolean containsNearbyDuplicate(int[] nums, int k) {
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++){
	            if(i > k) set.remove(nums[i-k-1]);
	            if(!set.add(nums[i])) return true;
	        }
	        return false;
	 }
	    
	    
	  
	   
	        public static String getHint(String secret, String guess) 
	        {
	            if (secret == null || secret.length() == 0)
	            {
	                return "0A0B";
	            }

	            int bull = 0;
	            int total = 0;
	            char[] sChar = secret.toCharArray();
	            char[] gChar = guess.toCharArray();
	            int[] flags = new int[10];

	            for (char c : sChar)
	            {
	                flags[c - '0']++;
	            }

	            for (int i = 0; i < sChar.length; i++)
	            {
	                if (gChar[i] == sChar[i])
	                {
	                    bull++;
	                }

	                if (flags[gChar[i] - '0']-- > 0)
	                {
	                    total++;
	                }
	            }
	            return bull + "A" + (total - bull) + "B";
	        }
	        //299. Bulls and Cows For example:Secret number:  "1807"
	        // Friend's guess: "7810"
	         //return 1A3B
	    
	           public static void main (String[] args) {
	             Random sa=new Random();
	              int s=sa.nextInt(338);
	              int[] nums={1,2,4,5,6,7,8,8};
	              String a1="1123";
	              String a2="0111";
	             
	              String a3=getHint(a1,a2);
	              System.out.println(a3);
	           }
	           
	          
	        
	       }



