package com.arc.tests;

import com.arc.pageobjects.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScenarioTest extends BaseTest{

    @Test
    public void scenario1() {
        Page page = new Page();
        page.login();
        page.clickShowOtherModules();
        page.clickFoldersAndFiles();
        page.clickPlusIcon();
        page.clickCreateNewFolder();
        page.enterFolderName("TestFolder");
        page.clickCreateButton();
        page.waitForPopUpClose();
        page.openFolder();
        page.clickPlusIcon();
        page.clickUploadFileOption();
        page.switchToChildWindow();
        page.clickSelectFilesBtn();
        page.uploadFile();
        page.clickUploadBtn();
        page.switchToDefaultWindow();
        Assert.assertTrue(page.getUploadedFile().isDisplayed());
    }

    @Test
    public void scenario2() {
        Page page = new Page();
        page.login();
        page.clickShowOtherModules();
        page.clickFoldersAndFiles();
        page.openFolder();
        page.openUploadedFile();
        page.switchToChildWindow();
        page.selectPinFromMenu();
        page.placePinOnFile();
        page.createPin();
        Assert.assertTrue(page.getCreatedPin().isDisplayed());
    }
}
