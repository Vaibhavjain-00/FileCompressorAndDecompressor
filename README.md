# 📦 File Compressor using Huffman Coding (Java)

A Java-based file compression and decompression system built using the **Huffman Coding algorithm**.
The program compresses text files by encoding characters based on frequency and reconstructs the original file using stored encoding maps.

This project demonstrates practical use of:

* Greedy algorithms
* Binary trees
* Priority queues
* File handling in Java

---

## 🚀 Features

✅ Compresses text files using Huffman Coding
✅ Separate compression and decompression programs
✅ Stores encoding map for independent decoding
✅ Displays compression statistics
✅ Console-based, lightweight implementation

---

## 🧠 How Huffman Compression Works

1. Count frequency of each character.
2. Build a binary tree using a priority queue.
3. Assign shorter binary codes to frequent characters.
4. Encode text into a binary string.
5. Save:

   * Encoded data
   * Character-to-code mapping

Decompression uses the saved map to rebuild original text.

---

## 📁 Project Structure

```
HuffmanNode.java
HuffmanComparator.java
HuffmanCoding.java
FileCompressor.java
FileDecompressor.java
input.txt
```

---

## ▶️ How to Run

### 1️⃣ Create input file

Create `input.txt` in project folder.

Example:

```
this is a huffman compression test
```

---

### 2️⃣ Compile

```bash
javac *.java
```

---

### 3️⃣ Compress File

```bash
java FileCompressor
```

Generated files:

```
compressed.txt
codes.txt
```

---

### 4️⃣ Decompress File

```bash
java FileDecompressor
```

Generated file:

```
decompressed.txt
```

---

## 📊 Output Example

```
Compression successful!
Original size: 320 bits
Compressed size: 178 bits
Decompression successful!
```

---

## 🔧 Implementation Details

### Huffman Tree Construction

* Uses `PriorityQueue`
* Combines lowest frequency nodes first
* Generates prefix-free binary codes

### Encoding

Each character replaced with its binary code.

### Decoding

Binary stream interpreted using stored code mapping.

---

## 📚 Concepts Practiced

* Greedy algorithm design
* Tree data structures
* Recursion
* File I/O handling
* Data encoding techniques
* Compression fundamentals

---

## 💡 Learning Outcome

Built a working file compression system that reduces file size by encoding characters based on frequency using binary trees. Gained hands-on experience with greedy algorithms, trees, and file processing in Java.

---

## 🔮 Possible Improvements

* Binary file compression instead of text bits
* GUI interface
* Support for large files
* Compression ratio analysis
* Stream-based processing

---
