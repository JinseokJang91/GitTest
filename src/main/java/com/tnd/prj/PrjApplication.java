package com.tnd.prj;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PrjApplication {
	@PostConstruct
	public static void initMemoryFinder() {
		log.info("init MemoryFinder");
	}

	public static void main(String[] args) {
		SpringApplication.run(PrjApplication.class, args);
	}

}
