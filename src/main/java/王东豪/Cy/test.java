package 王东豪.Cy;

public class test {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(2,3);
        System.out.println("圆柱体表面积:"+cylinder.area());
        cylinder.volume();
    }
}
