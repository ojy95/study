package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1786_찾기_KMP {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String T = bf.readLine();
		String P = bf.readLine();
		
		int tLength = T.length();
		int pLength = P.length();
		int[] term = new int[pLength];
		
		int count=0, position = 0;
		for(int i=1;i<pLength;i++) {
			while(position>0 && P.charAt(i) != P.charAt(position)) {
				position = term[position-1];
			}
			if(P.charAt(i) == P.charAt(position)) {
				position++;
				term[i]=position;
				
			}

		}
		position=0;
		for(int i=0;i<tLength;i++) {
//			System.out.println(P.charAt(position)+" " +T.charAt(i));
			while(P.charAt(position)!=T.charAt(i) && position>0) {
				position = term[position-1];
			}
			if(T.charAt(i)==P.charAt(position)) {
				if(position==pLength-1) {
					count++;
					position= term[position];
					sb.append(i-pLength+2 + " ");
				}else {
					position++;
				}
			}

		}
		sb.insert(0, count+"\n");
		System.out.println(sb);
		
	}

}
