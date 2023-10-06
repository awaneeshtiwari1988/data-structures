package com.practice.data.structures.strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> formattedTextString = new ArrayList<>();
        int startIndex = 0;

        while(startIndex < words.length){
            int nextStartIndex = startIndex + 1;
            int lineLength = words[startIndex].length();

            while(nextStartIndex < words.length && lineLength + words[nextStartIndex].length() + 1 <= maxWidth){
                lineLength += words[nextStartIndex].length() + 1;
                nextStartIndex++;
            }

            StringBuilder lineBuilder = new StringBuilder();
            int numberOfWords = nextStartIndex - startIndex;

            if(nextStartIndex == words.length || numberOfWords == 1){
                for(int i = startIndex; i < nextStartIndex;i++){
                    lineBuilder.append(words[i]);
                    if(i < nextStartIndex - 1){
                        lineBuilder.append(' ');
                    }
                }

                while(lineBuilder.length() < maxWidth){
                    lineBuilder.append(' ');
                }
            } else {
                int totalSpaces = maxWidth - lineLength + 1;
                int spacesBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpacesToDistribute = totalSpaces % (numberOfWords - 1);

                for(int i = startIndex; i < nextStartIndex;i++){
                    lineBuilder.append(words[i]);
                    if(i < nextStartIndex - 1){
                        lineBuilder.append(" ".repeat(Math.max(0, spacesBetweenWords)));

                        if(i - startIndex < extraSpacesToDistribute){
                            lineBuilder.append(' ');
                        }
                    }
                }
            }

            formattedTextString.add(lineBuilder.toString());
            startIndex = nextStartIndex;
        }

        return formattedTextString;
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
