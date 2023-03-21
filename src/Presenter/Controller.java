package Presenter;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import View.ConsolView;
import Model.GamingMachine;
import Model.Toy;
import Service.MachineService.DownloadData;
import Service.MachineService.Lottery;
import Service.MachineService.SaveData;
import Service.AdminService.AddedToy;
import Service.AdminService.ChoosingToy;
import Service.AdminService.DeleteToy;
import Service.AdminService.EditParametersToys;

public class Controller {

    // 2 поля: вью и модель
    private ConsolView cView;
    private GamingMachine gMachine;

    // конструктор
    public Controller() {
        this.cView = new ConsolView();
        this.gMachine = new GamingMachine();
    }

    public void button_click() {

        Boolean status = true;
        Scanner scan = new Scanner(System.in);

        String fileNomeclatureAddress = "src/SystemData/Toys.csv";
        String fileQueueAddress = "src/SystemData/line.csv";
        String givenOutToysAddress = "src/UserData/prizes.txt";

        // создание обьектов сервиса
        DownloadData downloadData = new DownloadData();
        AddedToy aToy = new AddedToy();
        DeleteToy dToy = new DeleteToy();
        EditParametersToys eParametersToys = new EditParametersToys();
        ChoosingToy choosingToy = new ChoosingToy();
        SaveData saveData = new SaveData();
        Lottery lottery = new Lottery();

        System.out.println("Включение...");

        // загрузка всех данных из файлов
        try {
            gMachine.setNomenclature_toys(downloadData.downloadListToysFromFile(fileNomeclatureAddress));
            gMachine.setGivenOut(downloadData.downloadListToysFromFile(fileQueueAddress));
            TimeUnit.SECONDS.sleep(1);

            System.out.println("Данные загружены...");

            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Готов к работе!\n");

        while (status) {
            System.out.println("Войти как:\n1. Администратор\n2. Игрок\n3. Не играть\n");
            switch (scan.next()) {
                case "1":
                    Boolean admStatus = true;
                    System.out.println("Включен режим администрирования");
                    while (admStatus) {
                        System.out.println("Меню:\n"
                                + "1. Посмотреть все игрушки\n"
                                + "2. Добавить игрушку\n"
                                + "3. Убрать игрушку\n"
                                + "4. Изменить параметры игрушки\n"
                                + "5. Сохранить изменения\n"
                                + "6. Выход из программы1\n");
                        switch (scan.next()) {
                            case "1":
                                cView.printListToy(gMachine.getNomenclature_toys());
                                break;
                            case "2":
                                aToy.addedToy(gMachine.getNomenclature_toys());
                                break;
                            case "3":
                                cView.printListToy(gMachine.getNomenclature_toys());
                                System.out.println("Введите ID игрушки для удаления");
                                dToy.delToy(gMachine.getNomenclature_toys(), cView.requestID());
                                break;
                            case "4":
                                cView.printListToy(gMachine.getNomenclature_toys());
                                System.out.println("Введите ID игрушки для изменения");
                                int enteredID = cView.requestID();
                                // Напечатаем параметры игрушки перед изменением
                                cView.printToy(choosingToy.choosingToy(gMachine.getNomenclature_toys(), enteredID));
                                boolean editStatus = true;
                                while (editStatus) {
                                    System.out.println("Меню:\n"
                                            + "1. Изменить название\n"
                                            + "2. Изменить вес\n"
                                            + "3. Изменить количество\n"
                                            + "4. Завершить изменения\n");
                                    switch (scan.next()) {
                                        case "1":
                                            String newName = cView.requestName();
                                            eParametersToys.editName(gMachine.getNomenclature_toys(), enteredID,
                                                    newName);
                                            System.out.println("Изменения внесены!");
                                            break;
                                        case "2":
                                            int newWeight = cView.requestWeight();
                                            eParametersToys.editWeight(gMachine.getNomenclature_toys(), enteredID,
                                                    newWeight);
                                            System.out.println("Изменения внесены!");
                                            break;
                                        case "3":
                                            int newAmount = cView.requestAmount();
                                            eParametersToys.editAmount(gMachine.getNomenclature_toys(), enteredID,
                                                    newAmount);
                                            System.out.println("Изменения внесены!");
                                            break;
                                        case "4":
                                            editStatus = false;
                                            break;
                                        default:
                                            System.out.println("Введена неверная команда!");
                                    }
                                }
                                break;
                            case "5":
                                System.out.println("Сохранение изменений, выход из режима администрирования....");
                                try {
                                    // Сохраняем списки в соответствующие файлы
                                    saveData.saveDataCSV(fileNomeclatureAddress, gMachine.getNomenclature_toys());
                                    saveData.saveDataCSV(fileQueueAddress, gMachine.getQueue());
                                    saveData.saveDataTXT(givenOutToysAddress, gMachine.getGivenOut());

                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Изменения сохранены....\n");
//                                System.out.println("Завершение работы....\n");
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Выключен режим администрирования!");
                                admStatus = false;

                                break;
                            case "6":
                                admStatus = false;
                                status = false;
                                break;
                            default:
                                System.out.println("Введена неверная команда");
                        }
                    }
                    break;
                case "2":
                    Boolean gamerStatur = true;
                    System.out.println("Приветствую, представьтесь пожалуйста: \n");
                    String gamer = scan.next();
                    System.out.println("Здравствуйте," + gamer);
                    while (gamerStatur) {
                        System.out.println("Меню:\n"
                                + "1. Запустить розыгрыш\n"
                                + "2. Ваши призы\n"
                                + "3. Забрать приз\n"
                                + "4. Выход \n");
                        switch (scan.next()) {
                            case "1":
                                System.out.println(gamer +", Ваш выигрыш!");
                                cView.printToy(lottery.chooseOnWeight(gMachine.getNomenclature_toys(), gMachine.getQueue()));
                                break;
                            case "2":
                                cView.printListToy(gMachine.getQueue());
                                break;
                            case "3":
                                Toy lastToy = gMachine.getQueue().get(gMachine.getQueue().size() - 1);
                                System.out.println(gamer + ", Вы получаете:");
                                cView.printToy(lastToy);
                                gMachine.getGivenOut().add(lastToy);
                                gMachine.getQueue().remove(lastToy);
                                break;
                            case "4":
                                System.out.println(gamer + ", Вы выбрали -4- для выхода");
                                gamerStatur = false;
                                break;
                            default:
                                System.out.println(gamer + ", Вы ввели что-то не то!");
                        }
                    }
                    break;
                case "3":
                    status = false;
                    break;
                default:
                    System.out.println("Введена неверная команда!");
            }

        }
        scan.close();
    }

}