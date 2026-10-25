import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Classe gestora central da aplicacao 
 * Armazena as colecoes de instrutores, socios, atividades e marcacoes
 */
public class Ginasio {

    private ArrayList<Instrutor> listaInstrutores;
    private ArrayList<Socio> listaSocios;
    private ArrayList<Atividade> listaAtividades;
    private ArrayList<Marcacao> listaMarcacoes;
    private int numSociosIndividuais;
    private int numSociosEmpresa;
    private int numAulasGrupo;
    private int numSessoesPT;

    /**
     * Construtor que inicializa as colecoes vazias e coloca os contadores a zero.
     */
    public Ginasio() {
        this.listaInstrutores = new ArrayList<Instrutor>();
        this.listaSocios = new ArrayList<Socio>();
        this.listaAtividades = new ArrayList<Atividade>();
        this.listaMarcacoes = new ArrayList<Marcacao>();
        this.numSociosIndividuais = 0;
        this.numSociosEmpresa = 0;
        this.numAulasGrupo = 0;
        this.numSessoesPT = 0;
    }

    /**
     * Carrega os dados iniciais
     */
    public void carregarDados() {
        Instrutor inst1 = new Instrutor("Duarte Lopes", "Masculino","Licenciatura em Ciencias do Desporto, Certificacao CrossFit Nivel 2");
        adicionarInstrutor(inst1);

        Instrutor inst2 = new Instrutor("Diana Pereira", "Feminino","Doutoramento em Yoga, instrutora deZumba");
        adicionarInstrutor(inst2);
        Instrutor inst3 = new Instrutor("Goncalo Valente", "Masculino","Mestrado em Desporto, especialista em Spinning");
        adicionarInstrutor(inst3);


        SocioIndividual sInd1 = new SocioIndividual("Martim Figueiredo", 101, "martimfig@gmail.com", 2010);
        SocioIndividual sInd2 = new SocioIndividual("Beatriz Lacerda", 102, "bialacerda@outlook.pt", 1996);
        SocioIndividual sInd3 = new SocioIndividual("Afonso Vasconcelos", 103, "afonsovasc@sapo.pt", 1958);

        adicionarSocioIndividual(sInd1);
        adicionarSocioIndividual(sInd2);
        adicionarSocioIndividual(sInd3);

        SocioEmpresa sEmp1 = new SocioEmpresa("Raquel Tavares", 201, "rtavares@criticalsoftware.com","Critical Software", 504276329);
        SocioEmpresa sEmp2 = new SocioEmpresa("Tiago Monteiro", 202, "tmonteiro@banzai.com","Banzai Portugal", 508914210);
        SocioEmpresa sEmp3 = new SocioEmpresa("Ines Guerreiro", 203, "ines.g@bluepharma.pt","Bluepharma", 503692184);
        adicionarSocioEmpresa(sEmp1);
        adicionarSocioEmpresa(sEmp2);
        adicionarSocioEmpresa(sEmp3);

        
        

        AulaGrupo ag1 = new AulaGrupo("Yoga", inst2, 60,LocalDateTime.of(2026, 11, 2, 9, 0), "Yoga", 15);
        adicionarAulaGrupo(ag1);
        AulaGrupo ag2 = new AulaGrupo("Spinning", inst3, 45, LocalDateTime.of(2026, 11, 2, 18, 30), "Spinning", 20);
        adicionarAulaGrupo(ag2);
        AulaGrupo ag3 = new AulaGrupo("Zumba", inst2, 50,LocalDateTime.of(2026, 11, 3, 19, 0), "Zumba", 25);
        adicionarAulaGrupo(ag3);
        AulaGrupo ag4 = new AulaGrupo("Crossfit", inst1, 60, LocalDateTime.of(2026, 11, 4, 20, 0), "CrossFit", 12);
        adicionarAulaGrupo(ag4);

        //localdatetime(ano, mes, dia, hora, minuto)
        SessaoPT pt1 = new SessaoPT("PT Abdominais", inst2, 45,LocalDateTime.of(2026, 11, 5, 10, 0), "Iniciacao");
        adicionarSessaoPT(pt1);
        SessaoPT pt2 = new SessaoPT("PT Flexibilidade", inst1, 60,LocalDateTime.of(2026, 11, 5, 15, 0), "Intermedio");
        adicionarSessaoPT(pt2);
        SessaoPT pt3 = new SessaoPT("PT Corpo superior", inst3, 60, LocalDateTime.of(2026, 11, 6, 11, 0), "Avançado");
        adicionarSessaoPT(pt3);
        SessaoPT pt4 = new SessaoPT("PT Core", inst1, 45,LocalDateTime.of(2026, 11, 6, 17, 0), "Iniciacao");
        adicionarSessaoPT(pt4);


        criarMarcacao(101, "CrossFit", LocalDateTime.of(2026, 11, 4, 20, 0));
        criarMarcacao(201, "CrossFit", LocalDateTime.of(2026, 11, 4, 20, 0));
        criarMarcacao(103, "CrossFit", LocalDateTime.of(2026, 11, 4, 20, 0));
        criarMarcacao(102, "Yoga", LocalDateTime.of(2026, 11, 2, 9, 0));
        criarMarcacao(202, "PT Flexibilidade", LocalDateTime.of(2026, 11, 6, 11, 0));
        criarMarcacao(203, "Spinning", LocalDateTime.of(2026, 11, 2, 18, 30));
    }

