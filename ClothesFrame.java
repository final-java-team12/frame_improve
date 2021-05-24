package team_12;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

//點選置物籃產生的介面
public class ClothesFrame extends JFrame{
    //兩個ImageIcon給搭配出來的衣服褲子
    private ImageIcon shirt;
    private ImageIcon pant;
    
    //設定置物籃介面
    public ClothesFrame(){
        super("今日合適搭配~");
        setLayout(new GridLayout(2,1));

    }

    //設定視窗資訊
    public static void main(String[] args){
        ClothesFrame clFrame = new ClothesFrame();
		clFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clFrame.setSize(500, 500); // set frame size
		clFrame.setVisible(true);
    }
}