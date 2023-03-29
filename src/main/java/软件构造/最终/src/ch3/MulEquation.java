package 软件构造.最终.src.ch3;

public class MulEquation extends Equation{

    public MulEquation(){
        generateEquation('×');
    }

    @Override
    protected int calculate() {
        return this.getLeft()*this.getRight();
    }
}
