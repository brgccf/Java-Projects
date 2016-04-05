package br.ufpe.cin.dados;

import br.ufpe.cin.banco.ContaAbstrata;

/**
 * Defina a interface aula14.br.ufpe.cin.dados.RepositorioContas com os metodos 
 *   -> inserir   - recebe uma ContaAbstrata e insere no repositorio
 *   -> procurar  - recebe um numero e retorna a conta se estiver no repositorio
 *   -> remover   - recebe um numero para remover a conta do repositorio
 *   -> atualizar - recebe uma ContaAbstrata para atualizar no repositorio
 *   -> existe    - recebe um numero e informa se existe uma conta com este numero no repositorio 
 *
 */
public interface RepositorioContas {
	  void inserir(ContaAbstrata conta);
	  ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException;
	  void remover(String numero) throws ContaNaoEncontradaException;
	  void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException;
	  boolean existe(String numero) throws ContaNaoEncontradaException;

}
