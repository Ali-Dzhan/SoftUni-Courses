package bg.softuni.entities.paymentSystem;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetails {
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private CardType type;

    @Column(name = "expiration_month")
    private int expirationMonth;

    @Column(name = "expiration_year")
    private int expirationYear;
}
