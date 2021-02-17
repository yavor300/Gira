package app.gira.domain.entities;

import app.gira.domain.entities.enums.ClassificationNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
@Getter
@Setter
@NoArgsConstructor
public class Classification extends BaseEntity {
    @Column(unique = true, nullable = false, name = "name")
    @Enumerated(EnumType.STRING)
    private ClassificationNameEnum classificationName;
    @Column
    private String description;
}
