import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Vacinacao {
    private String nome;
    private String cpf;
    private String nascimento;

    public Vacinacao(){
        this.nome = "";
        this.cpf = "";
        this.nascimento = "";
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getNascimento(){
        return this.nascimento;
    }

    public void cadastraVacina(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Nome: ");
        this.setNome(entrada.next());

        System.out.print("Cpf: ");
        this.setCpf(entrada.next());

        System.out.print("Nascimento(dd/mm/aaaa): ");
        this.setNascimento(entrada.next());
    }

    public void exibeVacina(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Nascimento: "+getNascimento());
        System.out.println("--------------------------------------------");
    }
}
