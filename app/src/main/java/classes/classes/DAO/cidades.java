package classes.classes.DAO;

public class cidades {

	private int idcidade;
	private String nomecidade;
	public int getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}
	public String getNomecidade() {
		return nomecidade;
	}
	public void setNomecidade(String nomecidade) {
		this.nomecidade = nomecidade;
	}
	public cidades(int idcidade, String nomecidade) {
		super();
		this.idcidade = idcidade;
		this.nomecidade = nomecidade;
	}
	
	public cidades(){
		
	}

    @Override
    public String toString() {
        return nomecidade;
    }

}
