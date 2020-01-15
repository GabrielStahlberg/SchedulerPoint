package com.scheculerpoint.scheculerpoint.cucumber;

import com.scheculerpoint.scheculerpoint.domain.Login;
import com.scheculerpoint.scheculerpoint.domain.Movimentation;
import com.scheculerpoint.scheculerpoint.domain.User;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumGender;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumUserRole;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberMain {
    private User user1, user2, userAdmin, userResult;
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080";

    @Given("^I have some users registered$")
    public void i_have_users_registered() throws Exception {
        restTemplate.delete(url+"/users");

        this.user1 = new User("Gabriel", "gabriel.stahlbergoliveira@amdocs.com", EnumGender.M, new Login("gabriest", "123", EnumUserRole.USER), new ArrayList<Movimentation>());
        this.user2 = new User("Letícia", "leticia.bragabueno@gmail.com", EnumGender.F, new Login("leticiabb", "321", EnumUserRole.USER), new ArrayList<Movimentation>());
        this.userAdmin = new User("Admin", "admin@amdocs.com", EnumGender.M, new Login("admin", "admin", EnumUserRole.ADMIN), new ArrayList<Movimentation>());

        this.user1 = restTemplate.postForEntity(url+"/users", user1, User.class).getBody();
        this.user2 = restTemplate.postForEntity(url+"/users", user2, User.class).getBody();
        this.userAdmin = restTemplate.postForEntity(url+"/users", userAdmin, User.class).getBody();
    }

    @When("^I request for the ADMIN one$")
    public void i_request_for_the_ADMIN_one() throws Exception {
        this.userResult = restTemplate.getForObject(url+"/users/admin", User.class);
    }

    @Then("^The response should be an ADMIN user$")
    public void the_response_should_be_an_ADMIN_user() throws Exception {
        assertEquals(userResult.getId().longValue(), userAdmin.getId().longValue());
    }
}
