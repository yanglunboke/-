package 软件构造.最终.src.ch5;

import 软件构造.最终.src.ch3.Exercise;
import 软件构造.最终.src.ch3.Student;

import java.util.Scanner;

public class CommandUI {
	static String ui1[] = {"退出","在线练习","","",""};//菜单数组（根据表驱动编程）
	static String ui2[][]= {
			{},//退出下面没有二级菜单
			{"返回上一级菜单","加法","减法","乘法","除法","混合"},//在线练习
			{},{},{}//批改习题没有二级菜单
	};
	static Scanner sc = new Scanner(System.in);//输入流，方便读取键盘输入

	public CommandUI() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int command1,command2;//一级菜单和二级菜单的命令
		boolean exit = false;//退出变量
		while(!exit) {
			print1();//输出一级菜单
			command1 = sc.nextInt();
			switch(command1) {
				case 1:
					print2(command1);//根据一级菜单输出对应的二级菜单
					command2 = sc.nextInt();
					command1_1(command2);
					break;
				case 0:
					exit = true;
					System.out.println("您已成功退出，感谢使用本系统！");
					break;
				default:
			}
		}
		sc.close();
	}
	public static void print1() {//输出一级菜单
		System.out.println("口算练习---功能列表");
		for(int i = 1;i < ui1[i].length();i++) {
			if(ui1[i]!=null && ui1[i].length()>0) {
				System.out.println(""+i+""+ui1[i]);
			}
		}
		System.out.println("0"+ui1[0]);
		System.out.println("请选择功能序号");
	}

	public static void print2(int index) {//index为对应的一级菜单序号
		System.out.println("您选择了功能："+ index +ui1[index]);
		if(ui2[index] !=null && ui2[index].length>0) {
			System.out.println("请选择习题类型");
			for(int i = 1;i<ui2[index].length;i++) {
				System.out.println(""+ i +""+ui2[index][i]);
			}
			System.out.println("0"+ui2[index][0]);
		}
	}

	public static void command1_1(int index) {//在线习题对应的方法
		int count;
		System.out.println("您选择了" + index +ui2[1][index]);
		if(index == 0)
			return;
		System.out.println("请输入算式数量");
		count = sc.nextInt();
		Exercise ex = new Exercise(count);
		if(index == 1) {
			ex.generateAddExercise();
		}
		else if(index == 2) {
			ex.generateSubExercise();
		}
		else {
			ex.generateExercise();
		}
		Student s = new Student();
		s.setSc(sc);//设置输入流
		s.setExercise(ex);//设置习题
		s.practiceOneByOne();
	}
}
