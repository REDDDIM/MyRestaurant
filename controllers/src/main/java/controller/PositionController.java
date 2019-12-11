package controller;

import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.PositionService;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @PostMapping("/allpositions")
    public List<PositionDto> getAllPositions(){
        return positionService.getAll();
    }

    @PostMapping("/addposition")
    public PositionDto addPosition(@RequestBody PositionDto dto){
        return positionService.save(dto);
    }

    @PostMapping("/removeposition")
    public ResponseEntity removePosition(@RequestBody List<PositionDto> positionDtos){
            positionService.remove(positionDtos);
            return new ResponseEntity(null, HttpStatus.OK);
    }
}
