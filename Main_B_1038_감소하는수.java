package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_1038_감소하는수 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine())+1;
		
		int length=0;
		long result=0;
		int[][] table = new int[11][10];
		for(int i=0;i<10;i++) {
			table[1][i]=1;
		}
		for(int i=2;i<11;i++) {
			for(int j=1;j<10;j++) {
				table[i][j] = table[i-1][j-1]+table[i][j-1];
			}
		}

		L:for(int i=1;i<11;i++) {
			for(int j=i-1;j<10;j++) {
				if(N<=table[i][j]) {
					result = (long)Math.pow(10, i-1)*j; 
					length=i;
					break L;
				}
				if(i==10) {
					result=-1;
					break L;
				}
				N-=table[i][j];
			}
		}

		L:for(int i=length-1;i>0;i--) {
			for(int j=i-1;j<10;j++) {
				if(N<=table[i][j]) {
					result += (long)Math.pow(10, i-1)*j;
					continue L;
				}
				N-=table[i][j];
			}
		}
		System.out.println(result);
	}

}
