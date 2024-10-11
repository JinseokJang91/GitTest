package com.tnd.prj.algrthm.backtracking;

import java.util.Scanner;

/**
 * <pre>
 * 15651번 N과 M (3)
 * </pre>
 *
 * @since 2024-10-08
 * <pre>
 * ===============================================
 * 재귀함수 사용
 * ===============================================
 * </pre>
 */
public class BJ_15651 {
    private static int[] nums;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        submit(input);

        sc.close();
    }

    private static void submit(String input) {
        String[] inputs = input.split(" ");
        final int N = Integer.parseInt(inputs[0]);
        final int M = Integer.parseInt(inputs[1]);

        solution(N, M);
    }

    private static void solution(final int N, final int M) {
        if(checkValid(N, M)) {
            nums = new int[M];

            backtracking(N, M, 0);
            System.out.println(sb);

        }
    }

    private static void backtracking(final int N, final int M, int depth) {
        if(depth == M) {
            for(int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++) {
            nums[depth] = i + 1;

            backtracking(N, M, depth + 1);
        }
    }

    private static boolean checkValid(final int N, final int M) {
        if((N >= 1 && N <= 7) && (M >= 1 && M <= 7)) {
            return N >= M;
        }

        return false;
    }
}
