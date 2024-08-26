class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
         List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            // Check if adding the next word would exceed the maxWidth
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                // Justify the current line
                result.add(justify(currentLine, currentLength, maxWidth));
                currentLine.clear();
                currentLength = 0;
            }
            // Add word to the current line
            currentLine.add(word);
            currentLength += word.length();
        }

        // Handle the last line
        result.add(leftJustify(currentLine, maxWidth));
        return result;
    }

    private String justify(List<String> line, int currentLength, int maxWidth) {
        int spacesToDistribute = maxWidth - currentLength;
        int gaps = line.size() - 1;

        if (gaps == 0) {
            // If there's only one word, left-justify it
            return leftJustify(line, maxWidth);
        }

        int spaces = spacesToDistribute / gaps;
        int extraSpaces = spacesToDistribute % gaps;

        StringBuilder justifiedLine = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            justifiedLine.append(line.get(i));
            if (i < gaps) {
                for (int j = 0; j < spaces + (i < extraSpaces ? 1 : 0); j++) {
                    justifiedLine.append(" ");
                }
            }
        }
        return justifiedLine.toString();
    }

    private String leftJustify(List<String> line, int maxWidth) {
        StringBuilder justifiedLine = new StringBuilder(String.join(" ", line));
        while (justifiedLine.length() < maxWidth) {
            justifiedLine.append(" ");
        }
        return justifiedLine.toString();
    }
}
