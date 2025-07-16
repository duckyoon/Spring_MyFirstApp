package com.junes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static{
        todos.add(new Todo(++todosCount, "junes", "Learn AWSggg",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "junes", "Learn DevOpsggg",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "junes", "Learn Springggg",
                LocalDate.now().plusYears(3), false));

    }

    public List<Todo> findByUsername(String username){
        // username이 매칭되면 리스트로 반환
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate,  Boolean done){
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id){
        // 모든 todo를 확인하고 조건에 매칭되면 removeIf 진행함.
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        //조건에 맞는 todo를 찾아 return
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

}
