package WorkingWithAbstractionExercise;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;


    public Card(CardSuits cardSuit, CardRanks cardRank) {
        //нова празна карта
        //cardSuit = null
        //cardRank = null
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    //сила = стойността на боята + стойността на вид
    public int calculatePower() {
        return this.cardSuit.getValue() + this.cardRank.getValue();
    }
}
