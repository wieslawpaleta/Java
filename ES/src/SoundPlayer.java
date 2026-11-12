import javax.sound.sampled.*;
import java.net.URL;

// Clase para gestionar la reproducción de efectos de sonido (Klasa do zarządzania odtwarzaniem efektów dźwiękowych)
public class SoundPlayer {

    // Método estático para reproducir un sonido por su nombre (Statyczna metoda do odtwarzania dźwięku po nazwie)
    public static void playSound(String soundFileName) {
        try {
            // Buscar el archivo en la carpeta de recursos /sounds/ (Wyszukiwanie pliku w folderze zasobów /sounds/)
            URL soundUrl = SoundPlayer.class.getResource("/sounds/" + soundFileName);
            
            if (soundUrl != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundUrl);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start(); // Reproducir el sonido (Odtworzenie dźwięku)
            } else {
                System.out.println("No se encontró el archivo de sonido: " + soundFileName + " (Nie znaleziono pliku dźwiękowego)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}