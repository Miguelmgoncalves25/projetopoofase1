import java.time.LocalDate;

/**
 * Representa um socio individual cujo desconto depende da idade.
 */

public class SocioIndividual extends Socio {

    private int anoNascimento;

    /**
     * Construtor de um socio individual
     *
     * @param nome Nome do socio
     * @param nsocio Numero unico do socio
     * @param email Endereco de email
     * @param anoNascimento Ano de nascimento do socio
     */
    public SocioIndividual(String nome, int nsocio, String email, int anoNascimento) {
        super(nome, nsocio, email);
        this.anoNascimento = anoNascimento;
        atualizarDesconto();
    }

    /**
     * Método que recalcula o desconto e atualiza os dados na superclasse.
     * Menores recebem 10%, maiores de 65 recebem 15
     */

    private void atualizarDesconto() {
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - this.anoNascimento;
        double taxa = 0.0;

        if (idade < 18) { taxa = 0.10; }
            else if (idade >= 65) { taxa = 0.15; }
        
        setDesconto(taxa);
        setDadosExtra("Tipo individual, nascido em " + this.anoNascimento + "," + idade + " anos");
    }

    /**
     * retorna o ano de nascimento do socio individual
     *
     * @return Ano de nascimento
     */

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    /**
     * Troca o ano de nascimento e atualiza o desconto 
     *
     * @param anoNascimento novo ano de nascimento
     */

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
        atualizarDesconto();
    }
}
