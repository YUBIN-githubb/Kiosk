package org.example.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //메뉴들을 관리할 리스트
        List<MenuItem> menuItems = new ArrayList<>();

        //선택된 메뉴의 인덱스를 관리할 리스트
        List<Integer> selectedMenuItems = new ArrayList<>();

        //리스트에 메뉴 추가
        menuItems.add(new MenuItem("random value", 0, "random value"));
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

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


        //메뉴 선택
        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuChoice = sc.nextInt();
            selectedMenuItems.add(menuChoice);

            if (menuChoice == 0) {
                //총 선택된 메뉴의 이름을 전부 출력
                System.out.print("총 선택된 메뉴: ");
                for (int i = 0; i < selectedMenuItems.size()-1; i++) {
                    System.out.print(menuItems.get(selectedMenuItems.get(i)).getName() + " ");
                }

                //while문 탈출
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }

            //메뉴 번호 입력 시 선택된 메뉴 이름, 가격, 설명 출력
            System.out.print("선택된 메뉴 : ");
            System.out.printf("%-14s |",menuItems.get(menuChoice).getName());
            System.out.printf(" W %-3s | ",menuItems.get(menuChoice).getPrice());
            System.out.print(menuItems.get(menuChoice).getDescription()+"\n");

        }
    }
}
