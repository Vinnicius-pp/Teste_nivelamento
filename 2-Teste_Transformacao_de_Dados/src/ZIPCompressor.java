import java.io.*;
import java.util.zip.*;

public class ZIPCompressor {


    public static void zipFile(String filePath, String zipName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(zipName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            ZipEntry zipEntry = new ZipEntry(filePath);
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            System.out.println("Arquivo compactado com sucesso: " + zipName);
        }
    }
}