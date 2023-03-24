package stepsDefinition;

import Helpers.constants;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import commons.ElementEvents;
import commons.pageObjects;
import io.cucumber.java.en.*;
import org.bson.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.json.Json;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;


public class editUpdateUser {
     WebDriver driver = hooks.driver;
    ElementEvents eL = new ElementEvents();
    pageObjects pO = new pageObjects();
    WebElement element;
    constants con = new constants();
    ExtentTest scenarioDef;
    public MongoClient mongoClient;
    public MongoDatabase database;
    ArrayList<String> colName = new ArrayList<>();
    ArrayList<Document> dbs = new ArrayList<>();
    ArrayList<String> dbName = new ArrayList<>();
    private String Database;
    public List<Document> collections = new ArrayList<>();
    public MongoCollection<Document> col;
    ArrayList<String> rows = new ArrayList<>();


    public editUpdateUser(){
        this.scenarioDef = hooks.scenarioDef;
    }

    @Given("open browser in Developer Guide")
    public void openBrowserInDeveloperGuide() throws InterruptedException, ClassNotFoundException {
        //use element variable to store the web element
        element = eL.getElementByXpath(pO.devGuideTitle);
        //call the method isDisplayed to verify if it's true or false
        boolean pageSelected = eL.elementIsDisplayed(element);
        //validate if element is displayed
        Assert.assertTrue(pageSelected);
        eL.sleeper(1);

        scenarioDef.createNode(new GherkinKeyword("Given"), "open browser in Developer Guide");
    }

    @And("user Clicks on Component Reference tab")
    public void userClicksOnComponentReferenceTab() throws InterruptedException, ClassNotFoundException {
        scenarioDef.createNode(new GherkinKeyword("And"), "user Clicks on Component Reference tab");

        //Locate the element
        element = eL.getElementByXpath(pO.tabComponentRefer);

        //click the element using actions
        eL.actionsClick(element);

        //wait for 3 seconds
        eL.sleeper(3);

        //clear element variable
        element = null;
        //set new element by xpath
        element = eL.getElementByXpath(pO.componentTitle);

        //validate if the element is displayed
        boolean componentPage = eL.elementIsDisplayed(element);
        Assert.assertTrue(componentPage);

        element = null;
    }

    @And("search in Quick Find for {string}")
    public void searchInQuickFindFor(String value) throws InterruptedException, ClassNotFoundException {
        scenarioDef.createNode(new GherkinKeyword("And"), "search in Quick Find for");

        element = eL.getElementByXpath(pO.txtQuickSearch);
        element.sendKeys("datatable");

        element = eL.getElementByXpath(pO.linkLightningWComp);
        eL.actionsClick(element);
        eL.sleeper(3);

        element = eL.getElementByXpath(pO.lblDataTableComp);
        String lblDataTableComp = eL.getText(element);
        Assert.assertEquals("Datatable", lblDataTableComp, "Text is not equal, expecting Datatable");
        element=null;
    }

    @And("click on {string} option in ddl")
    public void clickOnOptionInDdl(String value) throws InterruptedException, ClassNotFoundException {
        scenarioDef.createNode(new GherkinKeyword("And"), "click on option in ddl");

        element = eL.getElementsByXpath(pO.ddlExample);
        for(int x = 1; x <= 4; x++){
            element.sendKeys(Keys.DOWN);
        }
        element.sendKeys(Keys.ENTER);
        eL.sleeper(3);
        eL.actionsMoteToElement(element);
        eL.sleeper(2);
    }

    @And("click on Open in Playground button")
    public void clickOnOpenInPlaygroundButton() throws ClassNotFoundException {
        scenarioDef.createNode(new GherkinKeyword("And"), "click on Open in Playground button");

        eL.getElementByXpath(pO.btnPlayInBackground).click();
    }

