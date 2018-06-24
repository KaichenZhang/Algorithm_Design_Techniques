//Both inputs are tested
//The idea of handling operations to the tree is come from Lukas Eder(quoted from Stack Overflow)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Operation {
    final int p;
    final int q;
    final int r;

    Operation(int p, int q, int r) {
        this.p = p;
        this.q = q;
        this.r = r;
    }
}


public class Max {
	
	public static void main( String[] args ){
		long startMili=System.currentTimeMillis();		
	    //read lines	
		String filePath = "E:\\2014MyEclipse\\niubi\\file\\p2-sample-input2.txt";
		File file = new File(filePath);
		try {		
			//read the first line 
			BufferedReader br = new BufferedReader(new FileReader(file));
			String lineOne = br.readLine();
			String[] firstLine = lineOne.split(" ");
			long N=Integer.parseInt(firstLine[0]);
			long M=Integer.parseInt(firstLine[1]);		
			long line = 1;
			long[] array = new long[(int)N];
			
			for(long i=0;i<=M;i++){				
				 
				 if(line==1){
					 //do nothing
					 line++;                  
					 }
				 else{
					 String operationLines = br.readLine();
					 String[] otherLines = operationLines.split(" ");
					 int p=Integer.parseInt(otherLines[0]);
					 int q=Integer.parseInt(otherLines[1]);
					 int r=Integer.parseInt(otherLines[2]);

	                Operation[] ops = {new Operation(p, q, r)};
	                for (Operation op : ops) {
	            	    long lo = op.p;
	            	    long hi = op.q + 1;
	            	    
	            	    if (lo >= 0)
	            	        array[(int)lo] = array[(int)lo] + op.r;
	            	    if (hi < array.length)
	            	        array[(int)hi] = array[(int)hi] - op.r;
	            	    }
	                }
				 line++;
				 } 

	      long max = Integer.MIN_VALUE;	
	      long r = 0;
	      for (long i = 0; i < array.length; i++) {	
	          r = r + array[(int)i];
	            if (r > max) {
	                max = r;
	                }
	            }
	      
	   System.out.println(max);
	   br.close();
	
	   }catch (IOException e) {
	          e.printStackTrace();
	          }
		long endMili=System.currentTimeMillis();
		System.out.println("Totol Time£º"+(endMili-startMili)+"ms");
		}
	}




