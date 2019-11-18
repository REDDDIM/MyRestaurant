package interfaces;

import java.util.List;
import entities.Menu;

public interface MenuService {
    List<Menu> getAllMenu();
    Menu getMenuById(Long id);
    void createMenu(Menu menu) throws Exception;
    void updateMenu(Menu menu);
    void deleteMenu(Menu menu);
}
