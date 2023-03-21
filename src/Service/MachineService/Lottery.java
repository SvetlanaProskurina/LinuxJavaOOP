package Service.MachineService;

import Model.Toy;
import java.util.List;
import java.util.Random;

public class Lottery {

    // Функция рандомно выбирает игрушку:
    // 1. Добавляет ее в список очереди на выдачу в количестве 1 шт
    // 2. Уменьшает остаток этой игрушки в аппарате на 1 шт
    // 3. возвращает объект "Игрушка"
    public Toy chooseOnWeight(List<Toy> toys, List<Toy> queue) {
        double completeWeight = 0.0;
        for (Toy toy : toys) {
            completeWeight += toy.getWeightToy();
        }

        Random random = new Random();
        double r = random.nextDouble(0.5, 0.9) * completeWeight;
        double countWeight = 0.0;
        Toy resultToy = new Toy();
        for (Toy toy : toys) {
            countWeight += toy.getWeightToy();
            if (countWeight >= r) {
                if (toy.getAmountToys() > 1) {
                    toy.setAmountToys(toy.getAmountToys() - 1);
                    resultToy.setIdToy(toy.getIdToy());
                    resultToy.setNameToy(toy.getNameToy());
                    resultToy.setWeightToy(toy.getWeightToy());
                    resultToy.setAmountToys(1);
                } else {
                    resultToy.setIdToy(toy.getIdToy());
                    resultToy.setNameToy(toy.getNameToy());
                    resultToy.setWeightToy(toy.getWeightToy());
                    resultToy.setAmountToys(1);
                    toys.remove(toy);
                }
                break;
            }

        }
        boolean statusee = false;
        for (Toy toy : queue) {
            if (toy.getNameToy().toLowerCase().equals(resultToy.getNameToy().toLowerCase())) {
                toy.setAmountToys(toy.getAmountToys() + resultToy.getAmountToys());
                statusee = true;
            }

        }
        if (statusee == false) {
            queue.add(resultToy);
        }

        return resultToy;

    }
}
