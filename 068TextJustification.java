/*
68. Text Justification

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
*/


public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<String>();
    if (words == null || words.length == 0) {
        return result;
    }
    int startIndex = 0;
    int endIndex = 0;
    while (endIndex < words.length) {
        int wordsLenSum = words[endIndex].length();
        // Deal with OOB and adding one space between words
        while (endIndex + 1 < words.length && wordsLenSum + words[endIndex + 1].length() + 1 <= maxWidth) {
            wordsLenSum += 1 + words[++endIndex].length();
        }
        int interval = endIndex - startIndex;
        String line = words[startIndex];
        // If reach end or only one word a line. Careful with dividing 0
        if (interval == 0 || endIndex == words.length - 1) {
            for (int i = startIndex + 1; i <= endIndex; i++) {
                line += " " + words[i];
            }
            while (line.length() < maxWidth) {
                line += " ";
            }
        }
        // Deal with more spaces and less spaces intervals
        else {
            // Adding 1 because wordsLenSum has one space inside already
            int spaceEachInterval = (maxWidth - wordsLenSum) / interval + 1;
            int moreSpaceInterval = (maxWidth - wordsLenSum) % interval;
            for (int i = startIndex + 1; i <= endIndex; i++) {
                // More spaces
                if (i - startIndex <= moreSpaceInterval) {
                    for (int j = 0; j < spaceEachInterval + 1; j++) {
                        line += " ";
                    }
                }
                // Less spaces
                else {
                    for (int j = 0; j < spaceEachInterval; j++) {
                        line += " ";
                    }
                }
                line += words[i];
            }
        }
        result.add(line);
        // Next line
        startIndex = endIndex + 1;
        endIndex = startIndex;
    }
    return result;
}

/* Test case
[""]
0
["This", "is", "an", "example", "of", "text", "justification."]
16
*/