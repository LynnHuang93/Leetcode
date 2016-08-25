/*
5. Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. You may assume that the
maximum length of S is 1000, and there exists one unique longest palindromic substring.

*/

// Consider loop all the chars once. Take each as the middle char and try to grow on
// both sides. Divide into odd and even conditions. O(n^2)
public static String longestPalindrome(String s) {
  	int start = 0;
  	int end = 0;
  	int max = 0;
  	int length = s.length();
  	for (int i = 0; i < length; i++) {
        // Odd number
      	int count = 0;
      	for (int j = 0; (i - j >= 0) && (i + j < length); j++) {
          	if (s.charAt(i-j)==(s.charAt(i+j))) {
          		count = j * 2 + 1;
              	if (count > max) {
                  	start = i - j;
                    // substring does not include end;
                  	end = i + j + 1;
                    max = count;
              	}
          	}
          	else {
            	break;
          	}
        }
        // Even number
        for (int j = 0; (i - j >= 0) && (i + j + 1 < length); j++) {
          	if (s.charAt(i-j)==(s.charAt(i+j+1))) {
              	count = (j + 1) * 2;
              	if (count > max) {
                  	start = i - j;
                  	end = i + j + 2;
                    max = count;
              	}
          	}
          	else {
             	break; 
            }
        }
    }
    return s.substring(start, end);
}

// Manacher's Algorithm
public static String longestPalindrome(String s) {
    String news = "$#";
    int length = s.length();
    int[] count = new int[2 * length + 2];
    //'abccdccbc' -> '$#a#b#c#c#d#c#c#b#c#'
    // count-1=length  1212123218123214121
    // Turn all strings into odd
    for (int i = 0; i < length; i++) {
      	news = news + s.charAt(i) + "#";
    }
    int id = 0;
    int mx = 0;
    //  mx'      j   id   i      mx
    //       j = 2id - i       the most left side of palindromic string
    // If i > mx : count[i] = 1, then continue count.
    // If mx - i > count[j] : substring mid j/i in string mid id, count[i] = count[j].
    // If mx - i <=count[j] : substring mid i is at least count[j] long. Count from count[j].
    for (int i = 1; i < count.length; i++) {
    	count[i] = mx >= i ? Math.min(count[2 * id - i], mx - i) : 1 ;
      	while (i + count[i] < count.length && news.charAt(i - count[i]) == news.charAt(i + count[i])) {
          	count[i]++;
      	}
        if (i + count[i] > mx) {
          	mx = i + count[i];
          	id = i;
        }
  	}
    int index = 0;
    int max = 0;
    for (int i = 1; i < count.length; i++){
    	if (max < count[i]){
    		max = count[i];
    		index = i;
    	}
    }
  	return news.substring(index - max + 1, index + max).replace("#","");
}