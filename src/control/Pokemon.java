package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pokemon implements Pocketmonster {
	private String pokedex = "";
	private String nome = "", classificacao = "", descricao = "", altura = "", peso = "", numero = "";
	private String caminhoPokedados = new File("").getAbsolutePath() + "\\src\\dados\\Pokedados.txt";
	private String[] fraquezas = new String[] { "" }, resistencias = new String[] { "" }, tipo = new String[] { "" };
	private boolean pokeVisto = false;
	
	public int contaPokemon() {
		int i = 0;
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));

			while (leitor.ready()) {
				leitor.readLine();
				i++;
			}
			;
		} catch (Exception e) {
		}
		return i;
	}

	public String[] listarNumerosPokemon() {
		BufferedReader leitor;
		int i = contaPokemon();

		String[] lista = new String[i];

		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			String linha;
			i = 0;
			while (leitor.ready()) {
				linha = leitor.readLine();
				String[] pokemon = linha.split(":");
				String numeroPokemon = pokemon[0];
				lista[i] = numeroPokemon;
				i++;
			}
			;
		} catch (Exception e) {
		}
		return lista;

	}

	public String[] listarNomesENumeros() {
		BufferedReader leitor;
		int i = contaPokemon();

		String[] lista = new String[i];

		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			String linha;
			i = 0;
			while (leitor.ready()) {
				linha = leitor.readLine();
				String[] pokemon = linha.split(":");
				String numeroPokemon = pokemon[0];
				String nomePokemon = pokemon[1];
				lista[i] = numeroPokemon + " - " + nomePokemon;
				i++;
			}
			;
		} catch (Exception e) {
		}
		return lista;

	}

	public boolean isVisto() {
		return pokeVisto;
	}

	public String getCaminhoPokedados() {
		return caminhoPokedados;
	}

	public void setVisto(boolean visto) {
		this.pokeVisto = visto;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	private static String[] todosTipos = { "AGUA", "DRAGAO", "ELETRICO", "FADA", "FANTASMA", "FOGO", "GELO", "GRAMA",
			"INSETO", "LUTADOR", "METAL", "NORMAL", "NOTURNO", "PEDRA", "PSIQUICO", "TERRESTRE", "VENENO", "VOADOR" };

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getPokedex() {
		return pokedex;
	}

	public void setPokedex(String pokedex) {
		this.pokedex = pokedex;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public void setFraquezas(String[] fraquezas) {
		this.fraquezas = fraquezas;
	}

	public void setResistencias(String[] resistencias) {
		this.resistencias = resistencias;
	}

	public void setTipo(String[] tipo) {
		this.tipo = tipo;
	}

	private String caminho = null;

	public static String[] getTodosTipos() {
		return todosTipos;
	}

	public String exibirPokedex(Object selectedItem) {
		String filePath = new File("").getAbsolutePath();
		caminho = filePath + "/src/images/Pokemon/";
		String pokemon = selectedItem.toString();
		caminho = caminho + pokemon.substring(0, 3) + ".png";
		return caminho;
	}

	public String exibirTipo(String tipo) {
		String filePath = new File("").getAbsolutePath();
		caminho = filePath + "\\src\\images\\TagTipos\\";
		;
		caminho = caminho + tipo + ".png";
		return caminho;
	}

	public String[] getTipo() {
		return tipo;
	}

	public void verificarCaminho(String caminho) {
		File arquivo = new File(caminho);
		if (arquivo.exists()) {

		} else {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Pokemon() {
	}

	public Pokemon(String numero, boolean teste) {
		// Construtor para preencher os dados do quiz
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			while (leitor.ready()) {
				String linha1 = leitor.readLine();
				String[] dados;
				if (linha1.contains(numero)) {
					dados = linha1.split(":");
					this.numero = dados[0];
					nome = dados[1];

					try {
						classificacao = dados[2];
						altura = dados[3];
						peso = dados[4];
						tipo = dados[5].split("&");
						fraquezas = dados[6].split("@");
						resistencias = dados[7].split("%");
						descricao = dados[8];
					} catch (Exception e) {

					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Pokemon(String numero) {
		// Construtor para preencher os dados do quiz
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			while (leitor.ready()) {
				String linha1 = leitor.readLine();
				String[] dados;
				if (linha1.contains(numero)) {
					dados = linha1.split(":");
					nome = dados[1];
					tipo = dados[5].split("&");

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Pokemon(String numero, String nome, String classificacao, String altura, String peso, String tipo,
			String fraquezas, String resistencias, String descricao) {
		BufferedWriter escritor;
		try {
			escritor = new BufferedWriter(new FileWriter(caminhoPokedados, true));
			escritor.write(numero + ":" + nome + ":" + classificacao + ":" + altura + ":" + peso + ":" + tipo + ":"
					+ fraquezas + ":" + resistencias + ":" + descricao);
			escritor.newLine();
			escritor.close();
		} catch (Exception e) {
		}

	}

	public void preencherDescricao(String numero, String pokedex) {
		BufferedReader leitor;
		this.pokedex = pokedex;
		verificarStatus(numero);
		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			while (leitor.ready()) {
				String linha1 = leitor.readLine();
				String[] dados;
				if (linha1.contains(numero)) {
					dados = linha1.split(":");
					if (pokeVisto) {
						this.numero = dados[0];
						nome = dados[1];
						classificacao = dados[2];
						altura = dados[3];
						peso = dados[4];
						try {
							tipo = dados[5].split("&");
						} catch (Exception e) {
							tipo = new String[] { "" };
						}
						try {
							fraquezas = dados[6].split("@");
						} catch (Exception e) {
							fraquezas = new String[] { "" };
						}
						try {
							resistencias = dados[7].split("%");
						} catch (Exception e) {
							resistencias = new String[] { "" };
						}
						try {
							descricao = dados[8];
						} catch (Exception e) {
							descricao = "";
						}

					} else {
						String[] desconhecido = { "DESCONHECIDO" };
						this.numero = "$" + dados[0];
						nome = dados[1];
						classificacao = "??????";
						altura = "??????";
						peso = "??????";
						tipo = desconhecido;
						fraquezas = desconhecido;
						resistencias = desconhecido;
						descricao = "??????";
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void verificarStatus(String codigoPokemon) {
		int index = pokedex.indexOf(codigoPokemon);
		if (pokedex.substring(index, (index + 5)).contains("T"))
			pokeVisto = true;
		else
			pokeVisto = false;

	}

	public void preencherDescricao(String numero) {
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			while (leitor.ready()) {
				String linha1 = leitor.readLine();
				String[] dados;
				if (linha1.contains(numero)) {
					dados = linha1.split(":");
					this.numero = dados[0];
					nome = dados[1];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAltura() {
		return altura;
	}

	public String getPeso() {
		return peso;
	}

	public String[] getFraquezas() {
		return fraquezas;
	}

	public String[] getResistencias() {
		return resistencias;
	}

	public void salvarEdicao(String numero, String nome, String classificacao, String altura, String peso, String tipo,
			String fraquezas, String resistencias, String descricao) {
		BufferedReader leitor;
		BufferedWriter escritor;
		try {
			String temporario = caminhoPokedados.substring(0, caminhoPokedados.length() - 4) + "Temp.txt";
			File arquivoTemp = new File(temporario);
			File arquivo = new File(caminhoPokedados);
			if (!arquivoTemp.exists())
				arquivoTemp.createNewFile();

			String linha;

			escritor = new BufferedWriter(new FileWriter(arquivoTemp));
			leitor = new BufferedReader(new FileReader(arquivo));
			while (leitor.ready()) {
				linha = leitor.readLine();
				if (linha.contains(numero)) {
					escritor.write(numero + ":" + nome + ":" + classificacao + ":" + altura + ":" + peso + ":" + tipo
							+ ":" + fraquezas + ":" + resistencias + ":" + descricao);
					escritor.newLine();
				} else {
					escritor.write(linha);
					escritor.newLine();
				}
			}
			leitor.close();
			escritor.close();

			escritor = new BufferedWriter(new FileWriter(arquivo));
			leitor = new BufferedReader(new FileReader(arquivoTemp));
			while (leitor.ready()) {
				linha = leitor.readLine();
				escritor.write(linha);
				escritor.newLine();
			}

			leitor.close();
			escritor.close();
			arquivoTemp.delete();
		} catch (IOException e) {
		}

	}

	public String pesquisar(String nomePokemon) {
		String pesquisa = "";
		BufferedReader leitor;

		try {
			leitor = new BufferedReader(new FileReader(caminhoPokedados));
			String linha;

			while (leitor.ready()) {
				linha = leitor.readLine();
				
				if(linha.contains(nomePokemon)) {
				String[] pokemon = linha.split(":");
				String numeroPokemon = pokemon[0];
				String nome = pokemon[1];
				pesquisa = pesquisa + numeroPokemon + " - " + nome+":";
				}
			}
			;
		} catch (Exception e) {
		}
		
		return pesquisa;
		// TODO Auto-generated method stub
		
	}

	public void excluir() {
		BufferedReader leitor;
		BufferedWriter escritor;
		try {
			String temporario = caminhoPokedados.substring(0, caminhoPokedados.length() - 4) + "Temp.txt";
			File arquivoTemp = new File(temporario);
			File arquivo = new File(caminhoPokedados);
			if (!arquivoTemp.exists())
				arquivoTemp.createNewFile();

			String linha;

			escritor = new BufferedWriter(new FileWriter(arquivoTemp));
			leitor = new BufferedReader(new FileReader(arquivo));
			while (leitor.ready()) {
				linha = leitor.readLine();
				if (linha.contains(numero)) {
				} else {
					escritor.write(linha);
					escritor.newLine();
				}
			}
			leitor.close();
			escritor.close();

			escritor = new BufferedWriter(new FileWriter(arquivo));
			leitor = new BufferedReader(new FileReader(arquivoTemp));
			while (leitor.ready()) {
				linha = leitor.readLine();
				escritor.write(linha);
				escritor.newLine();
			}

			leitor.close();
			escritor.close();
			arquivoTemp.delete();
		} catch (IOException e) {
		}
		
	}

}
