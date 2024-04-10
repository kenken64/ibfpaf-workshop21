package sg.edu.nus.iss.workshop21.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends Customer{
    private double taxRate;
    private LocalDateTime orderDate;
}
