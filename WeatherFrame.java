package team_12;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.util.ArrayList;

//產生點選雲時介面
public class WeatherFrame extends JFrame{
    private JLabel place;
    private JButton goSearch;
    private JPanel p;
    private JPanel otherp;
    private JPanel anotherp;
    private JLabel showbroad;
    private final JComboBox<String> cityComboBox;
    private static final String[] city =
            {"基隆市", "臺北市", "新北市","桃園市","新竹市","新竹縣","苗栗縣","臺中市","彰化縣","南投縣"
                    ,"雲林縣","嘉義市","嘉義縣","臺南市","高雄市","屏東縣","宜蘭縣","花蓮縣","臺東縣","澎湖縣","金門縣","連江縣"};
    private ArrayList<String> weather_list;
    //設定天氣介面
    public WeatherFrame(){
        super("今日氣溫");
        setLayout(new GridLayout(4,1,5,5));

        place = new JLabel("輸入查詢地址");
        place.setFont(new Font("Serif", Font.PLAIN, 20));

        cityComboBox = new JComboBox<String>(city);
        goSearch = new JButton("查詢");

        p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(place);
        add(p);
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
            System.out.printf("%s%n",a.getWeather());
            weather_list=a.getWeather();
            String[] TMP=new String[3];
            int len=0;
            for(String i:weather_list) {
                TMP[len] = i;
                len++;
            }
            String newText="更新時間: "+TMP[0]+" 溫度: "+TMP[1]+" 天氣: "+TMP[2];
            anotherp=new JPanel();
            showbroad=new JLabel(newText);
            showbroad.setFont(new Font("Serif", Font.BOLD, 15));
            anotherp.add(showbroad);
            add(anotherp);
            revalidate();
        }

    }

    public JLabel getShowbroad() {
        return showbroad;
    }
}
