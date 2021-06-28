package team_12;


import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class JFileChooserDemo
{
    private Path fileName;
    private int condition = 0; //情況1234分別代表四種衣服 1短袖 2長袖 3長褲 4短褲
    private longSleeve longSleeveData = new longSleeve(); //長袖
    private shortSleeve shortSleeveData = new shortSleeve(); //短袖
    private longPants longPantsData = new longPants(); //長褲
    private shortPants shortPantsData = new shortPants(); //短褲


    public JFileChooserDemo(shortSleeve shortSleeveData) //設定拿到短袖
    {
        setCondition(1);
        analyzePath();
    }

    public JFileChooserDemo(longSleeve longSleeveData) //設定拿到長袖
    {
        setCondition(2);
        analyzePath();
    }

    public JFileChooserDemo(longPants longPantsData) //設定拿到長褲
    {
        setCondition(3);
        analyzePath();
    }

    public JFileChooserDemo(shortPants shortPantsData) //設定拿到短褲
    {
        setCondition(4);
        analyzePath();
    }
    public void analyzePath()
    {
        // get Path to user-selected file or directory
        Path path = getFileOrDirectoryPath();

        if (path != null && Files.exists(path)) // if exists, display info
        {
            fileName = path.toAbsolutePath(); //檔案名是絕對路徑
        }
        else // Path does not exist
        {
            JOptionPane.showMessageDialog(null, path.getFileName() + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    } // end method analyzePath

    // allow user to specify file or directory name
    private Path getFileOrDirectoryPath()
    {
        // configure dialog allowing selection of a file or directory
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
                JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(null);

        // if user clicked Cancel button on dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        // return Path representing the selected file
        return fileChooser.getSelectedFile().toPath();
    }

    public Path getFileName(){ return fileName;} //回傳檔案名
    public void setCondition(int condition) { this.condition = condition; } //設定情況

}

