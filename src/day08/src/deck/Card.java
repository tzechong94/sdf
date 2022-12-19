package deck;
public class Card {

    private final String suit;
    private final String name;
    private final Integer value;

    //if you have final, it has to be in the constructor
    
    public Card(String suit, String name, Integer value){
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }
    public String getName() {
        return name;
    }
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card [suit=" + suit + ", name="+ name + ", value=" + value + "]";
    }

    
}