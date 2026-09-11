package com.example.DigitalXShop.product.entity;

import com.example.DigitalXShop.product.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.DigitalXShop.product.mapper.ProductMapper.NEPAL_ZONE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String color;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;

    @Builder.Default
    private boolean active = true;

    @Builder.Default
    private boolean deleted = false;

    @PrePersist
    protected void onCreate()
    {
        LocalDateTime now = LocalDateTime.now(NEPAL_ZONE);
        createdAt = now;
        updatedAt = now;
    }


}
