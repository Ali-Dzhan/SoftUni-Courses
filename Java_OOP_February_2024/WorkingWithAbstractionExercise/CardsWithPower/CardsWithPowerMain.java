package WorkingWithAbstractionExercise.CardsWithPower;

import WorkingWithAbstractionExercise.Card;
import WorkingWithAbstractionExercise.CardRanks;
import WorkingWithAbstractionExercise.CardSuits;

import java.util.Scanner;

public class CardsWithPowerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine(); //вид на изтеглената карта
        String suit = scanner.nextLine(); //боя на изтеглената карта

        Card card = new Card(CardSuits.valueOf(suit), CardRanks.valueOf(rank));
        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, card.calculatePower());
    }
}
