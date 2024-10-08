package com.tnd.prj.algrthm.backtracking;

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
public class BJ_15649_try2 {
    public boolean[] isVisited;
    public int[] nums;
    public int count;

    public void solution(int n, int m) {
        // # Example
        //   - [n=3, m=2]이면 1~3 중에 2개를 골라 생성할 수 있는 수열의 경우의수
        // # Answer
        //   - [[1,2], [1,3], [2,1], [2,3], [3,1], [3,2]]

        // # Solution
        //   - 재귀함수 사용

        // # Try
        //   - 배열의 각 인덱스 별 방문여부를 설정
        //   - 재귀함수를 통해 결과인 경우의 수의 각 인덱스에 해당하는 값을 세팅
        // # Result
        //   - N=3, M=1인 경우, 경우의수 결과는 [1, 2, 3]
        //     - idx 파라미터를 설정해 출력할 결과 배열의 인덱스에 값을 세팅할 수 있도록 함
        //     - 반복문 순서
        //       - i = 0 / idx = 0
        //         - i 번째 인덱스 방문여부 true 처리 및 nums[idx] 값을 (i + 1)로 세팅
        //         - (idx + 1) 값을 가지고 재귀함수 호출 => 종료 조건에 해당 => 직전호출로 돌아간 후 나머지 로직인 [isVisited[i] = false;] 수행
        //         - 다음 인덱스(i)로 이동
        //       - i = 1
        //         - 동일 과정 반복

        if(checkValid(n ,m)) {
            isVisited = new boolean[n];
            nums = new int[m];

            backtracking(n, m, 0, 0);
        }
    }

    private void backtracking(int n, int m, int idx, int cnt) {
        System.out.println("[START] ---------------" + cnt + "th FUNCTION ---------------");
//        System.out.println("> [idx : " + idx + ", N : " + N + ", M : " + M + "] <");
        if(idx == m) {
            for(int val : nums) {
                System.out.print(val + " ");
            }
            System.out.println();

            System.out.println("[END] ---------------" + cnt + "th FUNCTION ---------------");
            return;
        }

        for(int i = 0; i < n; i++) {
            // 조건(!isVisited[i])을 제외하면 일괄로 출력됨
            // 그 결과를 필터링하기 위해 조건을 추가한다고 생각하면 이해하기 편함

            if(!isVisited[i]) {
                isVisited[i] = true;
                nums[idx] = i + 1;

                count++;
                backtracking(n, m, idx + 1, cnt + 1);
                System.out.println("[END] ---------------" + cnt + "th FUNCTION ---------------");

                isVisited[i] = false;

                System.out.println(">>> initialize isVisited[" + i + "] : " + isVisited[i]);
            }
        }
    }

    private boolean checkValid(int n, int m) {
        if((n >= 1 && n <= 8) && (m >= 1 && m <= 8)) {
            return m <= n;
        }

        return false;
    }

    public void submit(String input) {
        String[] inputs = input.split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        solution(n, m);
    }
}
