package com.example.memoryDB.book.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "book")
public class BookEntity {

    @Id//프라이머리 키로 맵핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)//맵핑 with auto increment=데이터 베이스에서 관리
    private Long id;//Long mapping with bigint(32)

    private String name;
    private String category;
    private BigDecimal amount;//mapping with DECIMAL(14,0)
}