    /**
     * Regista um novo instrutor na lista do ginasio
     *
     * @param instrutor Objeto Instrutor a adicionar
     */

    public void adicionarInstrutor(Instrutor instrutor) {
        if (instrutor != null) {
            this.listaInstrutores.add(instrutor);
        }
    }

    /**
     * Regista um socio individual e sobe o contador das estatisticas
     *
     * @param socio Objeto SocioIndividual a adicionar
     */

    public void adicionarSocioIndividual(SocioIndividual socio) {
        if (socio != null) {
            this.listaSocios.add(socio);
            this.numSociosIndividuais++;
        }
    }

    /**
     * Regista um socio empresario e adiciona no contador
     *
     * @param socio Objeto SocioEmpresa a adicionar
     */

    public void adicionarSocioEmpresa(SocioEmpresa socio) {
        if (socio != null) {
            this.listaSocios.add(socio);
            this.numSociosEmpresa++;
        }
    }

    /**
     * Regista uma aula de grupo e incrementa o contador
     *
     * @param aula Objeto AulaGrupo a adicionar
     */

    public void adicionarAulaGrupo(AulaGrupo aula) {
        if (aula != null) {
            this.listaAtividades.add(aula);
            this.numAulasGrupo++;
        }
    }

    /**
     * Regista uma sessao de PT e incrementa o contador
     * @param sessao objeto SessaoPT a adicionar
     */

    public void adicionarSessaoPT(SessaoPT sessao) {
        if (sessao != null) {
            this.listaAtividades.add(sessao);
            this.numSessoesPT++;
        }
    }

    /**
     * Procura um socio pelo seu numero
     *
     * @param nsocio Numero do socio a pesquisar
     * @return Objeto Socio correspondente ou null caso nao exista
     */

    public Socio procurarSocio(int nsocio) {
        for (Socio s : this.listaSocios) {
            if (s.getNsocio() == nsocio) {
                return s;
            }
        }
        return null;
    }

    /**
     * Procura uma atividade pelo nome 
     *
     * @param nomeAtividade Nome da atividade  
     * @return Objeto Atividade correspondente ou null se nao for encontrada
     */

    public Atividade procurarAtividade(String nomeAtividade) {
        for (Atividade a : this.listaAtividades) {
            if (a.getNome().equalsIgnoreCase(nomeAtividade.trim())) { // .trim para evitar erros de espaços 
                return a;
            }
        }
        return null; 
    }

    /**
     * Procura um instrutor pelo nome
     *
     * @param nomeInstrutor Nome do instrutor a encontrar
     * @return Objeto Instrutor ou null se nao existir
     */

    public Instrutor procurarInstrutor(String nomeInstrutor) {
        for (Instrutor inst : this.listaInstrutores) {
            if (inst.getNome().equalsIgnoreCase(nomeInstrutor.trim())) {
                return inst;
            }
        }
        return null;
    }

    /**
     * lista os instrutores disponiveisna para a criacao de atividades.
     */

    public void listarInstrutores() {
        if (this.listaInstrutores.isEmpty()) {
            System.out.println("Nao existem instrutores registados.");
            return;
        }
        System.out.println("\n--- INSTRUTORES REGISTADOS ---");
        for (Instrutor i : this.listaInstrutores) {
            System.out.println(i.getDados());
        }
    }

    /**
     * Cria e guarda uma marcacao associando um socio a uma atividade numa data e hora
     *
     * @param nsocio        Numero do socio
     * @param nomeAtividade Nome da atividade 
     * @param data          Data e hora da marcação
     * @return Objeto Marcacao criado ou null se o socio ou atividade nao existirem
     */

    public Marcacao criarMarcacao(int nsocio, String nomeAtividade, LocalDateTime data) {
        Socio socioEncontrado = procurarSocio(nsocio);
        if (socioEncontrado == null) {
            return null;
        }

        Atividade atividadeEncontrada = procurarAtividade(nomeAtividade);
        if (atividadeEncontrada == null) {
            return null;
        }

        Marcacao novaMarcacao = new Marcacao(socioEncontrado, atividadeEncontrada, data);
        this.listaMarcacoes.add(novaMarcacao);
        return novaMarcacao;
    }

