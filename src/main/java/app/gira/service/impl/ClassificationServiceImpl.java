package app.gira.service.impl;

import app.gira.domain.entities.Classification;
import app.gira.domain.entities.enums.ClassificationNameEnum;
import app.gira.domain.models.service.ClassificationServiceModel;
import app.gira.repository.ClassificationRepository;
import app.gira.service.ClassificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ModelMapper modelMapper) {
        this.classificationRepository = classificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initialize() {
        if (classificationRepository.count() == 0) {
            Arrays.stream(ClassificationNameEnum.values())
                    .forEach(classificationNameEnum -> {
                        Classification classification = new Classification(classificationNameEnum,
                                "Description for " + classificationNameEnum);
                        classificationRepository.saveAndFlush(classification);
                    });
        }
    }

    @Override
    public ClassificationServiceModel findByName(ClassificationNameEnum classificationNameEnum) {
        return modelMapper.map(classificationRepository.findByClassificationName(classificationNameEnum)
        ,ClassificationServiceModel.class);
    }
}
