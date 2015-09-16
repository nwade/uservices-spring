package com.nwade.uservices.dal;

import com.nwade.uservices.App;
import com.nwade.uservices.support.TestDataSource;
import com.nwade.uservices.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {App.class})
public class UserRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testShow() throws Exception {
        TestDataSource.cleanWithFixtures(dataSource);

        UserRepository userRepository = new UserRepository(new JdbcTemplate(dataSource));
        User aUser = userRepository.create(new User("aUser"));
        User actual = userRepository.show(aUser.getId());

        assertEquals("aUser", actual.getName());
    }
}
