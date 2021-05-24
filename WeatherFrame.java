package team_12;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;

//產生點選雲時介面
public class WeatherFrame extends JFrame{
    private JLabel place;
    private JTextField location;//user 輸入查詢地址
    private JButton goSearch;
    private JPanel p;
    private JPanel otherp;

    //設定天氣介面
    public WeatherFrame(){
        super("今日氣溫");
        setLayout(new GridLayout(3,1));

        place = new JLabel("輸入查詢地址");
        place.setFont(new Font("Serif", Font.PLAIN, 20));
        location = new JTextField();
        goSearch = new JButton("查詢");
        
        p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(place);
        add(p);
        add(location);

        otherp = new JPanel();
        otherp.setLayout(new FlowLayout());
        otherp.add(goSearch);
        add(otherp);

        WeatherHandler weatherHandler  = new WeatherHandler();
        goSearch.addActionListener(weatherHandler);

    }

    //設定視窗資訊
    public static void main(String[] args){
        WeatherFrame wFrame = new WeatherFrame();
		wFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wFrame.setSize(400, 200); // set frame size
		wFrame.setVisible(true);
    }

    private class WeatherHandler implements ActionListener{
        //如按下查詢按鈕，去取的使用者輸入在location地區在去查詢
        @Override
        public void actionPerformed(ActionEvent event){
            String s = location.getText();
            System.out.printf("%s%n",s);
        }

    }
}