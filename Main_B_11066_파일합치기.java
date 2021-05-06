package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_11066_파일합치기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int K = Integer.parseInt(br.readLine());
			int arr[] = new int[K];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<K;i++) {
				arr[i] =Integer.parseInt(st.nextToken());
			}
			sb.append(search(arr)+"\n");
		}
		System.out.println(sb);
	}

	private static int search(int[] arr) {
		int dp[][] = new int[arr.length][arr.length];
		int sum[] = new int[arr.length];
		
		sum[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		for(int i=0;i<arr.length-1;i++) {
			dp[i][i+1] = arr[i]+arr[i+1];
		}
		
		for(int j=2;j<arr.length;j++) {
			for(int i=0;i+j<arr.length;i++) {
				for(int k=i;k<i+j;k++) {
					if(dp[i][i+j]==0) {
						dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + sumCost(sum,i,i+j);
					}else{
						dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k]+dp[k+1][i+j] + sumCost(sum,i,i+j));
					}
				}
			}
		}
		return dp[0][arr.length-1];
	}

	private static int sumCost(int[] sum, int start, int end) {
		if(start==0) {
			return sum[end];
		}else {
			return sum[end]-sum[start-1];
		}
	}

}
