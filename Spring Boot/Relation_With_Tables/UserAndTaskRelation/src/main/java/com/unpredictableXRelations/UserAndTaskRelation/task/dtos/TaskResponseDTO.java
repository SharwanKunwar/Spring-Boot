package com.unpredictableXRelations.UserAndTaskRelation.task.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class TaskResponseDTO
{
    private UUID id;
    private String title;
    private String description;
}