    /**
     * lista todos os socios registados e os seus dados
     */

    public void listarSocios() {
        System.out.println("\n================ LISTA DE SOCIOS ("+ this.listaSocios.size() +") ================");
        if (this.listaSocios.isEmpty()) {
            System.out.println("Nenhum socio registado no ginasio");
            return;
        }
        for (Socio s : this.listaSocios) {
            System.out.println(s.getDados());
        }
    }

    /**
     * mostra todas as atividades registadas com os dados de cada
     */

    public void listarAtividades() {
        System.out.println("\n============== LISTA DE ATIVIDADES ("+ this.listaAtividades.size() +") ==============");
        if (this.listaAtividades.isEmpty()) {
            System.out.println("Nenhuma atividade registada no ginasio.");
            return;
        }
        for (Atividade a : this.listaAtividades) {
            System.out.println(a.getDados());
        }
    }

    /**
     * Apresenta todas as marcacoes , os custos e o total faturado
     */

    public void listarMarcacoes() {
        System.out.println("\n============== REGISTO DE MARCAÇÕES ("+ this.listaMarcacoes.size() +") ==============");
        if (this.listaMarcacoes.isEmpty()) {
            System.out.println("Nao existem marcações registadas.");
            return;
        }

        double faturacaoAcumulada = 0.0;
        for (Marcacao m : this.listaMarcacoes) {
            System.out.println(m.getDados());
            faturacaoAcumulada += m.getCustoFinal();
        }
        System.out.printf("total faturado pelo ginasio: %.2f EUR%n", faturacaoAcumulada);
    }

    /**
     * Apresenta o numero de registos existentes para cada tipo de socio e atividade
     */

    public void mostrarResumo() {
        System.out.println("\n================ RESUMO GERAL DO GINASIO ================");
        System.out.println("Socios individuais: " + this.numSociosIndividuais
                + ", Socios empresa: " + this.numSociosEmpresa);
        System.out.println("Aulas de grupo: " + this.numAulasGrupo
                + ", Sessoes de PT: " + this.numSessoesPT);
    }

    /**
     * Determina e lista qual a atividade com mais marcações associadas.
     */

    public void mostrarAtividadeMaisPopular() {
        System.out.println("\n================ ATIVIDADE MAIS POPULAR ================");
        if (this.listaAtividades.isEmpty() || this.listaMarcacoes.isEmpty()) {
            System.out.println("Ainda não existem marcações suficientes haver popularidade.");
            return;
        }

        Atividade maisProcurada = null;
        int recorde = 0;

        for (int i = 0; i < this.listaAtividades.size(); i++) {
            Atividade ativ= this.listaAtividades.get(i);
            int contagem = 0;

            for (int j = 0; j < this.listaMarcacoes.size(); j++) {
                Marcacao m = this.listaMarcacoes.get(j);
                if (m.getAtividade() == ativ) {
                    contagem++;
                }
            }

            if (contagem > recorde) {
                recorde = contagem;
                maisProcurada = ativ;
            }
        }

        if (maisProcurada != null) {
            System.out.println("Vencedora (" + recorde + " marcações): " + maisProcurada.getDados() );
        } else {
            System.out.println("Nenhuma atividade possui marcações associadas.");
        }
    }

    /**
     * mostra para um dado numero de socio, o valor total gasto no ginasio e o valor total poupado com o desconto
     *
     * @param nsocio Numero do socio a verificar
     */

    public void mostrarValoresSocio(int nsocio) {
        Socio alvo = procurarSocio(nsocio);
        if (alvo == null) {
            System.out.println("Erro: Nao existe nenhum socio com o numero #" + nsocio + ".");
            return;
        }

        double totalgasto = 0.0;
        double totalpoupado = 0.0;
        int numeroReservas = 0;

        for (Marcacao m : this.listaMarcacoes) {
            if (m.getSocio().getNsocio() == nsocio) {
                totalgasto += m.getCustoFinal();
                totalpoupado += m.getValorPoupado();
                numeroReservas++;
            }
        }

        System.out.println("\n--- Extrato do sócio número: " + nsocio + " ---");
        System.out.println("Nome: " + alvo.getNome());
        System.out.println("Marcacoes efetuadas: " + numeroReservas);
        System.out.printf("Valor Total Gasto no Ginasio:   %.2f EUR%n", totalgasto);
        System.out.printf("Valor Total Poupado (Desconto): %.2f EUR%n", totalpoupado);
    }
}