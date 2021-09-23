import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        LimpaTela limpar = new LimpaTela();
        String pausa, dataAtual = "";
        Vacinacao objres = new Vacinacao();
        boolean control = false, controlCadastro = false;
        int opcao;

        List<Vacinacao> vacina = new ArrayList<Vacinacao>();
        
        do{
            System.out.print("\n =========== Escolha uma das opcoes ===========");
            System.out.print("\n | 1) Cadastrar cidadão                       |");
            System.out.print("\n | 2) Exibir todos os cidadãos cadastrados    |");
            System.out.print("\n | 3) Atender cidadão                         |");
            System.out.print("\n | 4) Sair                                    |");
            System.out.print("\n ==============================================\n");
            System.out.print("\n>> ");
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    limpar.limpaTela();
                    Vacinacao temp = new Vacinacao();
                    temp.cadastraVacina();
                    dataAtual = temp.getDateTime();
                    
                    controlCadastro = true;
                    for(Vacinacao tmp: vacina){
                        if(tmp.getNome().equals(temp.getNome()) || tmp.getCpf().equals(temp.getCpf())){
                            System.out.println("Este usuário já foi cadastrado, realize a verificação e tente novamente!");
                            controlCadastro = false;
                        }
                    }

                    if(controlCadastro){
                        System.out.println("Cadastro realizado com sucesso!");
                        control = true;
                        vacina.add(temp);
                    }
                    System.out.println("Pressione qualquer tecla e aperte enter para continuar");
                    pausa = entrada.next();
                    limpar.limpaTela();
                break;

                case 2:
                    limpar.limpaTela();

                    if(control == true){
                        if(vacina.size() > 0){
                            for(Vacinacao tmp: vacina){
                                tmp.exibeVacina();
                            }
                        } else{
                            System.out.println("Não existe nenhum cidadão vacinado, sendo assim, não podendo exibir.");
                        }
                    } else{
                        System.out.println("Não existe nenhum cidadão vacinado, sendo assim, não podendo exibir.");
                    }
                    System.out.println("Pressione qualquer tecla e aperte enter para continuar");
                    pausa = entrada.next();
                    limpar.limpaTela();
                break;

                    case 3:
                    limpar.limpaTela();

                    if(control == true){
                        if(vacina.size() > 0){
                            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                            Date data1 = data.parse(dataAtual);
                            Date data2 = data.parse(dataAtual);
    
                            for(Vacinacao tmp: vacina){
                                data1 = data.parse(tmp.getNascimento());
                                if(data1.before(data2)){
                                    data2 = data.parse(tmp.getNascimento());
                                    objres = tmp;
                                }
                            }
                            System.out.println("O cidadão " +objres.getNome()+ " foi removido, já que o mesmo é o usuário mais idoso!");
                            vacina.remove(objres);      
                        } else{
                            System.out.println("Não existe nenhum cidadão vacinado, sendo assim, não podendo exibir.");
                        }
                    } else{
                        System.out.println("Não existe nenhum cidadão vacinado, sendo assim, não podendo exibir.");
                    }
                    System.out.println("Pressione qualquer tecla e aperte enter para continuar");
                    pausa = entrada.next();
                    limpar.limpaTela();
                break;

                case 4:
                    limpar.limpaTela();
                    System.out.println("Programa encerrado!");
                    System.out.println("Pressione qualquer tecla e aperte enter para continuar");
                    pausa = entrada.next();
                break;

                 default: 
                    limpar.limpaTela();
                    System.out.println("Opção inválida, tente novamente!");
                    System.out.println("Pressione qualquer tecla e aperte enter para continuar");
                    pausa = entrada.next();
                break;
            }
            limpar.limpaTela();
        }while(opcao != 4);
    }
}
