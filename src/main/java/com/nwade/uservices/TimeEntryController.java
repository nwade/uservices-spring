package com.nwade.uservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepo;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepo) {
        this.timeEntryRepo = timeEntryRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    TimeEntry create(@RequestBody TimeEntry timeEntry) throws SQLException {
        return timeEntryRepo.create(timeEntry);
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<TimeEntry> list(@RequestParam int userId) throws SQLException {
        return timeEntryRepo.list(userId);
    }
}
