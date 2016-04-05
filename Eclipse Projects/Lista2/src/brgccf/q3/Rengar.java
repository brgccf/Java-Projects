package brgccf.q3;

public class Rengar {
	private double life;
	private double armor;
	private double attackdmg;
	private double armorPenetrationRengar;
	//atributos do personagem
	
	public Rengar (double life, double armor, double attackdmg, double armorPenetration){
		this.life = life;
		this.armor = armor;
		this.attackdmg = attackdmg;
		this.armorPenetrationRengar = armorPenetration;
	}
	
	//metodos get
	public double getLifeRengar(){
		return this.life;
	}
	
	public double getArmorRengar(){
		return this.armor;
	}
	
	public double getAttackDmgRengar(){
		return this.attackdmg;
	}
	
	public double getArmorPenetrationRengar(){
		return this.armorPenetrationRengar;
	}
	
	
	//metodo Multiplicador de Redução
	public void reductionMultiplierRengar(double armorRengar, double armorKhazix){
		if (armorRengar >= 0){
			this.life -= this.life*(100/(100 + armorKhazix));
		}
		else{
			this.life -= this.life*(2-(100/(100 - armorKhazix)));
		}
		
	}
	
	
	//Skills:
	public void basicAttack(int a){
		if (a == 0){
			this.attackdmg = 111.0;
		}
		else{
			this.attackdmg += 0.2*this.attackdmg;
		}
	}
	
	public void savagery(){
		this.attackdmg = 150.0 + (0.2*111.0);
	}
	
	public void empoweredSavagery(){ 
		this.attackdmg = 240.0 + (0.5*111.0);
	}
	
	public void bolaStrike(){
		this.attackdmg = 250 + (0.7*111.0);
	}
	
	//Items:
	public void chainVest(){
		this.armor += 40;
	}
	
	public void ninjaTabi(int countNT){
		this.armor += 25;
		if (countNT == 0){
			this.armor += 0.1*this.armor;
		}
		
	}
	
	public void randuinsOmen(){
		this.armor += 70;
		this.life += 500;
	}
	
	public void tornmail(){
		this.armor += 100;
	}
	
	public void seekerArmsGuard(int stacks){
		this.armor += 30;
		if(stacks < 30){
			this.armor += 0.5*stacks;
		}
		else if(stacks == 30){
			this.armor += 0.5*stacks;
			basicAttack(1);
		}
	}
	
	public void sunfireCape(){
		this.armor += 45;
		this.life += 450;
	}
	
	public double battleRengar(){
		//segue os mesmos passos da batalha com khazix
		double armorPen = this.getArmorPenetrationRengar();
		Khazix khazix = new Khazix (2018.0, 75.0, 108.0, 0);
		double armorKhazix = khazix.getArmorKhazix();
		armorKhazix -= armorPen;
		double armorRengar = this.getArmorRengar();
		khazix.reductionMultiplierKhazix(armorRengar, armorKhazix);
		double lifeCha = khazix.getLifeKhazix();
		
		double damage = this.getAttackDmgRengar();
		double attackOut = lifeCha - damage;
		double dano = lifeCha - attackOut;
		damage = dano;
		
		
		return damage;
		
	}
	
	
	

}
