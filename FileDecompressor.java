import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileDecompressor {

    public static void main(String[] args) {
        String compressedFile = "compressed.txt";
        String codesFile = "codes.txt";
        String outputFile = "decompressed.txt";

        try {
            String encoded = readFile(compressedFile);
            Map<Character, String> codes = readCodes(codesFile);

            String decoded = HuffmanCoding.decode(encoded, codes);
            writeFile(outputFile, decoded);

            System.out.println("Decompression successful!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    private static Map<Character, String> readCodes(String filePath)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Map<Character, String> codes = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            char character = (char) Integer.parseInt(parts[0]);
            codes.put(character, parts[1]);
        }
        reader.close();
        return codes;
    }

    private static String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            data.append(line);
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
