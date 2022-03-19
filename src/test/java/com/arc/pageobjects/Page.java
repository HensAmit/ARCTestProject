package com.arc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static com.arc.driver.DriverManager.driver;

public class Page extends BasePage{

    private final By username = By.id("UserID");
    private final By password = By.id("Password");
    private final By loginBtn = By.id("btnLogin");
    private final By showOtherModules = By.xpath("//span[contains(text(),'Show other modules')]");
    private final By foldersAndFiles = By.xpath("//h4[contains(text(),'Folders & files')]");
    private final By plusIcon = By.xpath("//mat-icon[contains(@class,'icon-plus')]");
    private final By createNewFolder = By.xpath("//*[contains(text(),'Create new folder')]");
    private final By folderNameTextbox = By.xpath("//input[contains(@formcontrolname,'newFolderName')]");
    private final By createButton = By.xpath("//span[text()='Create']");
    private final By successPopupCloseBtn = By.xpath("(//button[contains(@class,'mat-focus-indicator')])[9]");
    private final By folder = By.xpath("//span[text()='TestFolder']");
    private final By uploadFileOption = By.xpath("//span[text()='Upload files']");
    private final By selectFilesBtn = By.id("btnSelectFiles");
    private final By uploadBtn = By.id("multipartUploadBtn");
    private final String frameId = "myFrameSPA";
    private final By uploadedFile = By.xpath("//span[text()='atlassian-git-cheatsheet.pdf']");
    private static String parentWindowId = "";
    private final By pinIcon = By.xpath("//a[@data-original-title='Add pin']/i");
    private final By iconSearch = By.id("tagIconSearchInput");
    private final By iconCreateBtn = By.xpath("//button[text()='Create']");
    private final By iconCreatedOnFile = By.xpath("//div[contains(@class,'icon-air-compressor')]");

    public void login(){
        driver.findElement(By.id("UserID")).sendKeys("testautomation@yopmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        driver.switchTo().frame(frameId);
    }

    public void clickShowOtherModules(){
        wait.until(ExpectedConditions.presenceOfElementLocated(showOtherModules)).click();
    }

    public void clickFoldersAndFiles(){
        wait.until(ExpectedConditions.elementToBeClickable(foldersAndFiles)).click();
    }

    public void clickPlusIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(plusIcon)).click();
    }

    public void clickCreateNewFolder(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewFolder)).click();
    }

    public void enterFolderName(String folderName){
        wait.until(ExpectedConditions.elementToBeClickable(folderNameTextbox)).sendKeys(folderName);
    }

    public void clickCreateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void waitForPopUpClose(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successPopupCloseBtn));
    }

    public void openFolder(){
        Actions actions = new Actions(driver);
        actions.doubleClick(wait.until(ExpectedConditions.elementToBeClickable(folder))).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickUploadFileOption(){
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileOption)).click();
    }

    public void switchToChildWindow(){
        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        parentWindowId = itr.next();
        String child = itr.next();
        driver.switchTo().window(child);
    }

    public void clickSelectFilesBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(selectFilesBtn)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uploadFile(){
        try {
            Runtime.getRuntime().exec("C:\\Users\\hensi\\IdeaProjects\\ARCTest\\Files\\fileupload.exe");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not upload the file.");
        }
    }

    public void clickUploadBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(uploadBtn)).click();
    }

    public void switchToDefaultWindow(){
        driver.switchTo().window(parentWindowId);
        driver.switchTo().frame(frameId);
    }

    public WebElement getUploadedFile(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(uploadedFile));
    }

    public void openUploadedFile(){
        Actions actions = new Actions(driver);
        actions.doubleClick(wait.until(ExpectedConditions.elementToBeClickable(uploadedFile))).perform();
    }

    public void selectPinFromMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(pinIcon)).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void placePinOnFile(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@class,'leaflet-tile-loaded')][1]"))).click();
    }

    public void createPin(){
        wait.until(ExpectedConditions.elementToBeClickable(iconSearch)).sendKeys("Air");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Air Compressor']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(iconCreateBtn)).click();
    }

    public WebElement getCreatedPin(){
        return wait.until(ExpectedConditions.elementToBeClickable(iconCreatedOnFile));
    }
}
