package model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class VoteResultExporter {
    public static void exportToTxt(Election election, String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            filePath = "results_" + timestamp + ".txt";
        }

        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            writer.println("Результаты голосования: " + election.getTitle());
            for (Map.Entry<Candidate, Integer> entry : election.getResults().entrySet()) {
                writer.println(entry.getKey().getFullName() + ": " + entry.getValue() + " голосов");
            }
            System.out.println("✅ Результаты сохранены в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Ошибка при сохранении файла.");
            e.printStackTrace();
        }
    }
}
