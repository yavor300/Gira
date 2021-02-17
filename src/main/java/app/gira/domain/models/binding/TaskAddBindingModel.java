package app.gira.domain.models.binding;

import app.gira.domain.entities.enums.ClassificationNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TaskAddBindingModel {
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters!")
    private String name;
    @Size(min = 6, message = "Description length must be more than 5 characters!")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date must be added!")
    @FutureOrPresent(message = "The date cannot be in the past!")
    private LocalDate dueDate;
    @NotNull(message = "Classification cannot be null!")
    private ClassificationNameEnum classification;
}
