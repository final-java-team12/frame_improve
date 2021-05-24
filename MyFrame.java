package team_12;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;

//主要介面
public class MyFrame extends JFrame {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JPanel p1;
	private JPanel p2;

	public MyFrame() {
		super("神蹟暖暖");
		setLayout(new GridLayout(2,1));

		//create image		 
		ImageIcon cabinet = new ImageIcon(getClass().getResource("cabinet.jpg"));
		cabinet.setImage(cabinet.getImage().getScaledInstance(290,290,Image.SCALE_DEFAULT));
		ImageIcon clothes = new ImageIcon(getClass().getResource("putclothes.jpg"));
		clothes.setImage(clothes.getImage().getScaledInstance(240,240,Image.SCALE_DEFAULT));
		ImageIcon weather = new ImageIcon(getClass().getResource("weather.jpg"));
		weather.setImage(weather.getImage().getScaledInstance(270,270,Image.SCALE_DEFAULT));
	
		label1 = new JLabel("點選衣櫃匯入衣服",cabinet,SwingConstants.RIGHT);
		label1.setFont(new Font("Serif", Font.BOLD, 17));
		label2 = new JLabel("點選搭配衣服",clothes,SwingConstants.LEFT);
		label2.setFont(new Font("Serif", Font.BOLD, 17));
		label3 = new JLabel("點選查詢今日天氣",weather,SwingConstants.LEFT);
		label3.setFont(new Font("Serif", Font.BOLD, 17));

		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.WHITE);
		p1.add(label1);
		p1.add(label3);
		
		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.add(label2);
		add(p1);
		add(p2,BorderLayout.CENTER);
		
		
		// create  mouse listeners
		MyEventListner handler = new MyEventListner();
		label1.addMouseListener(handler);
		label2.addMouseListener(handler);
		label3.addMouseListener(handler);
		
	}
	
	private class MyEventListner extends MouseAdapter {
		// handle each label clicked event
		@Override
		public void mouseClicked(MouseEvent event){
			if(event.getSource()==label1){
				//點選衣櫃產生衣櫃介面

				System.out.printf("%s%n",event.getSource());
				CabinetFrame cf = new CabinetFrame();
				cf.setVisible(true);
				cf.setLocationRelativeTo(null);
				cf.setSize(300, 200);

			}else if(event.getSource()==label2){
				//點選置物籃產生置物籃介面
				
				System.out.printf("%s%n",event.getSource());
				ClothesFrame clf = new ClothesFrame();
				clf.setVisible(true);
				clf.setLocationRelativeTo(null);
				clf.setSize(500, 500);
			
			}else{
				//點選雲產生天氣介面

				System.out.printf("%s%n",event.getSource());
				WeatherFrame wf = new WeatherFrame();
				wf.setVisible(true);
				wf.setLocationRelativeTo(null);
				wf.setSize(400, 200);
			
			}
		}
	}
	
} // end class MyFrame
