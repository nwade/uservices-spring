package com.nwade.uservices.backlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/stories")
public class StoryController {
    private final StoryRepository storyRepo;

    @Autowired
    public StoryController(StoryRepository storyRepo) {
        this.storyRepo = storyRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    Story create(@RequestBody Story s) throws Exception {
        return storyRepo.create(s);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Story> list(@RequestParam int projectId) throws SQLException {
        return storyRepo.list(projectId);
    }
}
