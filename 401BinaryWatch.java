/*
401. Binary Watch

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/

public List<String> readBinaryWatch(int num) {
    List<String> result = new ArrayList<>();
    int[] bit = {512,256,128,64,32,16,8,4,2,1};
    List<Integer> time = new ArrayList<>();
    helper(time, 0, 0, num, bit);
    
    for (int t = 0; t < time.size(); t++) {
        int hour = time.get(t)>>6;
        if (hour >= 12) continue;
        String rs = String.valueOf(hour) + ":";
        int min = time.get(t)&63;
        if (min >= 60) continue;
        rs += min > 9 ? String.valueOf(min): "0" + String.valueOf(min);
        result.add(rs);
    }
    return result;
}

public void helper(List<Integer> list, int sum, int pos, int digitLeft, int[] num) {
    if (digitLeft == 0) {
        list.add(sum);
        return;
    }

    for (int i = pos; i < num.length; i++) {
        helper(list, sum + num[i], i+1, digitLeft - 1, num);
    }
}

/* Test case
4
*/