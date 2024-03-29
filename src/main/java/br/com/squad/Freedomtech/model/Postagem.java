package br.com.squad.Freedomtech.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPostagem = LocalDate.now();

	@NotBlank
	@Size(min = 3, max = 30)
	private String titulo;

	@NotBlank
	@Size(max = 300, message = "Maximo 300 caracteres")
	private String descricao;

	private String link;

	private String resposta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "listaDePostagens" })
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDate dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
