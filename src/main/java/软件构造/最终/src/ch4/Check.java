package 软件构造.最终.src.ch4;


import 软件构造.最终.src.ch3.Exercise;

public class Check {
	private int count;//习题数量
	private int right;//正确习题数量
	private int wrong;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getWrong() {
		return wrong;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}


	public Check() {//构造方法初始化
		// TODO Auto-generated constructor stub
		right = 0;
		wrong = 0;
	}

	public void check(Exercise ex, Answer an) {//批改方法，将习题和答案比对
		count = ex.size();//获取习题中算式数量
		int wrong = 0, right = 0;
		ex.setIndex(0);
		an.reset();//初始化习题中算式的序号
		while(ex.hasNext()) {//对习题中所有算式进行比对
			if(ex.next().getResult() == an.next()) {
				right++;
			}
			else {
				wrong++;
			}

		}
		setRight(right);//设置批改结果
		setWrong(wrong);
	}


	public void printCheck() {//输出批改结果到屏幕
		System.out.println("本次练习批改结果：");
		System.out.println("算式总数：" + count);
		System.out.println("正确：" + right);
		System.out.println("错误：" + wrong);
	}

}

