import java.io.*;
import java.util.Map;

public class FileCompressor {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String compressedFile = "compressed.txt";
        String codesFile = "codes.txt";

        try {
            String content = readFile(inputFile);

            Map<Character, String> codes =
                    HuffmanCoding.buildHuffmanTree(content);

            String encoded = HuffmanCoding.encode(content, codes);

            writeFile(compressedFile, encoded);
            writeCodes(codesFile, codes);

            System.out.println("Compression successful!");
            System.out.println("Original size: " + content.length() * 8 + " bits");
            System.out.println("Compressed size: " + encoded.length() + " bits");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    private static void writeCodes(String filePath,
                                   Map<Character, String> codes)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            writer.write((int) entry.getKey() + ":" + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }

    private static String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            data.append(line).append("\n");
        }
        reader.close();
        return data.toString();
    }

    private static void writeFile(String filePath, String content)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }
}
