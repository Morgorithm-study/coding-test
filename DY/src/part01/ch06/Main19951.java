package part01.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //연병장 크기
        int m = Integer.parseInt(st.nextToken()); //조교 수

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[n+2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            arr2[start] += num;
            arr2[end + 1] -= num;
        }
        for (int i = 1; i <= n; i++) {
            arr2[i] += arr2[i - 1]; //
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + arr2[i]+ " ");
        }
    }
}
