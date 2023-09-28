package com.example.assignment2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "techLead")
public class TechLeadEntity implements SuperEntity{

    @Id
    int id;
    String name;
    String contactNo;
    @Lob
    @Column(columnDefinition = "BLOB")
    byte[] photo;

}
