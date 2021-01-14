package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_B_7453_합이0인네정수 {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<Long, Integer> sum = new HashMap<Long, Integer>();
		int N = Integer.parseInt(st.nextToken());
		int[][] array;
		array = new int[4][N];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(bf.readLine());
			array[0][n] = Integer.parseInt(st.nextToken());
			array[1][n] = Integer.parseInt(st.nextToken());
			array[2][n] = Integer.parseInt(st.nextToken());
			array[3][n] = Integer.parseInt(st.nextToken());
		}
		
	
		long tmp;
		long result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp = (long)array[0][i]+array[1][j];
				if(!sum.containsKey(tmp)) {
					sum.put(tmp, 1);					
				}else {
					sum.replace(tmp, sum.get(tmp)+1);
				}
					
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				tmp = array[2][i]+array[3][j];
				if(sum.containsKey(-tmp)) {
					result += sum.get(-tmp);
				}
				
			}
		}

		System.out.println(result);
	}

}
