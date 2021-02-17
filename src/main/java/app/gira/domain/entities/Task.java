package app.gira.domain.entities;

import app.gira.domain.entities.enums.ProgressEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProgressEnum progress;
    @Column(nullable = false)
    private LocalDate dueDate;
    @ManyToOne
    private Classification classification;
    @ManyToOne
    private User user;
}

