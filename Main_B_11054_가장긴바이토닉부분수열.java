package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		
		int[] increase = new int[N+1];
		int[] decrease = new int[N+1];
		
		for(int i=1; i<=N;i++) {
			increase[i] = 1;
			for(int j=1; j<i;j++) {
				if(array[i]>array[j]) {
					increase[i] = Math.max(increase[j] + 1, increase[i]);
				}
			}
		}
		
		for(int i=N; i>0;i--) {
			decrease[i] = 1;
			for(int j=N; j>i;j--) {
				if(array[i]>array[j]) {
					decrease[i] = Math.max(decrease[j] + 1, decrease[i]);
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			result = Math.max(result, increase[i] + decrease[i]-1);
		}
		
		System.out.println(result);
	}


}
