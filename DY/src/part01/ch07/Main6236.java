package part01.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int min = 1, max = 1;

        for(int i=0;i < N;i++) {
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, money[i]);
            max += money[i];
        }

        int mid, count, sum;
        while(min <= max){
            mid = (min+max)/2;

            sum = 0;
            count = 1;

            for(int i=0;i<N;i++){
                sum += money[i];
                if(sum>mid) {
                    sum = money[i];
                    count++;
                }
            }
            if(count>M) min = mid+1;
            else max = mid-1;
        }

        System.out.println(min);

    }
}
