/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labgraphs;

/**
 *
 * @author Santi Mercado
 */
public class Arista {
    Node n1;
    Node n2;
    int peso;
    public Arista(Node a1, Node a2, int a){
        n1 = a1;
        n2 = a2;
        peso = a;
    }
    
    public void SetPeso(int p){
        peso = p;
    }
}
