package com.example.assignment2.api;


import com.example.assignment2.dto.ProjectDto;
import com.example.assignment2.service.custom.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/project")
public class ProjectApi {

    @Autowired
    ProjectService projectService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ProjectDto saveProject(@RequestBody ProjectDto projectDto) {
        projectDto.setCode(123);

        return projectService.save(projectDto);

        // Body -> raw
        // {
        //    "title": "user1",
        //    "description": "pwd1"
        //}

        //http://localhost:8080/test/api/v1/project           -> POST
        //Content-type : application/json
    }

    @DeleteMapping("{code}")
    void deleteProject(@PathVariable Integer code) {
        projectService.deleteById(code);
    }

    @PutMapping("{code}")
    void updateProject(@PathVariable int code, @RequestBody ProjectDto request) {
        projectService.updateProject(code, request.getTitle(), request.getDescription());
    }
    // Body -> raw
    // {
    //    "title": "user1",
    //    "description": "pwd1"
    //}

    //http://localhost:8080/test/api/v1/project/123            -> PUT
    //Content-type : application/json


    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProjectDto getSelectedProject(@PathVariable Integer code) {
        return projectService.getById(code);
    }
}
