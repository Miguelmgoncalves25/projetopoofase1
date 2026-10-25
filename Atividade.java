
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Superclasse que representa uma atividade no ginasio.
 */
public class Atividade {
 
    private String nome;
    private Instrutor instrutor;
    private LocalDateTime data;
    private int dur_mins;
    private double custo_base;
    private String dadosExtra;

    /**
     * Construtor duma atividade do ginasio.
     *
     * @param nome Nome da atividade
     * @param instrutor Instrutor ou PT responsavel pela atividade
     * @param dur_mins Duracao prevista em minutos
     * @param data Data e hora agendadas para o inicio
     */
    public Atividade(String nome, Instrutor instrutor, int dur_mins, LocalDateTime data) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.dur_mins = dur_mins;
        this.data = data;
        this.custo_base = 0.0;
        this.dadosExtra = "";
    }

    /**
     * Devolve o nome da atividade.
     *
     * @return Nome da atividade
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Altera o nome da atividade.
     *
     * @param nome Novo nome da atividade
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o instrutor responsavel pela atividade.
     *
     * @return Instrutor
     */
    public Instrutor getInstrutor() {
        return this.instrutor;
    }
  
    /**
     * Modifica o instrutor responsavel pela atividade.
     *
     * @param instrutor Novo instrutor
     */
    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    /**
     * Devolve a duracao da atividade em minutos.
     *
     * @return Duracao em minutos
     */
    public int getDur_mins() {
        return this.dur_mins;
    }

    /**
     * Altera a duracao da atividade em minutos
     *
     * @param dur_mins nova duracao em minutos
     */
    public void setDur_mins(int dur_mins) {
        this.dur_mins = dur_mins;
    }

    /**
     * Devolve o custo base da sessao
     *
     * @return Custo base
     */
    public double getCusto_base() {
        return this.custo_base;
    }

    /**
     * Define o custo base da sessao.
     *
     * @param custo_base define custo, valor em euros
     */
    public void setCusto_base(double custo_base) {
        this.custo_base = custo_base;
    }

    /**
     * Devolve a data e hora de inicio da atividade.
     *
     * @return Data e hora de inicio
     */
    public LocalDateTime getData() {
        return this.data;
    }
  
    /**
     * Atualiza a data e hora de inicio da atividade.
     *
     * @param data Nova data e hora
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * Devolve os detalhes especificos da subclasse
     *
     * @return Descrição dos dados
     */
    public String getDadosExtra() {
        return this.dadosExtra;
    }

    /**
     * Atualiza os detalhes especificos da subclasse.
     *
     * @param dadosExtra Texto com informacao em falta
     */
    public void setDadosExtra(String dadosExtra) {
        this.dadosExtra = dadosExtra;
    }

    /**
     * Devolve uma linha com todas as informacoes da atividade.
     *
     * @return Descrição da atividade
     */
    public String getDados() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String dataTexto;
        if (this.data != null) {
            dataTexto = this.data.format(fmt);
        } else {
            dataTexto = "Sem horario";
        }

        String nomeProf;
        if (this.instrutor != null) {
            nomeProf = this.instrutor.getNome();
        } else {
            nomeProf = "Sem instrutor";
        }

        return "Atividade: " + this.nome + ", inicio: " + dataTexto + " , " + this.dur_mins + " min, instrutor: " + nomeProf + ", preco base: " + String.format("%.2f", this.custo_base) + " euros " + this.dadosExtra;
    }
}
