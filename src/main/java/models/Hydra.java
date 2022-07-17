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
        if (this.getHeads() > 0) {
            this.decrementHeads(1);
            this.incrementHeads(1);
        }
        else {
            System.out.println("Invalid move. Current head count: " + this.getHeads());
        }
    }

    public void removeOneTail() {
        if (this.getTails() > 0) {
            this.decrementTails(1);
            this.incrementTails(2);
            System.out.println("Removed one tail. Two grew in its place.");
        }
        else {
            System.out.println("Invalid move. Current tail count: " + this.getTails());
        }
    }

    public void removeTwoHeads() {
        if (this.getHeads() - 2 >= 0) {
            this.decrementHeads(2);
            System.out.println("Removed two heads.");
        }
        else {
            System.out.println("Invalid move. Current head count: " + this.getHeads());
        }
    }

    public void removeTwoTails() {
        if (this.getTails() - 2 >= 0) {
            this.decrementTails(2);
            this.incrementHeads(1);
            System.out.println("Removed two tails. A head sprouts in response.");
        }
        else {
            System.out.println("Invalid move. Current tails count: " + this.getTails());
        }
    }

    public void printStatus() {
        System.out.println("Hydra status -> heads: " + this.getHeads()
                + "; tails: " + this.getTails());
        System.out.println();
    }

}
