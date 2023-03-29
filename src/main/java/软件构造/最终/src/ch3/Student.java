package 软件构造.最终.src.ch3;

import 软件构造.最终.src.ch4.Answer;
import 软件构造.最终.src.ch4.Check;

import java.util.Scanner;

public class Student {
	private static Exercise exercise;
	private Answer answer;
	private Check check;
	private Scanner sc;

	public Student() {
		// TODO Auto-generated constructor stub
		check = new Check();
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.exercise = new Exercise();
		s.exercise.generateExercise();
		s.exercise.printExercise();

	}


	public static Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		Student.exercise = exercise;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public void practiceOneByOne() {//用户可以计算习题
		// TODO Auto-generated method stub
		answer = new Answer();
		exercise.setIndex(0);
		int i = 1;
		System.out.println("输入答案后回车继续下一题");
		while(exercise.hasNext()) {
			System.out.println("("+ i +")" + exercise.next().toString2());
			answer.add(sc.nextInt());//读取从键盘接收的答案同时加入答案集
		}
		check.check(exercise,answer);
		check.printCheck();

	}

}