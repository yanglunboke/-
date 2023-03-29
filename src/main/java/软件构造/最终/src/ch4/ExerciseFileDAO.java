package 软件构造.最终.src.ch4;

import 软件构造.最终.src.ch3.Exercise;
import 软件构造.最终.src.ch3.AddEquation;
import 软件构造.最终.src.ch3.SubEquation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ExerciseFileDAO {

	public ExerciseFileDAO() {
		// TODO Auto-generated constructor stub
	}

	public void writeExerciseToFile(Exercise e, String fileName) {//习题写入到文件中
		File exFile = new File(fileName);//定义文件对象
		Writer out;//输出流
		try {
			out = new FileWriter(exFile, true);//定义输出对象
			while(e.hasNext()) {//遍历习题中的算式
				out.write(e.next().toString() + ",");
			}
		}catch(IOException ex) {
			System.out.println("ERROR" + ex);
		}
	}

	public Exercise readExerciseFromFile(String fileName) {//读文件
		File exFile = new File(fileName);//定义文件对象
		Exercise exercise = new Exercise();//定义习题对象
		String equation;//定义字符串类型的算式
		Scanner in = null;
		try {
			in = new Scanner(exFile);//初始化输入流
			in.useDelimiter(",");//输入流的分隔符
			while(in.hasNext()) {
				equation = in.next().replaceAll("\\s", "");//过滤非法字符
				if(equation.contains("+")) {
					exercise.add(new AddEquation(equation));
				}
				else {
					exercise.add(new SubEquation(equation));
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {//必须执行的语句在finally
			in.close();
		}
		return exercise;
	}

}

