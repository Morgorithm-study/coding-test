package part01.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        num[0] = 0;
        for (int i = 1; i<= n; i++){
            num[i] = num[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i =0 ; i < sumCnt; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            System.out.println(num[last] - num[first - 1]);
        }
    }
}
