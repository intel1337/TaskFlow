package com.taskflow.app;

import org.springframework.boot.SpringApplication;

public class TestTaskflowApplication {

	public static void main(String[] args) {
		SpringApplication.from(TaskflowApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
