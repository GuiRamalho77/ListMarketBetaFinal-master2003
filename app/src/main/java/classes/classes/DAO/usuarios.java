package classes.classes.DAO;

public class usuarios {
	
	private int idusuario;
	private String nomeusuario;
	private String email;
	private String senha;
	private int idcidade_usuario;
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNomeusuario() {
		return nomeusuario;
	}
	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdcidade_usuario() {
		return idcidade_usuario;
	}
	public void setIdcidade_usuario(int idcidade_usuario) {
		this.idcidade_usuario = idcidade_usuario;
	}
	public usuarios(int idusuario, String nomeusuario, String email,
			String senha, int idcidade_usuario) {
		super();
		this.idusuario = idusuario;
		this.nomeusuario = nomeusuario;
		this.email = email;
		this.senha = senha;
		this.idcidade_usuario = idcidade_usuario;
	}

    public usuarios(String email){
        super();
        this.email = email;

    }

    public usuarios(){

    }
	

}
