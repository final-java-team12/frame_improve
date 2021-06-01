package team_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
package team_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Spiderweather{
    private ArrayList<String> weather=new ArrayList<>(3);
    private static final String[] city =
            {"基隆市", "臺北市", "新北市","桃園市","新竹市","新竹縣","苗栗縣","臺中市","彰化縣","南投縣"
                    ,"雲林縣","嘉義市","嘉義縣","臺南市","高雄市","屏東縣","宜蘭縣","花蓮縣","臺東縣","澎湖縣","金門縣","連江縣"};
    private static final String[] cityID =
            {"10017", "63", "65","68","10018","10004","10005","66","10007","10008"
                    ,"10009","10020","10010","67","64","10013","10002","10015","10014","10016","09020","09007"};
    private String citynum="63";
    public Spiderweather(String target) {

        //set city'id and city'name to search
        for(int i=0;i<22;i++)
        {
            if(target.equals(city[i]))
                citynum=cityID[i];
        }
        if(citynum.equals("65"))
            target = "板橋";
        else if(citynum.equals("10018"))
            target="新竹市東區";
        else if(citynum.equals("10007"))
            target="彰師大";
        else if(citynum.equals("10009"))
            target="斗六";
        else if(citynum.equals("10010"))
            target="太保";
        else if(citynum.equals("09007"))
            target="馬祖";
        else
            target=target.substring(0,2);
        System.out.println(target);

        String url="https://www.cwb.gov.tw/V8/C/W/OBS_County.html?ID="+citynum;
        String words="",title="";
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver diver=new ChromeDriver();

        Date date = new Date();
        String time=date.toString();
        System.out.println(time);

        diver.get(url);
        Document doc=Jsoup.parse(diver.getPageSource(),"utf-8");
        //System.out.println(doc);total web
        diver.quit();
        Elements place=doc.select("tbody[id=stations]");//整個表格
        Elements trs=place.select("tr");
        for(Element tr:trs)
        {
            Elements th=tr.select("th");
            Elements name=th.next();
            if(th.text().equals(target))
            {
                System.out.printf("name:%s\n", th.text());
                Elements tds = tr.select("td");

                int i=0;
                for (Element td :tds)
                {
                    if(i<2)
                        weather.add(td.text());//time and temperature
                    else if(i==2)
                    {
                        Elements a=td.select("img");
                        String b=a.toString();
                        String w=b.substring(b.indexOf("title")+7,b.length()-2);
                        System.out.println("a:"+w);
                        weather.add(w);
                    }
                    i++;
                }
                break;
            }
        }


    }
    public ArrayList<String> getWeather()
    {
        return weather;
    }
}

