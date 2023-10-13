package Noel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Books {
    private String title;
    private String author;
    private String type;
    private String description;

    public Books(String title, String author, String type, String description) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
    
    // 可以添加其他方法和属性，例如设置书评、评分等
    public class BookReader {
        public void main(String[] args) {
            String directoryPath = "D:/books"; // 修改为你的小说目录的路径

            File directory = new File(directoryPath);

            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                for (File file : files) {
                    if (file.isFile()) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                // 处理读取到的每一行文本
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}