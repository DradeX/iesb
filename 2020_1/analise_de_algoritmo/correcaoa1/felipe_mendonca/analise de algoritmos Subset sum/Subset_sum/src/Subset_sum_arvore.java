
public class Subset_sum_arvore {
	
	public String[] vet_valores = new String[0];
	public float[] vetfloat = new float[0];
	public float valor_max = 0;
	public float somatorio;
	
	Subset_sum_arvore (float[] vetfloat,float somatorio) {
		this.setVetfloat(vetfloat);
		this.setSomatorio(somatorio);
		this.obter_valor_max();
	}
	
	public boolean existe_o_somatorio_arvore(Arvore_n� arvore_n�, int intera��o,String valores) {
		if(arvore_n�.getValor_somado() == this.getSomatorio()) {
			add_vet_valores(valores);
			return true;
		}
		else if(arvore_n�.getValor_restante()==0) {
			return false;
		}
		else {
			boolean ignora = existe_o_somatorio_arvore(new Arvore_n�(arvore_n�.getValor_restante()-Math.abs(this.getVetfloat()[intera��o]),arvore_n�.getValor_somado()),intera��o+1,valores);
			boolean considera = existe_o_somatorio_arvore(new Arvore_n�(arvore_n�.getValor_restante()-Math.abs(this.getVetfloat()[intera��o]),arvore_n�.getValor_somado()+this.getVetfloat()[intera��o]),
					intera��o+1,valores+this.getVetfloat()[intera��o]+" ");
			return ignora || considera;
		}
	}
	
	private void obter_valor_max() {
		for(int i = 0;i<this.getVetfloat().length;i++) {
			this.setValor_max(this.getValor_max() + Math.abs(this.getVetfloat()[i]));
		}
	}
	
	private void add_vet_valores(String valores) {
		String[] vet_valores_aux = new String[this.getVet_valores().length+1];
		for(int i=0;i<this.getVet_valores().length;i++) {
			vet_valores_aux[i] = this.getVet_valores()[i];
		}
		vet_valores_aux[this.getVet_valores().length] = valores;
		this.setVet_valores(vet_valores_aux);
	}
	
	private void show_valores_somatorio() {
		for(int i=0;i<this.getVet_valores().length;i++) {
			System.out.println(this.getVet_valores()[i]);
		}
	}
	
	public void existe_somatorio_mais_numeros() {
		if(this.existe_o_somatorio_arvore(new Arvore_n�(this.getValor_max(),0),0,"")) {
			System.out.println("\nExiste o somatorio desejado!!!");
			this.show_valores_somatorio();
		}
		else {
			System.out.println("\nN�o existe o somatorio desejado");
		}
	}

	public String[] getVet_valores() {
		return vet_valores;
	}

	public void setVet_valores(String[] vet_valores) {
		this.vet_valores = vet_valores;
	}

	public float[] getVetfloat() {
		return vetfloat;
	}

	public void setVetfloat(float[] vetfloat) {
		this.vetfloat = vetfloat;
	}

	public float getValor_max() {
		return valor_max;
	}

	public void setValor_max(float valor_max) {
		this.valor_max = valor_max;
	}

	public float getSomatorio() {
		return somatorio;
	}

	public void setSomatorio(float somatorio) {
		this.somatorio = somatorio;
	}

}
