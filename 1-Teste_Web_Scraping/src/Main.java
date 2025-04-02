
public class Main {


    public static void main(String[] args) {
        try {

            WebScraper.scrapeAndDownload();


            FileZipper.zipFiles("downloads", "anexos.zip");

            System.out.println("Download e compactação concluídos com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro geral na execução do programa.");
            e.printStackTrace();
        }
    }

}
