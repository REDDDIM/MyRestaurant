package impl;

import dao.repository.MenuRepository;
import entities.Menu;
import interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenuItem() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuItemById(Long id) {
        return menuRepository.findOne(id);
    }

    @Override
    public void createMenuItem(Menu menu) throws Exception {
        menuRepository.saveAndFlush(menu);
    }

    @Override
    public void updateMenuItem(Menu menu) {
        menuRepository.saveAndFlush(menu);
    }

    @Override
    public void deleteMenuItem(Menu menu) {
        menuRepository.delete(menu);
    }
}
