/**
 * Representa um instrutor ou pt ao servico do ginasio.
 * Guarda os dados pessoais e a sua formacao 
 */
public class Instrutor {

    private String nome;
    private String genero;
    private String formacao;

    /**
     * Construtor do instrutor
     *
     * @param nome Nome do instrutor
     * @param genero Genero do instrutor
     * @param formacao Formacao do instrutor
     */
    public Instrutor(String nome, String genero, String formacao) {
        this.nome = nome;
        this.genero = genero;
        this.formacao = formacao;
    }

    /**
     * Devolve o nome do instrutor.
     *
     * @return Nome do instrutor
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Atualiza o nome do instrutor
     *
     * @param nome Novo nome a atribuir
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o genero do instrutor.
     *
     * @return Genero registado
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * Atualiza o genero do instrutor.
     *
     * @param genero Novo genero a atribuir
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Devolve a lista de formacoes e cursos do instrutor
     *
     * @return Descricao da formacao
     */

    public String getFormacao() {
        return this.formacao;
    }

    /**
     * Atualiza a descricao de formacoes do instrutor.
     *
     * @param formacao Nova descricao de cursos
     */

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    /**
     * Perfil completo do instrutor
     *
     * @return Texto com nome, genero e formacao
     */

    public String getDados() {
        return this.nome + " (" + this.genero + ") | Habilitacoes: " + this.formacao;
    }
}