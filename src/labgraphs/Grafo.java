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
public class Grafo {
    LinkedList<Node> vertices;
    LinkedList<Arista> aristas;
        public Grafo(){
            vertices = new LinkedList<Node>();
            aristas = new LinkedList<Arista>();
        }
}
