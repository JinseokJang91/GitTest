package com.tnd.prj.algrthm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 * 15654번 N과 M (5)
 * </pre>
 *
 * @since 2024-10-11
 * <pre>
 * ===============================================
 * 1. N, M이 주어진다.
 * 2. N개의 자연수가 주어진다.
 * 3. N개의 자연수 중 M개를 고른 수열을 출력한다. (사전 순 오름차순)
 *
 * 3 1
 * 4 5 2
 * ---
 * 2
 * 4
 * 5
 * ===============================================
 * </pre>
 */
public class BJ_15654 {
    public static int[] nums;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String elements = br.readLine();

        submit(input, elements);
    }

    private static void submit(String input, String elements) {
        StringTokenizer st1 = new StringTokenizer(input);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(elements);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        solution(N, M, arr);
    }

    private static void solution(int N, int M, int[] arr) {
        if(checkValid(N, M, arr)) {
            nums = new int[M];
            isVisited = new boolean[N];

            backtracking(N, M, arr, 0);

            System.out.println(sb.toString());
        }
    }

    private static void backtracking(int N, int M, int[] arr, int depth) {
        if(depth == M) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                nums[depth] = arr[i];

                backtracking(N, M, arr, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean checkValid(int N, int M, int[] arr) {
        if((N >= 1 && N <= 8) && (M >= 1 && M <= 8)) {
            for (int el : arr) {
                if(el <= 0 || el > 10000) {
                    return false;
                }
            }

            return N >= M;
        }

        return false;
    }
}
