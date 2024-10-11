package com.tnd.prj.algrthm.backtracking;

import java.util.*;

/**
 * <pre>
 * 15649번 N과 M (1)
 * </pre>
 *
 * @since 2024-10-04
 * <pre>
 * ===============================================
 * 재귀함수 사용
 * ===============================================
 * </pre>
 */
public class BJ_15649 {
    public static boolean[] isVisited;
    public static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        submit(input);
    }

    private static void submit(String input) {
        String[] inputs = input.split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        solution(n, m);
    }

    private static void solution(int n, int m) {
        if(checkValid(n ,m)) {
            isVisited = new boolean[n];
            nums = new int[m];

            backtracking(n, m, 0, 0);
        }
    }

    private static void backtracking(int n, int m, int idx, int cnt) {
        if(idx == m) {
            for(int val : nums) {
                System.out.print(val + " ");
            }
            System.out.println();

            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                nums[idx] = i + 1;

                backtracking(n, m, idx + 1, cnt + 1);

                isVisited[i] = false;
            }
        }
    }

    private static boolean checkValid(int n, int m) {
        if((n >= 1 && n <= 8) && (m >= 1 && m <= 8)) {
            return m <= n;
        }

        return false;
    }
}




