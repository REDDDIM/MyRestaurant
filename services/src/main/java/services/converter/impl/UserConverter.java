package services.converter.impl;

import dto.UserDto;
import entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import services.converter.BaseConverter;

@Component
@Qualifier("userConverter")
public class UserConverter extends GenericConverter<UserDto, User> implements BaseConverter<UserDto, User> {
}
