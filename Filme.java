/* Autores: Tulio N. Polido Lopes, Joao Victor da Silva, Gustavo Lescowicz Kotarsky, Temistocles Altivo Schwartz 
 * Data: 21/08/2018
 * */
import java.io.*;

public class Filme {
	private int id;
	private String titulo;
	private String tituloOriginal;
	private String pais;
	private short ano;
	private short duracao;
	private String diretor;
	private String sinopse;

	public Filme() {
	}//end Filme()

	public Filme(String titulo, String tituloOriginal, String pais, short ano, short duracao, String diretor, String sinopse,int id) {
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.pais = pais;
		this.ano = ano;
		this.duracao = duracao;
		this.diretor = diretor;
		this.sinopse = sinopse;
		this.id = id;
	}//end Filme()

	public Filme(String titulo, String tituloOriginal, String pais, short ano, short duracao, String diretor, String sinopse) {
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.pais = pais;
		this.ano = ano;
		this.duracao = duracao;
		this.diretor = diretor;
		this.sinopse = sinopse;
	}//end Filme()

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	public void setDuracao(short duracao) {
		this.duracao = duracao;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getTitulo () {
		return this.titulo;			
	}
	
	public String getTituloOriginal () {
		return this.tituloOriginal;
	}

	public String getPais () {
		return this.pais;
	}
	
	public int getAno () {
		return this.ano;
	}
	
	public int getDuracao () {
		return this.duracao;
	}
	
	public String getDiretor () {
		return this.diretor;
	}
	
	public String getSinopse () {
		return this.sinopse;
	}

	public int getID() {
		return this.id;
	}
	
	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		
		saida.writeInt(this.id);
		saida.writeUTF(this.titulo);
		saida.writeUTF(this.tituloOriginal);
		saida.writeUTF(this.pais);
		saida.writeShort(this.ano);
		saida.writeShort(this.duracao);
		saida.writeUTF(this.diretor);
		saida.writeUTF(this.sinopse);
		

		return dados.toByteArray();
	}//end getByteArray()

	public void setByteArray(byte[] bytes) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(bytes);
		DataInputStream entrada = new DataInputStream(dados);

		this.id = entrada.readInt();
		this.titulo = entrada.readUTF();
		this.tituloOriginal = entrada.readUTF();
		this.pais = entrada.readUTF();
		this.ano = entrada.readShort();
		this.duracao = entrada.readShort();
		this.diretor = entrada.readUTF();
		this.sinopse = entrada.readUTF();
		
	}//end setByteArray()

	public void writeObject(RandomAccessFile raf) throws IOException {
		byte[] dados = this.getByteArray();
		raf.writeChar(' ');
		raf.writeShort(dados.length);
		raf.write(dados);
	}//end writeObject()

	public String toString(){
		return "Titulo: "+this.titulo+
			"\nTitulo Original: "+this.tituloOriginal+
			"\nDiretor: "+this.diretor+
			"\nPais: "+this.pais+
			"\nDuracao: "+this.duracao+
			"\nAno: "+this.ano+
			"\nSinopse: "+this.sinopse+
			"\nID: "+this.id;

	}//end toString()
}
