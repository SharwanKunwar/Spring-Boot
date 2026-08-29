package com.unpredictableXpractice.Books.repository;

import com.unpredictableXpractice.Books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID>
{
    // Find a single non-deleted book by ID
    Optional<Book> findByIdAndDeletedFalse(UUID id);

    // Find all non-deleted books
    List<Book> findByDeletedFalse();
}
