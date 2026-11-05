import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Clase para la interfaz gráfica (Klasa dla interfejsu graficznego)
public class MainFrame extends JFrame {
    
    private final GameModel gamgModel;
    private final JLabel[][] slotLabels;
    private final JButton btnSpin;
    private final JComboBox<Integer> cbBet;
    private final JLabel lblCredit;
    private final JLabel lblWin;
    private final Random random = new Random();

    public MainFrame() {
        this.gameModel = new GameModel(1000);
        this.slotLabels = new JLabel[3][3];

        setTitle("Ultra Hot Deluxe - Refactored POO Edition");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }
}
