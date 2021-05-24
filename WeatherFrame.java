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
import javax.swing.JComboBox;

//產生點選雲時介面
public class WeatherFrame extends JFrame{
    private JLabel place;
    private JTextField location;//user 輸入查詢地址
    private JButton goSearch;
    private JPanel p;
    private JPanel otherp;
    private final JComboBox<String> cityComboBox;
    private static final String[] city =
            {"基隆市", "台北市", "新北市","桃園市","新竹市","新竹縣","苗栗縣","台中市","彰化縣","南投縣"
            ,"雲林縣","嘉義市","嘉義縣","台南市","高雄市","屏東縣","宜蘭縣","花蓮縣","台東縣","澎湖縣","金門縣","連江縣"};
    //設定天氣介面
    public WeatherFrame(){
        super("今日氣溫");
        setLayout(new GridLayout(3,1));

        place = new JLabel("輸入查詢地址");
        place.setFont(new Font("Serif", Font.PLAIN, 20));
        location = new JTextField();
        cityComboBox = new JComboBox<String>(city);
        goSearch = new JButton("查詢");

        p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(place);
        add(p);
        //add(location);
        add(cityComboBox);

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
            String s = (cityComboBox.getSelectedItem()).toString();
            Spiderweather a=new Spiderweather(s);
            System.out.printf("%s%n",s);
        }

    }
}