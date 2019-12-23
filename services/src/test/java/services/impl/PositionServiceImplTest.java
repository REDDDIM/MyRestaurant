package services.impl;

import dao.repository.OrderItemRepository;
import dao.repository.PositionRepository;
import dto.PositionDto;
import entities.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.PositionService;
import services.converter.impl.PositionConverter;
import services.exceptions.PositionException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PositionServiceImplTest {

    @InjectMocks
    PositionService positionService = new PositionServiceImpl();

    @Mock
    private PositionRepository positionRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    PositionConverter converter;

    Position expectedPosition;
    PositionDto expectedPositionDto;
    List<Position> expectedPositions;
    List<PositionDto> expectedPositionsDto;

    @Before
    public void setUp(){
        expectedPosition = new Position();
        expectedPosition.setTitle("expectedPosition");
        expectedPosition.setIngredients("some_ingredients");
        expectedPosition.setPrice(new BigDecimal(100));
        expectedPosition.setUnit("gr");
        expectedPosition.setWeight(200);
        PositionConverter positionConverter = new PositionConverter();
        expectedPositionDto = positionConverter.convertToDto(expectedPosition);
        expectedPositions = new ArrayList<>();
        Position firstExpectedPosition = new Position();
        firstExpectedPosition.setTitle("firstExpectedPosition");
        firstExpectedPosition.setIngredients("some_ingredients1");
        firstExpectedPosition.setPrice(new BigDecimal(100));
        firstExpectedPosition.setUnit("gr");
        firstExpectedPosition.setWeight(100);
        Position secondExpectedPosition = new Position();
        secondExpectedPosition.setTitle("secondExpectedPosition");
        secondExpectedPosition.setIngredients("some_ingredients2");
        secondExpectedPosition.setPrice(new BigDecimal(200));
        secondExpectedPosition.setUnit("gr");
        secondExpectedPosition.setWeight(200);
        expectedPositions.add(firstExpectedPosition);
        expectedPositions.add(secondExpectedPosition);
        expectedPositionsDto = positionConverter.convertToDto(expectedPositions);
    }

    @Test(expected = PositionException.class)
    public void returnEmptyList() throws PositionException {
        when(positionRepository.findAll()).thenReturn(new ArrayList<>());
        positionService.getAll();
    }

    @Test
    public void returnExpextedPositions() throws PositionException {
        when(converter.convertToDto(anyList())).thenReturn(expectedPositionsDto);
        when(positionRepository.findAll()).thenReturn(expectedPositions);
        assertEquals(positionService.getAll(), expectedPositionsDto);
    }
}