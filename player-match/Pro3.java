//The version used flag to define the groups using linked list taking array as element, 
//and assign the first array element the flag the next two elements are the players.
//The idea of hashing method and combine function is discussed with Shuaishuai Zhen


import java.io.*;
import java.util.*;


public class Pro3 {
	static HashMap<Integer, Integer> playerFlags = new HashMap<Integer, Integer>();
	static HashMap<Integer, HashSet<Integer>> country = new HashMap<Integer, HashSet<Integer>>();
	static String fileName = "E:\\2014MyEclipse\\niubi\\file\\programming_assignment3-sample_input2.txt";
	
	public static void main(String args[]){			
		File file = new File(fileName);
		BufferedReader br = null;
		String buffer = null;
		int N = 0;
		int I = 0;		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			// Reading the first line
			if ((buffer = br.readLine()) != null) {
				String[] temp = buffer.split(" ");
				N = Integer.parseInt(temp[0]);
				I = Integer.parseInt(temp[1]);
			}			
			// Reading the pairs of players
			int flag = 0;
			while ((buffer = br.readLine()) != null) {
				String[] str = buffer.split(" ");
				int leftOne = Integer.parseInt(str[0]);
				int rightOne = Integer.parseInt(str[1]);				
				if (playerFlags.containsKey(leftOne)) {
					if (playerFlags.containsKey(rightOne)) {
						int flagLeft = playerFlags.get(leftOne);
						int flagRight = playerFlags.get(rightOne);
						for (int player: playerFlags.keySet()) {
							if (playerFlags.get(player) == flagRight) {
								playerFlags.put(player, flagLeft);
							}
						}
					}
					else {
						playerFlags.put(rightOne, playerFlags.get(leftOne));
					}
				}
				else if (playerFlags.containsKey(rightOne)) {
					playerFlags.put(leftOne, playerFlags.get(rightOne));
				}
				else {
					playerFlags.put(leftOne, flag);
					playerFlags.put(rightOne, flag);
					flag++;
				}
			}
				
			combine(N, flag);
			
			//counting the results
			int counter = 0;
			Set<Integer> keyset = country.keySet();
			int[] flagCounter = new int[keyset.size()];
			int i = 0;
			for (int f: keyset) {
				flagCounter[i] = f;
				i++;
			}
			for (int k = 0; k < flagCounter.length; k++) {
				int curNum = country.get(flagCounter[k]).size();
				for (int j = k + 1; j < flagCounter.length; j++) {
					counter += curNum * country.get(flagCounter[j]).size();
				}
			}				
			System.out.println(counter);
		}
		catch (IOException e) {
			
		}
     }
	
	public static void combine(int N, int nextFlag) {
		for (int player = 0; player < N; player++) {		
			if (!playerFlags.containsKey(player)) {
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.add(player);
				country.put(nextFlag, temp);
				nextFlag++;
				continue;
			}			
			int flag = playerFlags.get(player);
			if (country.containsKey(flag)) {
				country.get(flag).add(player);
			}
			else {
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.add(player);
				country.put(flag, temp);
			}
		}		
		for (int flag: country.keySet()) {
			Iterator<Integer> iterator = country.get(flag).iterator();						
		}
	}
		
}
