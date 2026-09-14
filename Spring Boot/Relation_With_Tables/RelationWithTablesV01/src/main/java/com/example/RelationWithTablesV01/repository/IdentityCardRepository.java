package com.example.RelationWithTablesV01.repository;

import com.example.RelationWithTablesV01.entity.IdentityCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IdentityCardRepository extends JpaRepository<IdentityCard, UUID>
{
    IdentityCard findByStudent_Id(UUID id);
}
