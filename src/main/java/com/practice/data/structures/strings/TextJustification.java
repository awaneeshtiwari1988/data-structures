package com.practice.data.structures.strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int nextStartIndex = startIndex;
            int currentLineLength = 0;

            // Find the words to include in the current line
            while (nextStartIndex < words.length && currentLineLength + words[nextStartIndex].length() + nextStartIndex - startIndex <= maxWidth) {
                currentLineLength += words[nextStartIndex].length();
                nextStartIndex++;
            }

            int spacesCount = maxWidth - currentLineLength;
            int wordsCount = nextStartIndex - startIndex;

            // Initialize the line with the first word
            StringBuilder line = new StringBuilder(words[startIndex]);

            // If it's the last line or only one word in the line, left-justify
            if (nextStartIndex == words.length || wordsCount == 1) {
                for (int i = startIndex + 1; i < nextStartIndex; i++) {
                    line.append(' ');
                    line.append(words[i]);
                }
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } else {
                // Distribute spaces evenly between words
                int spacesBetweenWords = spacesCount / (wordsCount - 1);
                int extraSpaces = spacesCount % (wordsCount - 1);

                for (int i = startIndex + 1; i < nextStartIndex; i++) {
                    for (int j = 0; j < spacesBetweenWords; j++) {
                        line.append(' ');
                    }
                    if (extraSpaces > 0) {
                        line.append(' ');
                        extraSpaces--;
                    }
                    line.append(words[i]);
                }
            }

            result.add(line.toString());
            startIndex = nextStartIndex;
        }

        return result;
    }


    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        String[] words = {
                "This", "is", "an", "example", "of", "text", "justification."
        };
        int maxWidth = 16;

        List<String> formattedText = solution.fullJustify(words, maxWidth);
        for (String line : formattedText) {
            System.out.println(line);
        }
    }
}
