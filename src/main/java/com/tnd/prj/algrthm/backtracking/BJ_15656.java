package com.tnd.prj.algrthm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 * 15656번 N과 M (7)
 * </pre>
 *
 * @since 2024-10-14
 * <pre>
 * ===============================================
 * 1. N, M이 주어진다.
 * 2. N개의 자연수가 주어진다.
 * 3. N개의 자연수 중 M개를 고른 수열을 출력한다. (사전 순 오름차순, 중복 포함)
 * ===============================================
 * </pre>
 */
public class BJ_15656 {
    private static int[] nums;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        submit(input1, input2);
    }

    private static void submit(String input1, String input2) {
        String[] inputs = input1.split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(input2);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution(N, M, arr);
    }

    private static void solution(int N, int M, int[] arr) {
        if(validCheck(N, M, arr)) {
            nums = new int[M];

            backtracking(N, M, arr, 0);

            System.out.println(sb.toString());
        }
    }

    private static void backtracking(int N, int M, int[] arr, int depth) {
        if(depth == M) {
            for(int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++) {
            nums[depth] = arr[i];

            backtracking(N, M, arr, depth + 1);
        }
    }

    private static boolean validCheck(int N, int M, int[] arr) {
        if((N >= 1 && N <= 7) && (M >= 1 && M <= 7)) {
            for(int el : arr) {
                if(el <= 0 || el > 10000) {
                    return false;
                }
            }

            return N >= M;
        }

        return false;
    }
}
