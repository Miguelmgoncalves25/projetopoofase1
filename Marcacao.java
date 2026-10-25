import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa a inscricao  dum socio numa atividade.
 * Calcula e armazena o valor pago e o montante poupado pelo socio.
 */

public class Marcacao {

    private Socio socio;
    private Atividade atividade;
    private LocalDateTime dataHora;
    private double custoFinal;
    private double valorPoupado;

    /**
     * Construtor de uma marcação, calcula o desconto e o preço final.
     *
     * @param socio   ocio que efetua a reserva
     * @param atividade Atividade na qual o socio se inscreve
     * @param dataHora Data e hora associadas ao registo da marcação
     */
    public Marcacao(Socio socio, Atividade atividade, LocalDateTime dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = dataHora;

        double precoBase = atividade.getCusto_base();
        double taxaDesconto = socio.getDesconto();

        this.valorPoupado = precoBase * taxaDesconto;
        this.custoFinal = precoBase - this.valorPoupado;
    }

    /**
     * Devolve o socio da marcação
     *
     * @return Objeto Socio
     */
    public Socio getSocio() {
        return this.socio;
    }

    /**
     * Devolve a atividade associada à marcação
     *
     * @return Objeto Atividade
     */
    public Atividade getAtividade() {
        return this.atividade;
    }

    /**
     * Devolve a data e hora da marcação
     *
     * @return Objeto LocalDateTime
     */
    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    /**
     * Devolve o custo final cobrado ao socio apos o desconto.
     *
     * @return Valor pago em euros
     */
    public double getCustoFinal() {
        return this.custoFinal;
    }

    /**
     * Devolve o montante poupado pelo socio nesta marcação devido ao desconto.
     *
     * @return valor poupado em euros
     */
    public double getValorPoupado() {
        return this.valorPoupado;
    }

    /**
     * Devolve o resumo da marcacao e os valores.
     *
     * @return Linha com os dados da marcacao
     */

    public String getDados() {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String registoTempo;

    if (this.dataHora != null) {
        registoTempo = this.dataHora.format(fmt);
    } else {
        registoTempo = "N/D";
    }

    return "Data/Hora: " + registoTempo + ", socio: " + this.socio.getNome() + ", número: " + this.socio.getNsocio() + ", atividade: " + this.atividade.getNome() + ", com o custo: " + String.format("%.2f", this.custoFinal) + " euros" + ", poupanca de: " + String.format("%.2f", this.valorPoupado) + " euros"; }

}