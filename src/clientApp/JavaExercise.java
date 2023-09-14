package clientApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Demo implements Serializable{
	
	public int a;
	public String name;
	public Demo(int a, String name) {
		super();
		this.a = a;
		this.name = name;
	}

}

public class JavaExercise {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File file = new File("new-file.txt");
		file.createNewFile();
		
		Demo demo = new Demo(15, "Ganesh");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream outPutStream = new ObjectOutputStream(fos);
		
		outPutStream.writeObject(demo);
		
		fos.close();
		outPutStream.close();
		
		
		Demo demo1 = null;
		
		FileInputStream fileName = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fileName);
		
		demo1 = (Demo)ois.readObject();
		System.out.println(demo1.name+" , "+demo1.a);
		
		File destFile = new File("dest-file.txt");
		destFile.createNewFile();
		
		FileInputStream srcFile = new FileInputStream(file);
		FileOutputStream destFile1 = new FileOutputStream(destFile);
		
		int data;

		while((data = srcFile.read()) != -1) {
			destFile1.write(data);
		}
		
		srcFile.close();
		destFile1.close();
	}

}
