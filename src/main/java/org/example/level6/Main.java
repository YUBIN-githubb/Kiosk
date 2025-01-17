package org.example.level6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> burgerMenuItems = new ArrayList<>();
        burgerMenuItems.add(new MenuItem("random value", 0, "random value"));
        burgerMenuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<MenuItem> beverageMenuItems = new ArrayList<>();
        beverageMenuItems.add(new MenuItem("random value", 0, "random value"));
        beverageMenuItems.add(new MenuItem("Cola", 2.0, "짱 시원한 콜라"));
        beverageMenuItems.add(new MenuItem("Sprite", 2.0, "짱 시원한 스프라이트"));
        beverageMenuItems.add(new MenuItem("Milk shake", 3.0, "시원 달달한 밀크쉐이크"));
        beverageMenuItems.add(new MenuItem("Water", 0.5, "물"));

        List<MenuItem> dessertMenuItems = new ArrayList<>();
        dessertMenuItems.add(new MenuItem("random value", 0, "random value"));
        dessertMenuItems.add(new MenuItem("Ice cream", 2.0, "우유 아이스크림"));
        dessertMenuItems.add(new MenuItem("Pudding", 2.5, "달달한 커스터드 푸딩"));

        Menu burgers = new Menu(CategoryType.Burgers, burgerMenuItems);
        Menu beverages = new Menu(CategoryType.Beverages, beverageMenuItems);
        Menu desserts = new Menu(CategoryType.Desserts, dessertMenuItems);

        Kiosk kiosk = new Kiosk(burgers, beverages, desserts);
        kiosk.start();

    }
}
