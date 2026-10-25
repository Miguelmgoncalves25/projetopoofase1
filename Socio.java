/**
 * Superclasse de um socio normal
 */

public class Socio {

    private String nome;
    private int nsocio;
    private String email;
    private double desconto;
    private String dadosExtra;

    /**
     * Construtor do socio
     *
     * @param nome   Nome do socio
     * @param nsocio Numero unico do socio
     * @param email  Email do socio
     */

    public Socio(String nome, int nsocio, String email) {
        this.nome = nome;
        this.nsocio = nsocio;
        this.email = email;
        this.desconto = 0.0;
        this.dadosExtra = "";
    }

    /**
     * Devolve o nome do socio.
     *
     * @return Nome do socio
     */

    public String getNome() {
        return this.nome;
    }

    /**
     * muda o nome do socio.
     *
     * @param nome Novo nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o numero unico do socio.
     *
     * @return Numero de socio
     */

    public int getNsocio() {
        return this.nsocio;
    }

    /**
     * Muda o numero unico do socio.
     *
     * @param nsocio Novo numero de socio
     */

    public void setNsocio(int nsocio) {
        this.nsocio = nsocio;
    }

    /**
     * Devolve o email do socio.
     *
     * @return Endereco de email
     */

    public String getEmail() {
        return this.email;
    }

    /**
     * Atualiza o email de contacto 
     *
     * @param email Novo endereco de email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devolve a taxa de desconto aplicavel ao socio
     *
     * @return Valor do desconto em double
     */

    public double getDesconto() {
        return this.desconto;
    }

    /**
     * Define a taxa de desconto do socio
     *
     * @param desconto Valor do desconto
     */

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * Devolve a informacao adicional associada ao tipo de socio.
     *
     * @return Texto com os dados especificos da subclasse
     */

    public String getDadosExtra() {
        return this.dadosExtra;
    }

    /**
     * Atualiza a informacao adicional associada ao subtipo de socio.
     *
     * @param dadosExtra Texto com os dados adicionais
     */

    public void setDadosExtra(String dadosExtra) {
        this.dadosExtra = dadosExtra;
    }

    /**
     * Devolve os dados do socio para ser listado
     *
     * @return Dados do socio
     */

    public String getDados() {
        int percentagem = (int) Math.round(this.desconto * 100);
        return "[Socio #" + this.nsocio + "] " + this.nome
                + " | E-mail: " + this.email
                + " | Desconto: " + percentagem + "% | " + this.dadosExtra;
    }
}