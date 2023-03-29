package 软件构造.最终.src.ch3;

public class AddEquation extends Equation {

	public AddEquation() {//构造方法
		// TODO Auto-generated constructor stub
		generateEquation('+');
	}

	public AddEquation(String s) {//字符串构造加法算式，将字符串算式转换成算式类的对象结构
		int index = s.indexOf("+");//通过index获取加号位置，根据加号位置获取字符串的子串
		int length = s.length();
		this.setLeft(Integer.parseInt(s.substring(0,index)));//获取左运算符
		this.setRight(Integer.parseInt(s.substring(index+1,length)));//获取右运算符
		this.setOp(s.charAt(index));//设置运算符
		//this.setOp('+');可以直接设置为加号
		this.setResult(calculate());//调用运算方法获取结果
	}

	@Override
	protected int calculate() {
		// TODO Auto-generated method stub
		return this.getLeft() + this.getRight();
	}

}