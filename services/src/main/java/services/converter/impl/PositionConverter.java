package services.converter.impl;

import dto.PositionDto;
import entities.Position;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import services.converter.BaseConverter;

@Component
@Qualifier("positionConverter")
public class PositionConverter extends GenericConverter<PositionDto, Position> implements BaseConverter<PositionDto, Position> {
}
