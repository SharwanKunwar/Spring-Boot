package com.unpredictableXsoft.Hard_delete.ProjectsXStore.dtos;

import com.unpredictableXsoft.Hard_delete.ProjectsXStore.enums.Category;
import com.unpredictableXsoft.Hard_delete.ProjectsXStore.enums.Stacks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDTO
{
    private UUID id;
    private String title;
    private String description;
    private String source;
    private String live;
    private Category category;
    private Stacks stacks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
