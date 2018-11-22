package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;


public class demo {

	/*
	 * 定义训练集和测试集的元素个数
	 */
	public static final int Train_Num = 5000;
	public static final int Test_Num = 5000;
	public static final String FileName = "E:/test.txt";
	//存放读入数据
	public static Vector<String> inData = new Vector<>();
	/*
	 * 读取原始数据操作
	 */
	public static boolean readData(String url) {
		try {
			Scanner in = new Scanner(new File(url));
			while(in.hasNextLine()) {
				inData.add(in.nextLine());//文件内容写入
			}
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * 数据预处理
	 * TODO
	 */
	public static boolean preTreatment(Vector<String> sData) {
		//换成每个向量
		
		return false;
	}
	
	/*
	 *朴素贝叶斯算法实现
	 *TODO 
	 */
	public static void NaiveBayesClassif() {
		HashMap<String,Integer> element = new HashMap<String ,Integer>();
//		int [][]nation  = new int[Train_Num][Train_Num];
		String line;
		try {
			FileReader read = new FileReader(FileName);
			int c = 0;
			while( read.read() !=-1) {
				 System.out.print((char)c);
				 c=read.read();
			}
			BufferedReader in = new BufferedReader(new FileReader(FileName));
			line = in.readLine();
			while(line!=null) {
				System.out.println(line);
				line = in.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		NaiveBayesClassif();
	}
}
