/**
 * Representa um socio empresario
 */
public class SocioEmpresa extends Socio {

    private String nomeEmpresa;
    private int nif;

    /** Construtor dum socio empresario
     * 
     * @param nome Nome do socio
     * @param nsocio Numero de socio
     * @param email Email do socio
     * @param nomeEmpresa Nome da Empresa
     * @param nif Numero Contribuinte da empresa
     */

    public SocioEmpresa(String nome, int nsocio, String email, String nomeEmpresa, int nif) {
        super(nome, nsocio, email);
        this.nomeEmpresa = nomeEmpresa;
        this.nif = nif;
        setDesconto(0.20);
        atualizarResumo();
    }

    /**
     * atualiza os dados do socio
     */

    private void atualizarResumo() {
        setDadosExtra("Tipo:  Empresa | Entidade: " + this.nomeEmpresa + " (NIF: " + this.nif + ")");
    }

    /**
     * Devolve o nome da empresa
     *
     * @return Nome da empresa parceira
     */

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    /**
     * Atualiza o nome da empresa parceira
     *
     * @param nomeEmpresa Nova designacao da empresa
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        atualizarResumo();
    }

    /**
     * Devolve o NIF da empresa parceira
     *
     * @return NIF da empresa
     */

    public int getNif() {
        return this.nif;
    }

    /**
     * Atualiza o NIF da empresa parceira.
     *
     * @param nif Novo NIF da empresa
     */

    public void setNif(int nif) {
        this.nif = nif;
        atualizarResumo();
    }
}