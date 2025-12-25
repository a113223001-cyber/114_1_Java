import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ScannerFileDemo {
    public static void main(String[] args) {
        // args: [inputFile] [outputFile] [csv] [strict]
        String inputName = "data.txt";
        String outputName = "outputScores.txt";
        boolean strict = false;

        if (args.length > 0) inputName = args[0];
        if (args.length > 1) outputName = args[1];
        for (int i = 2; i < args.length; i++) {
            if ("strict".equalsIgnoreCase(args[i])) strict = true;
        }

        File input = new File(inputName);
        File output = new File(outputName);

        List<Student> students = new ArrayList<>();

        // 讀取並解析
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                try (Scanner ls = new Scanner(line)) {
                    if (ls.hasNext()) {
                        String name = ls.next();
                        if (ls.hasNextDouble()) {
                            double score = ls.nextDouble();
                            students.add(new Student(name, score));
                            System.out.println("加入: " + name + "\t" + score);
                            continue;
                        }
                    }
                }

                if (!strict) {
                    students.add(new Student(line, Double.NaN));
                    System.out.println("加入(raw): " + line);
                } else {
                    System.out.println("跳過(無法解析，嚴格模式): " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("輸入檔案不存在: " + e.getMessage());
            return;
        }

        // 使用 Formatter 輸出（TSV）
        try {
            try (Formatter formatter = new Formatter(output)) {
                formatter.format("%s\t%s%n", "Name", "Score");
                for (Student s : students) {
                    if (!Double.isNaN(s.score)) {
                        formatter.format("%s\t%.2f%n", s.name, s.score);
                    } else {
                        formatter.format("%s%n", s.name);
                    }
                }
            }
            System.out.println("已寫入: " + output.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("無法建立輸出檔案: " + e.getMessage());
        }
    }

    static class Student {
        String name;
        double score;

        Student(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }
}
