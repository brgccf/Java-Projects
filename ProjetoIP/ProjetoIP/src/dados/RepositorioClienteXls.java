package dados;

import iterator.IteratorCliente;
import iterator.IteratorClienteArray;
import iterator.IteratorProduto;
import iterator.IteratorProdutoArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import locadora.BluRay;
import locadora.Cliente;
import locadora.DVD;
import locadora.Jogos;
import locadora.Produto;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

public class RepositorioClienteXls implements RepositorioCliente {
	private final RepositorioClienteArray rep;

	private static final File file = new File(System.getProperty("user.dir") + "/Clientes.xls");
	
	public RepositorioClienteXls() throws RepositorioException {
		this.rep = new RepositorioClienteArray();
		if (file.exists()) {
			this.lerArquivo();
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RepositorioException();
			}
		}
	}
	
	public RepositorioClienteArray getRep() {
		return this.rep;
	}
	
	public Cliente[] getIterator() {
		return this.rep.getIterator();
	}

	private void lerArquivo() throws RepositorioException{
		InputStream fl;
		HSSFWorkbook wb = null;
		POIFSFileSystem fs;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		int tmp, qnt, tipo, dia, mes, ano, extra;
		double preco;
		String nome, cpf, descricao;
		Cliente cliente = null;
		Produto produto = null;
		Calendar calendario = new GregorianCalendar();
		try {
			fl = new FileInputStream(file);
			fs = new POIFSFileSystem(fl);
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheetAt(0);
			tmp=sheet.getPhysicalNumberOfRows();
			for (int i=0;i<tmp;i++) {
				row = sheet.getRow(i);
				nome=row.getCell((short) 0).getStringCellValue();
				cpf=row.getCell((short) 1).getStringCellValue();
				cliente = new Cliente(nome, cpf);
				qnt=(int)row.getCell((short) 2).getNumericCellValue();
				if (qnt>0) {
					while (qnt>0) {
						i++;
						row = sheet.getRow(i);
						tipo=(int)row.getCell((short) 0).getNumericCellValue();
						nome=row.getCell((short) 1).getStringCellValue();
						descricao=row.getCell((short) 2).getStringCellValue();
						preco=row.getCell((short) 3).getNumericCellValue();
						extra=(int)row.getCell((short) 4).getNumericCellValue();
						dia=(int)row.getCell((short) 5).getNumericCellValue();
						mes=(int)row.getCell((short) 6).getNumericCellValue();
						ano=(int)row.getCell((short) 7).getNumericCellValue();
						switch (tipo) {
						case(0):
							produto = new DVD(nome, descricao, preco, extra);
						break;
						case(1):
							produto = new BluRay(nome, descricao, preco, extra);
						break;
						case(2):
							produto = new Jogos(nome, descricao, preco, extra);
						break;
						}
						calendario.set(dia, mes, ano);
						produto.setCalendario(calendario);
						cliente.adicionar(produto);
						qnt--;
					}
				}
				this.rep.inserir(cliente);
			}
		} catch (IOException e) {
			throw new RepositorioException();
		} catch (ClienteExistenteException e) {
			throw new RepositorioException();
		} catch (ProdutoExistenteException e) {
			throw new RepositorioException();
		}
	}

	private void gravarArquivo() throws RepositorioException{
		IteratorCliente itCliente = null;
		IteratorProduto itProduto = null;
		FileOutputStream fl;
		HSSFWorkbook wb = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		Cliente cliente=null;
		Produto produto=null;
		RepositorioProdutoArray repProduto=null;
		try {
			itCliente = new IteratorClienteArray(rep.getIterator());
			fl = new FileOutputStream(file);
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("teste");
			for (int i=0;itCliente.hasNext();i++) {
				row = sheet.createRow(i);
				cliente=itCliente.next();
				row.createCell((short) 0).setCellValue(cliente.getNome());
				row.createCell((short) 1).setCellValue(cliente.getCpf());
				/*AQUI*/row.createCell((short) 2).setCellValue(((RepositorioProdutoArray) cliente.getRepositorioProduto()).getQnt());
				if (((RepositorioProdutoArray) cliente.getRepositorioProduto()).getQnt()>0) {
					repProduto=(RepositorioProdutoArray) cliente.getRepositorioProduto();
					itProduto=new IteratorProdutoArray(repProduto.getIterator());
					while (itProduto.hasNext()) {
						i++;
						produto=itProduto.next();
						row = sheet.createRow(i);
						if ((produto instanceof DVD) && !(produto instanceof BluRay)) {
							row.createCell((short) 0).setCellValue(0);
							row.createCell((short) 4).setCellValue(((DVD) produto).getDuracao());
						} else if (produto instanceof BluRay) {
							row.createCell((short) 0).setCellValue(1);
							row.createCell((short) 4).setCellValue(((BluRay) produto).getDuracao());
						} else if (produto instanceof Jogos){
							row.createCell((short) 0).setCellValue(2);
							row.createCell((short) 4).setCellValue(((Jogos) produto).getFaixaEtaria());
						}
						row.createCell((short) 1).setCellValue(produto.getNome());
						row.createCell((short) 2).setCellValue(produto.getDescricao());
						row.createCell((short) 3).setCellValue(produto.getPreco());
						row.createCell((short) 5).setCellValue(produto.getCalendario().get(Calendar.DAY_OF_MONTH));
						row.createCell((short) 6).setCellValue(produto.getCalendario().get(Calendar.MONTH));//ATENCAO
						row.createCell((short) 7).setCellValue(produto.getCalendario().get(Calendar.YEAR));
					}
				}
			}
			wb.write(fl);
		} catch (IOException e) {
			throw new RepositorioException();
		}
	}

	public void inserir(Cliente cliente) throws ClienteExistenteException, RepositorioException {
		this.rep.inserir(cliente);
		this.gravarArquivo();
	}

	public Cliente procurar(String nome) throws ClienteNaoExistenteException {
		return this.rep.procurar(nome);
	}

	public void atualizar(Cliente cliente) throws ClienteNaoExistenteException, RepositorioException {
		this.rep.atualizar(cliente);
		this.gravarArquivo();
	}

	public void remover(String nome) throws ClienteNaoExistenteException, RepositorioException {
		this.rep.remover(nome);
		this.gravarArquivo();
	}
	public void inserirProduto(String cpf, Produto produto) throws ProdutoExistenteException, RepositorioException {
		this.rep.inserirProduto(cpf, produto);
		this.gravarArquivo();
	}
	public void removerProduto(String cpf, String nomeProduto) throws ProdutoNaoExistenteException, RepositorioException {
		this.rep.removerProduto(cpf, nomeProduto);
		this.gravarArquivo();
	}

	public boolean existe(String nome) {
		return this.rep.existe(nome);
	}
	
}
