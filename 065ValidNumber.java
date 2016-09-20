/*
65. Valid Number

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
*/

// Valid: "3.e03" ".3e333" " 0." ".3" " +.0e-3"
// Not valide: " ." " e-3"
public boolean isNumber(String s) {
    if (s == null) {
        return false;
    }
    if (s.length()== 0) {
        return false;
    }
    // Eliminate space in the beginning
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != ' ') {
            s = s.substring(i, s.length());
            break;
        }
    }
    // Eliminate space in the end
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) != ' ') {
            s = s.substring(0, i+1);
            break;
        }
    }
    if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
        s = s.substring(1, s.length());
    }
    int eIndex = -1;
    boolean pointIndex = false;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'e') {
            eIndex = i;
            break;
        }
        if (s.charAt(i) == '.') {
            if (!pointIndex) {
                pointIndex = true;
                // "." is not valid
                if (!(i > 0 && s.charAt(i-1) - '0' >= 0 && s.charAt(i-1) - '0' <= 9 || i < s.length() - 1 && s.charAt(i+1) - '0' >= 0 && s.charAt(i+1) - '0' <= 9)) {
                    return false;
                }
            } 
            else {
                return false;
            }
            continue;
        }
        int num = s.charAt(i) - '0';
        if (num < 0 || num > 9) {
            return false;
        }
    }
    // if e occurs, must be followed by an int
    if (eIndex != -1) {
        if (eIndex == 0) {
            return false;
        }
        if (eIndex + 1 < s.length() && (s.charAt(eIndex + 1) == '+' || s.charAt(eIndex + 1) == '-') ) {
            eIndex++;
        }
        // If end with e, false
        if (eIndex == s.length() - 1) {
            return false;
        }
        for (int i = eIndex + 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num < 0 || num > 9) {
                return false;
            }
        }
    }
    return true;
}

/* Test case
" -3.e-3"
*/