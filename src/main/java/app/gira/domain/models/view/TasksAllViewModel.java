package app.gira.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TasksAllViewModel {
    private String name;
    private String userUsername;
    private String classificationClassificationName;
    private String dueDate;
    private String progress;
    private String id;
}
