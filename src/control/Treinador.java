package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Treinador {
	private String nomeTreinador = null, spritetreinador = null;
	private int nivel = 1, experiencia = 0, proximoNivel = 5;
	
	public int getTotalPokedex() {
		int total = 0;
		for(int i=0; i<pokedexVisto.length();i++){  
            char ch = pokedexVisto.charAt(i);  
	            String x1 = String.valueOf(ch);  
            if(x1.equalsIgnoreCase("T")){  
	                total=total+1;  
	            }  
	        }  
		return total;
	}


	private String senha, regiao, cidade, mesNasc, diaNasc;
	private int insigRocha = 0, insigCascata = 0, insigTrovao = 0, insigArcoIris = 0, insigLama = 0, insigAlma = 0,
			insigVulcao = 0, insigTerra = 0;
	private String caminhoTreinador = new File("").getAbsolutePath() + "\\src\\dados\\Treinador.txt";
	// private String caminhoTreinador = new File("").getAbsolutePath() +
	// "/src/dados/Treinador.txt";
	private String pokedexVisto = "#001F$#002F$#003F$#004F$#005F$#006F$#007F$#008F$#009F$#010F$#011F$#012F$#013F$#014F$#015F$#016F$#017F$#018F$#019F$#020F$#021F$#022F$#023F$#024F#025F$#026F$#027F$#028F$#029F$#030F$#031F$#032F$#033F$#034F$#035F$#036F$#037F$#038F$#039F$#040F$#041F$#042F$#043F$#044F$#045F$#046F$#047F$#048F$#049F$#050F$#051F$#052F$#053F$#054F$#055F$#056F$#057F$#058F$#059F$#060F$#061F$#062F$#063F$#064F$#065F$#066F$#067F$#068F$#069F$#070F$#071F$#072F$#073F$#074F$#075F$#076F$#077F$#078F$#079F$#080F$#081F$#082F$#083F$#084F$#085F$#086F$#087F$#088F$#089F$#090F$#091F$#092F$#093F$#094F$#095F$#096F$#097F$#098F$#099F$#100F$#101F$#102F$#103F$#104F$#105F$#106F$#107F$#108F$#109F$#110F$#111F$#112F$#113F$#114F$#115F$#116F$#117F$#118F$#119F$#120F$#121F$#122F$#123F$#124F$#125F$#126F$#127F$#128F$#129F$#130F$#131F$#132F$#133F$#134F$#135F$#136F$#137F$#138F$#139F$#140F$#141F$#142F$#143F$#144F$#145F$#146F$#147F$#148F$#149F$#150F$#151F";

	public void salvarTreinador(String nomeTreinador, String spriteTreinador, String mesNasc, String diaNasc,
			String regiao, String cidade, char[] senha) {
		BufferedReader leitor;
		BufferedWriter escritor;
		try {
			String temporario = caminhoTreinador.substring(0, caminhoTreinador.length() - 4) + "Temp.txt";
			File arquivoTemp = new File(temporario);
			File arquivo = new File(caminhoTreinador);
			if (!arquivoTemp.exists())
				arquivoTemp.createNewFile();

			String linha;

			escritor = new BufferedWriter(new FileWriter(arquivoTemp));
			leitor = new BufferedReader(new FileReader(arquivo));
			while (leitor.ready()) {
				linha = leitor.readLine();
				if (linha.contains(nomeTreinador)) {
					String senhaString = String.valueOf(senha);
					escritor.write(nomeTreinador + "%%" + experiencia + "%%" + spriteTreinador + ".png%%" + mesNasc
							+ "%%" + diaNasc + "%%" + regiao + "%%" + cidade + "%%" + senhaString + "%%" + insigRocha
							+ "%%" + insigCascata + "%%" + insigTrovao + "%%" + insigArcoIris + "%%" + insigLama + "%%"
							+ insigAlma + "%%" + insigVulcao + "%%" + insigTerra + "%%" + pokedexVisto);
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

	public void salvarTreinador(String spriteTreinador, String mesNasc, String diaNasc, String regiao, String cidade,
			char[] senha) {

		this.spritetreinador = spriteTreinador + ".png";
		this.mesNasc = mesNasc;
		this.diaNasc = diaNasc;
		this.regiao = regiao;
		this.cidade = cidade;
		this.senha = String.valueOf(senha);
		salvarTreinador();
	}

	public void salvarTreinador() {
		BufferedReader leitor;
		BufferedWriter escritor;
		try {
			String temporario = caminhoTreinador.substring(0, caminhoTreinador.length() - 4) + "Temp.txt";
			File arquivoTemp = new File(temporario);
			File arquivo = new File(caminhoTreinador);
			if (!arquivoTemp.exists())
				arquivoTemp.createNewFile();

			String linha;

			escritor = new BufferedWriter(new FileWriter(arquivoTemp));
			leitor = new BufferedReader(new FileReader(arquivo));
			while (leitor.ready()) {
				linha = leitor.readLine();
				if (linha.contains(nomeTreinador)) {
					escritor.write(nomeTreinador + "%%" + experiencia + "%%" + spritetreinador + "%%" + mesNasc + "%%"
							+ diaNasc + "%%" + regiao + "%%" + cidade + "%%" + senha + "%%" + insigRocha + "%%"
							+ insigCascata + "%%" + insigTrovao + "%%" + insigArcoIris + "%%" + insigLama + "%%"
							+ insigAlma + "%%" + insigVulcao + "%%" + insigTerra + "%%" + pokedexVisto);
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

	public Treinador(String nomeTreinador) {
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(caminhoTreinador));
			while (leitor.ready()) {
				String linha = leitor.readLine();
				if (linha.contains(nomeTreinador)) {
					String[] vetorTreinador = linha.split("%%");
					this.nomeTreinador = vetorTreinador[0];
					experiencia = Integer.parseInt(vetorTreinador[1]);
					spritetreinador = vetorTreinador[2];
					mesNasc = vetorTreinador[3];
					diaNasc = vetorTreinador[4];
					regiao = vetorTreinador[5];
					cidade = vetorTreinador[6];
					senha = vetorTreinador[7];
					insigRocha = Integer.parseInt(vetorTreinador[8]);
					insigCascata = Integer.parseInt(vetorTreinador[9]);
					insigTrovao = Integer.parseInt(vetorTreinador[10]);
					insigArcoIris = Integer.parseInt(vetorTreinador[11]);
					insigLama = Integer.parseInt(vetorTreinador[12]);
					insigAlma = Integer.parseInt(vetorTreinador[13]);
					insigVulcao = Integer.parseInt(vetorTreinador[14]);
					insigTerra = Integer.parseInt(vetorTreinador[15]);
					pokedexVisto = vetorTreinador[16];
				}
			}
		} catch (Exception e) {
		}
	}

	public void upInsignia(String tipo) {
		switch (tipo) {
		case "PEDRA":
			upInsigRocha();
			break;
		case "AGUA":
			upInsigCascata();
			break;
		case "ELETRICO":
			upInsigTrovao();
			break;
		case "GRAMA":
			upInsigArcoIris();
			break;
		case "PSIQUICO":
			upInsigLama();
			break;
		case "VENENO":
			upInsigAlma();
			break;
		case "FOGO":
			upInsigVulcao();
			break;
		case "TERRESTRE":
			upInsigTerra();
			break;
		}
	}

	public int determinarExpMaximo() {
		int experiencia = this.experiencia;
		int nivel = 1, xpMaximo = 5, xp = 0;
		for (int i = 0; i < experiencia; i++) {
			xp++;
			if (xp == xpMaximo) {
				xpMaximo += 5;
				xp = 0;
				nivel++;
			}
			proximoNivel = xpMaximo - xp;
		}
		this.nivel = nivel;
		return xpMaximo;

	}

	public int contaTreinador() {
		int i = 0;
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(caminhoTreinador));

			while (leitor.ready()) {
				leitor.readLine();
				i++;
			}
			;
		} catch (Exception e) {
		}
		return i;
	}

	public String[] listaTreinadores() {
		BufferedReader leitor;
		int i = contaTreinador();

		String[] lista = new String[i];

		try {
			leitor = new BufferedReader(new FileReader(caminhoTreinador));
			String linha;
			i = 0;
			while (leitor.ready()) {
				linha = leitor.readLine();
				String[] treinador = linha.split("%%");
				String nomeTreinador = treinador[0];
				lista[i] = nomeTreinador;
				i++;
			}
			;
		} catch (Exception e) {
		}
		return lista;

	}

	public int nivelInsignia(int pontosInsignia) {
		if (pontosInsignia >= 10 && pontosInsignia < 20)
			return 1;
		else if (pontosInsignia >= 20 && pontosInsignia < 30)
			return 2;
		else if (pontosInsignia > 30)
			return 3;
		else
			return 0;
	}

	public boolean verificarSenha(String senhaDigitada) {

		if (senha.equals(senhaDigitada)) {
			return true;
		} else {
			return false;
		}
	}

	public void verPokemon(String numeroPokemon) {
		String linha = pokedexVisto;
		int i = linha.indexOf(numeroPokemon);
		linha = linha.substring(0, (i + 4)) + "T" + linha.substring(i + 5);
		pokedexVisto = linha;
		salvarTreinador();
	}

	public Treinador() {
	}

	public String getSenha() {
		return senha;
	}

	public String getRegiao() {
		return regiao;
	}

	public String getCidade() {
		return cidade;
	}

	public String getMesNasc() {
		return mesNasc;
	}

	public int getInsigRocha() {
		return insigRocha;
	}

	public void upInsigRocha() {
		this.insigRocha = insigRocha + 1;
		salvarTreinador();
	}

	public int getInsigCascata() {
		return insigCascata;
	}

	public void upInsigCascata() {
		this.insigCascata = insigCascata + 1;
		salvarTreinador();
	}

	public int getInsigTrovao() {
		return insigTrovao;
	}

	public void upInsigTrovao() {
		this.insigTrovao = insigTrovao + 1;
		salvarTreinador();
	}

	public int getInsigArcoIris() {
		return insigArcoIris;
	}

	public void upInsigArcoIris() {
		this.insigArcoIris = insigArcoIris + 1;
		salvarTreinador();
	}

	public void upExperiencia() {
		this.experiencia = experiencia + 1;
		salvarTreinador();
	}

	public String getNomeTreinador() {
		return nomeTreinador;
	}

	public int getNivel() {
		return nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public int getProximoNivel() {
		return proximoNivel;
	}

	public String getSpritetreinador() {
		return spritetreinador;
	}

	public String getDiaNasc() {
		return diaNasc;
	}

	public int getInsigLama() {
		return insigLama;
	}

	public void upInsigLama() {
		this.insigLama = insigLama + 1;
	}

	public int getInsigAlma() {
		return insigAlma;
	}

	public void upInsigAlma() {
		this.insigAlma = insigAlma + 1;
	}

	public int getInsigVulcao() {
		return insigVulcao;
	}

	public void upInsigVulcao() {
		this.insigVulcao = insigVulcao + 1;
	}

	public int getInsigTerra() {
		return insigTerra;
	}

	public void upInsigTerra() {
		this.insigTerra = insigTerra + 1;
	}

	public String getPokedexVisto() {
		return pokedexVisto;
	}

	public void setPokedexVisto(String pokedexVisto) {
		this.pokedexVisto = pokedexVisto;
		salvarTreinador();
	}

	public Treinador(String nomeTreinador, String avatar, String mes, String dia, String regiao,
			String cidade, char[] senha) {
		BufferedWriter escritor;
		try {
			File arquivo = new File(caminhoTreinador);
			if (!arquivo.exists())
				arquivo.createNewFile();
			
			String senhaString = String.valueOf(senha);

			escritor = new BufferedWriter(new FileWriter(caminhoTreinador,true));
					escritor.write(nomeTreinador + "%%" + experiencia + "%%" + avatar+".png" + "%%" + mesNasc + "%%"
							+ diaNasc + "%%" + regiao + "%%" + cidade + "%%" + senhaString + "%%" + insigRocha + "%%"
							+ insigCascata + "%%" + insigTrovao + "%%" + insigArcoIris + "%%" + insigLama + "%%"
							+ insigAlma + "%%" + insigVulcao + "%%" + insigTerra + "%%" + pokedexVisto);
					escritor.newLine();

			escritor.close();
		} catch (IOException e) {
		}
	}

}
