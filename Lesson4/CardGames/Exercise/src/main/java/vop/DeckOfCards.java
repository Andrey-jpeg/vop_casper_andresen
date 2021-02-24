package vop;

/**
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards(){
        // Task 3. Initialiser deck, dan de 52 lovlige kort og saet dem i deck-arrayet
        
    }

    // Faerdiskrevet metode til "paen" udskrift af kortbunken
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        // Opgave 4 Bland kortene
    }

   
    public static void main(String[] args) {
        
            // Til test af task 3
            DeckOfCards deckOfCards = new DeckOfCards();
            System.out.println("Opg 3c:\n" + deckOfCards);
            
            // Til test af task 4
            deckOfCards.shuffle(100);
            System.out.println("Opg 3d:\n" + deckOfCards);
        

    }

}
