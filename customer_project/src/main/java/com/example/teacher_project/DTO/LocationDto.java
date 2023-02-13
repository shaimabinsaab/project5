package com.example.teacher_project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LocationDto {
    private Integer store_id;
    private String area;
    private String street;

}
