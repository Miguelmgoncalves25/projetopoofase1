import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe principal que gere o input com o utilizador.
 */
public class POOGym {

    private Ginasio ginasio;
    private Scanner leitor;
    private DateTimeFormatter formatoDataHora;

    /**
     * Construtor inicia o ginasio e carrega os dados de demonstracao.
     */
    public POOGym() {
        this.ginasio = new Ginasio();
        this.leitor = new Scanner(System.in);
        this.formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.ginasio.carregarDados();
    }

    /**
     * Ponto de entrada da aplicacao Java.
     *
     * @param args Argumentos da linha de comandos
     */
    public static void main(String[] args) {
        POOGym aplicacao = new POOGym();
        aplicacao.iniciarInterface();
    }

    /**
     * Inicia o menu principal.
     */
    public void iniciarInterface() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=======================================================");
            System.out.println("                POOGym - Gestao de Ginasio             ");
            System.out.println("=======================================================");
            System.out.println("  1. Registar socio (Individual ou Empresa)");
            System.out.println("  2. Registar instrutor / Personal Trainer"); 
            System.out.println("  3. Registar atividade (Aula de Grupo ou Sessao PT)");
            System.out.println("  4. Listar socios");
            System.out.println("  5. Listar atividades");
            System.out.println("  6. Criar marcacao");
            System.out.println("  7. Listar marcacoes e total faturado"); 
            System.out.println("  8. Resumo de atividades e socios");
            System.out.println("  9. Atividade mais popular");
            System.out.println(" 10. Valores gastos e poupados por socio");
            System.out.println("  0. Sair da aplicacao");
            System.out.println("=======================================================");

            System.out.print("Escolha uma opcao: ");
            opcao = this.leitor.nextInt();
            this.leitor.nextLine();

