import java.io.*;

public class CSVWriter {

    // Método para salvar os dados em um arquivo CSV
    public static void saveToCSV(String[][] data, String csvPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath))) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
            System.out.println("CSV gerado com sucesso: " + csvPath);
        }
    }
}