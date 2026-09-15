package com.unpredictableXRelations.UserAndTaskRelation.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO
{
    private UUID id;
    private String name;
    private String email;
    private String code;
}
