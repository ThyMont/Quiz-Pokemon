package control;

public interface Pocketmonster {
	int contaPokemon();

	String exibirPokedex(Object selectedItem);

	String exibirTipo(String tipo);

	String pesquisar(String nomePokemon);

	String[] listarNomesENumeros();

	String[] listarNumerosPokemon();

	void excluir();

	void preencherDescricao(String numero);

	void preencherDescricao(String numero, String pokedex);

	void salvarEdicao(String numero, String nome, String classificacao, String altura, String peso, String tipo,
			String fraquezas, String resistencias, String descricao);

	void verificarCaminho(String caminho);

	void verificarStatus(String codigoPokemon);

}