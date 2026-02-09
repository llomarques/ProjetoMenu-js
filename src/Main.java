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
                break;
            case "3":
                atualizarTurma();
                break;
            case "4":
                excluirTurma();
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
        
    }

    private static void atualizarTurma() {
        
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
        boolean repetido = true;
        while (sigla.isBlank() || !repetido) {
            System.out.println("Sigla inválida");
            sigla = Leitura.dados("Digite a sigla: ");
            sigla = sigla.toUpperCase();


            for (Turma t : listaTurma) {
                if (t.getSigla().equals(sigla)) {
                    System.out.println("Turma ja cadastrada!");
                    repetido = true;
                }
            }
            repetido = false;
        }

        Turma turma = new  Turma (curso, sigla, periodo);

        listaTurma.add(turma);
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
        if(listaTurma.isEmpty()){
            System.out.println("não há turmas cadastradas");
            return;
        }
        for (Turma t: listaTurma){
            System.out.println(t);
        }
        
    }

}
