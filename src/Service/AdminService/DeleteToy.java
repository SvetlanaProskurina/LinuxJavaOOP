package Service.AdminService;

import java.util.List;

import Model.Toy;

public class DeleteToy {

    // Добавление игрушки в список игрушек
    public void delToy(List<Toy> listToys, int toyID) {
        for (Toy toy : listToys){
            if (toy.getIdToy() == toyID){
                listToys.remove(toy);
                System.out.println("Позиция удалена!");
            } 
        }
    }
}
