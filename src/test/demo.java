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
	 * ����ѵ�����Ͳ��Լ���Ԫ�ظ���
	 */
	public static final int Train_Num = 5000;
	public static final int Test_Num = 5000;
	public static final String FileName = "E:/test.txt";
	//��Ŷ�������
	public static Vector<String> inData = new Vector<>();
	/*
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
	}
	
	/*
	 * ����Ԥ����
	 * TODO
	 */
	public static boolean preTreatment(Vector<String> sData) {
		//����ÿ������
		
		return false;
	}
	
	/*
	 *���ر�Ҷ˹�㷨ʵ��
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
