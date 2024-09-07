package part01.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long result = 0;
        long max = 0;

        long [] arr= new long[K];
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        System.out.println(search(arr, N, max));
    }

    private static long search(long arr[], int N, long end){
        long middle = 0;
        long start = 1;

        while(start <= end){
            middle = (start + end)/2;
            long cnt = 0;

            for(long n: arr){
                cnt += n / middle;
            }

            if(cnt < N){
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }
        return (end + start) / 2;
    }
}
