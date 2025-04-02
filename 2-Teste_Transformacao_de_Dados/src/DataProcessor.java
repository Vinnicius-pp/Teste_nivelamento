import java.util.*;
import java.util.regex.*;

public class DataProcessor {


    public String[][] processText(String text) {
        List<String[]> data = new ArrayList<>();


        String[] lines = text.split("\n");


        String regex = "\\s{2,}";

        for (String line : lines) {

            if (line.trim().isEmpty()) {
                continue;
            }


            String[] columns = line.trim().split(regex);
            data.add(columns);
        }


        replaceAbbreviations(data);


        String[][] result = new String[data.size()][];
        return data.toArray(result);
    }

    private void replaceAbbreviations(List<String[]> data) {
        Map<String, String> legend = new HashMap<>();
        legend.put("OD", "Oftalmologia Diagnóstica");
        legend.put("AMB", "Ambulatório");

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (legend.containsKey(row[i])) {
                    row[i] = legend.get(row[i]);
                }
            }
        }
    }
}