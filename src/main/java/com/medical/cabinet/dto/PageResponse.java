package com.medical.cabinet.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {
    private List<T> elements;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
}
