package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.UtilReuso;

public class LoginPage {
	
	private UtilReuso util;
		
	public LoginPage(WebDriver driver) {
		util = new UtilReuso(driver);
	}

	public void setNome (String nome) {
		util.escrever("name", nome);
	}
	
	public void setEmail(String email) {
		util.escrever("email", email);
	}
	
	public void setSenha(String senha) {
		util.escrever("password", senha);
	}
	
	public void cadastrar() {
		util.clicarBotao("register");
	}
	
	public void excluir() {
		util.clicarBotao("removeUser1");
	}
	
	public String nomeObrigatorio() {
		return util.valorTexto("//*[@id='name']/../p");
	}
	
	public String emailObrigatorio() {
		return util.valorTexto("//*[@id='email']/../p");
	}
	
	public String senhaObrigatorio() {
		return util.valorTexto("//*[@id='password']/../p");
	}
	
	public String campoInvalido() {
		return util.valorTexto(By.cssSelector("p[class]"));
	}
	
	public String cadastroEfetuado() {
		return util.valorTextoId("tdUserName1");
	}

}
