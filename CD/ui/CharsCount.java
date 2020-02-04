package com.cts.CD.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharsCount {

	public static void main(String[] args) {
		int charCount=0;
		int lineCount=0;
		int wordCount=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Filename :");
		String filename=sc.nextLine();
		try(FileReader fr=new FileReader(filename);
				BufferedReader br=new BufferedReader(fr);){
			String currentLine=br.readLine();
			while(currentLine!=null) {
				lineCount++;
				String[] words=currentLine.split(" ");
				wordCount=wordCount+words.length;
				for(String word:words) {
					charCount=charCount+word.length();
				}
				currentLine=br.readLine();
			}
			System.out.println("CharchterCount ="+charCount);
			System.out.println("lineCount ="+lineCount);
			System.out.println("WordsCount ="+wordCount);
		}catch(IOException excep) {
			excep.printStackTrace();
		}

	}

}
