package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.print.attribute.standard.PrinterLocation;

public class demo {
	private int count=0;
	private int reCursion(int a) {
		if(a<1 && count != 0) {
			return count; 
		}
		if(count==0) {
			return -1;
		}
		while(a>=1) {
			count = count * a;
			a--;
		}
		return count; 
	}
	//TODO
	public String longestPalindrome(String s) {
        char[] c = new char[s.length()];
//		String str="";
//		c=str.charAt(0);
        
        return "";
    }
	/*
	 * 定义训练集和测试集的元素个数
	 */
	public static final int Train_Num = 5000;
	public static final int Test_Num = 5000;
	public static final String FileName = "E:/test.txt";
	
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
