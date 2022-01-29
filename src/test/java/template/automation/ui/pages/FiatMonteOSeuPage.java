package template.automation.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import template.automation.ui.constants.PageMenuNames;

public class FiatMonteOSeuPage {

    @FindBy(how = How.CSS, css = "div.part-list-details h1")
    private ElementsCollection menuHorizontalInferior;

    @FindBy(how = How.CSS, css = "div.car-versions-vue div.part-list ul li h1")
    private ElementsCollection versoes;

    @FindBy(how = How.CSS, css = "div.car-options-vue div.part-list ul li h1")
    private ElementsCollection opcionais;

    @FindBy(how = How.CSS, css = "div.car-accessories-vue div.part-list ul li h1")
    private ElementsCollection acesorios;

    @FindBy(how = How.CSS, css = "button.add-item")
    private SelenideElement btnAdicionarItem;

    @FindBy(how = How.CSS, css = "a.negotiate")
    private SelenideElement btnVamosNegociar;

    @FindBy(how = How.CSS, css = "div.hub-info-bar__close-btn a")
    private SelenideElement btnFechar;

    @FindBy(how = How.CSS, css = "a.location-confirm")
    private SelenideElement btnContinuarLocalizacao;


    public void selecionarVersao(String versao) {
        btnFechar.click();
        btnContinuarLocalizacao.click();
        menuHorizontalInferior.find(Condition.text(PageMenuNames.MENU_MONTEOSEU_VERSAO_MOTOR_CAMBIO)).click();
        versoes.find(Condition.text(versao)).click();
    }

    public void adicionarOpcionais(String opcional) {
        menuHorizontalInferior.find(Condition.text(PageMenuNames.MENU_MONTEOSEU_OPCIONAIS)).click();
        opcionais.find(Condition.text(opcional)).click();
        btnAdicionarItem.click();
    }

    public void adicionarAcessorios(String acessorio) {
        menuHorizontalInferior.find(Condition.text(PageMenuNames.MENU_MONTEOSEU_ACESSORIOS)).click();
        acesorios.find(Condition.text(acessorio)).click();
        btnAdicionarItem.click();
    }

    public void negociar() {
        btnVamosNegociar.click();
    }

}
