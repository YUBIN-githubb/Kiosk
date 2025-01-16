package org.example.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //필드
    private List<MenuItem> menuItems = new ArrayList<>();

    //생성자
    public Kiosk(MenuItem ... menuitem) {
        for (MenuItem a : menuitem) {
            this.menuItems.add(a);
        }
    }

    //메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        //기본 메뉴출력
        int index = 1;
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 1; i < menuItems.size(); i++) {
            System.out.print(i + ". ");
            System.out.printf("%-14s |",menuItems.get(i).getName());
            System.out.printf(" W %-3s | ",menuItems.get(i).getPrice());
            System.out.print(menuItems.get(i).getDescription()+"\n");
        }
        System.out.println("0. 종료      | 종료");

        while (true) {

            try {
                int menuChoice = sc.nextInt();
                if (menuChoice == 0) {
                    System.out.println("\n프로그램을 종료합니다.");
                    break;

                } else {
                    //메뉴 번호 입력 시 선택된 메뉴 이름, 가격, 설명 출력
                    System.out.print("선택된 메뉴 : ");
                    System.out.printf("%-14s |",menuItems.get(menuChoice).getName());
                    System.out.printf(" W %-3s | ",menuItems.get(menuChoice).getPrice());
                    System.out.print(menuItems.get(menuChoice).getDescription()+"\n");
                }
            } catch (Exception e) {
                System.out.println("존재하지 않는 메뉴 번호입니다.");
            }


        }
    }

}
