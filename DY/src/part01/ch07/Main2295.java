package part01.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int [n];
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< n; i++){
            for(int j = i; j < n; j++){
                set.add(arr[i] + arr[j]);
            }
        }

        int max = -1;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                int num = arr[i] - arr[j];
                if(set.contains(num))
                    Math.max(max, arr[i]);
            }
        }

        System.out.println(max);
    }
}
