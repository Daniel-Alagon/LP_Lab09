package Lab09ej02;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountGUI extends JFrame {

    private JLabel linesLabel, wordsLabel, charsLabel;

    public WordCountGUI() {
        setTitle("Word Count");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        linesLabel = new JLabel("Lines=");
        wordsLabel = new JLabel("Words=");
        charsLabel = new JLabel("Chars=");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(linesLabel);
        panel.add(wordsLabel);
        panel.add(charsLabel);

        add(panel);

        processFile("C:\\universidad\\LPIII\\Lab09ej02\\lear.txt"); // Cambia el nombre del archivo según tu caso
    }

    private void processFile(String fileName) {
        try {
            int lines = 0;
            int words = 0;
            int chars = 0;

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines++;
                chars += line.length();

                // Contar palabras en cada línea
                String[] wordsArray = line.split("\\s+");
                for (String word : wordsArray) {
                    if (isWord(word)) {
                        words++;
                    }
                }
            }

            bufferedReader.close();

            // Actualizar las etiquetas en la interfaz gráfica
            linesLabel.setText("Lines=" + lines);
            wordsLabel.setText("Words=" + words);
            charsLabel.setText("Chars=" + chars);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWord(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCountGUI wordCountGUI = new WordCountGUI();
            wordCountGUI.setVisible(true);
        });
    }
}
