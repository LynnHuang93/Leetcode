/*
282. Expression Add Operators

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/


public class Solution {  
    public List<String> addOperators(String num, int target) {  
        List<String> results = new ArrayList<>();  
        opRecur(num, target, 0, 0, "", results);  
        return results;  
    }  

    //1. 有可能string很长，所以要用长整数。
    //2.需要记录last oprand，为的是处理乘号的情况。乘号时的计算公式为: result - lastOP + lastOP * curVaule，如 2 + 3 * 5, 当计算到要乘5时，result = 2 + 3 = 5, lastOp = 3, curValue = 5, 则最终结果为： 5 - 3 + 3 * 5 = 17 = 2 + 3 * 5。
    private void opRecur(String num, int target, long lastOp, long result, String expression, List<String> results) {  
        if(num.length() == 0) {  
            if(target == result)  
                results.add(expression);  
            return;  
        }
        //5. 按左操作数从长度为1 到长度为len(num)循环， 并递归。
        for(int i = 1; i <= num.length(); i++) {  
            String cur = num.substring(0, i);  
            //4. 需要跳过长于一个零的操作数，如“00”， “000”， etc.
            if(cur.length() > 1 && cur.charAt(0) == '0')  
                continue;
            //3. 记录当前结果，用于在num长度为零时， 判断是否与target相等，并加入最终的results中。
            String rest = num.substring(i);  
            long curV = Long.parseLong(cur);  
            if(expression.length() == 0) {  
                opRecur(rest, target, curV, curV, expression + cur, results);  
            } else {  
                opRecur(rest, target, curV, result + curV, expression + "+" + cur, results);  
                opRecur(rest, target, -curV, result - curV, expression + "-" + cur, results);  
                opRecur(rest, target, curV * lastOp, result - lastOp + lastOp * curV, expression + "*" + cur, results);  
            }  
        }  
    }  
}