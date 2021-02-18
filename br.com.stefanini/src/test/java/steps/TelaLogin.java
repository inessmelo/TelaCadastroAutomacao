package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import page.LoginPage;

public class TelaLogin {
	private WebDriver driver;
	private String url = "http://prova.stefanini-jgr.com.br/teste/qa/";
	private LoginPage page;

	@Rule
	public TestName nome = new TestName();
	
	@After
	public void finalizando() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File arquivo = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target\\file\\" + nome.getMethodName() + ".jpg"));
		
		driver.quit();
	}

	@Dado("que acesso o site")
	public void queAcessoOSite() {
		System.setProperty("webdriver.chome.driver", "target\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		page = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@Quando("clicar em Cadastrar")
	public void clicarEmCadastrar() {
		page.cadastrar();
	}

	@Entao("exibe as mensagens dos campos obrigatorios")
	public void exibeAsMensagensDosCamposObrigatorios() {
		assertEquals("O campo Nome é obrigatório.", page.nomeObrigatorio());
		assertEquals("O campo E-mail é obrigatório.", page.emailObrigatorio());
		assertEquals("O campo Senha é obrigatório.", page.senhaObrigatorio());
	}

	@Entao("exibe uma mensagem {string}")
	public void exibeUmaMensagem(String mensagem){
		assertEquals(mensagem, page.campoInvalido());
	}

	@Quando("preencher o campo nome com {string}")
	public void preencherOCampoNomeCom(String nome) {
		page.setNome(nome);
	}

	@Quando("preencher o campo email com {string}")
	public void preencherOCampoEmailCom(String email) {
		page.setEmail(email);
	}

	@Quando("preencher o campo senha com {string}")
	public void preencherOCampoSenhaCom(String senha) {
		page.setSenha(senha);
	}

	@Entao("o cadastro do usuario {string} e efetuado com sucesso")
	public void oCadastroDoUsuarioEEfetuadoComSucesso(String usuario) {
		assertEquals(usuario, page.cadastroEfetuado());
	}

	@Quando("clicar em excluir")
	public void clicarEmExcluir() {
		page.excluir();
	}

}
