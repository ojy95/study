package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1107_리모컨 {
	static int result,NN;
	static int[] up, down;
	static int max=-1, min=10;
	static String N;
	static boolean broken[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		NN = Integer.parseInt(N);
		while( N.length()<3) {
			N = "0"+N;
		}
		N = "0"+N;
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if(M!=0) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				broken[tmp] = true;
			}
		}
		for(int i=0;i<10;i++) {
			if(!broken[i]) {
				min = i;
				break;
			}
		}
		for(int i=9;i>=0;i--) {
			if(!broken[i]) {	
				if(i !=min) {
					max = i;					
				}
				break;
			}
		}
		
		up = new int[N.length()];
		down = new int[N.length()];
		Arrays.fill(up, -1);
		Arrays.fill(down, -1);
		for(int i=0;i<N.length();i++) {
			int num =N.charAt(i)-'0';
			for(int j=num+1;j<num+10;j++) {
				if(!broken[j%10]) {
					if(j%10==max || j%10==min) break;
					up[i] = j%10;
					break;
				}
			}
			for(int j=num+9;j>num;j--) {
				if(!broken[j%10]) {
					if(j%10==max || j%10==min) break;
					down[i] = j%10;
					break;
				}
			}
		}
		result = Math.abs(NN-100);
		if(M!=10) {			
			solution(0,0);
		}
		System.out.println(result);

	}
	private static void solution(int position, int num) {
		if(position == N.length()) {
			int c=1;
			if(num!=0) {
				c = (int)Math.log10(num)+1;
			}
			result = Math.min(result, c+Math.abs(NN-num));
			if(result==10) System.out.println(num);
			return;
		}
		int n =N.charAt(position)-'0';
		if(position != N.length()-1 &&num==0) {
			solution(position+1, 0);
		}
		if(!broken[n]) {
			solution(position+1, num*10+n);
		}
		if(n!=max && max!=-1) {			
			solution(position+1, num*10+max);
		}
		if(n!=min && min!=10) {			
			solution(position+1, num*10+min);
		}
		if(up[position]!=-1) {
			solution(position+1,  num*10+up[position]);		
		}
		if(down[position]!=-1 && down[position]!=up[position]) {			
			solution(position+1, num*10+down[position]);	
		}
	}



}
