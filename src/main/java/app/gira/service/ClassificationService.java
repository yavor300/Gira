package app.gira.service;

import app.gira.domain.entities.enums.ClassificationNameEnum;
import app.gira.domain.models.service.ClassificationServiceModel;

public interface ClassificationService {
    void initialize();

    ClassificationServiceModel findByName(ClassificationNameEnum classificationNameEnum);
}
