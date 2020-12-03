package com.example.springdatajpaquerydslwebsupport;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StudentPopulator implements CommandLineRunner {

    private final StudentRepos studentRepos;

    @Override
    public void run(String... args) throws Exception {

        studentRepos.save(new Student("Arthur", "sword"));
        studentRepos.save(new Student("Merlin", "magic"));
        studentRepos.save(new Student("Lancelot", "lance"));
    }
}
