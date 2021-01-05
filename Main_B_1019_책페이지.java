package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1019_책페이지 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		String strPage = st.nextToken();
		long length = strPage.length();
		long endPage = Long.parseLong(strPage);
		long[] result = new long[10];		

		for(long i=0;i<10;i++) {
			long tmp = 1;
			for(long j=1;j<=length;j++) {
				if(j==length && i==0) {
					continue;
				}
				
				
				if(i==0) {
					if(endPage%(tmp*10)/tmp == 0) {
						result[(int)i] += (endPage/(tmp*10)-1)*tmp + endPage%tmp+1;
					}else {
						result[(int)i] += (endPage/(tmp*10)-1)*tmp + tmp;
					}
				}else {
					if(endPage%(tmp*10)/tmp< i) {
						result[(int)i] += endPage/(tmp*10)*tmp;
					}else if(endPage%(tmp*10)/tmp == i) {
						result[(int)i] += endPage/(tmp*10)*tmp + endPage%tmp+1;
					}else {
						result[(int)i] += endPage/(tmp*10)*tmp + tmp;
					}
				}
				tmp*=10;
			}
		}

		for(int i=0;i<10;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
