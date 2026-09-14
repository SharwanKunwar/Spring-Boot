package com.example.RelationWithTablesV01.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "id_cards")
public class IdentityCard
{
    @Id
    @GeneratedValue
    private UUID cardID;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false, unique = true)
    private Student student;

    @PrePersist
    public void onCreate(){
        String generatedCardNumber = UUID.randomUUID().toString();
        cardNumber = generatedCardNumber;
    }

}