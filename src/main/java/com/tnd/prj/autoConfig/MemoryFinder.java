package com.tnd.prj.autoConfig;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * File Description
 * </pre>
 *
 * @since 2024-10-02
 * <pre>
 * ===============================================
 *
 * ===============================================
 * </pre>
 */
@Slf4j
@Component
public class MemoryFinder {
    public Memory get() {
        long max = Runtime.getRuntime().maxMemory(); // JVM이 사용할 수 있는 최대 메모리
        long total = Runtime.getRuntime().totalMemory(); // JVM이 확보한 전체 메모리
        long free = Runtime.getRuntime().freeMemory(); // JVM이 확보한 전체 메모리 중 사용하지 않은 것

        long used = total - free;

        return new Memory(used, max);
    }
}
