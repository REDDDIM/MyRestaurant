package controller;

import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PositionService;
import services.exceptions.PositionException;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/allpositions")
    public List<PositionDto> getAllPositions() throws PositionException {
        return positionService.getAll();
    }

    @PostMapping("/addposition")
    public PositionDto addPosition(@RequestBody PositionDto dto){
        return positionService.save(dto);
    }

    @DeleteMapping("/removeposition")
    public ResponseEntity removePosition(@RequestBody List<PositionDto> positionDtos){
            positionService.remove(positionDtos);
            return new ResponseEntity(null, HttpStatus.OK);
    }
}
