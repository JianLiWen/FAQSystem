package tfidfSimilarity;

import java.io.*;
//������������ʾ
public class Precomputation {

	public static void main(String[] args) {
		File tfidfVectorFile = new File("file\\Corpus\\FAQ\\vectorization\\TfIdf.txt");
		File squareRoot = new File("file\\Corpus\\FAQ\\precomputation\\squareRoot.txt");
		// ���������ļ��ĸ�·�������ڣ��򴴽�֮
		File fileParent = squareRoot.getParentFile();
		if(!fileParent.exists()) {
			fileParent.mkdirs();
		}
				
		// �����ʽ
		String charset = "GBK";// GBK----0
		// String charset = "UTF-8";// UTF-8

		if (tfidfVectorFile.isFile() && tfidfVectorFile.exists()) {
			try {
				OutputStreamWriter writer;
				writer = new OutputStreamWriter(new FileOutputStream(squareRoot, false)); // ���appendΪtrue�������׷��;���Ϊfalse���򸲸�ԭ�����ݡ�
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				
				InputStreamReader read;
				read = new InputStreamReader(new FileInputStream(tfidfVectorFile), charset); // ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				double ival = 0;
				double sum = 0;
				// ѭ�������ļ��е�ÿһ�У������浽����Ԥ����
				while ((lineTxt = bufferedReader.readLine()) != null) {
					sum = 0;
					String[] values = lineTxt.split(",");
					for(String value : values) {
						ival = Double.parseDouble(value);
						if(ival > 0) {
							sum += (ival * ival);
						}
					}
					bufferedWriter.write(Double.toString(Math.sqrt(sum)));
					bufferedWriter.newLine();
				}
				bufferedReader.close();
				bufferedWriter.close();

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
