import java.util.Random;

// Clase que maneja la lógica y las reglas del juego (Klasa zarządzająca logiką i zasadami gry)
public class GameModel {

    private int credit;
    private int currentBet;
    private final Symbol[][] grid;
    private final Random random;

    public GameModel(int initialCredit) {
        this.credit = initialCredit;
        this.currentBet = 10;
        this.grid = new Symbol[3][3];
        this.random = new Random();
        initializeGrid();
    }

    // Inicializar rejilla con símbolos por defecto (Inicjalizacja siatki domyślnymi symbolami)
    private void initializeGrid() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = Symbol.SEVEN;
            }
        }
    }

    // Generar nuevos símbolos aleatorios (Generowanie nowych losowych symboli)
    public Symbol[][] spin() {
        Symbol[] allSymbols = Symbol.values();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = allSymbols[random.nextInt(allSymbols.length)];
            }
        }
        return grid;
    }

    // Verificar si se puede realizar la apuesta (Sprawdzenie, czy można postawić zakład)
    public boolean canPlay() {
        return credit >= currentBet;
    }

    // Restar la apuesta del crédito (Odejmowanie zakładu od salda)
    public void deductBet() {
        credit -= currentBet;
    }

    // Calcular las ganancias de las 5 líneas (Obliczanie wygranych z 5 linii)
    public int calculateWin() {
        int baseWin = 0;

        // Líneas horizontales (Poziome linie)
        if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2]) baseWin += grid[0][0].getBaseValue();
        if (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]) baseWin += grid[1][0].getBaseValue();
        if (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2]) baseWin += grid[2][0].getBaseValue();

        // Diagonales (Przekątne)
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] baseWin += grid)
    }

    // Calcular ganancia total ajustada por la apuesta (Obliczenie całkowitej wygranej dostosowanej do zakładu)
    int
}
