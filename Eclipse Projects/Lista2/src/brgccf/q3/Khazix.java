package brgccf.q3;

public class Khazix {
	private double life;
	private double armor;
	private double attackdmg;
	private double armorPenetrationKhazix;
	//atributos do personagem
	
	
	//atributo para ser utilizado em metodos
	
	
	public Khazix(double life, double armor, double attackdmg, double armorPenetration){
		this.life = life;
		this.armor = armor;
		this.attackdmg = attackdmg;
		this.armorPenetrationKhazix = armorPenetration;
		
		
	}
	//metodos get
	public double getLifeKhazix(){
		return this.life;
	}
	
	public double getArmorKhazix(){
		return this.armor;
	}
	
	public double getAttackDmgKhazix(){
		return this.attackdmg;
	}
	
	public double getArmorPenetrationKhazix(){
		return this.armorPenetrationKhazix;
	}
	
	
	//metodo Multiplicador de Redução
	public void reductionMultiplierKhazix(double armorRengar, double armorKhazix){
		if (armorKhazix >= 0){
			this.life -= this.life*(100/(100 + armorRengar));
		}
		else{
			this.life -= this.life*(2-(100/(100 - armorRengar)));
		}
	}
	
	//Skills:
	public void basicAttack(){
		this.attackdmg = 108.0;
	}
	
	public void tasteTheirFear(){
		this.attackdmg = 170.0 + (1.2*108.0);
	}
	
	public void voidSpike(){ 
		this.attackdmg = 200.0 + 108.0;
	}
	
	public void leap(){
		this.attackdmg = 205 + (0.2*108.0);
	}
	
	//Items:
		public void swordOfTheOccult(int stacks){
			this.attackdmg += 10;
			if(stacks < 20){
				this.attackdmg += 5*stacks;
			}
			else if (stacks == 20){
				this.attackdmg += 5*stacks;
				this.armorPenetrationKhazix += 0.1*this.armorPenetrationKhazix;
			}
			
		}
		
		public void bfSword(){
			this.attackdmg += 50;
		}
		
		public void theBloodthirster(){
			this.attackdmg += 80;
		}
		
		public void theBlackCleaver(int countBC){
			this.attackdmg += 50;
			if(countBC == 0){
				this.armorPenetrationKhazix += 10;
			}
			
		}
		
		public void bladeOfTheRuinedKing(int countBRK){
			this.attackdmg += 25;
			if (countBRK == 0){
				this.attackdmg += 0.08*2116.0;
			}
		}
		
		public void theBrutalizer(int countTB){
			this.attackdmg += 25;
			if(countTB == 0){
				this.armorPenetrationKhazix += 10;
			}
			
		}
		
		public double battleKhazix (){
			//os passos abaixo servem para todos os ataques
			//2º passo: verifica a PA do personagem
			double armorPen = this.getArmorPenetrationKhazix();
			Rengar rengar = new Rengar (2116.0, 85.4, 111.0, 0.0);
			//3º passo: subtrai da armadura do inimigo a PA do personagem encontrada
			double armorRengar = rengar.getArmorRengar();
			armorRengar -= armorPen;
			//4º passo: verifica a armadura do campeao e executa o multiplicador de Redução
			double armorKhazix = this.getArmorKhazix();
			rengar.reductionMultiplierRengar(armorRengar, armorKhazix);
			//5º passo:verifica com quanto de vida o inimigo ficou
			double lifeCha = rengar.getLifeRengar();
			//6º passo: subtrai o dano do ataque escolhido da vida do inimigo
			double damage = this.getAttackDmgKhazix();
			double attackOut = lifeCha - damage;
			// 7º passo: verifica o dano causado ao inimigo
			double dano = lifeCha - attackOut;
			damage = dano;
			
			
			
			
			return damage;
		}
		
		

}
