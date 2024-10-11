package com.tnd.prj.algrthm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <pre>
 * 15652번 N과 M (4)
 * </pre>
 *
 * @since 2024-10-11
 * <pre>
 * ===============================================
 * 비내림차순
 * ===============================================
 * </pre>
 */
public class BJ_15652 {
    private static int[] nums;
    private static final List<String> resultList = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        submit(input);

        br.close();
    }

    private static void submit(String input) {
        StringTokenizer st = new StringTokenizer(input);
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        solution(N, M);
    }

    private static void solution(int N, int M) {
        if(checkValid(N, M)) {
            nums = new int[M];

            backtracking(N, M, 0);

            for(String result : resultList) {
                System.out.println(result);
            }
        }
    }

    private static void backtracking(int N, int M, int depth) {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < nums.length; i++) {
                if(i == 0) {
                    sb.append(nums[i]).append(" ");
                }

                if(i - 1 >= 0 && nums[i - 1] <= nums[i]) {
                    sb.append(nums[i]).append(" ");
                }
            }

            if(sb.length() == M * 2) {
                resultList.add(sb.toString());
            }

            return;
        }

        for(int i = 0; i < N; i++) {
            nums[depth] = i + 1;

            backtracking(N, M, depth + 1);
        }
    }

    private static boolean checkValid(int N, int M) {
        if((N >= 1 && N <= 8) && (M >= 1 && M <= 8)) {
            return N >= M;
        }

        return false;
    }
}
