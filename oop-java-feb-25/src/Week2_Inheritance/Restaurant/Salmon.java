package Week2_Inheritance.Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    private static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
