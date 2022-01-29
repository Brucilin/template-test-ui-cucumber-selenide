package template.automation.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FiatHomePage {

    @FindBy(how = How.CSS, css = "ul li.mobile-hidden div.menu-microsites-component div.microsites-menu div.menu-activator a.menu-icon--mobile")
    private SelenideElement menu;

    @FindBy(how = How.CSS, css = "ul li.mobile-hidden div.menu-microsites-component div.microsites-menu div.menu-wrapper div.menu-content ul li div.menu-item")
    private ElementsCollection subMenuComVariasOpcoes;

    @FindBy(how = How.CSS, css = "div.sub-menu-content ul li a.sub-menu-item")
    private ElementsCollection listaCarros;

    public void escolherCarro(String carro){

        menu.click();
        subMenuComVariasOpcoes.first().click();
        listaCarros.find(Condition.text(carro)).click();
    }

}
