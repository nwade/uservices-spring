package com.nwade.uservices.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwade.uservices.TestDataSource;
import com.nwade.uservices.users.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AccountsTestApp.class})
@WebAppConfiguration
public class RegistrationControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        TestDataSource.cleanWithFixtures(dataSource);

        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void testRegister() throws Exception {
        String json = "{\"name\":\"aUser\"}";

        mockMvc.perform(
                post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> {
                    User actual = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), User.class);
                    assertEquals("aUser", actual.getName());
                });
    }
}
