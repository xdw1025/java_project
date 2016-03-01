package test;

public class yanghuidanjiao {
	
		public static void main(String[] args){
			int tr[][]=new int[9][];
			for(int i=0;i<tr.length;i++){
				tr[i]=new int[i+1];
				for(int j=0;j<tr[i].length-1;j++){
					if(i==0||j==0||j==tr[i].length-1){
						tr[i][j]=1;
					}
					else{
						tr[i][j]=tr[i-1][j]+tr[i-1][j-1];
					}
					System.out.print(tr[i][j]+"\t");
				}
				System.out.println();
			}
			 
			
		}
		
	}

	
	

