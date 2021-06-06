package team_12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JFileChooserDemo textFieldFrame; //開檔
    public static shortSleeve upSummerData = new shortSleeve();
    public static longSleeve upWinterData = new longSleeve();
    public static shortPants downSummerData = new shortPants();
    public static longPants downWinterData = new longPants();

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
    public static void main(String[] args) {
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
                textFieldFrame = new JFileChooserDemo(upSummerData); //開檔
                upSummerData.setShortSleeve(textFieldFrame.getFileName()); //將短袖放入陣列

            }else if(event.getSource()==upWinter){
                textFieldFrame = new JFileChooserDemo(upWinterData); //開檔
                upWinterData.setLongSleeve(textFieldFrame.getFileName()); //將長袖放入陣列

            }else if(event.getSource()==downSummer){
                textFieldFrame = new JFileChooserDemo(downSummerData); //開檔
                downSummerData.setShortPants(textFieldFrame.getFileName()); //將短褲放入陣列
            }else{
                textFieldFrame = new JFileChooserDemo(downWinterData); //開檔
                downWinterData.setLongPants(textFieldFrame.getFileName()); //將長褲放入陣列
            }
        }
    }
}
