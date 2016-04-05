package hierarquia;

public class Programa {
	public static void main (String [] args){
		
		Circulo circulo = new Circulo(4);
		System.out.println(circulo.toString());
		Triangulo triangulo = new Triangulo(10, 5);
		System.out.println(triangulo.toString());
		
		Quadrado quadrado = new Quadrado (5);
		System.out.println(quadrado.toString());
		
		
		Esfera esfera = new Esfera(4);
		System.out.println(esfera.toString());
		
		Tetraedro tetraedro = new Tetraedro (3, 5, 8);
		System.out.println(tetraedro.toString());
		
		Cubo cubo = new Cubo(5, 8);
		System.out.println(cubo.toString());
		
		
		
			
	
		
		
		
	}

}
