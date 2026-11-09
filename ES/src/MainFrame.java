import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Clase para la interfaz gráfica (Klasa dla interfejsu graficznego)
public class MainFrame extends JFrame {

    private final GameModel gameModel;
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

        // 1. Header Panel (Górny panel)
        JLabel title = new JLabel("ULTRA HOT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.RED);
        add(title, BorderLayout.NORTH);

        // 2. Grid Panel (Panel środkowy)
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        gridPanel.setBackground(Color.BLACK);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                slotLabels[r][c] = new JLabel("", SwingConstants.CENTER);
                slotLabels[r][c].setOpaque(true);
                slotLabels[r][c].setBackground(Color.DARK_GRAY);
                updateLabelWithSymbol(slotLabels[r][c], gameModel.getGrid()[r][c]);
                gridPanel.add(slotLabels[r][c]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // 3. Control Panel (Dolny panel)
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        lblCredit = new JLabel("Crédito: " + gameModel.getCredit() + " ");
        lblCredit.setFont(new Font("Arial", Font.BOLD, 16));

        lblWin = new JLabel("Ganancia: 0 ");
        lblWin.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblBetText = new JLabel("Apuesta (Zakład):");
        lblBetText.setFont(new Font("Arial", Font.BOLD, 14));

        Integer[] betOptions = {5, 10, 20, 50, 100};
        cbBet = new JComboBox<>(betOptions);
        cbBet.setSelectedItem(10);
        cbBet.setFont(new Font("Arial", Font.BOLD, 14));
        cbBet.addActionListener(e -> gameModel.setCurrentBet((Integer) cbBet.getSelectedItem()));

        btnSpin = new JButton("START / SPIN");
        btnSpin.setFont(new Font("Arial", Font.BOLD, 18));
        btnSpin.setBackground(Color.ORANGE);
        btnSpin.addActionListener(e -> startSpinAnimation());

        controlPanel.add(lblCredit);
        controlPanel.add(lblWin);
        controlPanel.add(lblBetText);
        controlPanel.add(cbBet);
        controlPanel.add(btnSpin);

        add(controlPanel, BorderLayout.SOUTH);
    }

    // Actualizar visualmente un JLabel según el símbolo (Wizualna aktualizacja JLabel na podstawie symbolu)
    private void updateLabelWithSymbol(JLabel label, Symbol symbol) {
        ImageIcon icon = symbol.getIcon(100, 100);
        if (icon != null) {
            label.setIcon(icon);
            label.setText("");
        } else {
            label.setIcon(null);
            label.setText(symbol.getName());
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(Color.YELLOW);
        }
    }

    // Iniciar la animación y el proceso de giro (Uruchomienie animacji i procesu obrotu)
    private void startSpinAnimation() {
        if (!gameModel.canPlay()) {
            JOptionPane.showMessageDialog(this, "¡No tienes suficiente crédito! (Brak wystarczających środków!)");
            return;
        }

        gameModel.deductBet();
        lblCredit.setText("Crédito: " + gameModel.getCredit() + " ");
        lblWin.setText("Ganancia: 0 ");

        btnSpin.setEnabled(false);
        cbBet.setEnabled(false);

        Symbol[] symbols = Symbol.values();

        Timer spinTimer = new Timer(80, new ActionListener() {
            private int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Generar efecto visual de giro (Generowanie wizualnego efektu obrotu)
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        Symbol randomSymbol = symbols[random.nextInt(symbols.length)];
                        updateLabelWithSymbol(slotLabels[r][c], randomSymbol);
                    }
                }

                counter++;

                if (counter > 15) {
                    ((Timer) e.getSource()).stop();

                    // Obtener resultado final real del Modelo (Pobranie ostatecznego wyniku z Modelu)
                    Symbol[][] finalGrid = gameModel.spin();
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            updateLabelWithSymbol(slotLabels[r][c], finalGrid[r][c]);
                        }
                    }

                    // Obliczenie wygranych i aktualizacja (Calcular y actualizar estado)
                    int winAmount = gameModel.calculateWin();
                    lblWin.setText("Ganancia: " + winAmount + " ");
                    lblCredit.setText("Crédito: " + gameModel.getCredit() + " ");

                    btnSpin.setEnabled(true);
                    cbBet.setEnabled(true);
                }
            }
        });

        spinTimer.start();
    }
}