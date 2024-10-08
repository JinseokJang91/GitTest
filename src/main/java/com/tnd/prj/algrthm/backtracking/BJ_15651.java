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
 *
 * ===============================================
 * </pre>
 */
public class BJ_15651 {
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        submit(input);
    }

    private static void submit(String input) {
        String[] inputs = input.split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        solution(N, M);
    }

    private static void solution(int N, int M) {
        if(checkValid(N, M)) {
            nums = new int[M];

            backtracking(N, M, 0);
        }
    }

    private static void backtracking(int N, int M, int idx) {
        if(idx == M) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();

            return;
        }

        for(int i = 0; i < N; i++) {
            nums[idx] = i + 1;

            backtracking(N, M, idx + 1);
        }
    }

    private static boolean checkValid(int N, int M) {
        if((N >= 1 && N <= 7) && (M >= 1 && M <= 7)) {
            return N >= M;
        }

        return false;
    }
}
