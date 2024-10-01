package part01.ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 0;
        int high = 1;

        int answer = arr[N - 1] - arr[0];

        while (low < N - 1) {
            int differ = arr[high] - arr[low];

            if (differ >= M) {
                if (differ < answer) {
                    answer = differ;
                }
            }

            if (high == N - 1) {
                low++;
                continue;
            }

            if (differ > M) {
                low++;
            } else {
                high++;
            }
        }

        System.out.println(answer);
    }
}