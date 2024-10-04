package com.tnd.prj.algrthm.backtracking;

import java.util.*;
import java.util.stream.IntStream;

/**
 * <pre>
 * File Description
 * </pre>
 *
 * @since 2024-10-04
 * <pre>
 * ===============================================
 *
 * ===============================================
 * </pre>
 */
public class bj_15649 {
    public List<List<Integer>> solution(int n, int m) {
        // # Example
        //   [n=3, m=2]이면 1~3 중에 2개를 골라 생성할 수 있는 수열의 경우의수
        // # Answer
        //   [[1,2], [1,3], [2,1], [2,3], [3,1], [3,2]]

        // # Solution
        //   순열 사용 => nPm = n! / (n-m)!
        
        // # Try
        //   숫자를 랜덤뽑기로 수열 생성 후 포함여부 확인 => 없으면 List 추가 후 sorting
        // # Result
        //   시간 초과 - 랜덤뽑기 방식이 틀린듯

        List<List<Integer>> resultList = new ArrayList<>();

        if(checkValid(n ,m)) {
            int tryCnt = 0;

            int maxCase = getPermutation(n, m);
//            System.out.println("# maxCase = " + maxCase);

            while(resultList.size() != maxCase) {
                List<Integer> tmpList = new ArrayList<>();

                while(tmpList.size() != m) {
                    int randomNumber = getRandomNumber(n);

                    if(!tmpList.contains(randomNumber)) {
                        tmpList.add(randomNumber);
                    }

                    if(tmpList.size() == m) {
                        break;
                    }
                }

                List<Integer> caseList = new ArrayList<>(tmpList);
//                System.out.println("1. caseList = " + caseList);
//                System.out.println("2. T/F : " + resultList.contains(caseList));

                if(!resultList.contains(caseList)) {
                    resultList.add(caseList);
                }

                if(resultList.size() == maxCase) {
                    break;
                }

                tmpList.clear();

                tryCnt++;
            }

//            System.out.println("# tryCnt = " + tryCnt);
//            System.out.println("# resultList = " + resultList);

            int[] indexes = IntStream.range(0, m).toArray(); // {0, ... , m}

            sortResultList(resultList, indexes);

//            System.out.println("# sort resultList = " + resultList);
        }

        return resultList;
    }

    private void sortResultList(List<List<Integer>> resultList, int[] indexes) {
        Comparator<List<Integer>> comparator = Comparator.comparing(List::getFirst); // list -> list.get(0)

        for(int i = 1; i < indexes.length; i++) {
            final int index = i;
            comparator = comparator.thenComparing(list -> list.get(indexes[index]));
        }

        resultList.sort(comparator);
    }

    private int getPermutation(int n, int m) {
        int numerator = 1;
        int denominator = 1;

        int subtractNM = n - m;

        while(n != 1) {
            numerator *= n;

            n--;
        }

        if(subtractNM != 0) {
            while(subtractNM != 1) {
                denominator *= subtractNM;

                subtractNM--;
            }
        }

        return numerator / denominator;
    }

    private int getRandomNumber(int n) {
        Random rand = new Random();

        // cf. 1 <= rand.nextInt(n) <= n
        return rand.nextInt(n) + 1;
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

        List<List<Integer>> answer = solution(n, m);

        for(List<Integer> list : answer) {
            for(int i = 0; i < list.size(); i++) {
                if(i != list.size() - 1) {
                    System.out.print(list.get(i) + " ");
                } else {
                    System.out.print(list.get(i));
                }
            }
            System.out.println();
        }
    }
}
