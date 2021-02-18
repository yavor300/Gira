package app.gira.web.controllers;

import app.gira.domain.models.view.TasksAllViewModel;
import app.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        } else {
            model.addAttribute("tasks", taskService.findAll().stream().map(t -> modelMapper.map(t, TasksAllViewModel.class)).collect(Collectors.toList()));
            return "home";
        }
    }
}
