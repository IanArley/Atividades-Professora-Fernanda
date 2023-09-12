import java.util.Scanner;

public class MainBiblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca b = new Biblioteca();
        while (true) {
            System.out.println("Para utilizar o sistema é necessário realizar um login;\n1. Escolha essa opção caso já tenha um cadastro e deseja fazer o login;\n2. Escolha essa opção caso deseje criar um cadastro;\n3. Encerrar programa;\nDigite a seguir apenas o número correspondente a sua escolha: ");
            int escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("Digite o CPF(apenas os números)");
                long ident = sc.nextLong();
                if (b.users.contains(ident)) {
                    System.out.println("Escolha a operação que deseja realizar a seguir:\n1. Registrar um novo livro (Esta escolha apenas registrará um novo livro ao sistema, para fazer o empréstimo do livro, selecione a opção 2);\n2. Realizar o empréstimo de um livro (O livro que será emprestado deve estar cadastrado no sistema);\n3. Realizar a devolução de um livro\n4. Ver livros que foram emprestados\n5. Encerrar programa;\nDigite a seguir apenas o número correspondente a sua escolha: ");
                    int escolha2 = sc.nextInt();

                    if (escolha2 == 1) {
                        System.out.println("Digite a seguir o nome do livro(apenas letras minúsculas e sem espaços): ");
                        String nomeLivro = sc.next();
                        System.out.println("Digite a seguir o nome do autor do livro(apenas letras minúsculas e sem espaços): ");
                        String nomeAutor = sc.next();
                        b.livro.put(nomeLivro, nomeAutor);
                        b.registrados.add(nomeLivro);
                    } else if (escolha2 == 2) {
                        System.out.println("Digite o nome do livro que será emprestado(apenas letras minúsculas): ");
                        String nomeLivro = sc.next();
                        if (b.registrados.contains(nomeLivro) && !b.LivrosEmprestados.contains(nomeLivro)) {
                            b.LivrosEmprestados.add(nomeLivro);
                            b.emprestado.put(nomeLivro, ident);
                            System.out.println("O livro " + nomeLivro + " foi registrado ao seu cadastro como emprestado;");
                        } else if (!b.registrados.contains(nomeLivro)) {
                            System.out.println("Esse livro não está nos registros da biblioteca, registre o livro na biblioteca antes de pegá-lo emprestado");
                        } else if (b.LivrosEmprestados.contains(nomeLivro)) {
                            System.out.println("Esse livro já foi emprestado para outra pessoa");
                        }
                    } else if (escolha2 == 3) {
                        System.out.println("Digite o nome do livro que deseja devolver(utilize apenas letras minúsculas): ");
                        String nomeLivro = sc.next();
                        if (b.LivrosEmprestados.contains(nomeLivro)) {
                            b.LivrosEmprestados.remove(nomeLivro);
                            System.out.println("O livro foi devolvido para a biblioteca;");
                        } else {
                            System.out.println("Este livro não está na sua lista;");
                        }
                    }
                    else if(escolha2 == 4){
                        System.out.println("Os livros que esse usuário está utilizando são: " + b.LivrosEmprestados);
                    }
                    else if (escolha2 == 5) {
                        System.out.println("Encerrando programa");
                        break;
                    }
                } else {
                    System.out.println("Esse número de identificação não está cadastrado, por favor volte ao inicio e realize o cadastro;");
                }
            } else if (escolha == 2) {
                System.out.println("Para realizar o cadastro para a biblioteca digite a seguir seu nome(sem letras maiúsculas e sem acento): ");
                String nomeUsr = sc.next();
                System.out.println("Digite agora o seu CPF que servirá como número de identificação(Apenas os númerps sem espaço): ");
                long ident = sc.nextLong();
                b.users.add(ident);
                b.Login.put(nomeUsr, ident);
            } else if (escolha == 3) {
                System.out.println("Encerrando programa;");
                break;
            }
        }
    }
}
