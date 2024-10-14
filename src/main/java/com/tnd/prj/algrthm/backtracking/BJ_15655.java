package com.tnd.prj.algrthm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <pre>
 * 15655번 N과 M (6)
 * </pre>
 *
 * @since 2024-10-11
 * <pre>
 * ===============================================
 * 1. N, M이 주어진다.
 * 2. N개의 자연수가 주어진다.
 * 3. N개의 자연수 중 M개를 고른 수열을 출력한다. (숫자 오름차순)
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
public class BJ_15655 {
    private static int[] nums;
    private static boolean[] isVisited;
    private static final List<String> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String elements = br.readLine();

        submit(input, elements);
    }

    private static void submit(String input, String elements) {
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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

            for(String result : resultList) {
                System.out.println(result);
            }
        }
    }

    private static void backtracking(int N, int M, int[] arr, int depth) {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < nums.length; i++) {
                if(i == 0) {
                    sb.append(nums[i]).append(" ");
                }

                if(i - 1 >= 0 && nums[i] > nums[i - 1]) {
                    sb.append(nums[i]).append(" ");
                }
            }

            int count = sb.toString().split(" ").length;

            if(count == M) {
                resultList.add(sb.toString());
            }

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
