import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.regex.*;

public class WebScraper {

    private static final String URL_SITE = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    private static final String DOWNLOAD_FOLDER = "downloads";

    public static void scrapeAndDownload() throws IOException {

        String pageContent = getPageContent(URL_SITE);
        Files.createDirectories(Paths.get(DOWNLOAD_FOLDER));
        System.out.println("Pasta de downloads criada: " + DOWNLOAD_FOLDER);


        Pattern pattern = Pattern.compile("href=\"(https?://[^\"]+?(Anexo_I_Rol_2021RN_465.2021_RN627L.2024\\.pdf|Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025\\.pdf))\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pageContent);


        while (matcher.find()) {
            String fileUrl = matcher.group(1);
            System.out.println("Link encontrado: " + fileUrl);

            FileDownloader.downloadFile(fileUrl, DOWNLOAD_FOLDER);
        }
    }

    private static String getPageContent(String urlString) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}