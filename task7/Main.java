package home.task7;

public class Main {

    public static void main(String[] args) {
        Card card;
        int summ = 0; // summ of the game
        Deck<Card> deck = new Deck(new Card[IMethods.DECK_SIZE]);
        initDeck(deck);
        showDeck(deck, "[Before Shuffle]");

        delay(IMethods.DELAY);

        deck.shuffle();
        showDeck(deck, "[After Shuffle]");

        while (summ != IMethods.POINT) {
            card = deck.takeOneCard();
            summ += card.getRank().dignity;
            System.out.println(card.getRank().dignity + " => " + card.getRank() + " " + card.getSuit() + "\n");
            if (summ == IMethods.POINT) {
                System.out.println("Winner! Point = " + summ);
                break;
            } else if (summ > IMethods.POINT) {
                System.out.println("Loser! Point = " + summ);
                break;
            }
            delay(IMethods.DELAY);
        }
    }

    private static void showDeck(Deck<Card> deck, String string) {
        System.out.println(string + "\n" + "----------------");
        for (int i = 0; i < deck.getCardsInDeck(); i++) {
            System.out.println(deck.getCard()[i].getRank() + " " + deck.getCard()[i].getSuit());
        }
        System.out.println();
    }

    private static void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }

    private static void initDeck(Deck deck) {
        for (int i = 0; i < IMethods.Suit.values().length; i++) {
            for (int j = 0; j < IMethods.Rank.values().length; j++) {
                deck.insertNextCardToDeck(new Card(IMethods.Rank.values()[j], IMethods.Suit.values()[i]));
            }
        }
    }

}