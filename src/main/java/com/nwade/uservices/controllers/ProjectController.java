package com.nwade.uservices.controllers;

import com.nwade.uservices.models.Project;
import com.nwade.uservices.dal.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectRepository repository;

    @Autowired
    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    Project create(@RequestBody Project project) throws SQLException {
        return repository.create(project);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Project> list(@RequestParam int accountId) throws SQLException {
        return repository.list(accountId);
    }
}