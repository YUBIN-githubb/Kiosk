package org.example.level4to5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //필드
    private List<Menu> menu = new ArrayList<>();

    //생성자
    public Kiosk(Menu ... menus) {
        for (Menu a : menus) {
            menu.add(a);
        }
    }

    //메서드
    public void start () {
        Scanner sc = new Scanner(System.in);
        while (true) {
            showCategory();

            try {
                int categoryChoice = sc.nextInt();
                if (categoryChoice == 0) {
                    break;
                }

                //상세 메뉴 출력
                while (true) {
                    int menuChoice;
                    if (categoryChoice == 1) {
                        System.out.println("[BURGERS MENU]");
                        for (int i = 1; i < menu.get(0).getMenuItems().size(); i++) {

                            System.out.print(i + ". ");
                            System.out.printf("%-14s |",menu.get(0).getMenuItems().get(i).getName());
                            System.out.printf(" W %-3s | ",menu.get(0).getMenuItems().get(i).getPrice());
                            System.out.print(menu.get(0).getMenuItems().get(i).getDescription()+"\n");
                        }
                        System.out.println("0. 뒤로가기");

                        while(true) {
                            System.out.println("메뉴를 선택하세요: ");
                            menuChoice = sc.nextInt();

                            if (menuChoice == 0) {
                                break;
                            } else {
                                showSelectedMenu(1,menuChoice);
                            }
                        }
                        break;
                    } else if (categoryChoice == 2) {
                        System.out.println("[BEVERAGES MENU]");
                        for (int i = 1; i < menu.get(1).getMenuItems().size(); i++) {
                            ;
                            System.out.print(i + ". ");
                            System.out.printf("%-14s |",menu.get(1).getMenuItems().get(i).getName());
                            System.out.printf(" W %-3s | ",menu.get(1).getMenuItems().get(i).getPrice());
                            System.out.print(menu.get(1).getMenuItems().get(i).getDescription()+"\n");
                        }
                        System.out.println("0. 뒤로가기");


                        while(true) {
                            System.out.println("메뉴를 선택하세요: ");
                            menuChoice = sc.nextInt();
                            if (menuChoice == 0) {
                                break;
                            } else {
                                showSelectedMenu(2,menuChoice);
                            }

                        }
                        break;

                    } else if (categoryChoice == 3) {
                        System.out.println("[DESSERTS MENU]");
                        for (int i = 1; i < menu.get(2).getMenuItems().size(); i++) {

                            System.out.print(i + ". ");
                            System.out.printf("%-14s |",menu.get(2).getMenuItems().get(i).getName());
                            System.out.printf(" W %-3s | ",menu.get(2).getMenuItems().get(i).getPrice());
                            System.out.print(menu.get(2).getMenuItems().get(i).getDescription()+"\n");
                        }
                        System.out.println("0. 뒤로가기");

                        while (true) {
                            System.out.println("메뉴를 선택하세요: ");
                            menuChoice = sc.nextInt();
                            if (menuChoice == 0) {
                                break;
                            } else {
                                showSelectedMenu(3,menuChoice);
                            }
                        }
                        break;

                    } else {
                        throw new RuntimeException();
                    }
                }
            }
            catch (Exception e) {
                System.out.println("유효한 입력이 아닙니다.");
            }

        }
    }

    public void showCategory() {
        System.out.println("[MENU CATEGORY]");
        //for문 돌면서 카테고리 출력
        for (int i = 1; i <= menu.size(); i++) {
            System.out.println(i + ". " + menu.get(i-1).getCategory());
        }
        System.out.println("0. 종료      | 종료");
        System.out.println("메뉴 카테고리를 선택하세요 : ");
    }

    public void showSelectedMenu(int categoryChoice, int menuChoice) {
        System.out.print("선택된 메뉴 : ");
        System.out.printf("%-14s |",menu.get(categoryChoice-1).getMenuItems().get(menuChoice).getName());
        System.out.printf(" W %-3s | ",menu.get(categoryChoice-1).getMenuItems().get(menuChoice).getPrice());
        System.out.print(menu.get(categoryChoice-1).getMenuItems().get(menuChoice).getDescription()+"\n");
        System.out.println("");
    }



}



