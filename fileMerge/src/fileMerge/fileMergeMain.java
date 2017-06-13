package fileMerge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class fileMergeMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String June_8_file2 = args[0];
		
		FileReader fr = new FileReader(new File(June_8_file2));
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		ArrayList<String[]> voterData = new ArrayList<String[]>();
		
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			if(values.length > 1){
				voterData.add(values);
			}
		}
		
		br.close();
		fr.close();
		
		File myOutput = new File("/Users/benbrooks/Downloads/fileMerge.csv");
		
		FileOutputStream fos = new FileOutputStream(myOutput);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for (int i = 1; i < voterData.size(); i++) { //start at i = 1 to skip sample title row
			for(int j = 0; j < voterData.get(i).length; j++){
				bw.write(" " + voterData.get(i)[j] + ",");
			}
			bw.newLine();
		}
		
		bw.close();
		
		
	}

}
