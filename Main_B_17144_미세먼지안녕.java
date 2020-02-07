package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_17144_미세먼지안녕 {
	static int[][] array;
	static int[][] copyArray;
	static int R;
	static int C;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		array = new int[R + 2][C + 2];
		copyArray = new int[R + 2][C + 2];
		int moveY, moveX;
		int airY = 0;
		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j < C + 1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
			if (array[i][1] == -1) {
				airY = i;
			}
		}

		for (int y = 1; y < T + 1; y++) {
			for (int i = 1; i < R + 1; i++) {
				for (int j = 1; j < C + 1; j++) {
					if (array[i][j] == -1) {
						continue;
					}
					int count = 0;
					int way[] = new int[4];
					for (int k = 0; k < 4; k++) { // 확산방향 검색
						moveY = i + dy[k];
						moveX = j + dx[k];
						if (moveY == 0 || moveY == R + 1 || moveX == 0 || moveX == C + 1 || array[moveY][moveX] == -1) { // 벽,공청
							continue;
						}
						way[count++] = k; // 방향저장
					}

					for (int k = 0; k < count; k++) {
						copyArray[i+dy[way[k]]][j+dx[way[k]]] += array[i][j] / 5;
					}
					array[i][j] = array[i][j] - (array[i][j] / 5) * count;
				}
			}
			for (int i = airY - 3; i > 0; i--) { // 1열아래로
				array[i + 1][1] = array[i][1] + copyArray[i][1];
			}
			for (int i = airY + 2; i < R + 1; i++) {// 1열위로
				array[i - 1][1] = array[i][1] + copyArray[i][1];
			}
			for (int i = 2; i <= C; i++) {// 1,R행
				array[1][i - 1] = array[1][i] + copyArray[1][i];
				array[R][i - 1] = array[R][i] + copyArray[R][i];
			}
			for (int i = 2; i <= airY - 1; i++) { // C열위로
				array[i - 1][C] = array[i][C] + copyArray[i][C];
			}
			for (int i = R - 1; i >= airY; i--) {// C열아래로
				array[i + 1][C] = array[i][C] + copyArray[i][C];
			}
			for (int i = C - 1; i >= 2; i--) {// airY,airY-1행
				array[airY][i + 1] = array[airY][i] + copyArray[airY][i];
				array[airY - 1][i + 1] = array[airY - 1][i] + copyArray[airY - 1][i];
			}
			array[airY][2] = 0;
			array[airY - 1][2] = 0;
			for (int i = 2; i < R; i++) {
				if (i == airY || i == airY - 1)
					continue;
				for (int j = 2; j < C; j++) {
					array[i][j] = array[i][j] + copyArray[i][j];
				}
			}

			copyArray = new int[R + 2][C + 2];

		}
		int sum = 0;
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				sum += array[i][j];
			}
		}
		System.out.println(sum + 2);
	}

}
