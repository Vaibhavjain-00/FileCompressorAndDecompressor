import java.util.*;

public class HuffmanCoding {

    public static Map<Character, String> buildHuffmanTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq =
                new PriorityQueue<>(new HuffmanComparator());

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(
                    left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        HuffmanNode root = pq.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void generateCodes(HuffmanNode node, String code,
                                      Map<Character, String> map) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            map.put(node.character, code);
        }

        generateCodes(node.left, code + "0", map);
        generateCodes(node.right, code + "1", map);
    }

    public static String encode(String text, Map<Character, String> codes) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(codes.get(c));
        }
        return encoded.toString();
    }

    public static String decode(String encoded, Map<Character, String> codes) {
        Map<String, Character> reverseMap = new HashMap<>();
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        StringBuilder decoded = new StringBuilder();
        String temp = "";

        for (char bit : encoded.toCharArray()) {
            temp += bit;
            if (reverseMap.containsKey(temp)) {
                decoded.append(reverseMap.get(temp));
                temp = "";
            }
        }
        return decoded.toString();
    }
}
