package com.unpredictableXRelations.UserAndTaskRelation.task.dtos;

import com.unpredictableXRelations.UserAndTaskRelation.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TaskRequestDTO
{
    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Description is required.")
    @Size(max = 300, message = "Description must be in 300 character.")
    private String description;


}
