package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1016_제곱ㄴㄴ수 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		int result = (int) (max-min) + 1;
		int[] array = new int[result];
		long squared;
		for(long i=2;i<1000000;i++) {
			squared = i*i;
			
			if(squared>max) break;
			
			long squaredNum = ((min-1)/squared + 1)*squared;
			for(long j=squaredNum-min;j<result;j+=squared) {
				array[(int)j]=1;
			}
			
		}
		
		for(int i=0;i<array.length;i++) {
			result = result - array[i];
		}
		
		
		System.out.println(result);
	}
}
