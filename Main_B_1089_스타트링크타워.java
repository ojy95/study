package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1089_스타트링크타워 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] number = new char[5][39];
		String  tmp = 	"###...#.###.###.#.#.###.###.###.###.###" + 
						"#.#...#...#...#.#.#.#...#.....#.#.#.#.#" + 
						"#.#...#.###.###.###.###.###...#.###.###" + 
						"#.#...#.#.....#...#...#.#.#...#.#.#...#" + 
						"###...#.###.###...#.###.###...#.###.###";
		for(int i=0;i<5;i++) {
			for(int j=0;j<39;j++) {
				number[i][j] = tmp.charAt(i*39+j);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		char now[][] = new char[5][4*N-1];
		
		for(int i=0;i<5;i++) {
			tmp = br.readLine();
			for(int j=0;j<4*N-1;j++) {
				now[i][j] = tmp.charAt(j);
			}
		}
		double result =0;
		L :for(int i=0;i<N;i++) { 
			int count =0;
			int sum =0;
			M :for(int j=0;j<10;j++) {
				for(int k=0;k<5;k++) {
					for(int l=j*4, nowAt =i*4;l<(j+1)*4-1;l++,nowAt++) {
						if(number[k][l]=='.' && now[k][nowAt]=='#') {
							continue M;
						}
					}
				}
				count++;
				sum+=j;
			}
			if(count == 0) {
				result =-1;
				break L;
			}
			result += (double)sum/count*Math.pow(10, N-1-i);
		}
		
		System.out.println(result);
		
	}

}
