import java.util.Random;

// Clase que maneja la lógica, el cálculo de premios y el registro de celdas ganadoras (Klasa zarządzająca logiką, obliczaniem nagród i rejestrowaniem wygrywających komórek)
public class GameModel {

    private int credit;
    private int currentBet;
    private final Symbol[][] grid;
    private final boolean[][] winningCells; // Matriz para marcar las casillas que forman parte de una línea ganadora (Macierz do zaznaczania pól tworzących linię wygrywającą)
    private final Random random;

    public GameModel(int initialCredit) {
        this.credit = initialCredit;
        this.currentBet = 10;
        this.grid = new Symbol[3][3];
        this.winningCells = new boolean[3][3];
        this.random = new Random();
        initializeGrid();
    }

    private void initializeGrid() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = Symbol.SEVEN;
            }
        }
    }

    public Symbol[][] spin() {
        clearWinningCells(); // Limpiar marcas anteriores antes de girar (Wyczyszczenie poprzednich oznaczeń przed obrotem)
        
        Symbol[] allSymbols = Symbol.values();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = allSymbols[random.nextInt(allSymbols.length)];
            }
        }
        return grid;
    }

    public void clearWinningCells() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                winningCells[r][c] = false;
            }
        }
    }

    public boolean canPlay() {
        return credit >= currentBet;
    }

    public void deductBet() {
        credit -= currentBet;
    }

    // Método para calcular ganancias y marcar las celdas ganadoras (Metoda obliczająca wygrane i zaznaczająca wygrywające komórki)
    public int calculateWin() {
        int baseWin = 0;
        clearWinningCells();

        // Línea horizontal 1 (Pozioma linia 1)
        if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2]) {
            baseWin += grid[0][0].getBaseValue();
            winningCells[0][0] = true;
            winningCells[0][1] = true;
            winningCells[0][2] = true;
        }
        // Línea horizontal 2 (Pozioma linia 2)
        if (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]) {
            baseWin += grid[1][0].getBaseValue();
            winningCells[1][0] = true;
            winningCells[1][1] = true;
            winningCells[1][2] = true;
        }
        // Línea horizontal 3 (Pozioma linia 3)
        if (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2]) {
            baseWin += grid[2][0].getBaseValue();
            winningCells[2][0] = true;
            winningCells[2][1] = true;
            winningCells[2][2] = true;
        }
        // Diagonal principal (Przekątna główna)
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            baseWin += grid[0][0].getBaseValue();
            winningCells[0][0] = true;
            winningCells[1][1] = true;
            winningCells[2][2] = true;
        }
        // Diagonal secundaria (Przekątna poboczna)
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2]) {
            baseWin += grid[2][0].getBaseValue();
            winningCells[2][0] = true;
            winningCells[1][1] = true;
            winningCells[0][2] = true;
        }

        int totalWin = baseWin * (currentBet / 10);
        credit += totalWin;
        return totalWin;
    }

    public boolean[][] getWinningCells() {
        return winningCells;
    }

    public int getCredit() { return credit; }
    public int getCurrentBet() { return currentBet; }
    public void setCurrentBet(int currentBet) { this.currentBet = currentBet; }
    public Symbol[][] getGrid() { return grid; }
}