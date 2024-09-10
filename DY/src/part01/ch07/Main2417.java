package part01.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        System.out.println(binarySearch(N));
    }

    public static long binarySearch(long n){
        long start = 0;
        long end = n;
        long answer = 0;

        while(start <= end) {
            long middle = (start + end) / 2;

            if (Math.pow(middle, 2) >= n) {
                answer = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return answer;
    }
}
