package template.automation.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import template.automation.ui.constants.PageMenuNames;

public class FiatCarroSelecionadoPage {

    @FindBy(how = How.CSS, css = "a.Menu-asideAnchorLink")
    private ElementsCollection menuLatral;

    @FindBy(how = How.CSS, css = "div.contentRow button")
    private SelenideElement btnFechar;

    public void monteOSeu(){
        btnFechar.click();
        menuLatral.find(Condition.text(PageMenuNames.MENU_MONTE_O_SEU)).click();
    }

}
