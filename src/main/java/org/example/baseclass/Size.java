package org.example.baseclass;

/**
 * Список размеров пицц и их множитель для определения цены
 */
public enum Size {
    SMALL(0.5),
    MEDIUM(1.0),
    LARGE(1.5);

    private final double multiplier;

    Size(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
