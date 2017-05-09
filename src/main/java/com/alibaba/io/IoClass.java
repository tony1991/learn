package com.alibaba.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.Writer;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IoClass {
   	public static String inputFilePath = "src/com/alibaba/io/inputFile.txt";
   	public static String outputFilePath = "src/com/alibaba/io/outputFile.txt";
	public static String createFilePath = "src/com/alibaba/io/createFile.txt";
	public static String createFileFloader = "src/com/alibaba/io//createFileFloader";
	public static String zipFilePath = "src/com/alibaba/io/zipFile.zip";
	public static String fileFloaderListPath = "src/com/alibaba/io";

	public static void main(String[] args) {
		// fileToByteArray();
		// readFile();
		// readCharFile();
		// byteArrayToFile();
		// charStreamToFile();
		// createFile();
		// printFileConstant();
		// deleteFile();
		// createFileFloader();
		// fileFloaderList();
		// changStreamCharByte();
		// changeStreamInMem();
		// printStream();
		// BufferedReaderUsed();
		// readUsedScnner();
		// mergeStream();
		// zipFile();
		// unzipFile();
		// unzipFiles();
		getLoaclEncode();
		// testPipedStream();
	}

	/**
	 * 从文件读入到数组中,字节流，判断文件是否读到末尾
	 */
	public static byte[] fileToByteArray() {
		byte[] content = null;
		try {
			FileInputStream inputStream = new FileInputStream(inputFilePath);
			BufferedInputStream in = new BufferedInputStream(inputStream); // 带缓冲的输入流
			// 实现了一个输出流，其中的数据被写入一个byte数组。缓冲区会随着数据的不断写入而自动增长。可使用toByteArray()和toString()获取数据。
			ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
			int size = 0;
			byte[] tempByte = new byte[1024];
			// 不知道文件的大小时，要判断是否读到文件尾部
			while ((size = in.read()) != -1) {
				out.write(tempByte, 0, size);// 输出流
			}
			in.close();
			content = out.toByteArray();
			System.out.println("Readed bytes count:" + content.length);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 读文件，字节流
	 */
	public static void readFile() {
		File file = new File(inputFilePath);
		byte[] b = new byte[(int) file.length()];// 根据文件大小确定byte的长度，节约空间
		try {
			InputStream inputStream = new FileInputStream(file);
			// inputStream.read(b);
			// System.out.println("file length=" + file.length());
			// inputStream.close();
			// System.out.println(b.toString());
			// System.out.println(new String(b));
			// 一个一个字节读取
			for (int i = 0; i < b.length; i++) {
				b[i] = (byte) inputStream.read();
				System.out.println(new String(b));
			}
			inputStream.close();
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 读文件，字符流
	 */
	public static void readCharFile() {
		File file = new File(inputFilePath);
		char[] c = new char[(int) file.length()];
		int count = 0;
		int temp = 0;
		try {
			Reader reader = new FileReader(file);
			while ((temp = reader.read()) != -1) {
				// reader.read(c, 0, temp);
				c[count++] = (char) temp;
			}
			reader.close();
			System.out.println(new String(c));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 数组中字节流写回文件中
	 */
	public static void byteArrayToFile() {
		byte[] content = fileToByteArray();
		System.out.println("content=" + content.length);
		try {
			// FileOutputStream字节流方式写入文件
			FileOutputStream out = new FileOutputStream(outputFilePath);
			out.write(content);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 字符流写回文件
	 */
	public static void charStreamToFile() {
		// 字符流方式写入文件
		try {
			String str = "char stream to file……";
			// 内容替换
			FileWriter fw = new FileWriter(outputFilePath);
			// 内容追加
			// FileWriter fw = new FileWriter(outputFilePath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建一个文件
	 */
	public static Boolean createFile() {
		File file = new File(createFilePath);
		Boolean isSuccess = false;
		try {
			isSuccess = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("createFile=" + isSuccess);
		return isSuccess;
	}

	/**
	 * 删除一个文件
	 */
	public static Boolean deleteFile() {
		File file = new File(createFilePath);
		Boolean isDeleteSueecss = false;
		if (file.exists()) {
			isDeleteSueecss = file.delete();
		}
		System.out.println("isDeleteSueecss=" + isDeleteSueecss);
		return isDeleteSueecss;
	}

	/**
	 * 创建一个文件夹
	 */
	public static Boolean createFileFloader() {
		File file = new File(createFileFloader);
		Boolean isCreateFileFloader = false;
		if (!file.exists()) {
			isCreateFileFloader = file.mkdir();
		}
		System.out.println("isCreateFileFloader=" + isCreateFileFloader);
		return isCreateFileFloader;

	}

	/**
	 * File类的两个常量，路径分割，windows下与linux下分割符不同，用这两个常量能保证通用
	 */
	public static void printFileConstant() {
		System.out.println("File.pathSeparator=" + File.pathSeparator);
		System.out.println("File.pathSeparatorChar=" + File.pathSeparatorChar);
		System.out.println("File.separator=" + File.separator);
		System.out.println("File.pathSeparatorChar=" + File.separatorChar);

	}

	/**
	 * 列出指定目录的全部文件，包括隐藏文件
	 */
	public static void fileFloaderList() {
		File file = new File(fileFloaderListPath);
		// 判断指定路径时否为目录,同理判断文件是否为文件、是否为隐藏
		System.out.println("fileFloaderListPath is a directory true/flase "
				+ file.isDirectory());
		// 列出的时文件或文件夹名，没有完整路径
		String[] fileArray = file.list();
		for (int i = 0; i < fileArray.length; i++) {
			System.out.println(fileArray[i]);
		}
		// 列出完整路径
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}

	}

	/**
	 * OutputStreramWriter将输出的字符流转化为字节流
	 * 
	 * InputStreamReader将输入的字节流转换为字符流
	 */
	public static void changStreamCharByte() {
		File file = new File(outputFilePath);

		try {
			FileOutputStream out = new FileOutputStream(file);
			Writer writer = new OutputStreamWriter(out);// 字符流转换为字节流
			writer.write("char output stream");
			// 字符流有缓冲，没有下面这句，不能写如文件
			writer.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 字节流转换为字符流
		try {
			Reader read = new InputStreamReader(new FileInputStream(file));
			char[] b = new char[(int) file.length()];
			int len = read.read(b);
			System.out.println(new String(b, 0, len));
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ByteArrayInputStream 主要将内容写入内存
	 * 
	 * ByteArrayOutputStream 主要将内容从内存输出
	 */
	public static void changeStreamInMem() {
		String str = "ABCDE";
		try {
			ByteArrayInputStream bin = new ByteArrayInputStream(str.getBytes());
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			int temp = 0;
			while ((temp = bin.read()) != -1) {
				char ch = (char) temp;// 一个一个读取
				bout.write(Character.toLowerCase(ch));
			}
			String outStr = bout.toString();
			bout.close();
			bin.close();
			System.out.println(outStr);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用printStream
	 */
	public static void printStream() {
		try {
			PrintStream printStream = new PrintStream(outputFilePath);// 向文件输出
			String name = "zhiyong.lizy";
			String sex = "man";
			// 格式化输出
			printStream.printf("姓名：%s.性别：%s.", name, sex);
			printStream.close();
			// System.setOut(printStream);// 后面的system输出重定向到文件
			OutputStream out = System.err;// 向屏幕输出
			out.write(name.getBytes());
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * BufferedReader使用缓冲区
	 */
	public static void BufferedReaderUsed() {
		// 从键盘中读取内容
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		String str = null;
		System.out.println("请输入内容");
		try {

			str = buf.readLine();
			System.out.println("you input content:" + str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 从键盘读取更常用的方式,也可已从文件中输入
	public static void readUsedScnner() {
		Scanner sca = new Scanner(System.in);
		System.out.println("input content……");
		String str = sca.next();
		System.out.println("from keyboard content=" + str);

		try {
			Scanner scaFile = new Scanner(new File(inputFilePath));
			String strFile = null;
			strFile = scaFile.next();// 换行后的内容未能读出来
			System.out.println("from file content=" + strFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * SequenceInputStream合并流
	 */
	public static void mergeStream() {
		File file1 = new File(inputFilePath);
		File file2 = new File(outputFilePath);
		try {
			InputStream in1 = new FileInputStream(file1);
			InputStream in2 = new FileInputStream(file2);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			// 合并流
			SequenceInputStream sis = new SequenceInputStream(in1, in2);
			int temp = 0;
			while ((temp = sis.read()) != -1) {
				out.write(temp);
			}
			System.out.println("merge stream=" + out.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 压缩文件 ZipOutputStream
	 */
	public static void zipFile() {
		File file = new File(inputFilePath);
		File zipFile = new File(zipFilePath);
		try {
			InputStream input = new FileInputStream(file);
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
					zipFile));
			zipOut.putNextEntry(new ZipEntry(file.getName()));
			int temp = 0;
			while ((temp = input.read()) != -1) {
				zipOut.write(temp);
			}
			input.close();
			zipOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 解压文件 zipFile
	 */
	public static void unzipFile() {
		File zipFile = new File(zipFilePath);
		File unzipFile = new File(createFileFloader + File.separator
				+ "inputFile-unzip.text");
		try {
			ZipFile zip = new ZipFile(zipFile);
			ZipEntry entry = zip.getEntry("inputFile.txt");// 该方法解压压缩包中只有一个文件情况，要指定文件名
			OutputStream output = new FileOutputStream(unzipFile);
			InputStream input = zip.getInputStream(entry);
			int temp = 0;
			while ((temp = input.read()) != -1) {
				output.write(temp);
			}
			input.close();
			output.close();
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解压一个压缩包中多个文件情况 ZipInputStream
	 */
	public static void unzipFiles() {
		File file = new File(zipFilePath);
		File outFile = null;
		try {
			ZipFile zipFile = new ZipFile(file);
			ZipInputStream zipInput = new ZipInputStream(new FileInputStream(
					file));
			ZipEntry entry = null;
			InputStream input = null;
			OutputStream output = null;
			while ((entry = zipInput.getNextEntry()) != null) {
				System.out.println("解压缩" + entry.getName() + "文件");
				outFile = new File(createFileFloader + File.separator
						+ entry.getName());
				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdir();
				}
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				input = zipFile.getInputStream(entry);
				output = new FileOutputStream(outFile);
				int temp = 0;
				while ((temp = input.read()) != -1) {
					output.write(temp);
				}
				input.close();
				output.close();
			}
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取本地默认编码
	 */
	public static void getLoaclEncode() {
		System.out.println("local encode="
				+ System.getProperty("file.encoding"));
	}

	/**
	 * 管道流主要可以进行两个线程之间的通信。
	 * 
	 * PipedOutputStream 管道输出流
	 * 
	 * PipedInputStream 管道输入流
	 */
	static class Send implements Runnable {
		private PipedOutputStream pipedOutputStream = null;

		public Send() {
			pipedOutputStream = new PipedOutputStream();
		}

		public PipedOutputStream getPipedOutputStream() {
			return this.pipedOutputStream;
		}

		@Override
		public void run() {
			String sendStr = "zhiyong.lizy";
			try {
				pipedOutputStream.write(sendStr.getBytes());
				pipedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	static class Receive implements Runnable {
		private PipedInputStream pipedInputStream = null;

		public Receive() {
			pipedInputStream = new PipedInputStream();
		}

		public PipedInputStream getPipedInputStream() {
			return this.pipedInputStream;
		}

		@Override
		public void run() {
			byte[] b = new byte[1000];
			int temp = 0;
			try {
				temp = this.pipedInputStream.read(b);
				System.out.println("received message= "
						+ (new String(b, 0, temp)));
				pipedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testPipedStream() {
		/**
		 * 在Java中，类中的静态方法不能直接调用动态方法。只有将某个内部类修饰为静态类，然后才能够在静态类中调用该类的成员变量与成员方法。
		 * 所以解决办法是将public class改为public static class.
		 */
		Send send = new Send();
		Receive receive = new Receive();
		// 建立管道链接
		try {
			send.getPipedOutputStream().connect(receive.getPipedInputStream());
			new Thread(send).start();
			new Thread(receive).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
