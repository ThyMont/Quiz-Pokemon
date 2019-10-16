package control;

import java.util.Random;

public class Quiz {
	private String pokePergunta;
	private String pokeResposta;
	private String opcaoA = null, opcaoB = null, opcaoC = null, opcaoD = null;

	public String[] getTipos() {
		return getTipos();
	}

	public String getPokePergunta() {
		return pokePergunta;
	}

	public String getPokeResposta() {
		return pokeResposta;
	}

	public String getOpcaoA() {
		return opcaoA;
	}

	public String getOpcaoB() {
		return opcaoB;
	}

	public String getOpcaoC() {
		return opcaoC;
	}

	public String getOpcaoD() {
		return opcaoD;
	}

	public void dadosPergunta(String numero) {
		pokePergunta = numero;
		Pokemon pokemon = new Pokemon();
		pokemon.preencherDescricao(numero);
		pokeResposta = pokemon.getNome();
	}

	public Quiz(String numero) {
		pokePergunta = numero;
		Pokemon pokemon = new Pokemon(numero);
		pokeResposta = pokemon.getNome();
		preencherQuiz(numero);
		
		

	}

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public int sortearPokemonGenI() {
		Random r = new Random();
		int j = r.nextInt(new Pokemon().contaPokemon());

		return j;

	}

	public void preencherQuiz(String numero) {
		Random r = new Random();
		int i = r.nextInt(4);

		switch (i) {
		case 0: {
			opcaoA = preencherOpcaoCorreta(numero);
			opcaoB = preencherOpcaoErrada(numero);
			do {
				opcaoC = preencherOpcaoErrada(numero);
			} while (opcaoC.equals(opcaoB));
			do {
				opcaoD = preencherOpcaoErrada(numero);
			} while (opcaoD.equals(opcaoB) || opcaoD.equals(opcaoC));
			break;
		}
		case 1: {
			opcaoB = preencherOpcaoCorreta(numero);
			opcaoA = preencherOpcaoErrada(numero);
			do {
				opcaoC = preencherOpcaoErrada(numero);
			} while (opcaoC.equals(opcaoA));
			do {
				opcaoD = preencherOpcaoErrada(numero);
			} while (opcaoD.equals(opcaoA) || opcaoD.equals(opcaoC));
			break;
		}
		case 2: {
			opcaoC = preencherOpcaoCorreta(numero);
			opcaoA = preencherOpcaoErrada(numero);
			do {
				opcaoB = preencherOpcaoErrada(numero);
			} while (opcaoB.equals(opcaoA));
			do {
				opcaoD = preencherOpcaoErrada(numero);
			} while (opcaoD.equals(opcaoA) || opcaoD.equals(opcaoB));
			break;
		}
		case 3: {
			opcaoD = preencherOpcaoCorreta(numero);
			opcaoA = preencherOpcaoErrada(numero);
			do {
				opcaoB = preencherOpcaoErrada(numero);
			} while (opcaoB.equals(opcaoA));
			do {
				opcaoC = preencherOpcaoErrada(numero);
			} while (opcaoC.equals(opcaoA) || opcaoC.equals(opcaoB));
			break;
		}
		}
	}

	private String preencherOpcaoErrada(String numeroPergunta) {
		String[] quizGenI = new Pokemon().listarNumerosPokemon();
		Random r = new Random();
		String opcao;
		int i;
		do {
			i = r.nextInt(new Pokemon().contaPokemon());
			String numero = quizGenI[i];
			Pokemon pokemon = new Pokemon();
			pokemon.preencherDescricao(numero);
			opcao = pokemon.getNome();
		} while (quizGenI[i].equals(this.pokePergunta));

		return opcao;
	}

	private String preencherOpcaoCorreta(String numeroPergunta) {
		String opcao;
		Pokemon pokemon = new Pokemon();
		pokemon.preencherDescricao(numeroPergunta);
		opcao = pokemon.getNome();

		return opcao;
	}

	public boolean verificarResposta(String respostaUsuario) {
		if (respostaUsuario.equals(pokeResposta)) {
			return true;
		} else {
			return false;
		}
	}
}
