package logs;

import iterator.IteratorCliente;
import iterator.IteratorProduto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import locadora.BluRay;
import locadora.Cliente;
import locadora.Config;
import locadora.DVD;
import locadora.Jogos;
import locadora.Produto;
import dados.RepositorioCliente;
import excecoes.RepositorioException;

public class LogClientes {
	private RepositorioCliente rep;
	private File log = new File("C:\\Users\\pgrr\\Desktop\\LogClientes.txt");
	
	public LogClientes(RepositorioCliente rep) {
		this.rep = rep;
	}
	
	public void genLog() throws IOException, RepositorioException {
		IteratorCliente itCliente = Config.setIteratorCliente(rep);
		IteratorProduto itProduto = null;
		Cliente cliente = null;
		Produto produto = null;
		FileWriter fs = new FileWriter(log);
		BufferedWriter bw = new BufferedWriter(fs);
		while (itCliente.hasNext()) {
			cliente=itCliente.next();
			bw.write(cliente.getNome() + ", " + cliente.getCpf());
			bw.newLine();
			itProduto = Config.setIteratorProduto(cliente.getRepositorioProduto());
			while (itProduto.hasNext()) {
				bw.write("DVD's:\n");
				bw.newLine();
				while (itProduto.hasNext()) {
					produto = itProduto.next();
					if ((produto instanceof DVD) && !(produto instanceof BluRay)) {
						bw.write(produto.getNome() + " " + produto.getDescricao() + " " + produto.getPreco() + " " + ((DVD) produto).getDuracao());
						bw.newLine();
					}
				}
				bw.newLine();
				itProduto = Config.setIteratorProduto(cliente.getRepositorioProduto());
				bw.write("BluRay's:\n");
				bw.newLine();
				while (itProduto.hasNext()) {
					produto = itProduto.next();
					if ((produto instanceof BluRay)) {
						bw.write(produto.getNome() + " " + produto.getDescricao() + " " + produto.getPreco() + " " + ((DVD) produto).getDuracao());
						bw.newLine();
					}
				}
				bw.newLine();
				itProduto = Config.setIteratorProduto(cliente.getRepositorioProduto());
				bw.write("Jogos:\n");
				bw.newLine();
				while (itProduto.hasNext()) {
					produto = itProduto.next();
					if (produto instanceof Jogos) {
						bw.write(produto.getNome() + " " + produto.getDescricao() + " " + produto.getPreco() + " " + ((Jogos) produto).getFaixaEtaria());
						bw.newLine();
					}
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
