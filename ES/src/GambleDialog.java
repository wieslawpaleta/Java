import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Diálogo para la función de riesgo (Rojo o Negro) (Okno dialogowe funkcji ryzyka - Czerwone lub Czarne)
public class GambleDialog extends JDialog {

    private int currentWin;
    private boolean collected = false;
    private JLabel lblWinAmount;
    private final Random random = new Random();

    public GambleDialog(JFrame parent, int winAmount) {
        super(parent, "Ultra Hot - Función de Riesgo (Gamble)", true);
        this.currentWin = winAmount;

        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel superior con información del premio (Górny panel z informacją o wygranej)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("¡DOBLE O NADA!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblWinAmount = new JLabel("Premio actual: " + currentWin, SwingConstants.CENTER);
        lblWinAmount.setFont(new Font("Arial", Font.BOLD, 16));
        lblWinAmount.setForeground(Color.WHITE);
        lblWinAmount.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(Box.createVerticalStrut(15));
        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(lblWinAmount);
        topPanel.add(Box.createVerticalStrut(15));
        add(topPanel, BorderLayout.NORTH);

        // Panel central con los botones Rojo y Negro (Środkowy panel z przyciskami Czerwone i Czarne)
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(Color.BLACK);

        JButton btnRed = new JButton("ROJO (Czerwony)");
        btnRed.setBackground(Color.RED);
        btnRed.setForeground(Color.WHITE);
        btnRed.setFont(new Font("Arial", Font.BOLD, 16));
        btnRed.addActionListener(e -> playGamble("ROJO"));

        JButton btnBlack = new JButton("NEGRO (Czarny)");
        btnBlack.setBackground(Color.BLACK);
        btnBlack.setForeground(Color.WHITE);
        btnBlack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBlack.addActionListener(e -> playGamble("NEGRO"));

        centerPanel.add(btnRed);
        centerPanel.add(btnBlack);
        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior con el botón de cobrar (Dolny panel z przyciskiem odbioru)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);

        JButton btnCollect = new JButton("COBRAR (Odbierz)");
        btnCollect.setFont(new Font("Arial", Font.BOLD, 16));
        btnCollect.setBackground(Color.ORANGE);
        btnCollect.addActionListener(e -> {
            collected = true;
            dispose(); // Cerrar ventana y conservar el premio (Zamknij okno i zachowaj wygraną)
        });

        bottomPanel.add(btnCollect);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Lógica al elegir un color (Logika przy wyborze koloru)
    private void playGamble(String chosenColor) {
        String[] colors = {"ROJO", "NEGRO"};
        String drawnColor = colors[random.nextInt(colors.length)];

        if (chosenColor.equals(drawnColor)) {
            currentWin *= 2; // Duplicar premio (Podwojenie wygranej)
            lblWinAmount.setText("¡ACERTASTE! Premio actual: " + currentWin);
            JOptionPane.showMessageDialog(this, "¡Salió " + drawnColor + "! Has duplicado tu premio. (Wypadło " + drawnColor + "! Podwoiłeś swoją wygraną.)");
        } else {
            JOptionPane.showMessageDialog(this, "¡Salió " + drawnColor + "! Has perdido tu premio. (Wypadło " + drawnColor + "! Straciłeś swoją wygraną.)");
            currentWin = 0; // Se pierde todo el premio (Utrata całej wygranej)
            collected = true;
            dispose();
        }
    }

    public int getFinalWin() {
        return currentWin;
    }

    public boolean isCollected() {
        return collected;
    }
}