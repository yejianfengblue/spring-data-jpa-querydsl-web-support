package com.example.springdatajpaquerydslwebsupport;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepos studentRepos;

    @GetMapping
    ResponseEntity<List<Student>> getAll(Predicate predicate) {

        Iterable<Student> students = studentRepos.findAll(predicate);
        return ResponseEntity.ok(StreamSupport.stream(students.spliterator(), false)
                                              .collect(Collectors.toList()));
    }
}
