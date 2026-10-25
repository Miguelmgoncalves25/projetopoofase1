import java.time.LocalDateTime;

/**
 * Representa uma sessao individual de personal training, classificada por nivel de dificuldade.
 */
public class SessaoPT extends Atividade {

    private String nivel;

    /**
     * Construtor de uma sessao de PT, o custo base depende do nivel
     *
     * @param nome Nome da sessao de treino
     * @param instrutor PT responsavel
     * @param dur_mins Duracao do treino em minutos
     * @param data Data e hora da sessão
     * @param nivel Nivel de intensidade (Iniciacao, Intermedio ou Avançado)
     */
    public SessaoPT(String nome, Instrutor instrutor, int dur_mins, LocalDateTime data, String nivel) {
        super(nome, instrutor, dur_mins, data);
        this.nivel = nivel;
        atualizarTarifaNivel();
    }

    /**
     * Define o preco de personal training consoante o nivel.
     */
    private void atualizarTarifaNivel() {
        double preco = 18.00;
        if (this.nivel != null) {
            if (this.nivel.equalsIgnoreCase("Iniciacao") || this.nivel.equalsIgnoreCase("Iniciante")) {
                preco = 18.00;
            } else if (this.nivel.equalsIgnoreCase("Intermedio")) {
                preco = 22.00;
            } else if (this.nivel.equalsIgnoreCase("Avançado")) {
                preco = 28.00;
            }
        }
        setCusto_base(preco);
        setDadosExtra("Nivel de PT: " + this.nivel);
    }

    /**
     * Devolve o nivel de intensidade da sessao
     *
     * @return Nivel do treino
     */
    public String getNivel() {
        return this.nivel;
    }

    /**
     * Atualiza o nivel de intensidade e recalcula o custo base
     *
     * @param nivel Novo nivel (Iniciacao, Intermedio ou Avançado)
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
        atualizarTarifaNivel();
    }
}