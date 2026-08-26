package com.unpredictableXsoft.Hard_delete.ProjectsXStore.entity;

import com.unpredictableXsoft.Hard_delete.ProjectsXStore.enums.Category;
import com.unpredictableXsoft.Hard_delete.ProjectsXStore.enums.Stacks;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "ProjectXStore")
@AllArgsConstructor
@NoArgsConstructor
public class Project
{
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String live;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Stacks stacks;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
