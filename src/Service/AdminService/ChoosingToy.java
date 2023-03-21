package Service.AdminService;

import java.util.List;

import Model.Toy;

public class ChoosingToy {

    // функция, которая выбирает игрушку по ID
    public Toy choosingToy(List<Toy> listToys, int id) {
        Toy returnToy = null;
        for (Toy toy : listToys) {
            if (toy.getIdToy() == id) {
                returnToy = toy;
                break;
            }
        }
        return returnToy;
    }
}
