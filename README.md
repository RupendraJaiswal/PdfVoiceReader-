# 📄 PDF Voice Reader

A simple Java desktop application that allows you to **select a PDF file** and **listen to its content** using Text-to-Speech (TTS).  
Built using **Apache PDFBox** for PDF parsing and **FreeTTS** for offline speech synthesis.

---

## ✅ Features

- 📂 Select any `.pdf` file using a GUI file chooser
- 🗣️ Reads PDF content aloud using FreeTTS
- 🖥️ Runs offline — no internet required
- 👨 Voice: English (Male, `kevin16`)

---

## 🛠️ Requirements

- Java 8 or higher
- The following JAR libraries (add to your build path):

### 🔸 FreeTTS Libraries
- `freetts.jar`
- `cmulex.jar`
- `cmu_us_kal.jar`
- `en_us.jar`

> Download from [FreeTTS SourceForge](https://sourceforge.net/projects/freetts/files/freetts/1.2.2/)

### 🔸 Apache PDFBox Libraries
- `pdfbox-x.y.z.jar` (e.g., `2.0.27`)
- `fontbox-x.y.z.jar`

> Download from [PDFBox website](https://pdfbox.apache.org/download.html)

---

## 🚀 How to Run

### 💡 Using an IDE (Eclipse / IntelliJ)
1. Create a Java project and add all required JARs to the build path.
2. Copy the source code from `PdfVoiceReader.java`.
3. Run the program.
4. Use the GUI to choose a PDF file.

### 💡 Using the Command Line
```bash
javac -cp ".;lib/*" com/pdfReader/main/PdfVoiceReader.java
java -cp ".;lib/*" com.pdfReader.main.PdfVoiceReader
```

> Replace `;` with `:` on Linux/macOS  
> Place all dependencies in a `lib/` directory.

---

## 📦 How to Create a Runnable JAR

1. Package your project using Maven or manually bundle all dependencies.
2. Ensure `Main-Class` is set to `com.pdfReader.main.PdfVoiceReader` in `MANIFEST.MF`.
3. Run the JAR:

```bash
java -jar PdfVoiceReader.jar
```

---

## ⚠️ Limitations

- Only **English (US)** supported.
- Only one voice (`kevin16` - male).
- FreeTTS is old and sounds robotic.

---

## 🚀 Want Better Voices or Languages?

For female or multilingual voices, consider using:
- [Google Cloud Text-to-Speech](https://cloud.google.com/text-to-speech)
- [Amazon Polly](https://aws.amazon.com/polly/)
- [MaryTTS (Open-source)](https://github.com/marytts/marytts)

---

## 📜 License

This project is licensed under the **MIT License**.

---

## 🙌 Author

**Rupendra Jaiswal**  
📧 jaiswalrupendra8055@gmail.com