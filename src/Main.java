import java.util.ArrayList;

public class Main {
    private static ArrayList<Aluno> listaAluno = new ArrayList<>();
    private static  ArrayList<Turma> listaTurma= new ArrayList<>();
    public static void main(String[] args) {
        menuPrincipal();
        }

    public static void menuPrincipal(){
        System.out.println("=== Secretaria ===");
        System.out.println("1 - Alunos");
        System.out.println("2 - Turmas");
        System.out.println("3 - Sair");
        String opcao = Leitura.dados("Digite a opção desejada:");

        switch (opcao){
            case "1":
               menuAlunos();
               break;
            case "2":
              menuTurmas();
              break;
            case "3":
                System.out.println("Até a próxima 😘✌️");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente 🤔");
                menuPrincipal();

        }

    }

    private static void menuTurmas() {
        System.out.println("==== Turmas ====");
        System.out.println("1 - Listar Turmas");
        System.out.println("2 - Cadastrar Turma");
        System.out.println("3 - Atualizar Turma");
        System.out.println("4 - Excluir turma");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada:");
        switch (opcao){
            case "1":
                listarTurmas();
                menuTurmas();
                break;
            case "2":
                cadastrarTurma();
                menuTurmas();
                break;
            case "3":
                atualizarTurma();
                menuTurmas();
                break;
            case "4":
                excluirTurma();
                menuTurmas();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente 🤔");
                menuTurmas();

        }
    }

    private static void menuAlunos() {
        System.out.println("==== Aluno ====");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Atualizar Aluno");
        System.out.println("4 - Excluir Aluno");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada:");
        switch (opcao){
            case "1":
                listarAlunos();
                menuAlunos();
                break;
            case "2":
                cadastrarAluno();
                break;
            case "3":
                atualizarAluno();
                break;
            case "4":
                excluirAluno();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente 🤔");
                menuAlunos();

        }

    }

    private static void excluirAluno() {
    }

    private static void atualizarAluno() {
        
    }

    private static void cadastrarAluno() {

        
    }

    private static void listarAlunos() {
        if(listaAluno.isEmpty()){
            System.out.println("não há alunos cadastrados");
            menuAlunos();
        }
        for (Aluno a: listaAluno){
            System.out.println(a);
        }
        
    }

    private static void excluirTurma() {
        listarTurmasIndiceSigla();
        String opcao = Leitura.dados("\n\ndigite o número da turma que deseja excluir: ");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
       while (opcaoValida ==-1) {
           opcaoUsuario = validarItemLista(opcao);

           if (opcaoUsuario == -1) {
               System.out.println("opção inválida! digite novamente: ");

           } else {
               opcaoValida = opcaoUsuario;
           }
       }
          if (confirmaExclusao()) {
//listaTurma.remove(opcaoUsuario);
              listaTurma.get(opcaoUsuario).setAtivo(false);
              System.out.println("Turma excluida com sucesso!");
          }
    }

    private static boolean confirmaExclusao() {
        while(true) {
            String confirma = Leitura.dados("Você tem certeza? (S/N)").toUpperCase();
            switch (confirma) {
                case "S":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Opção inválidade, digite S para sim ou N para não!");
                    break;
            }
        }

    }

    private static int validarItemLista(String opcao){
        if (opcao.isBlank()) return -1;
        int opcaoNumero = -1;
        try{
            opcaoNumero= Integer.parseInt(opcao);
        } catch (NumberFormatException e){
            return -1;
        }

        int indiceLista = opcaoNumero-1;
        return indiceLista >= 0 && listaTurma.size() > indiceLista ? indiceLista : -1;

    }

    private static void listarTurmasIndiceSigla(){
        System.out.println("\nLista das Turmas:");
        for (int i=0;i<listaTurma.size();i++){
            if (listaTurma.get(i).isAtivo())
                System.out.printf("\n%d - %s", i + 1, listaTurma.get(i).getSigla());

            }
    }

