package team_12;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;

public class shortSleeve { //短袖

    private List<Path> data = new ArrayList<Path>();
    public void setShortSleeve(Path fileName)
    {
        data.add(fileName);
        printshortSleeve();
    }

    public void printshortSleeve() //印出資料
    {
        System.out.println("短袖資料：");
        for(int i = 0; i < data.size(); i++) {
            Path tmpData = data.get(i);
            System.out.println(tmpData);
        }
    }

    public String getPath(int i) //得到路徑
    {
        Path path = data.get(i);
        return path.toString();
    }

    public int getSize()
    {
        return data.size();
    } //得到大小
}
