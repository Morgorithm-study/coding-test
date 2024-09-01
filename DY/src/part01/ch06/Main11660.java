package part01.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //표의 크기
        int m = Integer.parseInt(st.nextToken()); //누적합 구하는 횟수

        //표 만들기
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                //한줄씩 누적합 저장하기
                matrix[i][j]= matrix[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        //누적 합 구하기
        for(int i = 0; i < m; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j <= x2; j++){
                //x기준
                sum += matrix[j][y2] - matrix[j][y1-1];
            }
            System.out.println(sum);
        }
    }
}
