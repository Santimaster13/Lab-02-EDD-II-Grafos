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
public class LabGraphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interface i = new Interface();
        i.setVisible(true);
        i.setSize(1200, 900);
        i.setResizable(false);
        i.Init();
    }
    
}
