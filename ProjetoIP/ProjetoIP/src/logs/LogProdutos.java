package logs;

import iterator.IteratorProduto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import locadora.BluRay;
import locadora.Config;
import locadora.DVD;
import locadora.Jogos;
import locadora.Produto;
import dados.RepositorioProduto;
import excecoes.RepositorioException;

public class LogProdutos {
	private RepositorioProduto rep;
	private File log = new File("C:\\Users\\pgrr\\Desktop\\LogProdutos.txt");

	public LogProdutos(RepositorioProduto rep) {
		this.rep=rep;
	}

	public void genLog() throws IOException, RepositorioException {
		IteratorProduto it = null;
		Produto produto = null;
		FileWriter fw = new FileWriter(log);
		BufferedWriter bw = new BufferedWriter(fw);
		it = Config.setIteratorProduto(rep);
		String status = "";
		bw.write("DVD's:\n");
		bw.newLine();
		while (it.hasNext()) {
			produto = it.next();
			if (produto.getAlugado()) {
				status = "Alugado";
			} else {
				status = "Disponivel";
			}
			if ((produto instanceof DVD) && !(produto instanceof BluRay)) {
				bw.write(produto.getNome() + " " + produto.getDescricao() + " " + produto.getPreco() + " " + ((DVD) produto).getDuracao() + " " + status + "\n");
				bw.newLine();
			}
		}
		bw.newLine();
		it = Config.setIteratorProduto(rep);
		bw.write("BluRay's:\n");
		bw.newLine();
		while (it.hasNext()) {
			produto = it.next();
			if (produto.getAlugado()) {
				status = "Alugado";
			} else {
				status = "Disponivel";
			}
			if ((produto instanceof BluRay)) {
				bw.write(produto.getNome() + " " + produto.getDescricao() + " " + produto.getPreco() + " " + ((DVD) produto).getDuracao() + " " + status + "\n");
				bw.newLine();
			}
		}
		bw.newLine();
		it = Config.setIteratorProduto(rep);
		bw.write("Jogos:\n");
		bw.newLine();
		while (it.hasNext()) {
			produto = it.next();
			if (produto.getAlugado()) {
				status = "Alugado";
			} else {
				status = "Disponivel";
			}
			if (produto instanceof Jogos) {
				bw.write(produto.getNome() + " " + produto.getDescricao() + " " + produto.getPreco() + " " + ((Jogos) produto).getFaixaEtaria() + " " + status + "\n");
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
