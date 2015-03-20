package classes.classes.DAO;

public class listascompras {

    private int idlista;
    private String nomelista;
    private String emailista;

    //usuarios usuarios = new usuarios();


    public listascompras(int idlista, String nomelista, String emailista) {
        this.idlista = idlista;
        this.nomelista = nomelista;
        this.emailista = emailista;
    }

    public String getEmailista() {
        return emailista;
    }


    public void setEmailista(String emailista) {
        this.emailista = emailista;
    }









    public int getIdlista() {
        return idlista;
    }
    public void setIdlista(int idlista) {
        this.idlista = idlista;
    }
    public String getNomelista() {
        return nomelista;
    }
    public void setNomelista(String nomelista) {
        this.nomelista = nomelista;
    }
    public listascompras(int idlista, String nomelista) {
        super();
        this.idlista = idlista;
        this.nomelista = nomelista;
    }


    public listascompras(){

    }

    @Override
    public String toString() {
        return nomelista;
    }
}
