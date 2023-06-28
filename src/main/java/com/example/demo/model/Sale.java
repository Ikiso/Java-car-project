package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Car car;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Manager manager;

    private int quantity;
}
