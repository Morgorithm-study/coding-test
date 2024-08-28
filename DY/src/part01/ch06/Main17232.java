package part01.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바둑판 크기 (열)
        int M = Integer.parseInt(st.nextToken()); // 바둑판 크기 (행)
        int T = Integer.parseInt(st.nextToken()); // 시간

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 기준이 되는 정수
        int a = Integer.parseInt(st.nextToken()); // 주위개수 기준
        int b = Integer.parseInt(st.nextToken()); // 주위개수 기준
        char[][] arr = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine(); // 수정된 부분: 불필요한 StringTokenizer 제거
            for (int j = 1; j <= M; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        int[][] sum = new int[N + 1][M + 1];
        for (int t = 0; t < T; t++) { // 시간만큼 반복하기
            // 누적합 구하기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    sum[i][j] = arr[i][j] == '*' ? 1 : 0; // 초기화 및 값 설정
                    if (i > 1) sum[i][j] += sum[i - 1][j];
                    if (j > 1) sum[i][j] += sum[i][j - 1];
                    if (i > 1 && j > 1) sum[i][j] -= sum[i - 1][j - 1];
                }
            }

            char[][] newArr = new char[N + 1][M + 1]; // 새로운 배열로 갱신
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int r1 = Math.max(i - K, 1);
                    int c1 = Math.max(j - K, 1);
                    int r2 = Math.min(i + K, N);
                    int c2 = Math.min(j + K, M);

                    int arround = sum[r2][c2]
                            - (c1 > 1 ? sum[r2][c1 - 1] : 0)
                            - (r1 > 1 ? sum[r1 - 1][c2] : 0)
                            + (r1 > 1 && c1 > 1 ? sum[r1 - 1][c1 - 1] : 0);

                    if (arr[i][j] == '*') arround--;

                    if (arr[i][j] == '*') {
                        newArr[i][j] = (arround < a || arround > b) ? '.' : '*';
                    } else {
                        newArr[i][j] = (arround > a && arround <= b) ? '*' : '.';
                    }
                }
            }
            arr = newArr; // 새로운 배열로 교체
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}