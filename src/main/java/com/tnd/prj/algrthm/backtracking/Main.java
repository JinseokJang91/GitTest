package com.tnd.prj.algrthm.backtracking;

import java.util.*;

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
public class Main {
    public static void main(String[] args) {
        test_bj_15649();
    }

    private static void test_bj_15649() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

//        BJ_15649_try1_timeout bj_15649_try1_timeout = new BJ_15649_try1_timeout();
//        bj_15649_try1_timeout.submit(input);

        BJ_15649_try2 bj_15649_try2 = new BJ_15649_try2();
        bj_15649_try2.submit(input);
    }
}


