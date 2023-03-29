package 软件构造.最终.src.ch3;

import java.util.Random;

public abstract class Equation {

	private final int UPPER=100;
	private final int MAX = 100;
	private final int MIN = 0;
	private int left,right,result;
	private char op;

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public char getOp() {
		return op;
	}


	public void setOp(char op) {
		this.op = op;
	}



	public Equation() {
		// TODO Auto-generated constructor stub
	}
	private int generateRandom(int min,int max) {//生成随机数
		Random r = new Random();
		return r.nextInt(max-min+1)+min;
	}

	private boolean isBetween(int value,int min,int max) {
		return value >=min && value <=max;
	}

	public boolean isEqual(Equation e) {
		boolean b = false;
		if(e.getOp() != this.getOp()) {
			b = false;
		}
		else {
			b = e.getLeft() == this.getLeft() && e.getRight() == this.getRight();
		}
		return b;
	}

	public String toString() {//将算式转换成字符串
		return ""+this.getLeft() + this.getOp() +this.getRight();
	}
	public String toString2() {
		return toString()+"=";
	}
	public String toString3() {
		return toString2()+this.getResult();
	}

	protected abstract int calculate();//运算方法，因为加减不同，定义为抽象方法

	public void generateEquation(char op) {//构造算式
		Random random=new Random();
		do {
			left = generateRandom(MIN,MAX);
			right= generateRandom(MIN,MAX);
			if(op=='÷'){
				while(!Divchecking(left,right)){
					left=random.nextInt(UPPER+1);
					right=random.nextInt(UPPER+1);
				}
			}
			if(op=='×'){
				while(!Mulchecking(left,right)){
					left=random.nextInt(UPPER+1);
					right=random.nextInt(UPPER+1);
				}
			}
			result = calculate();
		}while(!isBetween(result,MIN,MAX));
		this.setOp(op);
	}

	boolean Divchecking(int left,int right){
		if(right==0){
			return false;
		}else if(left%right!=0){
			return false;
		}else if(left<right){
			return false;
		}else if(right==1){
			return false;
		}else if(left==right){
			return false;
		}
		else {
			return true;
		}
	}

	boolean Mulchecking(int left,int right){
		if(left==1||right==1||left==0||right==0){
			return false;
		}else {
			return true;
		}
	}

}
