VALIDATE CHECK DIGITS - NETBEANS JAVA PROJECT

HOW TO OPEN
1. Extract the ZIP file.
2. In Apache NetBeans, choose File > Open Project.
3. Select the extracted ValidateCheckDigits_NetBeans folder.
4. Right-click the project > Run (or press F6).

IMPORTANT: Keep account_numbers.txt in the project folder (next to build.xml).
The program reads it, checks every number and prints a VALID/INVALID result
and totals in the Output window.

VALIDATION RULE
Each account must consist of exactly six digits. Add the first five
individual digits, then calculate remainder = sum % 10. The account is
valid only when this remainder equals the sixth (last) digit.

Example: 223355 -> 2+2+3+3+5=15, 15%10=5, last digit=5: VALID.

TEST DATA
20 account numbers, each on its own line. 10 are valid and 10 invalid,
so that both successful and unsuccessful validations can be demonstrated.
