package aula14.br.ufpe.cin.dados;

import aula13.br.ufpe.cin.banco.*;

/*Em classes abstratas poderiamos ter algo concreto (como metodos, construtor e atributos)
 * porem em interfaces tudo é abstrato e deve ser programado nas classes que implementam
 * essas interfaces. palavra-chave "implements"
 * A utilidade disto é que classes podem implementar mais de uma interface, enquanto
 * não podem herdar mais de uma classe.
 */
public interface RepositorioContas {
	public abstract void inserir (ContaAbstrata conta);
	public abstract String procurar (String numero);
	public abstract String remover (String numero);
	public abstract void atualizar (ContaAbstrata conta);
	public abstract boolean existe (String numero);

}
