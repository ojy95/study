package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_9251_LCS {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "0"+br.readLine();
		String s2 = "0"+br.readLine();
		int[][] chart = new int[s1.length()][s2.length()];
		
		for(int i=1;i<s1.length();i++) {
			for(int j=1;j<s2.length();j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					chart[i][j] = chart[i-1][j-1]+1;
					
				}else {
					chart[i][j] = Math.max(chart[i][j-1],chart[i-1][j]);
				}
			}
		}
		System.out.println(chart[s1.length()-1][s2.length()-1]);
	}

}
