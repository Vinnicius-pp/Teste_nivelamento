import java.io.*;
import java.util.zip.*;

public class FileZipper {

    public static void zipFiles(String folder, String zipFile) throws IOException {
        File dir = new File(folder);
        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            try (FileOutputStream fos = new FileOutputStream(zipFile);
                 ZipOutputStream zipOut = new ZipOutputStream(fos)) {

                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Adicionando arquivo ao ZIP: " + file.getName());
                        try (FileInputStream fis = new FileInputStream(file)) {
                            ZipEntry zipEntry = new ZipEntry(file.getName());
                            zipOut.putNextEntry(zipEntry);
                            byte[] bytes = new byte[1024];
                            int length;
                            while ((length = fis.read(bytes)) >= 0) {
                                zipOut.write(bytes, 0, length);
                            }
                            zipOut.closeEntry();
                        }
                    }
                }

                System.out.println("Arquivos compactados com sucesso em: " + zipFile);
            }
        } else {
            System.err.println("Nenhum arquivo para compactar na pasta: " + folder);
        }
    }
}
