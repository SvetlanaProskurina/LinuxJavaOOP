package Service.AdminService;

import java.util.List;

import Model.Toy;

public class EditParametersToys {

    // изменить название
    public void editName(List<Toy> listToy, int toyID, String newName) {
        for (Toy toy : listToy) {
            if (toy.getIdToy() == toyID) {
                toy.setNameToy(newName);
            }
        }
    }

    // изменить вес
    public void editWeight(List<Toy> listToy, int toyID, int newWeight) {
        for (Toy toy : listToy) {
            if (toy.getIdToy() == toyID) {
                toy.setWeightToy(newWeight);
            }
        }
    }

    // изменить количество
    public void editAmount(List<Toy> listToy, int toyID, int newAmount) {
        for (Toy toy : listToy) {
            if (toy.getIdToy() == toyID) {
                toy.setAmountToys(newAmount);
            }
        }
    }
}
