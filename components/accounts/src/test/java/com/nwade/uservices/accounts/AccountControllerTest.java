package com.nwade.uservices.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwade.uservices.schema.TestDataSource;
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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AccountsTestApp.class})
@WebAppConfiguration
public class AccountControllerTest {
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
    public void testShow() throws Exception {
        User user = new ObjectMapper()
                .readValue(mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"aUser\"}"))
                        .andReturn().getResponse().getContentAsString(), User.class);

        Account account = new ObjectMapper()
                .readValue(mockMvc.perform(get("/accounts")
                        .param("ownerId", String.valueOf(user.getId()))
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString(), Account.class);
        assertEquals(user.getId(), account.getOwnerId());
        assertEquals("aUser's account", account.getName());
    }
}
