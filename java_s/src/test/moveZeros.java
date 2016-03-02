package test;

public class moveZeros {
	public static void move(int[] nums) {
	    int n=nums.length;
	    int j;
	    for(int i=0;i<n-1;i++){
	        j=i+1;
	        if(nums[i]==0){
	            while(nums[j]==0&&j<n-1){
	                j++;
	            }
	            int temp=nums[i];
	            nums[i]=nums[j];
	            nums[j]=temp;
	        }else{
	            continue;
	        }
	    }
}
	
	public static void main(String[] args) {
		int[] nums={1,0,2,3,0};
		move(nums);
		for(int i=0;i<(nums.length);i++)
		{System.out.println(nums[i]);}
	
	}
}
