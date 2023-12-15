package interfaz;

import javax.sound.sampled.*;

public class MusicPlayer implements Runnable {
    private String filePath;

    public MusicPlayer(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            // Obtener el flujo de audio desde el archivo
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
            
            // Obtener el formato de audio
            AudioFormat format = audioInputStream.getFormat();
            
            // Crear una fuente de datos de audio
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            
            // Abrir la línea de audio y comenzar a reproducir
            line.open(format);
            line.start();
            
            // Leer los datos del archivo y escribir en la línea de audio
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            
            while ((bytesRead = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
                line.write(buffer, 0, bytesRead);
            }
            
            // Cerrar la línea de audio y el flujo de entrada cuando la reproducción haya terminado
            line.drain();
            line.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ruta del archivo de música (ajusta la ruta según la ubicación de tu archivo)
        String filePath = "/path/to/your/music/file.wav";

        // Crear una instancia del reproductor de música y ejecutar en un hilo aparte
        Thread musicThread = new Thread(new MusicPlayer(filePath));
        musicThread.start();
    }
}

