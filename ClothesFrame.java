package team_12;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

//點選置物籃產生的介面
public class ClothesFrame extends JFrame{
    //兩個ImageIcon給搭配出來的衣服褲子
    private ImageIcon shirt;
    private ImageIcon pant;
    private WeatherFrame weather;
    private JLabel labelShirt;
    private JLabel labelPant;

    //設定置物籃介面
    public ClothesFrame(){
        super("今日合適搭配~");
        setLayout(new GridLayout(2,1));
        labelShirt = new JLabel();
        labelPant = new JLabel();

        Random r = new Random();
        if (weather.temperature >= 20) //短袖短褲
        {
            int r1 = r.nextInt(CabinetFrame.upSummerData.getSize()); //隨機取亂數拿一件短袖
            shirt = new ImageIcon(CabinetFrame.upSummerData.getPath(r1));

            int r2 = r.nextInt(CabinetFrame.downSummerData.getSize()); ////隨機取亂數拿一件短褲
            pant = new ImageIcon(CabinetFrame.downSummerData.getPath(r2));
        }
        else { //長袖長褲
            int r1 = r.nextInt(CabinetFrame.upWinterData.getSize()); //隨機取亂數拿一件長袖
            shirt = new ImageIcon(CabinetFrame.upWinterData.getPath(r1));

            int r2 = r.nextInt(CabinetFrame.downWinterData.getSize()); ////隨機取亂數拿一件長褲
            pant = new ImageIcon(CabinetFrame.downWinterData.getPath(r2));
        }
        shirt.setImage(shirt.getImage().getScaledInstance(290,290,Image.SCALE_DEFAULT));
        labelShirt.setIcon(shirt);
        add(labelShirt);

        pant.setImage(pant.getImage().getScaledInstance(290,290,Image.SCALE_DEFAULT));
        labelPant.setIcon(pant);
        add(labelPant);


    }


}