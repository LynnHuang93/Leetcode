/*
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

// Backtracking
public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    List<String> path = new ArrayList<>();
    restoreIpHelper(result, s, path);
    return result;
}

public void restoreIpHelper(List<String> result, String s, List<String> path) {
    int sLen = s.length();
    if (sLen < 4 - path.size() || sLen > (4 - path.size()) * 3) {
        return;
    }
    if (path.size() == 4 && sLen == 0 ) {
        String ip = path.get(0) + "." + path.get(1) + "." + path.get(2) + "." + path.get(3);
        result.add(ip);
    }
    else {
        for (int i = 1; i < 4; i++) {
            if (i <= sLen) {
                String substring = s.substring(0, i);
                if (i !=3 || Integer.parseInt(substring) <= 255) {
                	// Take care of 0xx
                    if (i == 1 || substring.charAt(0) != '0') {
                        path.add(substring);
                        restoreIpHelper(result, s.substring(i, sLen), path);
                        path.remove(path.size() - 1);
                    }
                }
            }
            else {
                return;
            }
        }
    }
}

/* Test case
"010010"
*/