    @When("third row information is updated")
    public void thirdRowInformationIsUpdated() throws InterruptedException, ClassNotFoundException {
        scenarioDef.createNode(new GherkinKeyword("When"), "third row information is updated");

        eL.sleeper(20);
        eL.switchToFrameByNumber(0);
        //element = eL.getElementByXpath(pO.iFrame);
        eL.switchToFrameByNumber(1);
        element = eL.getElementByXpath(pO.tblPreview);
        Assert.assertTrue(eL.elementIsDisplayed(element));

        //edit Name
        eL.editTableRow(pO.btnEditR3, pO.txtR3, con.Name);

        //edit website
        eL.editTableRow(pO.btnEditWebsiteR3, pO.txtR3, con.Website);

        //edit Phone
        eL.editTableRow(pO.btnPhone, pO.txtR3, con.Phone);

        //edit DateTime
        eL.editTableRow(pO.btnDateTime, pO.txtDate, pO.txtTime, con.Date, con.Time);

        //edit Balance
        eL.editTableRow(pO.btnBalance, pO.txtR3, con.Balance);

    }

    @Then("verify that information has been saved correctly")
    public void verifyThatInformationHasBeenSavedCorrectly() throws ClassNotFoundException {
        scenarioDef.createNode(new GherkinKeyword("And"), "verify that information has been saved correctly");

        Assert.assertEquals(eL.getElementByXpath(pO.lblLabelText).getText(), con.Name);
        Assert.assertTrue(con.Website.equals(eL.getElementByXpath(pO.lblWebsite).getText()));
        Assert.assertEquals(eL.getElementByXpath(pO.lblPhoneText).getText(), con.Phone);
        Assert.assertEquals(eL.getElementByXpath(pO.lblDateText).getText(), con.Date);
        Assert.assertEquals(eL.getElementByXpath(pO.lblBalanceText).getText(), "$" + con.Balance);
    }

    @Given("conectar con mongo db")
    public void conectarConMongoDb() {

        try{
            mongoClient = new MongoClient("localhost", 27017);
            if(mongoClient != null){
                scenarioDef.createNode(new GherkinKeyword("Given"), "conectado correctamente");
            }else{
                System.out.println("Fallo coneccion");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @When("seleccione la base de datos")
    public void seleccioneLaBaseDeDatosDb() {
        try{
            dbs = mongoClient.listDatabases().into(new ArrayList<>());
            for(int i = 0; i < dbs.size(); i ++){
                dbName.add(dbs.get(i).get("name").toString());
            }
            System.out.println("Las bases de datos existentes son: " + dbName);
            Database = dbs.get(10).get("name").toString();
            database = mongoClient.getDatabase(Database);
            collections = database.listCollections().into(new ArrayList<>());

            for (int i = 0; i <collections.size(); i++){
                colName.add(collections.get(i).get("name").toString());
            }

            if(!colName.isEmpty()){
                scenarioDef.createNode(new GherkinKeyword("When"), "base de datos seleccionada" + Database);
            }else{
                System.out.println("No collections obtained");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("imprimir la coleccion que tiene")
    public void imprimirLaColeccionQueTiene() {
        try{
            System.out.println("La base de datos seleccionada es: " + Database);
            System.out.println("las colecciones son: " + colName);
            scenarioDef.createNode(new GherkinKeyword("Then"), "La(s) coleccion(es) que tiene: " + colName );
        }catch (Exception e){
            System.out.println(e);
        }
        mongoClient.close();
        Database = "";

    }

    @When("se elige la base de datos {string}")
    public void seEligeLaBaseDeDatos(String arg0) {
        try{
            database = mongoClient.getDatabase(arg0);
            if(database != null){
                collections = database.listCollections().into(new ArrayList<>());

                for (int i = 0; i <collections.size(); i++){
                    colName.add(collections.get(i).get("name").toString());
                }
                System.out.println("La base de datos contine: " + colName);
                scenarioDef.createNode(new GherkinKeyword("When"), "La base es " + arg0);
            }else{
                System.out.println("No database found");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("Imprimir el resultado")
    public void imprimirElResultado() {
        try{
            for(int x = 0; x < collections.size(); x ++){
                col = database.getCollection(collections.get(x).get("name").toString());

                col.find().limit(1).forEach((Consumer<Document>) (Document d) -> {
                    //System.out.println("Los registros son: " + d.toJson());
                    rows.add(d.toJson());
                });
                System.out.println("Los registros de " + collections.get(x).get("name").toString()
                        + " son: " + rows);
                scenarioDef.createNode(new GherkinKeyword("Then"), "Registro(s) de " + collections.get(x).get("name").toString()
                + "\n" + " son: " + rows);

                rows.clear();
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
