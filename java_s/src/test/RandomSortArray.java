package test;
import java.util.*;

public class RandomSortArray {

	public static void main(String[] args){
		TreeSet<Integer> set=new TreeSet<Integer>();
		Random ran=new Random();
		int count=0;
		while(count<10){
			boolean suc=set.add(ran.nextInt(1000));
			if(suc) count++;
		}
		int size=set.size();
		Integer[] array=new Integer[size];
		set.toArray(array);
		System.out.println("数组如下：");
		for(int va:array){
			System.out.print(va+"     ");
		}
	}
}
