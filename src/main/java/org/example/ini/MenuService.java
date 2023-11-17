package org.example.ini;

import java.util.List;

public interface MenuService {

    abstract List<String> getAllMenu();
    String menuDetail(String idMenu);
    void tambahMenu();

}
