package com.pdfReader.main;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class PdfVoiceReader {
    public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Set FreeTTS system property for voice
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            Voice voice = VoiceManager.getInstance().getVoice("kevin16");
            if (voice == null) {
                System.out.println("Voice 'kevin16' not found.");
                return;
            }
            voice.allocate();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a PDF File");
            fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

            // Loop to allow selecting multiple files one after another
            while (true) {
                int result = fileChooser.showOpenDialog(null);
                if (result != JFileChooser.APPROVE_OPTION) {
                    System.out.println("No file selected. Exiting...");
                    break;
                }

                File pdfFile = fileChooser.getSelectedFile();
                String pdfFilePath = pdfFile.getAbsolutePath();

                try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
                    PDFTextStripper stripper = new PDFTextStripper();
                    String text = stripper.getText(document);
                    voice.speak(text);
                } catch (IOException e) {
                    System.out.println("Failed to read PDF file: " + pdfFilePath);
                    e.printStackTrace();
                }
            }

            voice.deallocate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
