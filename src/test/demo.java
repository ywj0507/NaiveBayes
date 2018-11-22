package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 * �������ر�Ҷ˹����
 * ѵ������ ��R,1,3,4,3��
 */
public class demo {

	/*
	 * ����ѵ�����Ͳ��Լ���Ԫ�ظ���
	 */
	public static final int Train_Num = 5000;
	public static final int Test_Num = 5000;
	public static final String FileName = "E:/test.txt";
	//��Ŷ�������
	public static Vector<String> inData = new Vector<>();
	private static Vector<int[]> catagory_R = new Vector<>();
	private static Vector<int[]> catagory_L = new Vector<>();
	private static Vector<int[]> catagory_B = new Vector<>();
	/**
	 * ��ȡԭʼ���ݲ���
	 */
	public static boolean readData(String url) {
		try {
			Scanner in = new Scanner(new File(url));
			while(in.hasNextLine()) {
				inData.add(in.nextLine());//�ļ�����д��
			}
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
	 * ����Ԥ����
	 * TODO
	 */
	public static void preTreatment(Vector<String> inData) {
		//����ÿ������
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
	 *���ر�Ҷ˹�㷨ʵ��
	 *TODO 
	 */
	public static double NaiveBayes(int[] x, Vector<int[]> catagory) {
		if(catagory.size()<=0) {
			return -1;
		}
		double[] ai_y = new double[4];
		int[] sum_ai = new int[] {0,0,0,0};
		for(int i = 0; i < 4; i++) {  //��������
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
	
	
	public  void main(String[] args) {
		readData("E:/test.txt");
		
		
		
	}
}
