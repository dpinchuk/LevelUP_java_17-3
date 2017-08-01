package home.task7;

public interface IMethods<T> {

    int DECK_SIZE = 52;
    int POINT = 21;
    int DELAY = 2500;

    enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

        int dignity;

        Rank(int value) {
            dignity = value;
        }
    }

    enum Suit {HEARTS, SPADES, DIAMONDS, CLUBS}

    T[] getCard(); // get array of the Deck

    void shuffle(); // shuffle of the Deck

    T takeOneCard(); // take one card from the Deck

}