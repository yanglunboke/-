package 软件构造.最终.src.ch3;

public class DivEquation extends Equation{

    public DivEquation(){
        generateEquation('÷');
    }

    @Override
    protected int calculate() {
        return this.getLeft()/this.getRight();
    }
}
