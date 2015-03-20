package classes.classes.DAO;


public class produtos {

    private int idproduto;
    private String descricao;
    private Double preco;
    private Double quantidade;
    private String mercado;
    private String fkcidade;
    private String fklista;
    public int getIdproduto() {
        return idproduto;
    }
    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    public String getMercado() {
        return mercado;
    }
    public void setMercado(String mercado) {
        this.mercado = mercado;
    }
    public String getFkcidade() {
        return fkcidade;
    }
    public void setFkcidade(String fkcidade) {
        this.fkcidade = fkcidade;
    }
    public String getFklista() {
        return fklista;
    }
    public void setFklista(String fklista) {
        this.fklista = fklista;
    }
    public produtos(int idproduto, String descricao, Double preco,
                    Double quantidade, String mercado, String fkcidade, String fklista) {
        super();
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.mercado = mercado;
        this.fkcidade = fkcidade;
        this.fklista = fklista;
    }


    public produtos(){

    }

    @Override
    public String toString() {
        return  descricao + "Preço: " + preco+ "Mercado: " +mercado;
    }
}
