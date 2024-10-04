package com.tnd.prj.autoConfig;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

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
@AutoConfiguration
@ConditionalOnProperty(name = "memory", havingValue = "on") // memory=on 환경정보가 있을 떄만 라이브러리 사용 및 스프링 빈 등록됨
public class MemoryAutoConfig {
    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
