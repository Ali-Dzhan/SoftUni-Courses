package WorkingWithAbstractionExercise.CardSuit;

import WorkingWithAbstractionExercise.CardSuits;

public class SuitsMain {
    public static void main(String[] args) {
        CardSuits[] cardSuits = CardSuits.values();
        System.out.println("Card Suits:");
        for (CardSuits cardSuit : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.name());
        }
    }
}
