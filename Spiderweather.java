package team_12;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Spiderweather{
    public Spiderweather(String target) {
        System.out.println("hi");
        String url="https://www.cwb.gov.tw/V8/C/W/OBS_County.html?ID=10017";
        String words="",title="";
        try{
            Document doc=Jsoup.connect(url).get();
            Elements elements= doc.body().select("*");
            title=doc.title();
            for(Element element:elements)
                if(!element.ownText().equals(""))
                    words+=' '+element.ownText()+"\n";
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("fetch words from " + title + ':');
        System.out.println(words);
    }
}

