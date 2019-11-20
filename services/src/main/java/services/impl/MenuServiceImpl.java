package services.impl;

import dao.repository.MenuRepository;
import dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.MenuService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Override
    public List<MenuDto> getAllDtos() {
        List<MenuDto> menuDtoList = new ArrayList<>();
        menuRepository.findAll().forEach(m -> menuDtoList.add(m.convertToDto()));
        return menuDtoList;
    }
}
