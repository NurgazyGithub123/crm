package oop;

public class Apple extends Fruits{

    private String color;

    public Apple(String name, String color) {
        super(name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String howtoEat() {
        return "slice";
    }
}
