package br.com.jcacademy.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.jcacademy.application.service.AlunoService;
import br.com.jcacademy.domain.aluno.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private AlunoService alunoService;
	
	private Aluno aluno = new Aluno();
	
	public String gravar() {
		System.out.println("Aluno ==>" + aluno);
		alunoService.createOrUpdate(aluno);
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
