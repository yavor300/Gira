package app.gira.service.impl;

import app.gira.domain.entities.Classification;
import app.gira.domain.entities.Task;
import app.gira.domain.entities.User;
import app.gira.domain.entities.enums.ProgressEnum;
import app.gira.domain.models.service.TaskServiceModel;
import app.gira.domain.models.service.UserServiceModel;
import app.gira.repository.TaskRepository;
import app.gira.service.ClassificationService;
import app.gira.service.TaskService;
import app.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class TaskServiceImpl implements TaskService {
    private final UserService userService;
    private final ClassificationService classificationService;
    private final TaskRepository taskRepository;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(UserService userService, ClassificationService classificationService, TaskRepository taskRepository, HttpSession httpSession, ModelMapper modelMapper) {
        this.userService = userService;
        this.classificationService = classificationService;
        this.taskRepository = taskRepository;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskServiceModel add(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);

        Classification classification =
                modelMapper.map(
                        classificationService.findByName(taskServiceModel.getClassification().getClassificationName()),
                        Classification.class);
        task.setClassification(classification);

        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
        User user = modelMapper.map(userService.findById(userServiceModel.getId()),
                User.class);
        task.setUser(user);

        task.setProgress(ProgressEnum.OPEN);

        return modelMapper.map(taskRepository.saveAndFlush(task), TaskServiceModel.class);
    }
}
