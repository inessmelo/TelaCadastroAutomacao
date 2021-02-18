#language:pt

@testeLogin
Funcionalidade:
Eu como usuario do sistema.
Desejo realizar o cadastro de novos usuarios.
Para que seja possivel armazenar e gerenciar seus dados.

	@campoObrig
	Cenario: Validar campos obrigatorios
		Dado que acesso o site
		Quando clicar em Cadastrar
		Entao exibe as mensagens dos campos obrigatorios

	@dadosInvalido
	Esquema do Cenario: Inserir dados invalidos
		Dado que acesso o site
		Quando preencher o campo nome com "<nome>"
		E preencher o campo email com "<email>"
		E preencher o campo senha com "<senha>"
		E clicar em Cadastrar
		Entao exibe uma mensagem "<msg>"
		
		Exemplos:
		| nome       | email           | senha    | msg 													             |
		| Maria      | maria@teste.com | 12345678 | Por favor, insira um nome completo.		     |
		| Maria Joao | maria teste.com | 12345678 | Por favor, insira um e-mail válido. 			 |
		| Maria Joao | maria@teste.com | 123456   | A senha deve conter ao menos 8 caracteres. |

		
	@cadSucesso
	Esquema do Cenario: Cadastrar com sucesso
		Dado que acesso o site
		Quando preencher o campo nome com "<nome>"
		E preencher o campo email com "<email>"
		E preencher o campo senha com "<senha>"
		E clicar em Cadastrar
		Entao o cadastro do usuario "<user>" e efetuado com sucesso
		
		Exemplos:
		|   nome 			|   email	 		    | senha	   | user				 |
		| Ines Melo  	| ines@teste.com 	| 12345678 | Ines Melo	 |
		| Joao Carlos | joao@teste.com  | 12345678 | Joao Carlos |