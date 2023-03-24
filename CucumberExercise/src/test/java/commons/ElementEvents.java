package commons;

import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepsDefinition.hooks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ElementEvents {
    WebDriver driver;//r = hooks.driver;
    WebDriverWait wait;// = new WebDriverWait(driver, 10);
    JavascriptExecutor js;

    public ElementEvents() {
        this.driver = hooks.driver;
    }

    //Locate the element
    public WebElement getElementByID(String id){
        return  driver.findElement(By.id(id));
    }

    public WebElement getElementByName(String name){
        return  driver.findElement(By.name(name));
    }

    public WebElement getElementByClassName(String classN){
        return  driver.findElement(By.className(classN));
    }

    public WebElement getElementByTagName(String tagName){
        return  driver.findElement(By.tagName(tagName));
    }

    public WebElement getElementByLinkText(String linkT){
        return  driver.findElement(By.linkText(linkT));
    }

    public WebElement getElementByPartialLinkText(String partialLT){
        return  driver.findElement(By.partialLinkText(partialLT));
    }

    public WebElement getElementByXpath(String xPath){
        if(wait == null) {
            wait = new WebDriverWait(driver, 15);
        }
        WebElement xpathElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));

        return  xpathElement;
    }

    public WebElement getElementByCSSselector(String cssSelector){
        return  driver.findElement(By.cssSelector(cssSelector));
    }
    //locate element section ends

    public void clickEvent(WebElement element){
        element.click();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public boolean elementIsSelected(WebElement element){
        return  element.isSelected();
    }

    public boolean elementIsDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public WebElement getElementsByXpath(String xPath){
        if(wait == null) {
            wait = new WebDriverWait(driver, 15);
        }
        WebElement xpathElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));

        return  xpathElement;
    }

    public void implicitWait(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void waitElemetIsVisible(WebElement element){
        if(wait == null) {
            wait = new WebDriverWait(driver, 50);
        }
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitElemetIsVisible(String element){
        if(wait == null) {
            wait = new WebDriverWait(driver, 20);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void waitElementisClickable(WebElement element){
        if(wait == null) {
            wait = new WebDriverWait(driver, 15);
        }
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void actionsClick(WebElement element){
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .build();
        seriesOfActions.perform();
    }

    public void actionsMoteToElement(WebElement element){
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(element)
                .build();
        seriesOfActions.perform();
    }

    public void actionSendTime(int x, int y, String value){
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .moveByOffset(x, y)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys(Keys.chord("a"))
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(value)
                .sendKeys(Keys.TAB)
                .build();
        seriesOfActions.perform();
    }

    public void actionsClearTxt(WebElement element){
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder
                .keyDown(Keys.CONTROL)
                .sendKeys(Keys.chord("a"))
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .build();
        seriesOfActions.perform();
    }

    public void sleeper(int seconds) throws InterruptedException {
        seconds *= 1000;
        Thread.sleep(seconds);
    }

    public void switchToFrameByNumber(int fName){
        driver.switchTo().frame(fName);
    }

    public void switchToFrameByXpath(String xpath){
        driver.switchTo().frame(xpath);
    }

    public void editTableRow(String editButton, String txtBox, String value) throws InterruptedException {
        WebElement txtB;
        clickEvent(getElementByXpath(editButton));
        sleeper(2);
        txtB = getElementByXpath(txtBox);
        actionsClearTxt(txtB);
        sleeper(1);
        txtB.sendKeys(value);
        sleeper(1);
        txtB.sendKeys(Keys.TAB);
        sleeper(1);
    }

    public void editTableRow(String editButton, String txtBox, String txtBox2, String date, String tme) throws InterruptedException {
        WebElement txtB;
        clickEvent(getElementByXpath(editButton));
        sleeper(2);
        txtB = getElementByXpath(txtBox);
        actionsClearTxt(txtB);
        sleeper(1);
        txtB.sendKeys(date);
        sleeper(1);
        txtB.sendKeys(Keys.TAB);

        //actionSendTime(270,94, tme);
        txtB = getElementByXpath(txtBox2);
        String size = txtB.getAttribute("value");
        for (int x = 0; x < size.length(); x++){
            txtB.sendKeys(Keys.BACK_SPACE);
        }
        sleeper(1);
        txtB.sendKeys(tme);
        sleeper(1);
        txtB.sendKeys(Keys.TAB);
        sleeper(1);
    }

    public String reportDateTime(){
        DateFormat datF = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");

        Date date = new Date();

        String rDate = datF.format(date);

        rDate = rDate.replace("/", "");
        rDate =rDate.replace(" ", "_");

        return  rDate.replace(":", "");
    }

}
