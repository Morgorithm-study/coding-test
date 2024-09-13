package part01.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = N-1;
        int min = Integer.MAX_VALUE;
        int a = 0,b = 0;
        Arrays.sort(arr);

        while (start < end){
            int sum = arr[start] + arr[end];

            if(min > Math.abs(sum)){ //합이 최소값보다 작을때
                min = Math.abs(sum);

                a = arr[start]; //미리 최소값 만들어주는 숫자 저장하기
                b = arr[end];

                if(sum == 0) break; //0이면 최소이기 때문에 break
            }

            if(sum < 0)
                start++;
            else end--;
        }
        System.out.println(a + " " + b);
    }
}
