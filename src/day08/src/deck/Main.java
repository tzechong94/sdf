package deck;
import java.util.Optional;

public class Main {
    public static void main(String[] args){

        Deck deck = new Deck();
        System.out.println(deck);

        deck.shuffle();

        Optional<Card> opt = deck.take();
        if (opt.isPresent()) {
            Card c = opt.get();
            System.out.printf("Suit: ", c.getSuit());
        }
        opt.ifPresent(c -> {
            System.out.printf("suit: %s\n", c.getSuit());
        });
    }
}
