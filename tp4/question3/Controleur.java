package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author Rima Ghoulam
 * @version v0
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        
        newActionListener a = new newActionListener();
        boutons.add(push);  push.addActionListener(a);
        boutons.add(add);   add.addActionListener(a);
        boutons.add(sub);   sub.addActionListener(a);
        boutons.add(mul);   mul.addActionListener(a);
        boutons.add(div);   div.addActionListener(a);
        boutons.add(clear); clear.addActionListener(a);
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        
        if(pile.estPleine()) {
            push.setEnabled(false);
         }
        else {
            push.setEnabled(true);
         }
        
        if(pile.taille() <= 1  )
        {
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } 
        else {
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    class newActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
}
