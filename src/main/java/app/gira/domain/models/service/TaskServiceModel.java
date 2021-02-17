package app.gira.domain.models.service;

import app.gira.domain.entities.enums.ProgressEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TaskServiceModel {
    private String id;
    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationServiceModel classification;
    private UserServiceModel user;
}
