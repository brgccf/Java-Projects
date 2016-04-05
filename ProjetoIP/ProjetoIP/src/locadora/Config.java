package locadora;

import iterator.IteratorCliente;
import iterator.IteratorClienteArray;
import iterator.IteratorClienteLista;
import iterator.IteratorProduto;
import iterator.IteratorProdutoArray;
import iterator.IteratorProdutoLista;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import dados.RepositorioCliente;
import dados.RepositorioClienteArray;
import dados.RepositorioClienteLista;
import dados.RepositorioClienteXls;
import dados.RepositorioProduto;
import dados.RepositorioProdutoArray;
import dados.RepositorioProdutoLista;
import dados.RepositorioProdutoXls;
import excecoes.RepositorioException;

public class Config {
	private static final String ARQUIVO = System.getProperty("user.dir")+"/Config.txt";
	private static final File file = new File(ARQUIVO);

	public static IteratorCliente setIteratorCliente(RepositorioCliente rep) throws RepositorioException {
		Scanner inTxt = null;
		String tipo = null;
		IteratorCliente aux = null;
		check();
		try {
			inTxt = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RepositorioException();
		}
		while (inTxt.hasNext()) {
			tipo=inTxt.next();
			switch (tipo) {
			case("array"):
				aux = new IteratorClienteArray(((RepositorioClienteArray) rep).getIterator());
			break;
			case("lista"):
				aux = new IteratorClienteLista(((RepositorioClienteLista) rep));
			break;
			case("jakarta"):
				aux = new IteratorClienteArray(((RepositorioClienteArray) rep).getIterator());
			break;
			}
		}
		inTxt.close();
		return aux;
	}
	
	public static IteratorProduto setIteratorProduto(RepositorioProduto rep) throws RepositorioException {
		Scanner inTxt = null;
		String tipo = null;
		IteratorProduto aux = null;
		check();
		try {
			inTxt = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RepositorioException();
		}
		while (inTxt.hasNext()) {
			tipo=inTxt.next();
			switch (tipo) {
			case("array"):
				aux = new IteratorProdutoArray(((RepositorioProdutoArray) rep).getIterator());
			break;
			case("lista"):
				aux = new IteratorProdutoLista(((RepositorioProdutoLista) rep).getIterator());
			break;
			case("jakarta"):
				aux = new IteratorProdutoArray(((RepositorioProdutoArray) rep).getIterator());
			break;
			}
		}
		inTxt.close();
		return aux;
	}
	
	public static RepositorioProduto lerProduto() throws RepositorioException {
		Scanner inTxt = null;
		String tipo = null;
		RepositorioProduto aux = null;
		check();
		try {
			inTxt = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RepositorioException();
		}
		while (inTxt.hasNext()) {
			tipo=inTxt.next();
			switch (tipo) {
			case("array"):
				aux = new RepositorioProdutoArray();
			break;
			case("lista"):
				aux = new RepositorioProdutoLista();
			break;
			case("jakarta"):
				aux = new RepositorioProdutoXls();
			break;
			}
		}
		inTxt.close();
		return aux;
	}

	public static RepositorioProduto lerProdutoCliente() throws RepositorioException {
		Scanner inTxt = null;
		String tipo = null;
		RepositorioProduto aux = null;
		check();
		try {
			inTxt = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RepositorioException();
		}
		while (inTxt.hasNext()) {
			tipo=inTxt.next();
			switch (tipo) {
			case("array"):
				aux = new RepositorioProdutoArray();
			break;
			case("lista"):
				aux = new RepositorioProdutoLista();
			break;
			case("jakarta"):
				aux = new RepositorioProdutoArray();
			break;
			}
		}
		inTxt.close();
		return aux;

	}

	public static RepositorioCliente lerCliente() throws RepositorioException {
		Scanner inTxt = null;
		String tipo = null;
		RepositorioCliente aux = null;
		check();
		try {
			inTxt = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RepositorioException();
		}
		while (inTxt.hasNext()) {
			tipo=inTxt.next();
			switch (tipo) {
			case("array"):
				aux = new RepositorioClienteArray();
			break;
			case("lista"):
				aux = new RepositorioClienteLista();
			break;
			case("jakarta"):
				aux = new RepositorioClienteXls();
			break;
			}
		}
		inTxt.close();
		return aux;

	}

	private static void check() throws RepositorioException {
		Scanner inTxt = null;
		BufferedWriter bw = null;
		try {
			if (file.exists()) {
				inTxt = new Scanner(file);
			} else {
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				bw.write("array");
				bw.close();
			}
		} catch (FileNotFoundException e) {
			throw new RepositorioException();
		} catch (IOException e) {
			throw new RepositorioException();
		} finally {
			inTxt.close();
		}
		
	}

}
