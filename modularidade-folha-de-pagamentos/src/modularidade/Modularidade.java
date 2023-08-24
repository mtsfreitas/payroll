/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularidade;

/**
 *
 * @author Martins
 */
public class Modularidade {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Funcionario colaborador = new Funcionario("Pafuncio Figueiredo", "10/10/1990");
        System.out.println("Contrato de Funcionario: ");
        colaborador.contratar(modularidade.Contrato.efetivo, 2500, 1, "10/10/2018");
        System.out.println("Nome do Funcionario: "+ colaborador.nomeColaborador);
        colaborador.folhaDePagamento(2);



    }
    
}
