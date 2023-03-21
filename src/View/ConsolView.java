package View;

import java.util.*;
import Model.Toy;

public class ConsolView {

    Scanner scan = new Scanner(System.in);

    // функция запроса имени
    public String requestName() {
        System.out.println("Задайте название:");
        String name = scan.next();
        return name;
    }

    // функция запроса количества
    public int requestAmount() {
        System.out.println("Задайте количество:");
        int amount = scan.nextInt();
        return amount;
    }

    // функция запроса веса
    public int requestWeight() {
        System.out.println("Задайте вес:");
        int weight = scan.nextInt();
        return weight;
    }

    //функция запроса ID 
    public int requestID(){
        return scan.nextInt();
    }

    // печать списка игрушек
    public void printListToy(List<Toy> listToys) {

        for (Toy toy : listToys) {
            // System.out.printf("%s  |  %s\n", toy.getIdToy(), toy.getNameToy());
            printToy(toy);
        }
    }

    // печать параметров одной игрушки
    public void printToy(Toy toy) {
        System.out.printf("-----\nID - %s\nНазвание - %s\nКоличество - %s\nВес - %s\n-----\n",
                toy.getIdToy(),
                toy.getNameToy(),
                toy.getAmountToys(),
                toy.getWeightToy());
    }


}
