package com.directa24.main.challenge.entity;

import lombok.Data;

import java.util.List;
@Data
public class Movies {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<MovieData> data;
}
