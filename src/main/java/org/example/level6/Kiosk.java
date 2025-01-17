package org.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Kiosk {
    //필드
    private List<Menu> menu = new ArrayList<>(); //메뉴 객체들을 관리하는 리스트
    private List<MenuItem> shoppingCart = new ArrayList<>(); //선택된 MenuItem객체들을 관리하는 리스트(장바구니)
    private UserType type;

    //생성자
    public Kiosk(Menu ... menus) {
        //키오스크 객체 생성시 여러개의 Menu객체들을 받아와 menu리스트에 add
        for (Menu a : menus) {
            this.menu.add(a);
        }
    }

    //메서드
    //키오스크 프로그램의 전반적인 흐름을 담당하는 메서드
    public void start () {
        Scanner sc = new Scanner(System.in);

        //입력받는 변수들 선언
        int menuChoice;
        int cartChoice;
        int orderChoice;
        int finalChoice;
        int typeChoice;

        while (true) {
            //카테고리 출력
            showCategory();

            try {
                //카테고리 입력
                int categoryChoice = sc.nextInt();

                if (categoryChoice == 0) { //0입력받으면 프로그램 종료 (가장 바깥의 while 문 탈출)
                    break;
                } else if (categoryChoice == 1 || categoryChoice == 2 || categoryChoice == 3) {

                    while (true) {
                        //메뉴 출력
                        showMenu(categoryChoice);

                        //메뉴 선택
                        System.out.println("메뉴를 선택하세요: ");
                        menuChoice = sc.nextInt();

                        if (menuChoice == 0) {
                            break; //0입력 시 다시 카테고리 출력으로 되돌아감
                        } else {
                            //선택된 메뉴 출력
                            //menuChoice에서 입력예외가 발생할 경우 showSelectedMenu에서 예외가 일어나기 때문에
                            //따로 예외를 발생시키진 않았음
                            showSelectedMenu(categoryChoice,menuChoice);

                            //장바구니 추가 로직
                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1. 확인       2. 취소");
                            cartChoice = sc.nextInt();

                            if (cartChoice == 1) {
                                addShoppingCart(menu.get(categoryChoice-1).getMenuItems().get(menuChoice)); //장바구니 리스트에 추가
                                showCategory(); //다시 카테고리 출력
                                showOrderMenu(); //ORDER MENU 출력

                                //orderChoice 입력
                                orderChoice = sc.nextInt();
                                if (orderChoice == 4) {
                                    System.out.println("아래와 같이 주문하시겠습니까?\n");
                                    //장바구니에 담긴 메뉴들 출력
                                    showShoppingCartMenu();

                                    //finalChoice 입력
                                    System.out.println("1. 주문      2. 메뉴판");
                                    finalChoice = sc.nextInt();

                                    if (finalChoice == 1) {
                                        //할인 적용
                                        //주문완료 메세지 + 총 금액 출력
                                        System.out.println("할인 유형을 입력해주세요.: ");
                                        System.out.println("1. 국가유공자 : 10%");
                                        System.out.println("2. 군인     :  5%");
                                        System.out.println("3. 학생     :  3%");
                                        System.out.println("4. 일반     :  0%");
                                        typeChoice = sc.nextInt();

                                        if (typeChoice == 1) {
                                            System.out.println("주문이 완료되었습니다. 총 금액은 W" + discountAndCalculate(UserType.국가유공자) + "입니다.\n" );
                                        } else if (typeChoice == 2) {
                                            System.out.println("주문이 완료되었습니다. 총 금액은 W" + discountAndCalculate(UserType.군인) + "입니다.\n" );
                                        } else if (typeChoice == 3) {
                                            System.out.println("주문이 완료되었습니다. 총 금액은 W" + discountAndCalculate(UserType.학생) + "입니다.\n" );
                                        } else if (typeChoice == 4) {
                                            System.out.println("주문이 완료되었습니다. 총 금액은 W" + discountAndCalculate(UserType.일반) + "입니다.\n" );
                                        } else {
                                            throw new Exception();
                                        }

                                        //장바구니 비워주기
                                        shoppingCart.clear();

                                    } else if (finalChoice == 2) {
                                        break; //while문을 탈출해 다시 showCategory()로
                                    } else {
                                        throw new Exception(); // 그 외의 경우 예외발생
                                    }

                                } else if (orderChoice == 5) {
                                    //주문 취소
                                    System.out.println("주문이 취소되었습니다.\n");
                                    //장바구니 비워주기
                                    shoppingCart.clear();
                                    //while문 탈출해 다시 showCategory()로
                                    break;

                                } else if (orderChoice == 1 || orderChoice == 2 || orderChoice == 3) {
                                    //ORDER MENU가 아닌 MENU CATEGORY의 번호를 선택했을 경우
                                    //각 orderChoice에 따라서 categoryChoice 재할당
                                    if (orderChoice == 1) {
                                        categoryChoice = 1;
                                    } else if (orderChoice == 2) {
                                        categoryChoice = 2;
                                    } else if (orderChoice == 3) {
                                        categoryChoice = 3;
                                    }

                                    continue; //재할당 된 categoryChoice를 가지고 다시 while문 처음으로 올라가기

                                } else if (orderChoice == 0) {
                                    break; //while문 탈출해 다시 showCategory()로

                                } else {
                                    throw new Exception(); //그 외의 경우 예외 발생 (orderChoice 변수 예외)
                                }


                            } else if (cartChoice == 2) {
                                break; //while문 탈출해 다시 showCategory()로

                            } else {
                                throw new Exception(); //그 외의 경우 예외 발생 (cartChoice 변수 예외)
                            }
                        }

                        break;

                    }
                } else {
                    throw new Exception(); //그 외의 경우 예외 발생 (categoryChoice 변수 예외)
                }

            }
            catch (Exception e) {
                //예외처리
                //예외가 처리되면 다시 while문의 처음으로
                System.out.println("유효한 입력이 아닙니다.");
            }
        }
    }

    //메뉴 카테고리를 출력하는 메서드
    public void showCategory() {
        System.out.println("[MENU CATEGORY]");

        //IntStream이용
        IntStream.range(1,this.menu.size()+1).forEach(
                i -> {System.out.println(i + ". " + this.menu.get(i-1).getCategory());} //Menu 객체의 getCategory() 이용
        );

        System.out.println("0. 종료      | 종료\n");

    }

    //선택된 카테고리에 따른 메뉴들을 출력하는 메서드
    public void showMenu(int categoryChoice) {
        //선택된 카테고리에 따라 메뉴 카테고리 이름 출력
        if (categoryChoice == 1) {
            System.out.println("[" + CategoryType.Burgers.name() + " MENU]");
        } else if (categoryChoice == 2) {
            System.out.println("[" + CategoryType.Beverages.name() + " MENU]");
        } else if (categoryChoice == 3) {
            System.out.println("[" + CategoryType.Desserts.name() + " MENU]");
        }

        //선택된 카테고리에 따라 해당 카테고리에 속한 메뉴들을 stream으로 출력
        //Menu를 관리하는 리스트에서 해당하는 카테고리로 인덱스 접근 -> getMenuItems()를 이용해서 MenuItem을 관리하는 리스트에 접근 ->
        //IntStream을 이용해 i를 통해 차례대로 인덱스를 통해 접근 -> 접근한 MenuItem 리스트에 getName(), getPrice(), getDescription() 이용해서 값 출력
        IntStream.range(1, this.menu.get(categoryChoice-1).getMenuItems().size()).forEach(i -> {
            System.out.print(i + ". ");
            System.out.printf("%-14s |",this.menu.get(categoryChoice-1).getMenuItems().get(i).getName());
            System.out.printf(" W %-3s | ",this.menu.get(categoryChoice-1).getMenuItems().get(i).getPrice());
            System.out.print(this.menu.get(categoryChoice-1).getMenuItems().get(i).getDescription()+"\n");
        });

        System.out.println("0. 뒤로가기\n");
    }

    //선택된 MenuItem의 정보를 출력하는 메서드
    public void showSelectedMenu(int categoryChoice, int menuChoice) {
        System.out.print("선택된 메뉴 : ");
        System.out.printf("%-14s |",this.menu.get(categoryChoice-1).getMenuItems().get(menuChoice).getName());
        System.out.printf(" W %-3s | ",this.menu.get(categoryChoice-1).getMenuItems().get(menuChoice).getPrice());
        System.out.print(this.menu.get(categoryChoice-1).getMenuItems().get(menuChoice).getDescription()+"\n");

    }

    //장바구니에 선택된 MenuItem을 추가하는 메서드
    public void addShoppingCart(MenuItem menuItem) {
        shoppingCart.add(menuItem);
        System.out.println(menuItem.getName() + "이 장바구니에 추가되었습니다.\n");
    }

    //ORDER MENU를 출력하는 메서드
    public void showOrderMenu() {
        System.out.println("[ORDER MENU]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.\n");
    }

    //장바구니에 담긴 MenuItem을 출력 + 총 결제금액을 출력하는 메서드
    public void showShoppingCartMenu() {

        System.out.println("[ORDERS]");

        //스트림 적용
        this.shoppingCart.stream().forEach(
                (MenuItem a) -> {
                    System.out.printf("%-14s |",a.getName());
                    System.out.printf(" W %-3s | ",a.getPrice());
                    System.out.print(a.getDescription()+"\n");}
        );

        double totalSum = this.shoppingCart.stream().mapToDouble(MenuItem::getPrice).sum();

        System.out.println("[TOTAL]");
        System.out.println("W " + totalSum + "\n");

    }

    //할인적용 + 총 결제 금액을 반환하는 메서드
    public double discountAndCalculate(UserType type) {
        double total = 0;
        for (MenuItem a : this.shoppingCart) {
            total += a.getPrice();
        }
        if (type == UserType.국가유공자) {
            total -= total * 0.1;
        } else if (type == UserType.군인) {
            total -= total * 0.05;
        } else if (type == UserType.학생) {
            total -= total * 0.01;
        } else if (type == UserType.일반) {
            total = total;
        }

        return total;
    }

}



