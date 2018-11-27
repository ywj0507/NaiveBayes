package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * 练手朴素贝叶斯例子
 * 训练样本 （R,1,3,4,3）
 */
public class demo {
	private static Logger log = Logger.getLogger(demo.class.getName());
	/*
	 * 定义训练集和测试集的元素个数
	 */
	public static final int Train_Num = 5000;
	public static final int Test_Num = 5000;
	public static final String FileName = "E:/test.txt";
	//存放读入数据
	public static Vector<String> inData = new Vector<>();
	private static Vector<int[]> catagory_R = new Vector<>();
	private static Vector<int[]> catagory_L = new Vector<>();
	private static Vector<int[]> catagory_B = new Vector<>();
	/**
	 * 读取原始数据操作
	 */
	public static boolean readData(String url) {
		try {
			Scanner in = new Scanner(new File(url));
			while(in.hasNextLine()) {
				String st = in.nextLine();
				inData.add(st);//文件内容写入
			}
			in.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
//		try {
//			FileReader read = new FileReader(FileName);
//			int c = 0;
//			while( read.read() !=-1) {
//				 System.out.print((char)c);
//				 c=read.read();
//			}
//			BufferedReader in = new BufferedReader(new FileReader(FileName));
//			line = in.readLine();
//			while(line!=null) {
//				System.out.println(line);
//				line = in.readLine();
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 数据预处理
	 * TODO
	 */
	public static void preTreatment(Vector<String> inData) {
		//换成每个向量
		int i=0;
		while(i<inData.size()) {
			int[] tem = new int[] {0,0,0,0};
			String[] sourceStr =  inData.get(i).split("," , 5);
			switch(sourceStr[0]) {
				case "R":{
					for(int j=1;j<5;j++) {
						tem[j-1] = Integer.parseInt(sourceStr[j]);
					}
					catagory_R.add(tem);
					break;
				}
				case "L":{
					for(int j=1;j<5;j++) {
						tem[j-1] = Integer.parseInt(sourceStr[j]);
					}
					catagory_L.add(tem);
					break;
				}
				case "B":{
					for(int j=1;j<5;j++) {
						tem[j-1] = Integer.parseInt(sourceStr[j]);
					}
					catagory_B.add(tem);
					break;
				}
			}
			i++;
		}
	}
	
	/**
	 *朴素贝叶斯算法实现
	 *TODO 
	 */
	public static double NaiveBayes(int[] x, Vector<int[]> catagory) {
		if(catagory.size()<=0) {
			return -1;
		}
		double[] ai_y = new double[4];
		int[] sum_ai = new int[] {0,0,0,0};
		for(int i = 0; i < 4; i++) {  //计算总数
			for(int j=0;j<catagory.size();j++) {
				if(x[i] == catagory.elementAt(j)[i]) {
					sum_ai[i]++;
				}
			}
		}
		for(int i=0; i<4;i++) {
			ai_y[i] = (double)sum_ai[i] / (double)catagory.size(); 
		}
		return ai_y[0]*ai_y[1]*ai_y[2]*ai_y[3];
	}
	/**
	 * 求最大值
	 * @param args
	 */
	private static double maxDouble(double... ds ) {
		double result = 0;
		for(double tem : ds) {
			if(tem>result) {
				result = tem;
				
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		//载入源数据
		readData("E:/bayes.txt");
		//预处理数据
		preTreatment(inData);
		//计算先验概率
		double y_R = (double)catagory_R.size() / (double)inData.size();
		double y_L = (double)catagory_L.size() / (double)inData.size();
		double y_B = (double)catagory_B.size() / (double)inData.size();
		//修正偏斜
		y_B = y_B*3.0;
		
		int[] x = new int[4];
		int sumR=0,sumL=0,sumB=0,cor=0;
		double x_R,x_L,x_B;
		for(int i=0;i<inData.size();i++) {
			for(int j =0;j<4;j++) {
				x[j] = Integer.parseInt(inData.elementAt(i).split(",", 5)[j+1]);
			}
			x_R = NaiveBayes(x,catagory_R)*y_R;
			x_L = NaiveBayes(x,catagory_L)*y_L;
			x_B = NaiveBayes(x,catagory_B)*y_B;
			log.info("R,L,B分别为："+x_R+" , "+x_L+" , "+x_B);
			if(x_R ==maxDouble(x_R,x_L,x_B)) {
				System.out.println("输入的第 "+i+" 个值被分为：R类");
				sumR++;
				if(inData.elementAt(i).split(",", 5)[0].equals("R")) {
					cor++;
				}
			}
			if(x_L ==maxDouble(x_R,x_L,x_B)) {
				System.out.println("输入的第 "+i+" 个值被分为：L类");
				sumL++;
				if(inData.elementAt(i).split(",", 5)[0].equals("L")) {
					cor++;
				}
			}
			if(x_B ==maxDouble(x_R,x_L,x_B)) {
				System.out.println("输入的第 "+i+" 个值被分为：B类");
				sumB++;
				if(inData.elementAt(i).split(",", 5)[0].equals("B")) {
					cor++;
				}
			}
		}
		System.out.println("正确率："+(cor*1.0)/(inData.size()*1.0)*100.0+"%");
		System.out.println("被分为R类个数："+sumR);
		System.out.println("被分为L类个数："+sumL);
		System.out.println("被分为B类个数："+sumB);
		
	}
}
