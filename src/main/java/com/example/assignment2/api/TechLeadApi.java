package com.example.assignment2.api;

import com.example.assignment2.dto.TechLeadDto;
import com.example.assignment2.service.custom.TechLeadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tech")

public class TechLeadApi {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    TechLeadService techLeadService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    TechLeadDto saveTechLead(@RequestPart String name, @RequestPart String contactNo, @RequestPart byte[] photo) {

        TechLeadDto techLeadDto = new TechLeadDto();
        techLeadDto.setName(name);
        techLeadDto.setContactNo(contactNo);
        techLeadDto.setPhoto(photo);
        techLeadDto.setId(1235);

        System.out.println(name);
        System.out.println(contactNo);

        return techLeadService.save(techLeadDto);

        // Body -> formdata

        //    name -> user1
        //    contactNo -> pwd1
        //    photo -> 1.jpg
        //

        //http://localhost:8080/test/api/v1/tech          -> POST
        //Content-type : multipart/form-data
    }

    @DeleteMapping("{id}")
    void deleteTechLead(@PathVariable Integer id) {
        techLeadService.deleteById(id);
    }

    @PutMapping("{id}")
    void updateTechLead(@PathVariable Integer id, @RequestPart String name, @RequestPart String contactNo, @RequestPart byte[] photo) {
        techLeadService.updateTechLead(id, name, contactNo, photo);
        // Body -> formdata

        //    name -> user1
        //    contactNo -> pwd1
        //    photo -> 1.jpg
        //

        //http://localhost:8080/test/api/v1/tech/1235          -> PUT
        //Content-type : multipart/form-data
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    TechLeadDto getSelectedTechLead(@PathVariable Integer id) {
        return techLeadService.getById(id);
    }
}

//@RequestBody -> Body - raw
//@RequestPart -> formdata