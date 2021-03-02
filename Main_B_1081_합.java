package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1081_합 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int term = U - L;
		int ul = (int) Math.log10(U)+1;

		long result = 0;
//		(long)45*(term/10);
		for(int i=1;i<ul;i++) {
			result += (long)45*Math.pow(10, i-1) * (term/(int)Math.pow(10, i));
		}
		for(int i=1;i<=ul;i++) {
			int ln = L%(int)Math.pow(10, i);
			int un = U%(int)Math.pow(10, i);
			if(un>=ln){
				int u = un/(int)Math.pow(10, i-1);
				int l = ln/(int)Math.pow(10, i-1);
				
				if(u==l) {
					result += (un-ln+1)*u;
				}else {
					result += (Math.pow(10, i-1) - ln%Math.pow(10, i-1))*l;
					result += (un%Math.pow(10, i-1)+1)*u;
					result += (u+l)*(u-l-1)/2*Math.pow(10, i-1);
				}
				
			}else {
				int u = un/(int)Math.pow(10, i-1);
				int l = ln/(int)Math.pow(10, i-1);
				
				result += (Math.pow(10, i-1) - ln%Math.pow(10, i-1))*l;
				result += (un%Math.pow(10, i-1)+1)*u;
				result += (45 - (u+l)*(l-u+1)/2)*Math.pow(10, i-1);
			}
		}
			System.out.println(result);
	}

}
