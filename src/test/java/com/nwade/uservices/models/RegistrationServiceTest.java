package com.nwade.uservices.models;

import com.nwade.uservices.App;
import com.nwade.uservices.support.TestDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {App.class})
public class RegistrationServiceTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private RegistrationService service;

    @Test
    public void testCreateUserWithAccount() throws Exception {
        TestDataSource.cleanWithFixtures(dataSource);

        User aUser = service.createUserWithAccount(new User("aUser"));
        assertEquals("aUser", aUser.getName());
    }
}
