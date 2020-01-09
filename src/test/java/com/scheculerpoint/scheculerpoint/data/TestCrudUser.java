package com.scheculerpoint.scheculerpoint.data;

import com.scheculerpoint.scheculerpoint.domain.Login;
import com.scheculerpoint.scheculerpoint.domain.User;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumGender;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumUserRole;
import com.scheculerpoint.scheculerpoint.repository.UserRepository;
import com.scheculerpoint.scheculerpoint.resource.UserResource;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCrudUser {

    User user1, user2, userAdmin;

    @Autowired
    private UserResource resource;

    @Autowired
    private UserRepository repository;

    @Before
    public void init() {
        repository.deleteAll();
        user1 = new User("Gabriel", "gabriel.stahlbergoliveira@amdocs.com", EnumGender.M, new Login("gabriest", "123", EnumUserRole.USER));
        user2 = new User("Letícia", "leticia.bragabueno@gmail.com", EnumGender.F, new Login("leticiabb", "321", EnumUserRole.USER));
        userAdmin = new User("Admin", "admin@amdocs.com", EnumGender.M, new Login("admin", "admin", EnumUserRole.ADMIN));
        repository.save(user1);
        repository.save(user2);
        repository.save(userAdmin);
    }

    @After
    public void finalize() {
        repository.deleteAll();
    }

    @Test
    public void findAll() {
        Long total = repository.count();

        List<User> usersResult = resource.findAll().getBody();

        assertThat(usersResult.size()).isEqualTo(total.intValue());
    }

    @Test
    public void findById() {
        User userResult = resource.findById(user1.getId()).getBody();

        assertEquals(userResult.getLogin().getUsername(), user1.getLogin().getUsername());
    }

    @Test
    public void update() {
        User user = resource.findById(user1.getId()).getBody();
        user.setName("mudou");
        ResponseEntity<User> response = resource.update(user.getId(), user);
        user = resource.findById(user1.getId()).getBody();

        assertEquals(response.getBody().getName(), "mudou");
        assertEquals(user.getName(), "mudou");
    }

    @Test
    public void findAdmin() {
        User userResult = resource.findAdmin().getBody();
        assertNotNull(userResult);
        assertThat(userResult.getLogin().getRole()).isEqualTo(EnumUserRole.ADMIN);
    }

    @Test
    public void save() {
        User user3 = new User("Marcela", "marcela.stahlbergoliveira@amdocs.com", EnumGender.F, new Login("marcelast", "333", EnumUserRole.USER));
        assertNull(user3.getId());

        ResponseEntity<User> response = resource.save(user3);
        assertNotNull(user3.getId());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void deleteAll() {
        List<User> users = resource.findAll().getBody();

        assertTrue(users.size() > 0);

        ResponseEntity<?> response = resource.deleteAll();
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());

        users = resource.findAll().getBody();
        assertTrue(users.size() == 0);
    }

    @Test
    public void deleteById() {
        User userResult = resource.findById(user1.getId()).getBody();
        assertNotNull(userResult);

        resource.deleteById(user1.getId());
        userResult = resource.findById(user1.getId()).getBody();
        assertNull(userResult);
    }
}