            switch (opcao) {
                case 1:
                    menuRegistarSocio();
                    break;  
                case 2:
                    menuRegistarInstrutor();
                    break; 
                case 3:
                    menuRegistarAtividade();
                    break;
                case 4:
                    this.ginasio.listarSocios();
                    break;
                case 5:
                    this.ginasio.listarAtividades();
                    break;
                case 6:
                    menuCriarMarcacao();
                    break;
                case 7:
                    this.ginasio.listarMarcacoes();
                    break;
                case 8:
                    this.ginasio.mostrarResumo();
                    break;
                case 9:
                    this.ginasio.mostrarAtividadeMaisPopular();
                    break;
                case 10:
                    System.out.print("Introduza o numero unico do socio: ");
                    int numero = this.leitor.nextInt();
                    this.leitor.nextLine();
                    this.ginasio.mostrarValoresSocio(numero);
                    break;
                case 0:
                    System.out.println("Ate a proxima.");
                    break;
                default:
                    System.out.println("Opcao invalida, tente outra vez.");
                    break;
            }
        }
    }

    /**
     * Recolhe os dados do utilizador para registar um socio individual ou empresa.
     */
    private void menuRegistarSocio() {
        System.out.println("\n--- REGISTAR NOVO SOCIO ---");
        System.out.print("Tipo de Socio (1 - Individual | 2 - Empresa): ");
        int tipo = this.leitor.nextInt();
        this.leitor.nextLine();

        if (tipo != 1 && tipo != 2) {   
            System.out.println("Erro: Tipo de socio invalido.");
            return;
        }

        System.out.print("Numero de socio (unico): "); 
        int nsocio = this.leitor.nextInt();
        this.leitor.nextLine();

        if (this.ginasio.procurarSocio(nsocio) != null) {
            System.out.println("Erro: Ja existe um socio registado com o numero #" + nsocio + ".");
            return;
        }

        System.out.print("Nome completo: ");
        String nome = this.leitor.nextLine();

        System.out.print("E-mail: ");
        String email = this.leitor.nextLine();

        if (nome.isEmpty() || email.isEmpty()) {
            System.out.println("Erro: O nome e o e-mail nao podem ficar vazios.");
            return;
        }
  
        if (tipo == 1) {
            System.out.print("Ano de nascimento (ex: 2004): ");
            int anoNasc = this.leitor.nextInt();
            this.leitor.nextLine();

            SocioIndividual novoInd = new SocioIndividual(nome, nsocio, email, anoNasc);
            this.ginasio.adicionarSocioIndividual(novoInd); 
            System.out.println("Socio individual registado com sucesso! " + novoInd.getDados());
        } else {
            System.out.print("Nome da empresa parceira: ");
            String empresa = this.leitor.nextLine();

            System.out.print("NIF da empresa: ");
            int nif = this.leitor.nextInt();
            this.leitor.nextLine();

            SocioEmpresa novoEmp = new SocioEmpresa(nome, nsocio, email, empresa, nif);
            this.ginasio.adicionarSocioEmpresa(novoEmp);
            System.out.println("Socio empresa registado com sucesso! " + novoEmp.getDados());
        }
    }

    /**
     * Recolhe os dados para registar um novo instrutor.
     */
    private void menuRegistarInstrutor() {
        System.out.println("\n--- REGISTAR INSTRUTOR / PERSONAL TRAINER ---");
        System.out.print("Nome do instrutor: "); 
        String nome = this.leitor.nextLine();

        System.out.print("Genero: ");
        String genero = this.leitor.nextLine(); 

        System.out.print("Formacao (cursos e certificacoes): ");
        String formacao = this.leitor.nextLine();
 
        if (nome.isEmpty() || genero.isEmpty() || formacao.isEmpty()) {
            System.out.println("Erro: Todos os campos do instrutor sao obrigatorios.");
            return;
        }

        Instrutor novoInst = new Instrutor(nome, genero, formacao);
        this.ginasio.adicionarInstrutor(novoInst);
        System.out.println("Instrutor adicionado: " + novoInst.getDados());
    }

    /**
     * Recolhe os dados para criar uma aula de grupo ou sessao de PT. 
     */
    private void menuRegistarAtividade() {
        System.out.println("\n--- REGISTAR ATIVIDADE ---");
        System.out.print("Categoria (1 - Aula de Grupo | 2 - Sessao de Personal Training): ");
        int tipo = this.leitor.nextInt();
        this.leitor.nextLine();

        if (tipo != 1 && tipo != 2) {
            System.out.println("Erro: Categoria inválida.");
            return;
        }
   
        this.ginasio.listarInstrutores();
        System.out.print("Nome do instrutor responsavel: ");
        String nomeProf = this.leitor.nextLine();

        Instrutor instrutor = this.ginasio.procurarInstrutor(nomeProf);
        if (instrutor == null) {
            System.out.println("Erro: Instrutor não encontrado. Registe primeiro o instrutor na opcao 2.");
            return;
        }

        System.out.print("Nome da atividade: ");
        String nomeAtiv = this.leitor.nextLine();

        if (nomeAtiv.isEmpty() || this.ginasio.procurarAtividade(nomeAtiv) != null) {
            System.out.println("Erro: Nome inválido ou atividade já existente.");
            return;
        } 

        System.out.print("Data e hora de inicio (dd/MM/yyyy HH:mm): ");
        String textoData = this.leitor.nextLine();
        LocalDateTime dataInicio = LocalDateTime.parse(textoData, this.formatoDataHora);

        System.out.print("Duracao em minutos: ");
        int duracao = this.leitor.nextInt();
        this.leitor.nextLine();

        if (tipo == 1) {
            System.out.print("Modalidade (1 - Yoga | 2 - Spinning | 3 - Zumba | 4 - CrossFit): "); 
            int opção = this.leitor.nextInt();
            this.leitor.nextLine();

            String mod = "";
            if (opção == 1) {mod = "Yoga";}
                else if (opção == 2) { mod = "Spinning"; }
                else if (opção == 3) {mod = "Zumba"; }  
                else if (opção == 4) { mod = "CrossFit";} 
            else {
                System.out.println("Erro: Opção de modalidade inválida.");
                return;
            }

            System.out.print("Capacidade máxima de participantes: ");
            int capacidade = this.leitor.nextInt();
            this.leitor.nextLine();
 
            AulaGrupo novaAula = new AulaGrupo(nomeAtiv, instrutor, duracao, dataInicio, mod, capacidade);
            this.ginasio.adicionarAulaGrupo(novaAula);
            System.out.println("Aula de grupo criada: " + novaAula.getDados());
        } else {
            System.out.print("Nivel do treino (1 - Iniciante | 2 - Intermedio | 3 - Avançado): "); 
            int opNivel = this.leitor.nextInt();
            this.leitor.nextLine();

            String nivel = "";
            if (opNivel == 1) { nivel = "Iniciacao";} 
                else if (opNivel == 2) { nivel = "Intermedio";}
                else if (opNivel == 3) {nivel = "Avancado";}
            else {
                System.out.println("Erro: Opcao de nivel invalida.");
                return;
            }

            SessaoPT novaSessao = new SessaoPT(nomeAtiv, instrutor, duracao, dataInicio, nivel);
            this.ginasio.adicionarSessaoPT(novaSessao);
            System.out.println("Sessao de PT criada: " + novaSessao.getDados());
        }
    }
  
    /**
     * Faz uma nova marcação e apresenta o custo final com desconto
     */
    private void menuCriarMarcacao() {
        System.out.println("\n--- CRIAR MARCAÇÂO ---");
        System.out.print("Número do socio: ");
        int nsocio = this.leitor.nextInt();
        this.leitor.nextLine();

        if (this.ginasio.procurarSocio(nsocio) == null) {
            System.out.println("Erro: Nao existe nenhum socio com o número " + nsocio + ".");
            return;
        }

        System.out.print("Nome da atividade pretendida: ");
        String nomeAtiv = this.leitor.nextLine();

        if (this.ginasio.procurarAtividade(nomeAtiv) == null) {
            System.out.println("Erro: Nao foi encontrada a atividade '" + nomeAtiv + "'.");
            return;
        }

        System.out.print("Data e hora da marcação (dd/MM/yyyy HH:mm): ");
        String textoData = this.leitor.nextLine();
        LocalDateTime dataMarcacao = LocalDateTime.parse(textoData, this.formatoDataHora);

        Marcacao criada = this.ginasio.criarMarcacao(nsocio, nomeAtiv, dataMarcacao);

        if (criada != null) {
            System.out.println("Marcação confirmada com sucesso!");
            System.out.println(" -> " + criada.getDados());
        } else {
            System.out.println("Nao foi possivel registar a marcação.");
        }
    }
}