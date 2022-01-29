package template.automation.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.FormatString;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FiatResumoPropostaPage {

    @FindBy(how = How.CSS, css = "li.item-mvs span.price")
    private SelenideElement precoInicial;

    @FindBy(how = How.CSS, css = "li.item-color span.price")
    private SelenideElement precoCor;

    @FindBy(how = How.CSS, css = "li.item-optionals span.price")
    private SelenideElement precoOpcionais;

    @FindBy(how = How.CSS, css = "li.item-accessories span.price")
    private SelenideElement precoAcessorios;

    @FindBy(how = How.CSS, css = "div.payment-info strong")
    private SelenideElement pagamentoTotal;

    @FindBy(how = How.CSS, css = "div.section-accessory span.resume-text-big")
    private ElementsCollection acessorios;

    @FindBy(how = How.CSS, css = "div.section-optional span.resume-text-big")
    private ElementsCollection opcionais;

    public boolean valoresOk() throws ParseException {

        Double totalCalculado = doubleValue(precoInicial.getText())
                + doubleValue(precoCor.getText())
                + doubleValue(precoOpcionais.getText());

        return doubleValue(pagamentoTotal.getText()).equals(totalCalculado);
    }

    public boolean opcionaisOk(String opcional){
        return opcionais.find(Condition.text(opcional)) != null;
    }

    public boolean acessoriosOk(String acessorio){
        return acessorios.find(Condition.text(acessorio)) != null;
    }
    private Double doubleValue(String valueStr) throws ParseException {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());

        String value = valueStr
                .substring(2)
                .replace(".", "")
                .replace(" ", "")
                .replace("*", "");

        return numberFormat.parse(value).doubleValue();
    }
}
