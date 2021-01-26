package br.com.jcacademy.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.jcacademy.application.util.StringUtils;
import br.com.jcacademy.application.util.Validation;
import br.com.jcacademy.domain.aluno.Aluno;
import br.com.jcacademy.domain.aluno.AlunoRepository;

@Stateless
public class AlunoService {
	
	@EJB
	private AlunoRepository alunoRepository;
	
	private void create(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		aluno.gerarMatricula();
		alunoRepository.store(aluno);
	}
	
	private void update(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		alunoRepository.update(aluno);
	}
	
	public void createOrUpdate(Aluno aluno) {
		if(StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		} else {
			update(aluno);
		}
	}

}
