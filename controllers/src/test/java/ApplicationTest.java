import application.MyRestaurantApp;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.RestController;
import entities.User;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.MenuService;
import services.OrderService;
import services.UserService;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyRestaurantApp.class)
public class ApplicationTest {

    @Autowired
    MenuService menuService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Test
    public void testMenu() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = menuService.saveAndReturnAsJson("test_title",
                "test_ingredients",
                "1",
                "1",
                "1");
        assertNotNull(menuService.getAllDtos());
        menuService.remove("["+json.toString()+"]");
    }

    @Test
    public void testUser() throws Exception {
        User user = userService.save("test_firstname",
                "test_lastname",
                "test_login",
                "test_password",
                "test_address",
                "1234567890",
                "client");
        userService.findByUsername("test_login");
        userService.getAll();
        userService.getAllCouriers();
        userService.authorizeByLoginAndPassword("test_login", "test_password");
        userService.remove(user.getId());
    }

    @Test
    public void mockExample(){
        RestController restController = mock(RestController.class);
        when(restController.removeMenu("test")).thenReturn(new ResponseEntity(null, HttpStatus.OK));
        assertEquals(200, restController.removeMenu("test").getStatusCode().value());
    }
}
