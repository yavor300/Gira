package app.gira.domain.models.service;

import app.gira.domain.entities.enums.ClassificationNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassificationServiceModel {
    private String id;
    private ClassificationNameEnum classificationName;
    private String description;
}
