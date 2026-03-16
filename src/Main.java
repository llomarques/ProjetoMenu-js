import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

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
//
               break;
            case "2":
              menuTurmas();
              break;
            case "3":
                System.out.println("Até a próxima️!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
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
                if (isVazio(listaTurma)){
                   System.out.println("Não existe turmas!");
                 menuAlunos();
              } else {
                    cadastrarAluno();
                    menuAlunos();
                }
                break;
            case "3":
                atualizarAluno();
                menuAlunos();
                break;
            case "4":
                excluirAluno();
                menuAlunos();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente 🤔");
                menuAlunos();

        }

    }









    private static void excluirTurma() {
        if(isVazio(listaTurma)){
            System.out.println("Não há turmas cadastradas");
            return;
        }

        listarTurmasIndiceSigla();
        int idExcluir = validaIdTurma();

        if (confirmaExclusao()){
            listaTurma.get(idExcluir).setAtivo(false);
            System.out.println("Turma excluida com sucesso ! :)");
        }

    }

    private static void excluirAluno(){
        if (Isvazio(listaAluno)) {
            System.out.println("Não há alunos cadastrados!");
            return;

        }
        listarAlunoIndice();
        int excluirAluno = validarIdAluno();

        if (confirmaExclusao()){
            listaAluno.get(excluirAluno).setAtivo(false);
            System.out.println("Aluno excluido da lista com sucesso!");
        }
        }



    private static boolean isVazio(ArrayList<Turma> listaTurmas) {
        if (listaTurmas.isEmpty()) return true;

        for (Turma turma : listaTurmas){
            if (turma.isAtivo()) return false;
        }

        return true;
    }

    private static boolean Isvazio(ArrayList<Aluno>listaAluno){
        if (listaAluno.isEmpty()) return true;
        for (Aluno aluno : listaAluno){
           if(aluno.Isativo()) return false;
        }
        return true;
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

    private static void listarAlunoIndice(){
        System.out.println("\nLista de alunos:");
        for (int i=0;i<listaAluno.size();i++){
            if (listaAluno.get(i).Isativo())
                System.out.printf("\n%d - %s", i + 1, listaAluno.get(i).getNome());
        }

    }

    private static void atualizarTurma() {
        if(isVazio(listaTurma)){
            System.out.println("não há turmas cadastradas");
            return;
        }

        listarTurmasIndiceSigla();
        int idAtualizar = validaIdTurma();

        System.out.printf("O período atual é: %s", listaTurma.get(idAtualizar).getPeriodo());
        atualizarParcial("período", idAtualizar);

        System.out.printf("O curso atual é: %s", listaTurma.get(idAtualizar).getCurso());
        atualizarParcial("curso", idAtualizar);

        System.out.printf("A sigla atual é: %s", listaTurma.get(idAtualizar).getSigla());
        atualizarParcial("sigla", idAtualizar);

    }
    private static void atualizarAluno() {
        if(Isvazio(listaAluno)){
            System.out.println("não há alunos cadstrados");
            return;
        }

        listarAlunoIndice();
        int atualizarAlunoIndice = validarIdAluno();

        System.out.printf("O nome atual é: %s", listaAluno.get(atualizarAlunoIndice).getNome());
        atualizarParcialAluno("nome", atualizarAlunoIndice);

        System.out.printf("A data de nascimento atual é: %s", listaAluno.get(atualizarAlunoIndice).getDataNascimento());
        atualizarParcialAluno("Data de Nascimeno", atualizarAlunoIndice);

        System.out.printf("A turma atual é: %s", listaAluno.get(atualizarAlunoIndice).getTurma());
        atualizarParcialAluno("turma", atualizarAlunoIndice);

    }

    private static void atualizarParcialAluno (String atributo, int atualizarAlunoIndice){
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcao= Leitura.dados("\nDeseja modificar a "+ atributo + "(S/N)?").toUpperCase();
            switch (opcao) {
                case "S":
                    switch (atributo){
                        case "nome":
                           String nome  = validarNome();
                            listaAluno.get(atualizarAlunoIndice).setNome(nome);
                            break;
                        case "curso":
                           LocalDate dataNascimento = validarData();
                            listaAluno.get(atualizarAlunoIndice).setDataNascimento(dataNascimento);
                            break;
                        case "turma":
                            Turma turma  = validarTurma();
                            listaAluno.get(atualizarAlunoIndice).setTurma(turma);
                            break;
                    }
                    System.out.println(atributo + " atualizado com sucesso!");
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");

            }

        }
    }




    private static void atualizarParcial (String atributo, int idAtualizar){
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcao= Leitura.dados("Deseja modificar a "+ atributo + "(S/N)?").toUpperCase();
            switch (opcao) {
                case "S":
                    switch (atributo){
                        case "período":
                            Periodo periodo = validarPeriodo();
                            listaTurma.get(idAtualizar).setPeriodo(periodo);
                            break;
                        case "curso":
                            String curso= validarCurso();
                            listaTurma.get(idAtualizar).setCurso(curso);
                            break;
                        case "sigla":
                            String sigla = validarSigla();
                            listaTurma.get(idAtualizar).setSigla(sigla);
                            break;
                    }
                    System.out.println(atributo + "atualizado com sucesso!");
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");

            }

        }
    }

    private static String validarSigla (){
      String sigla = Leitura.dados("Digite a sigla: ");
      while(!validarSigla(sigla)){
          System.out.println("Sigla inválida! Precisa conter texto e não pode ser repetida");
          sigla = Leitura.dados("Digite a sigla: ");
      }
      return sigla;
    }

    private static String validarCurso (){
     String curso = Leitura.dados("Digite o curso: ");
     while(!isCharacter(curso)){
         System.out.println("Nome do curso inválido! Não use números ou caracteres especiais, por favor");
         curso = Leitura.dados ("Digite o curso: ");
     }
    return curso;
    }


    private static void atualizarPeriodo( int idAtualizar){
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

    private static int validarIdAluno(){
        String opcao = Leitura.dados("\nDigite o aluno que deseja: ");
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

    private static void cadastrarTurma() {

        Periodo  periodo = validarPeriodo();
        String curso = validarCurso();
        String sigla = validarSigla();

        Turma turma = new  Turma (curso, sigla, periodo);
        listaTurma.add(turma);


    }

    private static void cadastrarAluno() {

        String nome = validarNome();
        LocalDate dataNascimento = validarData();
        Turma turma = validarTurma();

      Aluno aluno = new Aluno( nome, dataNascimento, turma);
      listaAluno.add(aluno);

    }

    private static int turmaAluno(){
        listarTurmasIndiceSigla();
        String turmaAluno = Leitura.dados("\nEm qual turma deseja inserir o aluno?");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
        while (opcaoValida == -1) {
            opcaoUsuario = validarItemLista(turmaAluno);

            if (opcaoUsuario == -1) {
                System.out.println("Opção inválida! Digite novamente:");
                turmaAluno = Leitura.dados("Digite o Id da turma que deseja:");
            } else {
                opcaoValida = opcaoUsuario;
            }

        }
        return opcaoValida;

    }
    private static Turma validarTurma() {
        int turmaAluno = turmaAluno();
        System.out.printf("\nA turma escolhida é: %s\n",listaTurma.get(turmaAluno).getCurso());

        return listaTurma.get(turmaAluno);
    }

    private static LocalDate validarData() {
        while (true) {
            String dataAluno = Leitura.dados("\nQual a data de nascimento do aluno? (dd/MM/yyyy)");

            if (!dataAluno.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Data inválida, digite uma data válida");
                continue;
            }

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(dataAluno, formatter);

                if (isData(data)) {
                    return data;
                }

            } catch (DateTimeParseException e) {
                System.out.println("Erro: Data inexistente. Verifique dia, mês e ano.");
            }
        }
    }



    private static boolean isData(LocalDate data){
        LocalDate hoje = LocalDate.now();

        if(data.isAfter(hoje)){
            System.out.println("Data não pode ser no futuro.");
            return false;
        }

        if (data.isAfter(hoje.minusYears(14))){
            System.out.println("Aluno deve ter no mínimo 14 anos.");
            return false;
        }

        if(data.isBefore(hoje.minusYears(130))){
            System.out.println("Idade inválida");
            return false;
        }
        return true;
    }


    //private static Turma TurmaAluno() {
    //}



    private static String validarNome() {
        String nome = Leitura.dados("\nQual o nome do aluno?");
       while (!isCharacter(nome)){
            System.out.println("Nome do aluno inválido! Não use caracteres especiais ou números, por favor!");
            nome = Leitura.dados("Digite o nome novamente: ");
        }
        return nome;
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

    private static void listarAlunos() {
        if(Isvazio(listaAluno)){
            System.out.println("Não há alunos cadastrados :( ");
            menuAlunos();
        }
        for (Aluno a: listaAluno){
            if (a.Isativo())
                System.out.println(a);
        }

    }

}
