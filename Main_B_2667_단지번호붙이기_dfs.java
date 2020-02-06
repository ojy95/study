

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2667_단지번호붙이기_오정엽_dfs {
	static int N;
	static int array[][];
	static boolean boolArray[][];
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String str;
		N = Integer.parseInt(st.nextToken());
		array = new int[N + 2][N + 2];
		boolArray = new boolean[N + 2][N + 2];
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine());
			str = st.nextToken();
			for (int j = 1; j < N + 1; j++) {
				if (str.charAt(j - 1) == '1') {
					array[i][j] = 1;
					boolArray[i][j] = true;
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (boolArray[i][j]) {

					boolArray[i][j] = false;
					queue.offer(dfs(i, j));
				}
			}
		}
		System.out.println(queue.size());
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

	private static int dfs(int y, int x) {
		int num = 1;
		for (int i = 0; i < 4; i++) {
			if (y + dy[i] == 0 || y + dy[i] == N + 1 || x + dx[i] == 0 || x + dx[i] == N + 1)
				continue;
			if (array[y + dy[i]][x + dx[i]] == 1 && boolArray[y + dy[i]][x + dx[i]]) {
				boolArray[y + dy[i]][x + dx[i]] = false;
				num += dfs(y + dy[i], x + dx[i]);
			}
		}
		return num;
	}
}
