import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner scan = new Scanner(System.in);
        String fName = "";
        String lName = "";
        String password = "";
        String ccNum;
        String maskedNum;
        System.out.println("Enter your first name");
        fName = scan.nextLine();
        System.out.println("Enter your last name");
        lName = scan.nextLine();
        String username = generateUsername(fName, lName);
        System.out.println(username);
        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.println("Enter your password");
        password = scan.nextLine();
        boolean ifWorks = validatePassword(password);
        System.out.println(ifWorks);
        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if(ifWorks){
            System.out.println("Enter your credit card number");
            ccNum = scan.nextLine();
            maskedNum = maskCreditCard(ccNum);
            System.out.println(maskedNum);
        }
        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String fName, String lName) {
        String Username = "";
        if (fName.length() > 3) {
            Username += fName.substring(0, 3);
        } else {
            Username += fName;
        }
        if (lName.length() > 3) {
            Username += lName.substring(0, 3);
        }
        else {
            Username += lName;
        }
        return Username.toLowerCase();
    }

    public static boolean validatePassword(String password) {
        int works = 0;
        int firstCheck;
        if (password.length() < 8) {
            System.out.println("The password isn't long enough");
        } else {
            works++;
        }
        firstCheck = works;
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i + 1).equals(password.substring(i, i + 1).toUpperCase())) {
                works++;
            }
        }
        if (firstCheck == works) {
            System.out.println("The password must have a capital letter");
        }
        int secondCheck = works;
        for (int i = 0; i < password.length(); i++) {
            if (containsDigit(password.substring(i, i + 1)) == true) {
                works++;
            }
        }
        if (firstCheck == works) {
            System.out.println("The password must have a digit");
        }
        if (works >= 3){
            return true;
        }
        else{
            return false;
        }
    }

    public static String maskCreditCard(String ccNum) {
        int count = 0;
        String output = "";
        if (allDigits(ccNum)){
            count++;
        }
        else{
            System.out.println("Your credit card number can only have digits");
        }
        if (ccNum.length() == 16){
            count++;
        }
        else{
            System.out.println("Your credit card number has to be 16 characters long");
        }
        if (count == 2){
            for(int i = 1; i<17;i++){
                if (i<13 && i%4 == 0){
                    output += "* ";
                }
                else if( i<13){
                    output+= "*";
                }
                else{
                    output += ccNum.substring(i-1,i);
                }
            }
            return output;
        }
        return "N/A";
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
