import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Transaction {
    private String date;
    private double amount;
    private String description;
}
