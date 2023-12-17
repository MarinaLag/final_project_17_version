package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode  // Equals и HashCode
public class FoodItem {
    private int id;
    private int type;
    private String name;
    private double price;
}
