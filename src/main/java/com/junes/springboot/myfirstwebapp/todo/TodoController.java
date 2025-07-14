package com.junes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUsername("junes");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    // GET 요청 처리
    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        return "todo";
    }

    // POST 요청 처리
    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, ModelMap model){
        todoService.addTodo((String)model.get("name"), description, LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }

}
