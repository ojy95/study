package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_16234_인구이동 {
	static int[][] area;
	static boolean[][] boolArea;
	static int result = 0;
	static int N;
	static int L;
	static int R;
	static int dy[] = new int[] { -1, 0, 1, 0 };// 상우하좌
	static int dx[] = new int[] { 0, 1, 0, -1 };
	static int count;
	static boolean oneMore;
	static int saveY[];
	static int saveX[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		area = new int[N + 2][N + 2];
		boolArea = new boolean[N + 2][N + 2];
		saveY = new int[N * N];
		saveX = new int[N * N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				area[i + 1][j + 1] = Integer.parseInt(st.nextToken());
			}
		}

		moveArea();
		System.out.println(result);
	}

	private static void moveArea() {
		int sum;
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (boolArea[i + 1][j + 1])
						continue;
					for (int k = 0; k < 4; k++) {
						if (area[i + 1 + dy[k]][j + 1 + dx[k]] == 0 || boolArea[i + 1 + dy[k]][j + 1 + dx[k]])
							continue;

						if (Math.abs(area[i + 1][j + 1] - area[i + 1 + dy[k]][j + 1 + dx[k]]) >= L
								&& Math.abs(area[i + 1][j + 1] - area[i + 1 + dy[k]][j + 1 + dx[k]]) <= R) {
							boolArea[i + 1][j + 1] = true;
							count = 1;
							saveY[count - 1] = i + 1;
							saveX[count - 1] = j + 1;
							sum = checkPoint(i, j, area[i + 1][j + 1]);
							oneMore = true;
							for (int l = 0; l < count; l++) {
								area[saveY[l]][saveX[l]] = sum / count;
							}
							count = 0;
							saveY = new int[N * N];
							saveX = new int[N * N];
							break;
						}
					}
				}
			}

			if (oneMore) {
				result++;
				oneMore = false;
				boolArea = new boolean[N + 2][N + 2];
			} else
				break;
		}
	}

	private static int checkPoint(int y, int x, int population) {
		for (int k = 0; k < 4; k++) {
			if (area[y + 1 + dy[k]][x + 1 + dx[k]] == 0 || boolArea[y + 1 + dy[k]][x + 1 + dx[k]])
				continue;

			if (Math.abs(area[y + 1][x + 1] - area[y + 1 + dy[k]][x + 1 + dx[k]]) >= L
					&& Math.abs(area[y + 1][x + 1] - area[y + 1 + dy[k]][x + 1 + dx[k]]) <= R) {
				boolArea[y + 1 + dy[k]][x + 1 + dx[k]] = true;
				count++;
				saveY[count - 1] = y + 1 + dy[k];
				saveX[count - 1] = x + 1 + dx[k];
				population += checkPoint(y + dy[k], x + dx[k], area[y + 1 + dy[k]][x + 1 + dx[k]]);
			}
		}
		return population;
	}
}
