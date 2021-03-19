package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B_1099_알수없는문장 {
	static String[] word;
	static String text;
	static int result= -1;
	static int N;
	static int[][] wordCost;
	static int[][] wordAlphabet;
	static int[] minCost;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		text = br.readLine();
		N = Integer.parseInt(br.readLine());
		word = new String[N];
		wordCost = new int[N][50];
		wordAlphabet = new int[N]['z'-'a'+1];
		minCost = new int[text.length()+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		for(int i=0;i<N;i++) {
			word[i] = br.readLine();
			Arrays.fill(wordCost[i], -1);
			for(int j=0;j<word[i].length();j++) {
				wordAlphabet[i][word[i].charAt(j)-'a']++;
			}
		}
		search(0, 0);
		
		System.out.println(result);
	}
	private static void search(int start, int c) {
		if(start==text.length()) {
			if(result==-1 || result>c) {
				result =c;
			}
		}
		L: for(int i=0;i<N;i++) {
			if(start+word[i].length() > text.length()) {
				continue;
			}
			
			int cost=0;
			if(wordCost[i][start]!=-1) {
				cost = wordCost[i][start];
			}else {
				int[] tmp = wordAlphabet[i].clone();
				for(int j=start;j<start+word[i].length();j++) {
					if(--tmp[text.charAt(j)-'a'] < 0) {
						continue L;
					}
					if(text.charAt(j) != word[i].charAt(j-start)) {
						cost++;
					}
				}
				wordCost[i][start] = cost;
			}
			if(minCost[start+word[i].length()] > c+cost) {
				minCost[start+word[i].length()] = c+cost;
			}else {
				continue;
			}
			
			
			search(start+word[i].length(), c+cost);
		}
		
	}

}
