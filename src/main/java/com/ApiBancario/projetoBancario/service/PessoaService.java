package com.ApiBancario.projetoBancario.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiBancario.projetoBancario.model.Pessoa;
import com.ApiBancario.projetoBancario.repository.PessoaRepository;
import com.ApiBancario.projetoBancario.service.exception.PessoaException;
import com.ApiBancario.projetoBancario.service.exception.ResourceNotFoundException;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;	
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	//paginado
	public Page<Pessoa> findAll(Pageable pageable){
		Page<Pessoa> list = pessoaRepository.findAll(pageable);		
		return list;
	}	
	
	public Pessoa getById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		Pessoa p = pessoa.orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));
		return p;
	}
	
	public Pessoa create (Pessoa pessoa) {
		try {
			
		Pessoa p = new Pessoa();
		p.SetNome(pessoa.getNome());
		p.SetCodAgencia(pessoa.getCodAgencia());
		p.SetNumConta(pessoa.getNumConta());
		p.SetDigitoVerificador(pessoa.getDigitoVerificador());
		p.SetRegistroID(pessoa.getRegistroID());
		
		pessoaRepository.save(p);
		return p;
	}
		
		catch (DataIntegrityViolationException e) {
			throw new PessoaException("Cliente: " + pessoa.getNome() + " já consta no cadastro do banco.");
	}
	}
		@Transactional
		public Pessoa update(Pessoa pessoa, Long id) {
			
			try {
				Optional<Pessoa> p = pessoaRepository.findById(id);
				p.get().SetNome(pessoa.getNome());
				p.get().SetCodAgencia(pessoa.getCodAgencia());
				p.get().SetNumConta(pessoa.getNumConta());
				p.get().SetDigitoVerificador(pessoa.getDigitoVerificador());
				p.get().SetRegistroID(pessoa.getRegistroID());
				
				pessoaRepository.save(p.get());
				
				return p.get();
				
			} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException("ID: " + id + " não encontrado");
			}
			
		catch(NoSuchElementException e) {
			throw new ResourceNotFoundException("ID: " + id + " não encontrado");
		}
		
	}
		@Transactional 
		public PessoaRepository delete(Long id) {
			try {
				pessoaRepository.deleteById(id);
				
			} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID: " + id + " não encontrado");
			} catch (DataIntegrityViolationException e) {
			throw new PessoaException("Integridade do cliente violada!");
			
		}
			return pessoaRepository;
}
		}

