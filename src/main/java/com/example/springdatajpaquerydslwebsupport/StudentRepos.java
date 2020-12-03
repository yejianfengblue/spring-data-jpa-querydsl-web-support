package com.example.springdatajpaquerydslwebsupport;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface StudentRepos extends PagingAndSortingRepository<Student, Long>,
        QuerydslPredicateExecutor<Student>, QuerydslBinderCustomizer<QStudent> {

    @Override
    default void customize(QuerydslBindings bindings, QStudent root) {

        bindings.bind(root.major)
                .all((path, value) -> Optional.of(path.in(value)));
    }
}
