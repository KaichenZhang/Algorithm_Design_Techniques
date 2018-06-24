import java.io.*;

public class ROS{

	static long dp[][];
	
	static long counter=0;
	
	public static long repeatOnceCounter(String str){
		
		for(int p=1;p<=str.length()-1;p++){
			String leftSubSting=str.substring(0,p);               
			String rightSubString=str.substring(p,str.length());    
			int n = rightSubString.length();
			dp = new long[leftSubSting.length() + 1][rightSubString.length() + 1];
			for(int i=1;i<=p;i++){
				dp[i][0]=0;
			}
			for(int j=1;j<=n;j++){
				dp[0][j]=0;
			}	
			for(int i=1;i<=p;i++){		
				for(int j=1;j<=n;j++){
					if(leftSubSting.charAt(i-1)!=rightSubString.charAt(j-1)){
						dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];        //the idea is discussed with Chenyang Li
					}
					else{
						dp[i][j]=dp[i-1][j]+dp[i][j-1]+1;	
					}
				}
			}
			
			counter+=dp[p][n]-dp[p-1][n];

		}
		
		return counter;
	}
	
	public static void clear(){
		counter=0;
	}


	public static void main(String[] args) {
		
		/*Please change the file path when test the program.
		**Since the required input is a number in the first line,but the sample text file given doesn't have the number.
		**Please add the number of cases to the first line of the file
		*/
		String filePath = "E:\\2014MyEclipse\\niubi\\file\\sample_input2.txt";
		File file = new File(filePath);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int totalCase=Integer.parseInt(br.readLine());
			int line = 1;
			
			 for(int i=0;i<=totalCase;i++){
				 if(line==1){
					 line++;
				 }
				 else{
					 String str = br.readLine();
					 System.out.println(repeatOnceCounter(str));
					 clear();
					 line++;
				 }
			 }
			 
			 br.close();
			 
		}catch (IOException e) {
			 e.printStackTrace();
		}
				
		
	}

}
