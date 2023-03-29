package 软件构造.最终.src.ch3;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {
	private int count = 50;
	private int index = 0;//当前访问的算式序号
	private ArrayList<Equation> exercise = null;//习题数据结构：采用封装集合类的方法

	public ArrayList<Equation> getExercise() {
		return exercise;
	}

	public void setExercise(ArrayList<Equation> exercise) {
		this.exercise = exercise;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


	public Exercise () {//习题类构造方法
		index = 0;
		exercise = new ArrayList<Equation>();

	}

	public Exercise(int count) {//习题类构造方法
		this.setCount(count);//可构造任意数量的算术习题
		index = 0;
		exercise = new ArrayList<Equation>();
	}

	public boolean occursIn(Equation e) {
		boolean b = false;
		for(Equation equation: exercise) {
			if(equation.isEqual(e)) {
				b = true;
				break;
			}
		}
		return b;
	}

	public void generateExercise() {//生成随机算式
		int i = 0;
		Random r = new Random();
		while(i<count) {
			Equation e;//定义算式
			int n=r.nextInt(4);
			if(n==1){
				e = new AddEquation();//1代表加法
				if(!occursIn(e)) {
					exercise.add(e);
					i++;
				}
			}
			if(n==2){
				e = new SubEquation();//2代表减法
				if(!occursIn(e)) {
					exercise.add(e);
					i++;
				}
			}
			if(n==3){
				e = new DivEquation();//2代表除法
				if(!occursIn(e)) {
					exercise.add(e);
					i++;
				}
			}else {
				e = new MulEquation();//3代表乘法
				if(!occursIn(e)) {
					exercise.add(e);
					i++;
				}
			}

		}
	}

	public void generateAddExercise() {
		int i = 0;
		while(i<count) {
			Equation e = new AddEquation();
			if(!occursIn(e)) {
				exercise.add(e);
				i++;
			}
		}
	}

	public void generateSubExercise() {
		int i = 0;
		while(i<count) {
			Equation e = new SubEquation();
			if(!occursIn(e)) {
				exercise.add(e);
				i++;
			}
		}
	}

	public void generateMulExercise(){
		int i = 0;
		while(i<count) {
			Equation e = new MulEquation();
			if(!occursIn(e)) {
				exercise.add(e);
				i++;
			}
		}
	}

	public void generateDivExercise(){
		int i = 0;
		while(i<count) {
			Equation e = new DivEquation();
			if(!occursIn(e)) {
				exercise.add(e);
				i++;
			}
		}
	}

	public void printExercise() {//输出算式
		int i = 0;
		for(Equation e:exercise) {
			i++;
			System.out.println("("+i+")"+e.toString3());
			if(i%5 == 0) {
				System.out.println("\t");
			}
		}
	}

	public boolean hasNext() {//遍历算式
		return index < exercise.size();
	}
	public Equation next() {//获取下一个算式
		if(index < exercise.size()) {
			return exercise.get(index++);
		}
		else {
			return null;
		}
	}

	public boolean add(Equation e) {//在习题集中加入算式
		if(index < count) {
			exercise.add(e);
			index++;
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {//获取习题数量
		return exercise.size();
	}

	public Equation get(int index) {
		if(index < size()) {
			return exercise.get(index);
		}
		else {
			return null;
		}
	}

}

