import java.io.*;
import java.net.*;
import java.nio.file.*;

public class FileDownloader {

    public static void downloadFile(String fileUrl, String folder) throws IOException {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        System.out.println("Baixando o arquivo: " + fileName);

        try (InputStream in = new URL(fileUrl).openStream()) {
            Files.copy(in, Paths.get(folder, fileName));
            System.out.println("Baixado: " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao baixar o arquivo: " + fileUrl);
            e.printStackTrace();
        }
    }
}