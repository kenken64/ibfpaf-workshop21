package sg.edu.nus.iss.workshop21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    protected Integer id;

    protected String firstName;

    protected String lastName;
    
}
