package dados;

import iterator.IteratorProduto;
import iterator.IteratorProdutoArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import locadora.BluRay;
import locadora.DVD;
import locadora.Jogos;
import locadora.Produto;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

public class RepositorioProdutoXls implements RepositorioProduto {
	private final RepositorioProdutoArray rep;
	private static final String ARQUIVO = System.getProperty("user.dir") + "/Produto.xls";
	private File file;

	public RepositorioProdutoXls() throws RepositorioException {
		this.rep = new RepositorioProdutoArray();
		this.file = new File(ARQUIVO);
		if (this.file.exists()) {
			this.lerArquivo();
		} else {
			try {
				this.file.createNewFile();
			} catch (IOException e) {
				throw new RepositorioException();
			}
		}
	}

	public RepositorioProdutoArray getRep() {
		return rep;
	}

	private void lerArquivo() throws RepositorioException{
		InputStream file;
		HSSFWorkbook wb = null;
		POIFSFileSystem fs;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		int tmp, tipo, extra;
		String nome;
		String descricao;
		double preco;
		boolean alugado=false;
		Produto aux = null;
		try {
			file = new FileInputStream(this.file);
			fs = new POIFSFileSystem(file);
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheetAt(0);
			tmp=sheet.getPhysicalNumberOfRows();
			for (int i=0;i<tmp;i++) {
				row = sheet.getRow(i);
				tipo=(int)(row.getCell((short) 0).getNumericCellValue());
				nome=row.getCell((short) 1).getStringCellValue();
				descricao=row.getCell((short) 2).getStringCellValue();
				preco=(row.getCell((short) 3).getNumericCellValue());
				extra=(int)(row.getCell((short) 5).getNumericCellValue());
				if (row.getCell((short) 4).getBooleanCellValue()) {
					alugado=true;
				}
				switch (tipo) {
				case (0):
					aux=new DVD(nome, descricao, preco, extra);
				aux.setAlugado(alugado);
				this.rep.inserir(aux);
				break;
				case (1):
					aux=new BluRay(nome, descricao, preco, extra);
				aux.setAlugado(alugado);
				this.rep.inserir(aux);
				break;
				case (2):
					aux=new Jogos(nome, descricao, preco, extra);
				aux.setAlugado(alugado);
				this.rep.inserir(aux);
				break;
				}
			}
		} catch (IOException e) {
			throw new RepositorioException();
		} catch (ProdutoExistenteException e) {
			throw new RepositorioException();
		}
	}

	private void gravarArquivo() throws RepositorioException{
		IteratorProduto it = null;
		FileOutputStream file;
		HSSFWorkbook wb = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		Produto produto=null;
		try {
			it = new IteratorProdutoArray(rep.getIterator());
			file = new FileOutputStream(this.file);
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("teste");
			for (int i=0;it.hasNext();i++) {
				row = sheet.createRow(i);
				produto=it.next();
				if ((produto instanceof DVD) && !(produto instanceof BluRay)) {
					row.createCell((short) 0).setCellValue(0);
					row.createCell((short) 5).setCellValue(((DVD) produto).getDuracao());
				} else if (produto instanceof BluRay) {
					row.createCell((short) 0).setCellValue(1);
					row.createCell((short) 5).setCellValue(((BluRay) produto).getDuracao());
				} else if (produto instanceof Jogos) {
					row.createCell((short) 0).setCellValue(2);
					row.createCell((short) 5).setCellValue(((Jogos) produto).getFaixaEtaria());
				}
				row.createCell((short) 1).setCellValue(produto.getNome());
				row.createCell((short) 2).setCellValue(produto.getDescricao());
				row.createCell((short) 3).setCellValue(produto.getPreco());
				row.createCell((short) 4).setCellValue(produto.getAlugado());

			}
			wb.write(file);
		} catch (IOException e) {
			throw new RepositorioException();
		}
	}

	public void inserir(Produto produto) throws ProdutoExistenteException, RepositorioException {
		this.rep.inserir(produto);
		this.gravarArquivo();
	}

	public Produto procurar(String nome) throws ProdutoNaoExistenteException {
		return this.rep.procurar(nome);
	}

	public void atualizar(Produto produto) throws ProdutoNaoExistenteException, RepositorioException {
		this.rep.atualizar(produto);
		this.gravarArquivo();
	}

	public void remover(String nome) throws ProdutoNaoExistenteException, RepositorioException {
		this.rep.remover(nome);
		this.gravarArquivo();
	}
	
	public boolean existe(String nome) {
		return this.rep.existe(nome);
	}

}
