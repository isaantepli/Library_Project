package com.library.pages;

import com.library.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
        @FindBy (id = "inputEmail")
        private WebElement usernameInput;

        @FindBy (id = "inputPassword")
        private WebElement passwordInput;

        @FindBy (className = "btn btn-lg btn-primary btn-block")
        private WebElement signInBtn;

        public void login(String role){
            String librarianEmail = ConfigurationReader.getProperty("librarianEmail");
            String librarianPassword = ConfigurationReader.getProperty("librarianPassword");

            String libraryStudentEmail = ConfigurationReader.getProperty("libraryStudentEmail");
            String libraryStudentPasswrod = ConfigurationReader.getProperty("libraryStudentPassword");

            if (role.equalsIgnoreCase("librarian")){
                usernameInput.sendKeys(librarianEmail);
                passwordInput.sendKeys(librarianPassword+ Keys.ENTER);
            } else if(role.equalsIgnoreCase("student")){
                usernameInput.sendKeys(libraryStudentEmail);
                passwordInput.sendKeys(libraryStudentPasswrod+Keys.ENTER);
            } else {
                System.out.println("No such role! Please Verify!");
            }
        }

}
