package com.driver;

import java.util.Objects;

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
        if(Objects.equals(this.getPassword(), oldPassword)){
            if(checkPasswordStrength(newPassword)){
                this.password=newPassword;
            }
        }
    }

    private boolean checkPasswordStrength(String newPassword) {
        int n=newPassword.length();
        int upper=0;
        int lower=0;
        int digit=0;
        int special=0;
        for(int i=0;i<n;i++){

            if(newPassword.charAt(i)-'a'>=0&&newPassword.charAt(i)-'a'<=25){
                lower++;
            }
            else if(newPassword.charAt(i)-'A'>=0&&newPassword.charAt(i)-'A'<=25){
                upper++;
            }
            else if(newPassword.charAt(i)-'0'>=0&&newPassword.charAt(i)-'0'<=9){
                digit++;
            }
            else{
                special++;
            }
        }
        if(newPassword.length()>=8&&lower>=1&&upper>=1&&digit>=1&&special>=1){
            return true;
        }
        return false;
    }
}
