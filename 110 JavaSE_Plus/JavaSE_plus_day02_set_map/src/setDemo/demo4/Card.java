package setDemo.demo4;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package setDemo.demo4
 * @className setDemo.demo4.Card
 * @date 2024/11/16 19:56
 * @description 牌
 */
public class Card {
    private String name;
    private String color;
    private String value;
    private int number; // 牌值

    public Card(){

    }

    public Card(String value, String color, int number){
        this.value = value;
        this.color = color;
        this.number = number;
        this.name = number + " " + value  + " " + color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){
        return value + " " + color;
    }
}
