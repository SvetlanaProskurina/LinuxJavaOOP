package Service.AdminService;

import java.util.List;
import Model.Toy;

public class AddedToy {

    // Добавление игрушки в список игрушек и проверка: если игрушка с таким
    // названием уже есть, то увеличивается количество существующей на полученое от пользователя
    public void addedToy(List<Toy> listToys) {
        CreateToy cToy = new CreateToy();
        Toy newToy = cToy.newToy();
        boolean statusee = false;
        for (Toy toy : listToys) {
            if (toy.getNameToy().toLowerCase().equals(newToy.getNameToy().toLowerCase())) {
                toy.setAmountToys(toy.getAmountToys() + newToy.getAmountToys());
                statusee = true;
            }

        }
        if (statusee == false) {
            listToys.add(newToy);
        }

    }
}
