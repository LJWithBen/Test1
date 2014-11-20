import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Handle{
	private JFrame frame = new JFrame("new file");
	private JFrame frame1 = new JFrame("word");
	private Container con = frame.getContentPane();
	private JTextArea text = new JTextArea();
	private JMenu menu = new JMenu("file");
	private JMenu menu1 = new JMenu("size");
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem openItem = new JMenuItem("open");
	private JMenuItem saveItem = new JMenuItem("save");
	private JMenuItem closeItem = new JMenuItem("close");
	private JMenuItem wordItem = new JMenuItem("word");
	private Object size1[] = {8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,72};
	private JList<Object> list = new JList<Object>(size1);
	private JPanel panWord1 = new JPanel();
	private JPanel panWord2 = new JPanel();
	private JTextField textWord = new JTextField();
	private JScrollPane jsp = new JScrollPane(list);
	private JButton butEnter = new JButton("确定");
	private JButton butCancel = new JButton("取消");
	private Font font = new Font("Serief",Font.BOLD,12);
	public Handle(){
		//openItem.setMnemonic('N');
		//saveItem.setMnemonic('S');
		//closeItem.setMnemonic('E');
		openItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK));
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK));
		closeItem.setAccelerator(KeyStroke.getKeyStroke('E',java.awt.Event.ALT_MASK));
		wordItem.setAccelerator(KeyStroke.getKeyStroke('W',java.awt.Event.CTRL_MASK));
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser jfc = new JFileChooser();
				int result = jfc.showOpenDialog(frame);
				File f = null;
				if(result==JFileChooser.APPROVE_OPTION){
					f = jfc.getSelectedFile();
					frame.setTitle(f.getName());
					text.setText("");
				}
				if(f!=null){
					try{
						Scanner scan = new Scanner(new FileInputStream(f));
						scan.useDelimiter("\n");
						while(scan.hasNext()){
							text.append(scan.next());
							text.append("\n");
						}
						scan.close();
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		saveItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser jfc = new JFileChooser();
				int result = jfc.showSaveDialog(frame);
				File f = null;
				if(result==JFileChooser.APPROVE_OPTION){
					f = jfc.getSelectedFile();
				}
				if(f!=null){
					try{
						PrintStream p = new PrintStream(new FileOutputStream(f));
						p.print(text.getText());
						p.close();
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
			}
		});
		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		
		text.setFont(font);
		frame1.setLayout(new GridLayout(1,2));
		panWord1.setLayout(new GridLayout(2,1));
		panWord2.setLayout(new GridLayout(2,1));
		panWord1.add(textWord);
		panWord1.add(jsp);
		panWord2.add(butEnter);
		panWord2.add(butCancel);
		frame1.add(panWord1);
		frame1.add(panWord2);
		list.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()){
					int temp = list.getSelectedIndex();
					String s = list.getModel().getElementAt(temp).toString();
					textWord.setText(s);
				}
			}
		});
		butEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int sizes = 12;
					String itemSize = textWord.getText();
					try{
						sizes = Integer.parseInt(itemSize);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					text.setFont(new Font("Serif",0,sizes));
					frame1.dispose();
			}
		});
		butCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame1.dispose();
			}
		});
		wordItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame1.setSize(300,200);
				frame1.setLocation(350,250);
				frame1.setVisible(true);
				//text.setText("you have choose the word button");
			}
		});
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(closeItem);
		menu1.add(wordItem);
		menuBar.add(menu);
		menuBar.add(menu1);
		frame.setJMenuBar(menuBar);
		JScrollPane jp = new JScrollPane(text);
		con.add(jp);
		frame.setSize(700,500);
		frame.setLocation(300,200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
	}
}
public class MyNotepad{
	public static void main(String[]agre){
		new Handle();
	}
}