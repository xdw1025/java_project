package test;
import java.util.*; 

public class Solution {
    public static int ABC() {
    	Scanner sc = new Scanner(System.in);
    	String s=sc.next();
    	
        //if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<Character>();
        int start = 0;
        int end = 0;
        int res = 1;
      set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                res = Math.max(res, end - start + 1);
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            end = i;
        }
        res = Math.max(res, end - start + 1);
        return res;
    }
    public static void main(String[] args){
    	ABC();
    }
    
}
