import java.time.LocalDateTime;

/**
 * Representa uma aula de grupo com modalidade especifica e limite maximo de vagas.
 */
public class AulaGrupo extends Atividade {

    private String modalidade;
    private int capacidade_max;

    /**
     * Construtor de uma aula de grupo.
     *
     * @param nome Nome da aula
     * @param instrutor Instrutor que leciona a aula
     * @param dur_mins Duracao em minutos
     * @param data Data e hora de realizacao
     * @param modalidade Modalidade (Yoga, Spinning, Zumba ou CrossFit)
     * @param capacidade_max Lotacao maxima permitida na sala
     */
    public AulaGrupo(String nome, Instrutor instrutor, int dur_mins, LocalDateTime data, String modalidade, int capacidade_max) {
        super(nome, instrutor, dur_mins, data);
        this.modalidade = modalidade;
        this.capacidade_max = capacidade_max;
        atualizarTarifaeInfo();
    }
 
    /**
     * Determina o custo base e atualiza os dados extra.
     */
    private void atualizarTarifaeInfo() {
        double preco = 8.00;
        if (this.modalidade != null) {
            if (this.modalidade.equalsIgnoreCase("Yoga")) { preco = 8.00;}
            else if (this.modalidade.equalsIgnoreCase("Spinning")) {preco = 9.00;} 
            else if (this.modalidade.equalsIgnoreCase("Zumba")) { preco = 8.50;}
            else if (this.modalidade.equalsIgnoreCase("CrossFit")) {preco = 12.00; }
        }

        setCusto_base(preco);
        setDadosExtra("[Aula de grupo] Modalidade: " + this.modalidade + " | Lotacao maxima: " + this.capacidade_max + " vagas");
    }
  
    /**
     * Devolve a modalidade da aula de grupo
     *
     * @return Nome da modalidade
     */
    public String getModalidade() {
        return this.modalidade;
    }

    /**
     * Altera a modalidade da aula e recalcula o custo base.
     *
     * @param modalidade Nova modalidade
     */
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
        atualizarTarifaeInfo();
    }

    /**
     * Devolve a capacidade maxima da aula.
     *
     * @return Lotação máxima
     */
    public int getCapacidade_max() {
        return this.capacidade_max;
    }

    /**
     * Altera a capacidade máxima de participantes.
     *
     * @param capacidade_max Nova lotação máxima
     */
    public void setCapacidade_max(int capacidade_max) {
        this.capacidade_max = capacidade_max;
        atualizarTarifaeInfo();
    }
}