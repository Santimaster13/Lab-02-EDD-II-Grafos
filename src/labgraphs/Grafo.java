/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labgraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Santi Mercado
 */
public class Grafo {
    LinkedList<Node> vertices;
    LinkedList<Arista> aristas;
    int [][] mdistancia;
    String [][] mrecorrido;
    String dfsout;
        public Grafo(){
            vertices = new LinkedList<Node>();
            aristas = new LinkedList<Arista>();
        }
        
        public String BFS(int pos){
            this.Clear();
            Queue<Node> cola = new LinkedList<Node>();
            String order = vertices.get(pos).nombre;
            vertices.get(pos).visitado = true;
            cola.add(vertices.get(pos));
            while(cola.isEmpty() == false){
                Node temp = cola.poll();
                for (int i=0; i<temp.adyacentes.size(); i++){
                    if(temp.adyacentes.get(i).visitado == false){
                        order = order + " --> " + temp.adyacentes.get(i).nombre;
                        temp.adyacentes.get(i).visitado = true;
                        cola.add(temp.adyacentes.get(i));
                    }
                }
            }
            
            return order;
        }
        
        public void DFS(int pos){
              vertices.get(pos).visitado = true;
            if(dfsout.equals("")){
                dfsout = vertices.get(pos).nombre;
            } else {
                 dfsout = dfsout + " --> " + vertices.get(pos).nombre;
            }  
            for (int i=0; i<vertices.get(pos).adyacentes.size(); i++){
                for(int j=0; j<vertices.size(); j++){
                    if(vertices.get(pos).adyacentes.get(i) == vertices.get(j)){
                        if(vertices.get(j).visitado == false){
                            DFS(j);
                        }
                    }
                }
            }
            
        }
        
        public void Clear(){
            for (int i=0; i<vertices.size(); i++){
                vertices.get(i).visitado = false;
            }
            dfsout = "";
        }
        
        public void LlenarMatrices(){
            mdistancia = new int [vertices.size()][vertices.size()];
            boolean ady = false;
            int pos = -1;
            for (int i=0; i<vertices.size(); i++){
                for (int j=0; j<vertices.size(); j++){
                    ady = false;
                    for (int k=0; k<vertices.get(i).adyacentes.size(); k++){
                        if(vertices.get(i).adyacentes.get(k).equals(vertices.get(j))){
                          ady = true;  
                          pos = k;
                        } 
                    }
                    if (ady == true){
                         for (int z=0; z<aristas.size(); z++){
                             if( (aristas.get(z).n1.equals(vertices.get(i)) && aristas.get(z).n2.equals(vertices.get(j))) || (aristas.get(z).n2.equals(vertices.get(i)) && aristas.get(z).n1.equals(vertices.get(j))) ){
                                 mdistancia[i][j] = aristas.get(z).peso;
                             }
                         }
                    } else {
                       mdistancia[i][j] = 999999999; 
                    }   
                    if(i == j){
                        mdistancia[i][j] = 0;
                    }
                }
            }
            mrecorrido = new String[vertices.size()][vertices.size()];
           for (int i=0; i<vertices.size(); i++){
               for (int j=0; j< vertices.size(); j++){
                   mrecorrido[i][j] = vertices.get(j).nombre; 
               }
           }
        }
        
        public String FloydWarshall(Node inicio, Node fin){
            int ini=-1;
            int fini = -1;
           for (int k = 0; k < vertices.size(); k++) {
             if(vertices.get(k).equals(inicio)){
                 ini = k;
             }
             if(vertices.get(k).equals(fin)){
                 fini = k;
             }
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    int tmp = mdistancia[i][k] + mdistancia[k][j];
                    if (mdistancia[i][j] > tmp) {
                        mdistancia[i][j] = tmp;
                        mrecorrido[i][j] = mrecorrido[i][k];
                    }
                }
            }
        }
           int finale = mdistancia[ini][fini];
           String order = vertices.get(ini).nombre;
           boolean terminado = false;
           while(terminado == false){
               if (mrecorrido[ini][fini].equals(inicio.nombre) || mrecorrido[ini][fini].equals(fin.nombre)){
                   order = order + " --> "+ fin.nombre;
                   terminado = true;
               } else {
                   order = order + " --> " + mrecorrido[ini][fini];
                   String temp = mrecorrido[ini][fini];
                   for (int i=0; i<vertices.size(); i++){
                       if (vertices.get(i).nombre.equalsIgnoreCase(temp)){
                           ini = i;
                       }
                   }
                    
               }
           }
           order = order + " /// Peso total: " + finale;
           if(finale >= 999999999){
               order = "No hay camino posible desde " + inicio.nombre + " hasta " + fin.nombre;
           }
           return order;
        }
        
        public void ImprimirMatriz(){
            System.out.println("Matriz de recorrido");
            for (int i=0; i<vertices.size(); i++){
                for (int j=0; j<vertices.size(); j++){
                    System.out.print(mrecorrido[i][j]+" ");
                }
                System.out.println("");
            }
        }
}
