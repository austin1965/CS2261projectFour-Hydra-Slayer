package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hydra {
    private int heads;
    private int tails;

    public Hydra() {
        this(0, 0);
    }

    public Hydra(int heads) {
        this(heads, 0);
    }

    public Hydra(int heads, int tails) {
        this.setHeads(heads);
        this.setTails(tails);
    }

    public void incrementHeads(int heads) {
        this.heads += heads;
    }

    public void decrementHeads(int heads) {
        this.heads -= heads;
    }

    public void incrementTails(int tails) {
        this.tails += tails;
    }

    public void decrementTails(int tails) {
        this.tails -= tails;
    }

    public void removeOneHead() {
        this.decrementHeads(1);
        this.incrementHeads(1);
    }

    public void removeOneTail() {
        this.decrementTails(1);
        this.incrementTails(2);
    }

    public void removeTwoHeads() {
        this.decrementHeads(2);
    }

    public void removeTwoTails() {
        this.decrementTails(2);
        this.incrementHeads(1);
    }

}
