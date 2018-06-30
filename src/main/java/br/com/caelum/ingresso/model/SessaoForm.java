package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;

public class SessaoForm	{
	private	Integer	id;
	
	@NotNull
	private	Integer	salaId;
	
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	
	private	LocalTime horario;
	
	@NotNull
	private	Integer	filmeId;
	
	//getters	e	setters	
	public Integer getSalaId() {
		return this.salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}
	
	public	Sessao toSessao(SalaDao	salaDao, FilmeDao filmeDao){
		Filme	filme	=	filmeDao.findOne(filmeId);
		Sala	sala	=	salaDao.findOne(salaId);
		Sessao	sessao	=	new	Sessao(horario,	filme,	sala);
		sessao.setId(id);
		return	sessao;
	}
	

}
