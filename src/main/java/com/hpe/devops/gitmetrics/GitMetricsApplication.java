package com.hpe.devops.gitmetrics;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GitMetricsApplication {
	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GitMetricsApplication.class, args);
    }
}
