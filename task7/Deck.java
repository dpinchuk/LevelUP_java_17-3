package home.task7;

public class Deck<T> implements IMethods {

    private T[] deckOfCards;
    private int cardsInDeck = DECK_SIZE;
    private int position;

    public Deck(T[] deckOfCards) {
        this.deckOfCards = deckOfCards;
        this.position = -1;
    }

    public void insertNextCardToDeck(T card) {
        this.deckOfCards[++this.position] = card;
    }

    // get deck array
    public T[] getCard() {
        return this.deckOfCards;
    }

    // shuffle of the deck
    public void shuffle() {
        T card;
        int index;
        for (int i = 0; i < this.cardsInDeck; i++) {
            index = (int) (Math.random() * (this.cardsInDeck - i)) + i;
            card = this.deckOfCards[i];
            this.deckOfCards[i] = this.deckOfCards[index];
            this.deckOfCards[index] = card;
        }
    }

    // is next card present?
    private boolean hasNext() {
        return this.cardsInDeck > 0 ? true : false;
    }

    // take one card from the Deck
    public T takeOneCard() {
        if (hasNext()) {
            T card = this.deckOfCards[0];
            for (int i = 0; i < this.cardsInDeck - 1; i++) {
                this.deckOfCards[i] = this.deckOfCards[i + 1];
            }
            //this.deck[--this.cardsInDeck] = null; // Is it necessary to delete an object in this way???
            return card;
        } else {
            System.out.println("The Deck is empty!");
            return null;
        }
    }

    // size of the deck
    public Integer getCardsInDeck() {
        return cardsInDeck;
    }

}