package com.unpredictableXRelations.UserAndTaskRelation.task.repository;

import com.unpredictableXRelations.UserAndTaskRelation.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>
{
    List<Task> getAllTaskByUserId(UUID id);

}
