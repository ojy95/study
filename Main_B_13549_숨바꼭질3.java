package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_13549_숨바꼭질3 {
	static int N,K,min=Integer.MAX_VALUE;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[] boolArray = new int[200001];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(boolArray,-1);
		boolArray[N]=0;
		queue.offer(new int[] {N,0});

		
		searchBfs();
		System.out.println(min);
	}

	private static void searchBfs() {
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp[] = new int[2];
				tmp = queue.poll();	
				if (tmp[0] == K || tmp[1]>min || tmp[1]>boolArray[tmp[0]]) {
					if(tmp[1]<min) {
						min=tmp[1];
					}
					continue;
				}
				
				if (tmp[0] != 0 && tmp[0] < 100000 && (boolArray[tmp[0]*2]==-1 || boolArray[tmp[0]*2]>tmp[1]))  {
					
					queue.offer(new int[] {2 * tmp[0],tmp[1]});
					boolArray[tmp[0]*2]=tmp[1];
				}
				if (tmp[0] < 100000 && (boolArray[tmp[0]+1]==-1 || boolArray[tmp[0]+1]>tmp[1]+1)) {
					queue.offer(new int[] {tmp[0] + 1,tmp[1]+1});
					boolArray[tmp[0]+1]=tmp[1]+1;
				}
				if (tmp[0] > 0 &&  (boolArray[tmp[0]-1]==-1 || boolArray[tmp[0]-1]>tmp[1]+1)) {
					queue.offer(new int[] {tmp[0] - 1,tmp[1]+1});
					boolArray[tmp[0]-1]=tmp[1]+1;
				}

			}
			
		}

	}
}