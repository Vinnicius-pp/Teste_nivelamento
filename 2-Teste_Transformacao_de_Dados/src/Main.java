public class Main {

    public static void main(String[] args) {
        try {

            String pdfText = PDFExtractor.extractTextFromPDF("Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf");


            DataProcessor dataProcessor = new DataProcessor();
            String[][] csvData = dataProcessor.processText(pdfText);


            CSVWriter.saveToCSV(csvData, "Rol_de_Procedimentos.csv");


            ZIPCompressor.zipFile("Rol_de_Procedimentos.csv", "Teste-Vinnicius.Paolicchi.zip");

            System.out.println("Processamento concluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}