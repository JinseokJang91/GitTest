package com.tnd.prj.algrthm.backtracking;

import java.util.*;

/**
 * <pre>
 * 15650번 N과 M (2)
 * </pre>
 *
 * @since 2024-10-08
 * <pre>
 * ===============================================
 * 재귀함수 사용
 * ===============================================
 * </pre>
 */
public class BJ_15650 {
    private static boolean[] isVisited;
    private static int[] nums;
    private static final List<Set<Integer>> resultList = new ArrayList<>();

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
            isVisited = new boolean[N];
            nums = new int[M];

            backtracking(N, M, 0);

            // 결과 출력
            for(Set<Integer> resultSet : resultList) {
                for (Integer result : resultSet) {
                    System.out.print(result + " ");
                }
                System.out.println();
            }
        }
    }

    private static void backtracking(int N, int M, int idx) {
        if(idx == M) {
            Set<Integer> tmpSet = new HashSet<>();

            for (int num : nums) {
                tmpSet.add(num);
            }
            // HashSet : 자동 오름차순 정렬

            Set<Integer> caseSet = new HashSet<>(tmpSet);

            if(!resultList.contains(caseSet)) {
                resultList.add(caseSet);
            }

            tmpSet.clear();

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                nums[idx] = i + 1;

                backtracking(N, M, idx + 1);

                isVisited[i] = false;
            }
        }
    }

    private static boolean checkValid(int N, int M) {
        // 1 <= M <= N <= 8
        if((M >= 1 && M <= 8) && (N >= 1 && N <= 8)) {
            return M <= N;
        }

        return false;
    }
}
