package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
public class Application implements Comparable<Application>{

    @Getter
    private String clorderId;

    @Getter
    @Setter
    private char action;

    @Getter
    @Setter
    private long price;

    @Getter
    @Setter
    private int amount;

    @Getter
    @Setter
    private int amountRest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return action == that.action && price == that.price && amount == that.amount && amountRest == that.amountRest && Objects.equals(clorderId, that.clorderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clorderId, action, price, amount, amountRest);
    }

    @Override
    public String toString() {
        return "Application{" +
                "clorderId='" + clorderId + '\'' +
                ", action=" + action +
                ", price=" + price +
                ", amount=" + amount +
                ", amountRest=" + amountRest +
                '}';
    }

    @Override
    public int compareTo(Application appl) {
        if (price - appl.getPrice() > 0){
            return 1;
        }
        if (price - appl.getPrice() < 0){
            return -1;
        }
        return 0;
    }
}
