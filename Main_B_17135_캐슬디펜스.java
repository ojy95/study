package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] field;
	static int[][] copyField;
	static boolean[][] boolField;
	static boolean full[];
	static Queue<int[]> queue;
	static Stack<int[]> death = new Stack<int[]>();
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { 0, -1, 0 };
	static int result=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		full = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selectPosition(0, 0);
		
		System.out.println(result);
	}

	private static void selectPosition(int p, int index) { //순열
		if (index == 3) {
			System.out.println(Arrays.toString(full));
			simul();// 시뮬시작
			return;
		}
		if (p == M)
			return;
		full[p] = true;
		selectPosition(p + 1, index + 1);

		full[p] = false;
		selectPosition(p + 1, index);
	}

	private static void simul() {
		int tmp[] = new int[2];
		int d=0;
		copyField = new int[N][M];
		for(int i=0;i<N;i++) {
			copyField[i]=field[i].clone();
		}
		for (int t = 0; t < N; t++) { // N초 후 무조건 0
			boolField = new boolean[N][M];
			for (int i = 0; i < M; i++) { // 궁수 순서대로
				if (full[i]) {
					queue = new LinkedList<int[]>();
					queue.offer(new int[] { N-1, i });
					search();
					
					if(!death.isEmpty()) {
						tmp=death.peek();
						if(!boolField[tmp[0]][tmp[1]]) {
							boolField[tmp[0]][tmp[1]]=true;
							d++;
						}
					}
				}
			}
			while(!death.isEmpty()) {
				tmp=death.pop();
				copyField[tmp[0]][tmp[1]]=0;
			}
			for(int i=N-2;i>=0;i--) {
				copyField[i+1]=copyField[i].clone();
			}
			Arrays.fill(copyField[0], 0);
		}
		if(result<d) {
			result=d;
		}
		return;
	}

	private static void search() { // bfs
		int depth = D;
		int size;
		int tmp[] = new int[2];
		while (true) {
			size = queue.size();
			for (int j = 0; j < size; j++) {
				tmp = queue.poll();
				if (copyField[tmp[0]][tmp[1]] == 1) {
					death.push(new int[] { tmp[0], tmp[1] });
					return;
				}
				for (int i = 0; i < 3; i++) {
					if (tmp[0] + dy[i] >= 0 && tmp[0] + dy[i] < N && tmp[1] + dx[i] >= 0 && tmp[1] + dx[i] < M) {
						queue.offer(new int[] { tmp[0] + dy[i], tmp[1] + dx[i] });
					}
				}

			}
			if (--depth == 0) {
				break;
			}
		}
		return;

	}
}
