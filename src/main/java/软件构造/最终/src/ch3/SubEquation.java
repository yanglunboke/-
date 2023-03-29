package 软件构造.最终.src.ch3;

public class SubEquation extends Equation {

	public SubEquation() {
		// TODO Auto-generated constructor stub
		generateEquation('-');
	}

	public SubEquation(String s) {
		int index = s.indexOf("-");
		int length = s.length();
		this.setLeft(Integer.parseInt(s.substring(0,index)));
		this.setRight(Integer.parseInt(s.substring(index+1,length)));
		this.setOp(s.charAt(index));
		this.setResult(calculate());
	}

	@Override
	protected int calculate() {
		// TODO Auto-generated method stub
		return this.getLeft() - this.getRight();
	}

}