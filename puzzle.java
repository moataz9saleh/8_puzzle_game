import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class puzzle extends JFrame implements MouseListener , ActionListener {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JButton b1 = new JButton(" 1 ");
    JButton b2 = new JButton(" 2 ");
    JButton b3 = new JButton(" 3 ");
    JButton b4 = new JButton(" 4 ");
    JButton b5 = new JButton(" 5 ");
    JButton b6 = new JButton(" 6 ");
    JButton b7 = new JButton(" 7 ");
    JButton b8 = new JButton(" 8 ");
    JButton b9 = new JButton("  ");
    JButton b10 = new JButton(" BFS ");
    JButton b11 = new JButton(" DFS ");
    JButton b12 = new JButton(" Manhattan ");
    JButton b14 = new JButton(" Euclidean ");
    JButton b13 = new JButton(" next step ");
    JLabel l1 = new JLabel("  ");

    JButton[] buttons = {b9,b1,b2,b3,b4,b5,b6,b7,b8};
    Color light_Grey = new Color(153,153,153);
    static char [][] init;
    static ArrayList<char[][]> pathList = new ArrayList<>();
    static ArrayList<String> moveList = new ArrayList<>();
    public static void setinit(char[][] x) {
        init=x;
    }
    public puzzle() {
        showpuzzle();

    }
    public void showpuzzle() {
        setTitle("8puzzle");
        this.setSize(700,650);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setLocation(250,50);
        p1.setBackground(light_Grey);
        p1.setLayout(null);
        add(p1);
        p2.setBackground(light_Grey);
        p2.setLayout(new GridLayout(3,3,5,5));
        p2.setBounds(40,40,470,520);
        p1.add(p2);
        setNumbers(init);
        p3.setBackground(light_Grey);
        p3.setLayout(new GridLayout(6,1,20,10));
        p3.setBounds(520,150,150,300);
        p1.add(p3);
        p3.add(l1);
        p3.add(b10);p3.add(b11); p3.add(b12);p3.add(b14);p3.add(b13);
        b1.setBackground(Color.PINK);
        b2.setBackground(Color.PINK);
        b3.setBackground(Color.PINK);
        b4.setBackground(Color.PINK);
        b5.setBackground(Color.PINK);
        b6.setBackground(Color.PINK);
        b7.setBackground(Color.PINK);
        b8.setBackground(Color.PINK);
        b9.setBackground(Color.PINK);
        b10.setBackground(Color.PINK);
        b11.setBackground(Color.PINK);
        b12.setBackground(Color.PINK);
        b13.setBackground(Color.PINK);
        b14.setBackground(Color.PINK);
        b1.setFont(new Font("r",Font.BOLD,50));
        b2.setFont(new Font("r",Font.BOLD,50));
        b3.setFont(new Font("r",Font.BOLD,50));
        b4.setFont(new Font("r",Font.BOLD,50));
        b5.setFont(new Font("r",Font.BOLD,50));
        b6.setFont(new Font("r",Font.BOLD,50));
        b7.setFont(new Font("r",Font.BOLD,50));
        b8.setFont(new Font("r",Font.BOLD,50));
        b10.setFont(new Font("r",Font.BOLD,20));
        b11.setFont(new Font("r",Font.BOLD,20));
        b12.setFont(new Font("r",Font.BOLD,20));
        b13.setFont(new Font("r",Font.BOLD,20));
        b14.setFont(new Font("r",Font.BOLD,20));
        l1.setFont(new Font("r",Font.BOLD,20));
        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b3.setForeground(Color.BLACK);
        b4.setForeground(Color.BLACK);
        b5.setForeground(Color.BLACK);
        b6.setForeground(Color.BLACK);
        b7.setForeground(Color.BLACK);
        b8.setForeground(Color.BLACK);
        b9.setForeground(Color.BLACK);
        b10.setForeground(Color.BLACK);
        b11.setForeground(Color.BLACK);
        b12.setForeground(Color.BLACK);
        b13.setForeground(Color.BLACK);
        b14.setForeground(Color.BLACK);
        l1.setForeground(Color.BLACK);
        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        b4.addMouseListener(this);
        b5.addMouseListener(this);
        b6.addMouseListener(this);
        b7.addMouseListener(this);
        b8.addMouseListener(this);
        b9.addMouseListener(this);
        b10.addMouseListener(this);
        b11.addMouseListener(this);
        b12.addMouseListener(this);
        b13.addMouseListener(this);
        b14.addMouseListener(this);

        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b14.addActionListener(this);
        b13.addActionListener(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton k = (JButton)e.getSource();
        k.setBackground(Color.DARK_GRAY);
        k.setForeground(Color.WHITE);

    }
    @Override
    public void mouseExited(MouseEvent e) {
        JButton k = (JButton)e.getSource();
        k.setBackground(Color.PINK);
        k.setForeground(Color.BLACK);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    public void setNumbers(char[][] init) {
        for(int i = 0; i<init.length; i++) {
            for(int j = 0; j<init.length; j++) {
                p2.add(buttons[Character.getNumericValue(init[i][j])]);
            }
        }
    }

    int next = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b12) {
            try {
                Main.callManhattan();
                next=0;
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }

        if(e.getSource() == b14) {
            try {
                Main.callEuc();
                next=0;
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }

        if(e.getSource() == b10) {
            try {
                Main.callBFS();
                next=0;
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }
        if(e.getSource() == b11) {
            try {
                Main.callDFS();
                next=0;
            } catch (IOException e1) {

                e1.printStackTrace();
            }


        }
        if(e.getSource() == b13) {
            if(next<pathList.size()) {

                setNumbers(pathList.get(next));
                l1.setText("move: "+ moveList.get(next));
                next++;
                this.revalidate();

            }
        }

    }
}