    private static void atualizarTurma() {
        if(isVazio(listaTurma)){
            System.out.println("não há turmas cadastradas");
            return;
        }
        listarTurmasIndiceSigla();
        int idAtualizar = validaIdTurma();
        System.out.println("O período atual é: " + listaTurma.get(idAtualizar).getPeriodo());

//        while (true) {
//            String opcaoPeriodo = Leitura.dados("Deseja modificar o periodo? (S/N)?").toUpperCase();
//            switch (opcaoPeriodo) {
//                case "S":
//               /*
//                 Periodo  periodo = validarPeriodo();
//                 listaTurmas.get(idAtualizar).setPeriodo(periodo);
//                */
//                    listaTurma.get(idAtualizar).setPeriodo(validarPeriodo());
//                    break;
//                case "N":
//                    break;
//                default:
//                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");
//                    continue;
//            }
//            break;
//        }


    }

    private static void atualizarPeriodo(){
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcaoPeriodo = Leitura.dados("Deseja modificar o periodo? (S/N)?").toUpperCase();
            switch (opcaoPeriodo) {
                case "S":

                    Periodo  periodo = validarPeriodo();
                    listaTurma.get(idAtualizar).setPeriodo(periodo);
                    System.out.println("Período atualizado com sucesso para: " + periodo);
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");

            }
            break;
        }
    }

    private static int validaIdTurma() {
        String opcao = Leitura.dados("\nDigite o Id da turma que deseja: ");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
        while (opcaoValida == -1) {
            opcaoUsuario = validarItemLista(opcao);

            if (opcaoUsuario == -1) {
                System.out.println("Opção inválida! Digite novamente:");
                opcao = Leitura.dados("Digite o Id da turma que deseja:");
            } else {
                opcaoValida = opcaoUsuario;
            }

        }
        return opcaoValida;
    }


    private static boolean isVazio(ArrayList<Turma> listaTurmas) {
        if (listaTurmas.isEmpty()) return true;

        for (Turma turma : listaTurmas){
            if (turma.isAtivo()) return false;
        }

        return true;
    }
    private static void cadastrarTurma() {


        Periodo  periodo = validarPeriodo();
        System.out.println(periodo);
        String curso = Leitura.dados("Digite o curso: ");
        while (!isCharacter(curso)) {
            System.out.println("Nome do curso inválido, não use números ou caracters especiais, por favor!");
             curso = Leitura.dados("Digite o curso: ");
        }
        String sigla = Leitura.dados("Digite a sigla: ");
        while (!validarSigla(sigla)) {
            System.out.println("Sigla inválida! Precisa conter somente texto e não pode ser repetida");
            sigla = Leitura.dados("Digite a sigla: ");
            sigla = sigla.toUpperCase();

        }

        Turma turma = new  Turma (curso, sigla, periodo);

        listaTurma.add(turma);


    }

    private static boolean validarSigla(String sigla){
        if(sigla.isBlank()) return false;

        for (Turma turma: listaTurma){
            if (turma.getSigla().equals(sigla)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCharacter(String texto) {
         String textoSemNumeros = texto.replaceAll("\\d", "");
         return !texto.isBlank() && texto.equals(textoSemNumeros);

    }

    private static Periodo validarPeriodo() {

        String opcaoPeriodo = Leitura.dados("""
                Digite o número do período escolhido:
                1 - Matutino
                2 - Vespertino
                3 - Noturno
                4 - Integral""");
        switch (opcaoPeriodo) {
            case "1":
                return Periodo.MATUTINO;

            case "2":
                return Periodo.VESPERTINO;

            case "3":
                return Periodo.NOTURNO;

            case "4":
                return Periodo.INTEGRAL;

            default:
                System.out.println("Opção inválida, digite novamente");
                return validarPeriodo();

        }
    }

    private static void listarTurmas() {
        if(isVazio(listaTurma)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }
        for(Turma t : listaTurma){
            if (t.isAtivo())
                System.out.println(t);
        }
    }

}
