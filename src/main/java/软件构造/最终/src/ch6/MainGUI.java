package 软件构造.最终.src.ch6;

import 软件构造.最终.src.ch3.Exercise;
import 软件构造.最终.src.ch4.Answer;
import 软件构造.最终.src.ch4.Check;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class MainGUI extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCenter, panelSouth;
	private JTextField tEquation[];//显示算式
	private JTextField tAnswer[];//输入算式的答案
	private JButton preButton, nextButton;//两个翻页按钮
	private JLabel pageIndex;//显示第几页
	private int equationCount;//显示算式数量
	private int pages, currentPage;//总页数，当前显示的页数
	private Exercise exercise;//习题类
	private Answer answer;//批改习题的答案类
	private JButton check;//批改按钮
	private JLabel labelResult;//显示批改结果

	private final int PAGE_SIZE = 20;//保存每一页显示的算式数量

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		this.setTitle("用户答题系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 280);//窗口宽度580，高度280
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);//定义窗口大小不能改变
		init();//自定义的初始化图形界面方法
	}

	/**
	 * 自定义初始化方法
	 */
	private void init() {
		JMenuBar menuBar = new JMenuBar();//初始化菜单栏
		setJMenuBar(menuBar);//设置菜单栏
		JMenu menuOnline = new JMenu("在线练习");
		menuBar.add(menuOnline);//菜单加入菜单栏
		//加法菜单项
		JMenuItem onlineAdd = new JMenuItem("加法");
		onlineAdd.setActionCommand("onlineAdd");
		menuOnline.add(onlineAdd);
		onlineAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				online(arg0);//自定义响应方法
			}
		});
		//减法菜单项
		JMenuItem onlineSub = new JMenuItem("减法");
		onlineSub.setActionCommand("onlineSub");
		menuOnline.add(onlineSub);
		onlineSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				online(arg0);//自定义响应方法
			}
		});
		//乘法菜单项
		JMenuItem onlineMul = new JMenuItem("乘法");
		onlineMul.setActionCommand("onlineMul");
		menuOnline.add(onlineMul);
		onlineMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				online(arg0);//自定义响应方法
			}
		});
		//除法菜单项
		JMenuItem onlineDiv = new JMenuItem("除法");
		onlineDiv.setActionCommand("onlineDiv");
		menuOnline.add(onlineDiv);
		onlineDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				online(arg0);//自定义响应方法
			}
		});
		//混合运算菜单项
		JMenuItem onlineMix= new JMenuItem("混合");
		onlineMix.setActionCommand("onlineMix");
		menuOnline.add(onlineMix);
		onlineMix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				online(arg0);//自定义响应方法
			}
		});

		JMenu menuJuan=new JMenu("试卷");
		menuBar.add(menuJuan);

		JMenuItem Juan=new JMenuItem("生成试卷");
		Juan.setActionCommand("Juan");
		menuJuan.add(Juan);
		Juan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				online(arg0);//自定义响应方法
			}
		});

		JMenu menuExit = new JMenu("退出");
		menuBar.add(menuExit);
		JMenuItem exit = new JMenuItem("退出");
		menuExit.add(exit);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

		//答题区面板
		panelCenter = new JPanel();
		//批改区面板
		panelSouth = new JPanel();
		FlowLayout flowLayout = (FlowLayout)panelSouth.getLayout();//放在面板的南区
		flowLayout.setAlignment(FlowLayout.LEFT);//不具管理器的对齐方式，居左对齐
		contentPane.add(BorderLayout.CENTER, panelCenter);//将两个面板添加到框架
		contentPane.add(BorderLayout.SOUTH, panelSouth);

		//初始化答题区
		tEquation = new JTextField[PAGE_SIZE];
		tAnswer = new JTextField[PAGE_SIZE];
		for(int i = 0; i < PAGE_SIZE; i++) {
			tEquation[i] = new JTextField(5);
			tEquation[i].setHorizontalAlignment(JTextField.RIGHT);
			tEquation[i].setBackground(panelCenter.getBackground());
			tEquation[i].setBorder(null);
			tEquation[i].setEditable(false);
			tAnswer[i] = new JTextField(2);
			panelCenter.add(tEquation[i]);
			panelCenter.add(tAnswer[i]);

			tEquation[i].setVisible(false);
			tAnswer[i].setVisible(false);
		}
		preButton = new JButton("前一页");
		preButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				prePage();//自定义方法，前翻页
			}

		});

		nextButton = new JButton("后一页");
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				nextPage();//自定义方法，后翻页
			}

		});
		panelCenter.add(preButton);
		//页数
		pageIndex = new JLabel();
		panelCenter.add(pageIndex);
		panelCenter.add(nextButton);
		preButton.setVisible(false);
		nextButton.setVisible(false);

		//批改区
		check = new JButton("批改");
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				check();//自定义批改方法
			}

		});

		labelResult = new JLabel();
		panelSouth.add(check);
		panelSouth.add(labelResult);
		check.setVisible(false);;
		labelResult.setVisible(false);
	}

	/**
	 * 自定义在线练习方法
	 */
	public void online(ActionEvent arg0) {
		if(arg0.getActionCommand() == "onlineAdd") {
			equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入加法算式数量"));
			exercise = new Exercise(equationCount);
			exercise.generateAddExercise();
		}
		else if(arg0.getActionCommand() == "onlineSub") {
			equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入减法算式数量"));
			exercise = new Exercise(equationCount);
			exercise.generateSubExercise();
		}else if(arg0.getActionCommand() == "onlineMul"){
			equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入乘法算式数量"));
			exercise = new Exercise(equationCount);
			exercise.generateMulExercise();
		}else if(arg0.getActionCommand() == "onlineDiv"){
			equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入除法算式数量"));
			exercise = new Exercise(equationCount);
			exercise.generateDivExercise();
		}
		else if(arg0.getActionCommand() == "onlineMix") {
			equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入混合算式数量"));
			exercise = new Exercise(equationCount);
			exercise.generateExercise();
		}else if(arg0.getActionCommand() == "Juan"){
			equationCount = Integer.parseInt(JOptionPane.showInputDialog("请选择试卷：（50/100道）"));
			exercise = new Exercise(equationCount);
			exercise.generateExercise();
		}

		answer = new Answer();
		for(int i = 0; i < equationCount; i++) {
			answer.add(-1);
		}

		pages = (int)Math.ceil(equationCount * 1.0 / PAGE_SIZE);
		currentPage = 1;
		labelResult.setText("");
		update();//自定义刷新图形界面方法
	}

	/**
	 * 自定义刷新图形界面
	 */
	public void update() {
		//i,算式在习题中的序号；j，当前页面中算式的序号，即图形组件序号
		for(int i = (currentPage - 1) * PAGE_SIZE, j = 0; i < currentPage * PAGE_SIZE; i++, j++) {
			if(i < equationCount) {
				tEquation[j].setText(exercise.get(i).toString2());
				tEquation[j].setBackground(panelCenter.getBackground());
				tEquation[j].setVisible(true);
				if(answer.get(i) != -1) {
					tAnswer[j].setText(Integer.toString(answer.get(i)));
				}
				else {
					tAnswer[j].setText("");
				}
				tAnswer[j].setVisible(true);
			}
			else {
				tEquation[j].setVisible(false);
				tAnswer[j].setVisible(false);
			}
		}
		//如果页数大于1，显示翻页按钮
		preButton.setVisible(pages > 1);
		nextButton.setVisible(pages > 1);
		preButton.setEnabled(currentPage > 1);
		nextButton.setEnabled(currentPage < pages);
		pageIndex.setText(currentPage + " / " + pages);
		check.setVisible(true);
		labelResult.setVisible(true);
		//批改按钮直到最后一页才有效
		if(currentPage == pages) {
			check.setEnabled(true);
		}
		else {
			check.setEnabled(false);
		}
	}

	//自定义翻页
	public void prePage() {
		for(int i = (currentPage - 1) * PAGE_SIZE, j = 0; i < currentPage * PAGE_SIZE; i++, j++) {
			if(i < equationCount && tAnswer[j].getText() != null && tAnswer[j].getText().length() > 0) {
				if(tAnswer[j].getText().matches("^[0-9]*$")) {
					answer.set(i, Integer.parseInt(tAnswer[j].getText()));
				}
			}
		}
		currentPage--;
		update();
	}

	public void nextPage() {
		for(int i = (currentPage - 1) * PAGE_SIZE, j = 0; i < currentPage * PAGE_SIZE; i++, j++) {
			if(i < equationCount && tAnswer[j].getText() != null && tAnswer[j].getText().length() > 0) {
				if(tAnswer[j].getText().matches("^[0-9]*$")) {
					answer.set(i, Integer.parseInt(tAnswer[j].getText()));
				}
			}
		}
		currentPage++;
		update();
	}

	/**
	 * 自定义批改方法
	 */
	public void check() {
		for(int i = (currentPage - 1) * PAGE_SIZE, j = 0; i < currentPage*PAGE_SIZE; i++, j++) {
			if(i < equationCount && tAnswer[j].getText() != null && tAnswer[j].getText().length() > 0) {
				if(tAnswer[j].getText().matches("^[0-9]*$")) {
					answer.set(i, Integer.parseInt(tAnswer[j].getText()));
				}
			}
		}
		Check ch = new Check();
		ch.check(exercise, answer);
		labelResult.setText("正确：" + ch.getRight() + "； 错误：" + ch.getWrong()+"   错题已导入错题本 ");
	}

}