import javax.swing.*;
import java.awt.*;
import java.net.URL;

// Enum que representa cada símbolo del juego (Enum reprezentujący każdy symbol w grze)
public enum Symbol {
    SEVEN("77", 1500),
    BAR("BAR", 300),
    PLUM("PLUM", 80),
    ORANGE("ORANGE", 80),
    LEMON("LEMON", 80),
    CHERRY("CHERRY", 80),
    X("X", 10);

    private final String name;
    private final int baseValue;

    Symbol(String name, int baseValue) {
        this.name = name;
        this.baseValue = baseValue;
    }

    public String getName() {
        return name;
    }

    public int getBaseValue() {
        return baseValue;
    }

    // Cargar e icono redimensionado del símbolo (Ładowanie i przeskalowanie ikony symbolu)
    public ImageIcon getIcon(int width, int height) {
        URL imgUrl = getClass().getResource("/images/" + name + ".png");
        if (imgUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imgUrl);
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        }
        return null;
    }
}