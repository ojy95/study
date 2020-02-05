package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_16235_나무재테크 {
	static int tree[][]; // 같은 공간 나무수
	static int food[][]; // 양분
	static int winterFood[][]; // 양분
	static int old[][][]; // 같은 공간 동갑
	static boolean die;
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int l =1245807597;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int y, x;
		tree = new int[N + 2][N + 2];
		food = new int[N + 2][N + 2];
		winterFood = new int[N + 2][N + 2];
		old = new int[N + 2][N + 2][110];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				winterFood[i][j] = Integer.parseInt(st.nextToken());
				food[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			tree[y][x]++;
			old[y][x][Integer.parseInt(st.nextToken())]++;
		}
		int survive, lastSurvive;
		for (int year = 0; year < K; year++) {
			// 봄,여름
			for (int i = 1; i < N + 1; i++) { // 밭
				for (int j = 1; j < N + 1; j++) {
					die = false; // 초기화
					survive = 0; // 살아남은 수
					for (int l = 1; l < 110;l++) { // 나무 어린순 검색
						if (die) {
							if (tree[i][j] == survive)
								break;

							if (old[i][j][l] > 0) {
								food[i][j] = food[i][j] + old[i][j][l] * (l / 2);
								tree[i][j] -= old[i][j][l];
								old[i][j][l]=0;
							}
							continue;
						}

						if (old[i][j][l] > 0) {// 같은나이 나무수만큼
							if (food[i][j] - l * old[i][j][l] >= 0) { // 동갑나무수만큼 양분되면
								food[i][j] -= l * old[i][j][l];
								survive += old[i][j][l];
								if (survive == tree[i][j])
									break; // 밭 나무수 채우면 break;
								continue;
							} else { // 없으면
								lastSurvive = food[i][j] / l; // 동갑나무 lastSurvive수만큼 살아남음
								survive += lastSurvive;
								die = true;
								tree[i][j] -= (old[i][j][l] - lastSurvive); // 앞에서 죽으면 뒤에는 다 죽지만 양분을 계산해야하기때문에
								food[i][j] += (old[i][j][l] - lastSurvive) * (l / 2) -  lastSurvive*l;//죽은거*(l/2) -산거*l
								
								old[i][j][l] = lastSurvive; // 같은나이 lastSurvive개 생존
							}
						}
					}
				}
			}
			// 가을,겨울,봄나이 더해주기
			for (int i = 1; i < N + 1; i++) { // 밭
				for (int j = 1; j < N + 1; j++) {
					for (int l = 108; l >= 0; l--) {
						if (old[i][j][l] > 0) {
							old[i][j][l + 1] = old[i][j][l];
							old[i][j][l] = 0;
							if ((l + 1) % 5 == 0) {
								for (int k = 0; k < 8; k++) { // 일단 0살로 널어주고 나중에 예외처리 해줄예정
									if (i + dy[k] > 0 && i + dy[k] < N + 1 && j + dx[k] > 0 && j + dx[k] < N + 1) {
										tree[i + dy[k]][j + dx[k]]+=old[i][j][l+1];
										old[i + dy[k]][j + dx[k]][0]+=old[i][j][l+1];
									}
								}
							}
						}
					}
					food[i][j] += winterFood[i][j];
				}
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (old[i][j][0] != 0) { // 예외처리
						old[i][j][1] += old[i][j][0];
						old[i][j][0] = 0;
					}
				}
			}
			///////////////////////////////////
//			for (int i = 1; i < N + 1; i++) {
//				System.out.println(Arrays.toString(tree[i])+(year+1));
//			}
//			System.out.println();
//			for (int i = 1; i < N + 1; i++) {
//				System.out.println(Arrays.toString(food[i])+(year+1));
//			}
//			System.out.println(Arrays.toString(old[4][4]) + (year+1));
//			System.out.println(tree[4][4]);
//			System.out.println(food[4][4]);
//			System.out.println();
		}
		int result=0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				result += tree[i][j];
			}
		}
		System.out.println(result);
	}
}
