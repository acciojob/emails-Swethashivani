package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(this.getPassword().equals(oldPassword)){
          if(newPassword.length()>=8 && checkUppercase(newPassword) && checkLowercase(newPassword) && checkDigit(newPassword) && checkSpecialCharacter(newPassword)){
              this.password=newPassword;
          }
        }
    }
    private boolean checkUppercase(String password){
        for(int i=0; i<password.length(); i++){
            if((int)password.charAt(i) >=65 && (int)password.charAt(i) <=90)
                return true;
        }
        return false;
    }
    private boolean checkLowercase(String password){
        for(int i=0; i<password.length(); i++){
            if((int)password.charAt(i) >=97 && (int)password.charAt(i) <=122)
                return true;
        }
        return false;
    }
    private boolean checkDigit(String password){
        for(int i=0; i<password.length(); i++){
            if((int)password.charAt(i) >=48 && (int)password.charAt(i) <=57)
                return true;
        }
        return false;
    }
    private boolean checkSpecialCharacter(String password){
        for(int i=0; i<password.length(); i++){
            if(((int)password.charAt(i) >=32 && (int)password.charAt(i) <=47) || ((int)password.charAt(i) >=58 && (int)password.charAt(i) <=64) || ((int)password.charAt(i) >=91 && (int)password.charAt(i) <=96) || ((int)password.charAt(i) >=123 && (int)password.charAt(i) <=126))
                return true;
        }
        return false;
    }
}
