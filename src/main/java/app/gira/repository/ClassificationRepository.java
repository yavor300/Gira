package app.gira.repository;

import app.gira.domain.entities.Classification;
import app.gira.domain.entities.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {
    Classification findByClassificationName(ClassificationNameEnum classificationNameEnum);
}
