package util;

import model.Vote;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class TextExporter {

    public static void export(List<Vote> votes, String folder, String filename, boolean singleFile) {
        if (folder == null || folder.isEmpty()) {
            folder = System.getProperty("user.dir");
        }
        if (filename == null || filename.isEmpty()) {
            filename = "results_" + System.currentTimeMillis();
        }

        try {
            if (singleFile) {
                Path filePath = Paths.get(folder, filename + ".txt");
                try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                    for (Vote v : votes) {
                        writer.write("Голосование: " + v.getName());
                        writer.newLine();
                        v.countResults()
                                .forEach((candidate, count) -> {
                            try {
                                writer.write(candidate + ": " + count);
                                writer.newLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        writer.newLine();
                    }
                }
            } else {
                for (Vote v : votes) {
                    String safeName = v.getName().replaceAll("\\s+", "_");
                    Path filePath = Paths.get(folder, filename + "_" + safeName + ".txt");
                    try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                        writer.write("Голосование: " + v.getName());
                        writer.newLine();
                        v.countResults().forEach((candidate, count) -> {
                            try {
                                writer.write(candidate + ": " + count);
                                writer.newLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            }
            System.out.println("✅ Результаты экспортированы в текстовые файлы.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
