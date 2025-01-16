package org.example.level4to5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //필드
    //MenuItem 클래스를 리스트로 관리
    private List<MenuItem> menuItems = new ArrayList<>();
    private String category;

    //생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    //메서드
    //리스트에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItem() {
        for (MenuItem a : menuItems) {
            System.out.println(a.toString());
        }
    }

    //메뉴리스트를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    //카테고리를 리턴하는 함수
    public String getCategory() {
        return category;
    }
}
