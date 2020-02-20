package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2206_벽부수고이동하기 {
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int N, M, result = 1;
	static int[][] map;
	static int[][] boolMap;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		boolMap[0][0] = 2;
		q.offer(new int[] { 0, 0, 1 }); // y x 벽횟수
		if (searchMin()) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

//	3 6
//	010000
//	010111
//	000110
	private static boolean searchMin() {
		int[] tmp = new int[3];
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				tmp = q.poll();
				if (tmp[0] == N - 1 && tmp[1] == M - 1)
					return true;

				for (int i = 0; i < 4; i++) {
					int moveY = tmp[0] + dy[i];
					int moveX = tmp[1] + dx[i];
					int canBreak = tmp[2];
					if (moveY < 0 || moveY > N - 1 || moveX < 0 || moveX > M - 1) {
						continue;
					}
					if (map[moveY][moveX] == 0 && boolMap[moveY][moveX] < 1 + canBreak) {
						boolMap[moveY][moveX] = 1 + canBreak;
						q.offer(new int[] { moveY, moveX, canBreak });
					} else if (map[moveY][moveX] == 1 && canBreak == 1) {
						boolMap[moveY][moveX] = 1;
						q.offer(new int[] { moveY, moveX, 0 });
					}
				}
				
			}
			for (int j = 0; j < N; j++) {
				System.out.println(Arrays.toString(boolMap[j]));
			}
			System.out.println();
			result++;
			
		}
		return false;
	}
}
