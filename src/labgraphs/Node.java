/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labgraphs;

import java.util.LinkedList;

/**
 *
 * @author Santi Mercado
 */
public class Node {
    String nombre;
    boolean visitado;
    LinkedList<Node> adyacentes;
    
    public Node(String s){
        this.nombre = s;
        this.adyacentes = new LinkedList<Node>();
        visitado = false;
    }
    
    public void EliminarAristas(){
        
    }
    
    
}
