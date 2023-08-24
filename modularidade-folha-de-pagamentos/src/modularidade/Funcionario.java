package modularidade;

public class Funcionario{
    
    String nomeColaborador;
    private String dataDeNascimento;
    private String dataDeAdmissao;
    private float salario;
    private int qtdFilhosMenores;
    private Contrato contratoColaborador;
    
    //contrato
    public Contrato getTipoContrato() {
        return contratoColaborador;
    }
    public void setTipoContrato(Contrato contratoColaborador) {
        this.contratoColaborador = contratoColaborador;
    }
    
    //salario
    public float getSalario() {
        return salario;
    }
    
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    //admissao
    public String getDataAdmissao() {
        return dataDeAdmissao;
    }
    
    public void setDataAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }
    
    //filhos menores
     public int getqtdFilhosMenores() {
        return qtdFilhosMenores;
    }
    public void setqtdFilhosMenores(int qtdFilhosMenores) {
        this.qtdFilhosMenores = qtdFilhosMenores;
    }
    
    //Método construtor para inicializar o nome e a data de nascimento do funcionário;
    public Funcionario(String nomeColaborador, String dataDeNascimento){
        
        this.nomeColaborador = nomeColaborador;
        this.dataDeNascimento = dataDeNascimento;
        
    }
    
    //Método "contratar" que altera os demais atributos do funcionario (tipo de contrato, salário,numero de filhos menores de idade e data de admissao);
    public void contratar(Contrato tipo, float salario, int qtdFilhosMenores, String dataDeAdmissao)
    {
        this.contratoColaborador = tipo;
        this.salario = salario;
        this.qtdFilhosMenores = qtdFilhosMenores;
        this.dataDeAdmissao = dataDeAdmissao;
    }
    
    //Método para calcular o salário bruto (o método deve receber o número de horas trabalhadas pelo funcionario, e verificar se é Horista ou Efetivo);
    public float calculaSalarioBruto(int horasTrabalhadas){
        float salarioBruto = salario;

        if(contratoColaborador == Contrato.horas){
            salarioBruto = horasTrabalhadas*salario;
        }
        return salarioBruto;
    }
    
    //Método para calcular o desconto do INSS (conforme tabela oficial da Previdência Social, apresentada abaixo no Anexo I);
    public float descontoINSS(float salarioBruto){
        
        float desconto;
        
        if(salarioBruto <= 1659.38f){
            desconto = salarioBruto*0.08f;
        }else if(salarioBruto <= 2765.66){
            desconto = salarioBruto*0.09f;
        }else if(salarioBruto <= 5531.31f){
            desconto = salarioBruto*0.11f;
        }else{
            desconto = 5531.31f*0.11f;
        }
        return desconto;
    }
    
    //Método para calcular o desconto de imposto de renda (conforme tabela oficial da Receita Federal, apresentada abaixo no Anexo II)
    public float descontoImpostoDeRenda(float salarioBruto){
        if(salarioBruto <= 1903.98){

        return 0.0f;

        }else if(salarioBruto <= 2826.65)
        {

            return (salarioBruto*0.075f)-142.8f;
            
        }else{

                 return 9f;
             }
    }
    //Método para calcular o salário líquido (salário bruto – deduções de INSS e imposto de renda);
     public float calculaSalarioLiquido(float salarioBruto){
        float descontos = descontoINSS(salarioBruto) + descontoImpostoDeRenda(salarioBruto);
        return salarioBruto - descontos;       
    }
    //Método para mostrar sua folha de pagamento (contendo o saláario bruto, descontos e salario liquido);
    public void folhaDePagamento(int horasTrabalhadas){

        float salarioBruto = this.calculaSalarioBruto(horasTrabalhadas);
        
        System.out.println("Nome do Funcionario: "+this.nomeColaborador);
        System.out.println("Valor do salario Bruto: "+salarioBruto);
        System.out.println("Valor do desconto INSS: "+this.descontoINSS(salarioBruto));
        System.out.println("Valor do desconto IR: "+this.descontoImpostoDeRenda(salarioBruto));
        System.out.println("Valor do salario Liquido: "+this.calculaSalarioLiquido(salarioBruto));

    }
    
}