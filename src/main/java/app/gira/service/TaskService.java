package app.gira.service;

import app.gira.domain.models.service.TaskServiceModel;

import java.util.List;

public interface TaskService {
    TaskServiceModel add(TaskServiceModel taskServiceModel);

    List<TaskServiceModel> findAll();

    void progress(String id);
}
