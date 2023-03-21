package Service.MachineService;

import java.io.FileWriter;
import java.util.List;
import Model.Toy;

public class SaveData {

    // сохранение списка игрушек в файл. На вход подаем адрес файла и список,
    // который туда надо сохранить (формат csv)
    public void saveDataCSV(String fileAddress, List<Toy> listToys) {
        try (FileWriter fWriter = new FileWriter(fileAddress)) {
            for (Toy toy : listToys) {
                fWriter.write(
                        toy.getIdToy() + ";" + toy.getNameToy() + ";" + toy.getAmountToys() + ";" + toy.getWeightToy()
                                + "\n");
            }
            fWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // сохранение списка игрушек в файл. На вход подаем адрес файла и список,
    // который туда надо сохранить (формат txt)
    public void saveDataTXT(String fileAddress, List<Toy> listToys) {
        try (FileWriter fWriter = new FileWriter(fileAddress)) {
            for (Toy toy : listToys) {
                fWriter.write(
                        "ID - " + toy.getIdToy() + "; "
                                + "Название - " + toy.getNameToy() + "; "
                                + "Количество - " + toy.getAmountToys() + "; "
                                + "Вес - " + toy.getWeightToy()
                                + "\n");
            }
            fWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
