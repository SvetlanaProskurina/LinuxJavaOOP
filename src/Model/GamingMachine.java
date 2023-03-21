package Model;

import java.util.*;

public class GamingMachine {

    private List<Toy> nomenclature_toys = new LinkedList<>();
    private List<Toy> givenOut = new LinkedList<>();
    private List<Toy> queue = new LinkedList<>();

    public List<Toy> getNomenclature_toys() {
        return nomenclature_toys;
    }

    public List<Toy> getGivenOut() {
        return givenOut;
    }

    public List<Toy> getQueue() {
        return queue;
    }

    public void setNomenclature_toys(List<Toy> nomenclature_toys) {
        this.nomenclature_toys = nomenclature_toys;
    }

    public void setGivenOut(List<Toy> givenOut) {
        this.givenOut = givenOut;
    }

    public void setQueue(List<Toy> queue) {
        this.queue = queue;
    }

}
