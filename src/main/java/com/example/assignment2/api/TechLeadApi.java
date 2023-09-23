package com.example.assignment2.api;

import com.example.assignment2.dto.TechLeadDto;
import com.example.assignment2.service.custom.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tech")

public class TechLeadApi {

    @Autowired
    TechLeadService techLeadService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    TechLeadDto saveTechLead(@RequestPart String name, @RequestPart String contactNo, @RequestPart byte[] photo) {

        TechLeadDto techLeadDto = new TechLeadDto();
        techLeadDto.setName(name);
        techLeadDto.setContactNo(contactNo);
        techLeadDto.setPhoto(photo);
        techLeadDto.setId(1234);

        return techLeadService.save(techLeadDto);

    }

    @DeleteMapping("{code}")
    void deleteTechLead(@PathVariable Integer id) {
        techLeadService.deleteById(id);
    }

    @PutMapping("{code}")
    void updateTechLead(@PathVariable Integer id, @RequestBody TechLeadDto techLeadDto) {
        techLeadService.updateTechLead(id, techLeadDto.getName(), techLeadDto.getContactNo(), techLeadDto.getPhoto());
    }

    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    TechLeadDto getSelectedTechLead(@PathVariable Integer id) {
        return techLeadService.getById(id);
    }
}
