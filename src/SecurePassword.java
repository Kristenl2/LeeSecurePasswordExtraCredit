public class SecurePassword {
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password) {
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }


    public boolean isSecure() {
        if(isLongEnough()&&containsLowercase()&&containsUppercase()&&containsDigit()&&containsSpecialSymbol()){
            return true;
        }else{
            return false;
        }
    }


    public String status() {
        String status = "";
        if(isSecure()){
            status = "This password is secure";
        }else{
            if(!isLongEnough()){
                status += "The password must be at least 8 characters"+"\n";
            }
            if(!containsUppercase()){
                status += "The password must contain an uppercase letter"+"\n";
            }
            if(!containsLowercase()){
                status += "The password must contain a lowercase letter"+"\n";
            }
            if(!containsDigit()){
                status += "The password must contain a digit"+"\n";
            }
            if(!containsSpecialSymbol()){
                status += "The password must contain a special symbol: ! @ # $ % ^ & * ?"+"\n";
            }
        }
        return status;
    }


    private boolean isLongEnough() {
        if(password.length()>=8){
            return true;
        }else{
            return false;
        }
    }



    private boolean containsUppercase() {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }


    private boolean containsLowercase() {
        String lowerCaseLetters = "avcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }



    private boolean containsDigit() {
        String digits = "0123456789";
        return checkString(digits);
    }


    private boolean containsSpecialSymbol() {
        String symbols = "!@#$%^&*";
        return checkString(symbols);
    }


    private boolean checkString(String characterString) {
        int count = 0;
        for(int i = 0; i<password.length(); i++){
            for(int j = 0; j<characterString.length(); j++){
                if(password.substring(i,i+1).equals(characterString.substring(j,j+1))){
                    count++;
                }
            }
        }
        if (count>0){
            return true;
        }else{
            return false;
        }
    }
}