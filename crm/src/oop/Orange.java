package oop;

public class Orange extends Fruits{

    private double weight;

    public Orange(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String howtoEat() {
        return "make juice";
    }
}
