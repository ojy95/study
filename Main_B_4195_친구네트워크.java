package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_B_4195_친구네트워크 {
	static int[] check;
	static HashMap<String, Integer> name;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(st.nextToken());
		for(int tc=0;tc<TC;tc++) {
			st = new StringTokenizer(bf.readLine());
			int F = Integer.parseInt(st.nextToken());
			check = new int[F*2];
			Arrays.fill(check, -1);
			name = new HashMap<String, Integer>();
			int index = 1;
			
			for(int i=0;i<F;i++) {
				st = new StringTokenizer(bf.readLine());
				String tmp1 = st.nextToken();
				String tmp2 = st.nextToken();
				int tmp1index,tmp2index;
				
				if(name.containsKey(tmp1)) {
					tmp1index = name.get(tmp1);
				}else {
					tmp1index = index++;
					name.put(tmp1, tmp1index);
				}
				
				if(name.containsKey(tmp2)) {
					tmp2index = name.get(tmp2);
				}else {
					tmp2index = index++;
					name.put(tmp2, tmp2index);			
				}
				
				sb.append(-merge(tmp1index,tmp2index)+"\n");
			}
			
		}
		System.out.println(sb);
	}
	private static int merge(int tmp1index, int tmp2index) {
		int root1 = search(tmp1index);
		int root2 = search(tmp2index);
		
		if(root1 != root2) {
			if(check[root1] > check[root2]) { // 루트 값 비교
				check[root2] += check[root1]; //작은쪽이 루트
				check[root1] = root2;
			}else {
				check[root1] += check[root2];
				check[root2] = root1;
			}
			
		}
		if(check[root1]<0) {
			return check[root1];
		}else {
			return check[root2];
		}
	}
	private static int search(int index) {
		if(check[index]<0) {//루트
			return index;
		}
		return check[index] = search( check[index] );
	}
	

}
