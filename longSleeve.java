package team_12;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;

public class longSleeve { //長袖

    private List<Path> data = new ArrayList<Path>();

    public void setLongSleeve(Path fileName) //設定資料
    {
        if(Files.isDirectory(fileName))
        {
            try{
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(fileName);

                for (Path p : directoryStream)
                    data.add(p);
            }
            catch (IOException E)
            {
                System.out.println("讀取錯誤");
            }
        }
        else{
            data.add(fileName);
        }
        printLongSleeve();
    }

    public void printLongSleeve() //印出資料
    {
        System.out.println("長袖資料：");
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

