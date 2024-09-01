package part01.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

       int i = 0;
       int j = arr.length -1;

       int bestNum1 = 0;
       int bestNum2 = 0;

       int min = Integer.MAX_VALUE;
       int sum;
       int abs;
       while(i < j){
           sum = arr[i] + arr[j];
           abs = Math.abs(sum);
           if(abs < min){
               bestNum1 = arr[i];
               bestNum2 = arr[j];
               min = abs;
           }
           if(sum > 0)
               j--;
           else
               i++;
       }

        System.out.println(bestNum1 + " " + bestNum2);
    }
}
