public class Solution {
    public String addStrings(String num1, String num2) 
    {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        
        while (i1 >= 0 || i2 >= 0 || carry > 0) {
            int v1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int v2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            int sum = v1 + v2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i1--;
            i2--;
        }
        
        return result.reverse().toString();
    }
}