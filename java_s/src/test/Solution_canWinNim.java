package test;
import java.security.PublicKey;
import java.util.Scanner;
public class Solution_canWinNim {
	        public static void main(String[] args){
	        	int num=199;
	        	int res=0;
	        	res=Solution_canWinNim(num);
	        	do{
	        		res=Solution_canWinNim(res);
	        	}
	        	while(res>=10);
	        	
	        	System.out.println(res);
	        	
	        }
	        
	        public static int Solution_canWinNim(int num){
	        	int res=0;
	        	 String str=""+num;
	 	        char[] c=str.toCharArray();
	 	        for(int i=0;i<c.length;i++){
	 	        	res+=(int)(c[i] - 48);
	 	        }
	 	        return res;
	        
}
}