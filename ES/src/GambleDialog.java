import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Dialogo para la función de riesgo (Rojo o Negro) (Okno dialogowe funkcji ryzyka - Czerwone lub Czarne)
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
        lblWinAmount.setAlignmentX((Component.CENTER_ALIGNMENT));

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

        // Panel central con los botones Rojo y Negro (Środkowy panel z przyciskami Czerwone i Czarne)
        JPanel centerJPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        centerPanel.setBackground(Color.RED);
        

    }
}
