package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_10974_모든순열 {

	static int newArray[];
	static int N;
	static boolean boolArray[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N=Integer.parseInt(st.nextToken());

		newArray = new int[N];
		boolArray = new boolean[N];
		printDic(0);
	}
	private static void printDic(int index) {
		if(index==N) {
			for(int i=0;i<N;i++) {
				System.out.print(newArray[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<N;i++) {
			if(boolArray[i]) continue;
			boolArray[i]=true;
			newArray[index]=i+1;
			printDic(index+1);
			boolArray[i]=false;
		}
	}
}
