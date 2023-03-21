package Service.AdminService;
import Model.Toy;
import View.ConsolView;

public class CreateToy {
    
    public Toy newToy(){
        ConsolView cView = new ConsolView();
        Toy toy = new Toy();
        toy.setIdToy(toy.hashCode() / 10000);
        toy.setNameToy(cView.requestName());
        toy.setAmountToys(cView.requestAmount());
        toy.setWeightToy(cView.requestWeight());
        return toy;
    }
}
