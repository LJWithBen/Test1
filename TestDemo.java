import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

class Handle {
	private JFrame frame = new JFrame("Welcome to Test");// 容器；
	private JPanel nextpan = new JPanel();					//放置下一个图形的显示框
	private JPanel levelpan = new JPanel();					//放置游戏等级
	private JPanel scorepan = new JPanel();					//放置分数
	private JPanel pausepan = new JPanel();					//放置暂停按钮
	private JPanel temp = new JPanel();						//放置全部东西的地方
	private JLabel nextlab = new JLabel();					//靠，不写注释了
	private JLabel levellab = new JLabel("level");					//
	private JLabel scorelab = new JLabel("score");
	private JLabel lab = new JLabel("hehe",JLabel.CENTER);			//暂时代替游戏窗口
	private JTextField level = new JTextField();
	private JTextField score = new JTextField();
	private JButton pausebut = new JButton("exit");
	private Container con = frame.getContentPane();
	private JSplitPane rightjsp1 = null;							//分割线
	private JSplitPane rightjsp2 = null;
	private JSplitPane rightjsp3 = null;
	private JSplitPane leftjsp = null;
	public Handle(){
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);			//exit the program;
			}
		});
		score.setEnabled(false);
		level.setEnabled(false);
		frame.setLayout(new GridLayout(1,2));
		nextpan.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
		levelpan.setLayout(new GridLayout(1,2));
		scorepan.setLayout(new GridLayout(1,2));
		pausepan.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
		//temp.setLayout(new GridLayout(4,1));
		nextpan.add(nextlab);
		levelpan.add(levellab);
		levelpan.add(level);
		scorepan.add(scorelab);
		scorepan.add(score);
		pausepan.add(pausebut);
		rightjsp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,nextpan,levelpan);
		rightjsp1.setDividerSize(5);
		rightjsp1.setEnabled(false);
		rightjsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,rightjsp1,scorepan);
		rightjsp2.setDividerSize(5);
		rightjsp2.setEnabled(false);
		rightjsp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,rightjsp2,pausepan);
		rightjsp3.setDividerSize(5);
		rightjsp3.setEnabled(false);
		leftjsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,lab,rightjsp3);
		leftjsp.setDividerSize(5);
		leftjsp.setEnabled(false);
		con.add(lab);
		con.add(leftjsp);
		pausebut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		frame.setSize(400,300);
		SwingUtilities.updateComponentTreeUI (frame);
		frame.setVisible(true);
		frame.addComponentListener(new ComponentAdapter(){   
            public void componentResized(ComponentEvent e) {  
            	rightjsp1.setDividerLocation(0.7);
            	rightjsp2.setDividerLocation(0.8);
            	rightjsp3.setDividerLocation(0.9);
            	leftjsp.setDividerLocation(50);
            	}  
        });  
		rightjsp1.setDividerLocation(0.7);
	 	rightjsp2.setDividerLocation(0.8);
	 	rightjsp3.setDividerLocation(0.9);
	 	leftjsp.setDividerLocation(50);
	 	
	}
}

public class Test{
	public static void main(String[]agre){
		new Handle();
	}
}