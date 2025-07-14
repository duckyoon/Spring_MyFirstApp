package com.junes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;

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
        String username = (String)model.get("name");
        // 양방향 바인딩 구현
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1),false);
        model.put("todo", todo);
        return "todo";
    }

    // POST 요청 처리
    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            // validation error 발생하면 리턴
            return "todo";
        }
        todoService.addTodo((String)model.get("name"), todo.getDescription(), LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }

}
