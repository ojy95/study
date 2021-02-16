package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1013_Contact {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			boolean result = false;
			
			for(int j=s.length()-1;j>=0;j--) {
				if(j<1 || s.charAt(j)!='1') {
					break;
				}
				
				if(s.charAt(--j)=='1') { //끝이 11
					while(j>0) {
						if(s.charAt(--j)!='1') {
							break;
						}
					}
					
					if(--j>0 && s.charAt(j)!='0') { //끝이  10111...
						break;
					}
					while(j>0) {
						if(s.charAt(--j)=='1') {
							if(j==0) {
								result=true;
							}
							break;
						}
					}
					
				}else { //끝이 01
					if(j==0) {
						result = true;
						break;
					}else {
						if(s.charAt(--j)=='0') {//끝이 001
							while(j>0) {
								if(s.charAt(--j)=='1') {
									if(j==0) {
										result=true;
									}
									break;
								}
							}
						}else { //끝 101
							j++;
							continue;
						}
					}
				}
			}
			
			
			if(result) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}

	}

}
