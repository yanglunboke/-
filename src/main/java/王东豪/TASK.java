package 王东豪;

public class TASK {
    public static void main(String[] args) {
        student01 s1=new student01("王东豪","5421134604",0);
        student01 s2=new student01("杨伦","5421134606",100);
        student01 s3=new student01("牛逼","5421134607",70);
        student01 s4=new student01("牛叉","5421134608",30);
        student01 s5=new student01("无敌","5421134600",80);
        student01[] s=new student01[]{s1,s2,s3,s4,s5};
        student01 studentmax = new student01().maxScore(s);
        student01 studentmin = new student01().minScore(s);

        System.out.println("获得最高分的学生是"+studentmax.getName()+",学号为"+studentmax.getNumber()+",成绩为"+studentmax.getScore());
        System.out.println("获得最低分的学生是"+studentmin.getName()+",学号为"+studentmin.getNumber()+",成绩为"+studentmin.getScore());
    }

}

class student01 {
    private String name;
    private String number;
    private int score;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public student01(String name, String number, int score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    public student01() {
    }

    public student01 maxScore(student01[] s){
        int max=s[0].score;
        student01 stu=s[0];
        for(int i=0;i<s.length;i++) {
            if(s[i].score>max){
                max=s[i].score;
                stu=s[i];
            }
        }
        return stu;
    }

    public student01 minScore(student01[] s){
        int min=s[0].score;
        student01 stu=s[0];
        for(int i=0;i<s.length;i++) {
            if(s[i].score<min){
                min=s[i].score;
                stu=s[i];
            }
        }
        return stu;
    }
}
