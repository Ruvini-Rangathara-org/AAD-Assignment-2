package com.example.assignment2.dto;

import java.io.Serializable;
public class TechLeadDto implements Serializable, SuperDto {

    int id;
    String name;
    String contactNo;
    byte[] photo;

    public TechLeadDto() {
    }

    public TechLeadDto(int id, String name, String contactNo, byte[] photo) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
