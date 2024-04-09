package sg.edu.nus.iss.workshop21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends Customer{
    private double taxRate;
    private LocalDateTime orderDate;
}
