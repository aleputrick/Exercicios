package AtividadeAV2;

public class BuscaCep {

	public static void main(String[] args) {
		WebServiceCep webServiceCep = WebServiceCep.searchCep("82640220");
		if(webServiceCep.wasSuccessful()) {
			System.out.println("Rua: " + webServiceCep.getLogradouro());
			System.out.println("Bairro: " + webServiceCep.getBairro());
			System.out.println("Cidade: " + webServiceCep.getCidade());
			System.out.println("UF: " + webServiceCep.getUf());
		}
		else {
			System.out.println("Cep inválido!");
		}
	}
}
