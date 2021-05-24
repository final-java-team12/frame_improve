package team_12;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;

//點選衣櫃時產生的介面
public class CabinetFrame extends JFrame{
    private JLabel label;
    private JButton upSummer;
    private JButton upWinter;
    private JButton downSummer;
    private JButton downWinter;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    //設定衣櫃介面
    public CabinetFrame(){
        super("新增服裝");
        setLayout(new GridLayout(3,1));

        label = new JLabel("點選新增");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(label);
        add(panel1);
        

        upSummer = new JButton("短袖");
        upWinter = new JButton("長袖");
        downSummer = new JButton("短褲");
        downWinter = new JButton("長褲");
        upSummer.setSize(100,100);
        upWinter.setSize(100,100);
        downSummer.setSize(200,200);
        downWinter.setSize(200,200);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(upSummer);
        panel2.add(upWinter);
        add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(downSummer);
        panel3.add(downWinter);
        add(panel3);

        Handler handler = new Handler();
        upSummer.addActionListener(handler);
        upWinter.addActionListener(handler);
        downSummer.addActionListener(handler);
        downWinter.addActionListener(handler);
    }

    //設定視窗資訊
    public static void main(String[] args){
        CabinetFrame cFrame = new CabinetFrame();
		cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cFrame.setSize(300, 200); // set frame size
		cFrame.setVisible(true); 
    }

    private class Handler implements ActionListener{
        //匯入上衣(up)和褲子(down)
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==upSummer){
                
            }else if(event.getSource()==upWinter){

            }else if(event.getSource()==downSummer){

            }else{

            }
        }
    }
}