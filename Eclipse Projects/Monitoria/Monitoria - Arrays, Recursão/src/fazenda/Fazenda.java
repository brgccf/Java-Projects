package fazenda;

public class Fazenda {
	private Vaca[] arrayVacas;
	
	public Fazenda(){
		arrayVacas = new Vaca [1];
	}
	
	public void inserir (Vaca vaca){
		for (int i =0; i <= arrayVacas.length; i++){
			if(i == arrayVacas.length){
				Vaca [] aux = new Vaca [arrayVacas.length*2];
				for (int j = 0; j < arrayVacas.length; j++){
					aux[j] = arrayVacas[j];
				}
				this.arrayVacas = aux;
			}
			if(arrayVacas[i] == null){
				arrayVacas[i] = vaca;
				i = arrayVacas.length + 1;
			}
		}
	}
	//o metodo abaixo retorna todo o objeto
	public Vaca busca(int indice, Vaca[] array, Vaca vacaBuscada){
		if (indice == array.length) {
			return null; 
			
		}
		else if (array[indice].equals(vacaBuscada)) {
			return array[indice];
		}else{
			return busca(indice + 1, array, vacaBuscada);
		}
	}
	

}
