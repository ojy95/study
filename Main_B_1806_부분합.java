package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1806_부분합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum=0,start=0,result=Integer.MAX_VALUE;
		for(int end=0;end<N;end++) {
			sum+=arr[end];
			if(sum<S) {
				continue;
			}
			while(sum>=S) {
				if(end-start+1<result) {
					result = end-start+1;
				}
				sum-=arr[start++];
			}
		}
		if(result == Integer.MAX_VALUE) {
			result = 0;
		}
		System.out.println(result);
	}

}
