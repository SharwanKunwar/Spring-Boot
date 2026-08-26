package com.unpredictableXsoft.Hard_delete.ProjectsXStore.dtos;

import com.unpredictableXsoft.Hard_delete.ProjectsXStore.enums.Category;
import com.unpredictableXsoft.Hard_delete.ProjectsXStore.enums.Stacks;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO
{
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Project title must be between 3 to 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotBlank(message = "Project source url is required.")
    private String source;

    @NotBlank(message = "Project live url is required.")
    private String live;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Stacks is required")
    private Stacks stacks;
}
