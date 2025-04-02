package org.example;

import java.io.*;
import java.util.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFExtractor {

    public static List<String[]> extractTable(String pdfPath) {
        List<String[]> data = new ArrayList<>();

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(3); // Ignora as duas primeiras páginas

            String text = stripper.getText(document);
            for (String line : text.split("\n")) {
                // Melhorar a separação das colunas, considerando espaços ou tabulação
                String[] columns = line.trim().split("\\s{2,}|\t");
                data.add(columns);
            }
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo PDF: " + e.getMessage());
        }

        return data;
    }
}
