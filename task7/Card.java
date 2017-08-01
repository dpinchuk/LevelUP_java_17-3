package home.task7;

public class Card {

    private final IMethods.Rank rank;
    private final IMethods.Suit suit;

    Card(IMethods.Rank rank, IMethods.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public IMethods.Suit getSuit() {
        return suit;
    }

    public IMethods.Rank getRank() {
        return rank;
    }

}