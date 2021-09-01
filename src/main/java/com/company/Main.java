package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

//Замечания:
//1. Не сделал входные данные через stdin
//2. Вместо того, чтобы писать в консоль надо настроить нормально логгер + расширить ошибки
//3. Написать тесты
//
//Идеи по улучшению:
//1. Каждый раз перебирать при изменении заявки перебирать коллекцию долго (51 строка)
//Решение создать set с ключами заявок с максимальной ценой.
//Если цена изменилась в меньшую сторону у заявки не из сета, то и фиг с ней.
//Если цена изменилась в меньшую сторону у заявки из сета и в сете, удаляем её, если set не пустой,
//то макс цена не изменилась, вывода нет, если set пустой, то перебор коллекции с поиском макс. цены

public class Main {

    public static void main(String[] args) {

        ApplicationBilder applBilder = new ApplicationBilder();
        ApplicationСheck applСheck = new ApplicationСheck();

        Map<String, Application> conteinerOfAppl = new TreeMap<>();
        long maxPrice = 0;

//        100, 101, 0
//        String[] applStr = {"2;0;100;3;3", "2;1;101;1;2", "2;1;101;2;0"};

//        100, 101, 0
        String[] applStr = {"1;0;100;2;2", "2;0;101;3;3", "3;0;99;10;10", "2;1;101;1;2", "2;1;101;2;0"};

        for(int i = 0; i < applStr.length; i++){
            String[] strArray = applStr[i].split(";");

            if(strArray.length == 5) {
                if (conteinerOfAppl.containsKey(strArray[0])) {

                    String currentKey = strArray[0];
                    Application applicationOld = conteinerOfAppl.get(currentKey);

                    if (applСheck.checkExistAppl(applicationOld, strArray)) {
                        Application applicationNew = applBilder.changeAppl(applicationOld, strArray);

                        if (applicationNew.getAmountRest() == 0) {
                            conteinerOfAppl.remove(applicationOld.getClorderId());
                        }

                        long newMaxPrice = Collections.max(conteinerOfAppl.values()).getPrice();
                        if(conteinerOfAppl.isEmpty()) {
                            System.out.println(0);
                        } else if(newMaxPrice != maxPrice) {
                            maxPrice = newMaxPrice;
                            System.out.println(maxPrice);
                        }

                    } else {
                        System.out.println("Заявка " + (i + 1) + " некорректна");
                    }
                } else {

                    if (applСheck.checkNewAppl(strArray)) {
                        Application appl = applBilder.createAppl(strArray);
                        conteinerOfAppl.put(appl.getClorderId(), appl);

                        if (appl.getPrice() > maxPrice) {
                            maxPrice = appl.getPrice();
                            System.out.println(maxPrice);
                        }

                    } else {
                        System.out.println("Заявка " + (i + 1) + " некорректна");
                    }
                }
            } else {
                System.out.println("Заявка " + (i + 1) + " некорректна");
            }
        }
    }
}
