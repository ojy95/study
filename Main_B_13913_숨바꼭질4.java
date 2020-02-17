package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B_13913_숨바꼭질4 {
	static int N,K,result=0;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean[] boolArray = new boolean[200001];
	static int[] trace = new int[150000];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		boolArray[N]=true;
		queue.offer(N);
		int count=0;

		
		searchBfs();
		System.out.println(result);
		traceAnswer(K);
	}
	
	private static void traceAnswer(int a) {
		if(a==N) {
			System.out.print(a+" ");
			return;
		}
		traceAnswer(trace[a]);
		System.out.print(a+" ");
	}

	private static void searchBfs() {
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();	
				if (tmp == K)
					return;
				
				if (tmp != 0 && tmp < 60001 && !boolArray[tmp*2]) {
					queue.offer(2 * tmp);
					boolArray[tmp*2]=true;
					trace[tmp*2]=tmp;
				}
				if (tmp < 100000 && !boolArray[tmp+1]) {
					queue.offer(tmp + 1);
					boolArray[tmp+1]=true;
					trace[tmp+1]=tmp;
				}
				if (tmp > 0 &&  !boolArray[tmp-1]) {
					queue.offer(tmp - 1);
					boolArray[tmp-1]=true;
					trace[tmp-1]=tmp;
				}

			}
			
			result++;
		}

	}
}
