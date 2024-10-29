package bg.softuni.entities.paymentSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetails {
    @Column(name = "name")
    private String name;

    @Column(name = "swift_code")
    private String swiftCode;
}
