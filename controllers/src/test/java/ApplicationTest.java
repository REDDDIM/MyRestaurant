import application.MyRestaurantApp;
import controller.PositionController;
import dto.PositionDto;
import dto.UserDto;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.PositionService;
import services.OrderService;
import services.UserService;
import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyRestaurantApp.class)
public class ApplicationTest {

    @Autowired
    PositionService positionService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Test
    public void testPosition(){
        PositionDto positionDto = new PositionDto();
        positionDto.setTitle("test_title");
        positionDto.setIngredients("test_ingredients");
        positionDto.setPrice(new BigDecimal(1));
        positionDto.setWeight(1);
        positionDto.setUnit("1");
        positionDto = positionService.save(positionDto);
        assertNotNull(positionDto.getId());
        assertTrue(!positionService.getAll().isEmpty());
        positionService.remove(Arrays.asList(positionDto));
    }

    @Test
    public void userTest(){
        UserDto userDto = new UserDto();
        userDto.setName("test_name");
        userDto.setSurname("test_surname");
        userDto.setLogin("test_login");
        userDto.setPassword("test_password");
        userDto.setAddress("test_address");
        userDto.setPhoneNumber(new Long(1234567890));
        userDto = userService.createNewUser(userDto);
        assertNotNull(userDto.getId());
        assertTrue(!userService.getAll().isEmpty());
        userService.remove(userDto.getId());
    }



    @Test
    public void mockExample(){
        PositionDto positionDto = new PositionDto();
        positionDto.setTitle("test_title");
        positionDto.setIngredients("test_ingredients");
        positionDto.setPrice(new BigDecimal(1));
        positionDto.setWeight(1);
        positionDto.setUnit("1");
        PositionController restController = mock(PositionController.class);
        when(restController.removePosition(Arrays.asList(positionDto))).thenReturn(new ResponseEntity(null, HttpStatus.OK));
        assertEquals(200, restController.removePosition(Arrays.asList(positionDto)).getStatusCode().value());
    }
}
