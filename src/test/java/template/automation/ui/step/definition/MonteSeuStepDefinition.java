package template.automation.ui.step.definition;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import template.automation.ui.pages.FiatCarroSelecionadoPage;
import template.automation.ui.pages.FiatHomePage;
import template.automation.ui.pages.FiatMonteOSeuPage;
import template.automation.ui.pages.FiatResumoPropostaPage;

import java.text.ParseException;
import java.util.ArrayList;


public class MonteSeuStepDefinition {

    @Before
    public void setUp() {
        Configuration.baseUrl = "https://www.fiat.com.br";
        Configuration.browser = "chrome";
    }

    @Dado("que eu esteja na tela inicial da FIAT")
    public void acessarSiteFiat() {
        Selenide.open("");
    }

    @Quando("selecionar o carro {string} que desejo realizar a proposta")
    public void selecionarOCarroArgoQueDesejoRealizarAProposta(String carro) {
        Selenide.page(FiatHomePage.class).escolherCarro(carro);
    }

    @E("acessar o opção de Monte o Seu carro")
    public void acessarOOpçãoDeMonteOSeuCarro() {
        Selenide.page(FiatCarroSelecionadoPage.class).monteOSeu();
        System.out.println("");

        ArrayList<String> tabs = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(1);
    }

    @E("escolher a versão {string}, opcional {string}, acessório {string} e selecionar vamos negociar")
    public void escolherAVersãoOpicionaisAcessóriosESelecionarVamosNegociar(String versao, String opcionais, String acessorio) {

        FiatMonteOSeuPage fiatMonteOSeuPage = Selenide.page(FiatMonteOSeuPage.class);
        fiatMonteOSeuPage.selecionarVersao(versao);
        fiatMonteOSeuPage.adicionarOpcionais(opcionais);
        fiatMonteOSeuPage.adicionarAcessorios(acessorio);
        fiatMonteOSeuPage.negociar();
    }

    @Entao("deve ser exibida a tela de Resumo da Proposta com opcional {string} e acessório {string} escolhido")
    public void deveSerExibidaATelaDeResumoDaPropostaComOpcionalEAcessórioEscolhido(String opcional, String acessorio) throws ParseException {
        
        FiatResumoPropostaPage fiatResumoPropostaPage = Selenide.page(FiatResumoPropostaPage.class);
        Assert.assertTrue(fiatResumoPropostaPage.valoresOk());
        Assert.assertTrue(fiatResumoPropostaPage.opcionaisOk(opcional));
        Assert.assertTrue(fiatResumoPropostaPage.acessoriosOk(acessorio));
    }

    @After
    public void cleanUp(){
        WebDriverRunner.getWebDriver().close();
    }
}
