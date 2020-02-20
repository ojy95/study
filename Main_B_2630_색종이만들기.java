package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2630_색종이만들기 {
	static int[][] map;
	static int white = 0, blue = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					count++;
				}
			}
		}

		cutMap(0, 0, N, count);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cutMap(int startY, int startX, int length, int count) {
		if (count == length * length) {
			blue++;
			return;
		}
		if (count == 0) {
			white++;
			return;
		}
		int nCount[] = new int[4];
		int position;
		for (int i = startY; i < startY + length; i++) {
			for (int j = startX; j < startX + length; j++) {
				if (i < startY+ length / 2 && j >= startX+length / 2) { // 1사분면
					position = 0;
				} else if (i < startY+length / 2 && j < startX+length / 2) { // 2사분면
					position = 1;
				} else if (i >= startY+length / 2 && j < startX+length / 2) { // 3사분면
					position = 2;
				} else {
					position = 3;
				}
				if (map[i][j] == 1)
					nCount[position]++;
			}
		}
		cutMap(startY, startX + length / 2, length / 2, nCount[0]);
		cutMap(startY, startX, length / 2, nCount[1]);
		cutMap(startY + length / 2, startX, length / 2, nCount[2]);
		cutMap(startY + length / 2, startX + length / 2, length / 2, nCount[3]);
	}

}
