package commons;

public class pageObjects {

    //Developer Guide Elements
    public static String tabComponentRefer = "//a[@title='Component Reference']";
    public static String tabDeveloperGuide = "//*[@id='skip-target-nav-3']/div/componentreference-nav-item[2]/a";
    public static  String devGuideTitle = "//*[@id='topic-title']";

    //Component Reference page Objects
    public static String componentTitle = "//*[@id='skip-target-content']/div/componentreference-components/" +
            "componentreference-bundles/componentreference-component-filters/div[1]/h2";
    public static String txtQuickSearch = "//*[@placeholder='Quick Find']";
    public static String linkLightningWComp = "//a[@href = '/docs/component-library/bundle/lightning-datatable' and @role='presentation']";
    public static String lblDataTableComp = "//*[text()='Datatable']";
    public static  String ddlExample = "//input[@placeholder='Choose Example']";
    public static String btnPlayInBackground = "//button[text()= 'Open in Playground']";

    //playground
    public static String tblPreview = "//table[@role='grid']";
    public static String lblPreviewHeader = "//table[@role='grid']/thead/tr/th[1]/lightning-primitive-header-factory/div";
    public static String txtR3 = "//*[@class='slds-input']";
    public static String txtDate = "//lightning-datepicker[@class='slds-form-element']/div/div/input";
    public static String txtTime = "//lightning-timepicker[@class='slds-form-element']/div/lightning-base-combobox/div/div[1]/input";
    public static String btnEditR3 = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/th/lightning-primitive-cell-factory/span/button";
    public static String btnEditWebsiteR3 = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[3]/lightning-primitive-cell-factory/span/button";
    public static String btnPhone = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[4]/lightning-primitive-cell-factory/span/button";
    public static String btnDateTime = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[5]/lightning-primitive-cell-factory/span/button";
    public static String btnBalance = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[6]/lightning-primitive-cell-factory/span/button";

    public static String lblLabelText = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/th/lightning-primitive-cell-factory/span/div/lightning-base-formatted-text";
    public static String lblWebsite = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[3]/lightning-primitive-cell-factory/span/div/lightning-formatted-url/a";
    public static String lblPhoneText = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[4]/lightning-primitive-cell-factory/span/div/lightning-formatted-phone/a";
    public static String lblDateText = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[5]/lightning-primitive-cell-factory/span/div/lightning-formatted-date-time";
    public static String lblBalanceText = "//tbody[@style='counter-reset: row-number 0;']/tr[3]/td[6]/lightning-primitive-cell-factory/span/div/lightning-formatted-number";





}
