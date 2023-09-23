package com.example.assignment2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "project")
public class ProjectEntity implements SuperEntity{

    @Id
    int code;
    String title;
    String description;

}
