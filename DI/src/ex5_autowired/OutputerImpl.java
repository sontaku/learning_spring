package ex5_autowired;

import java.io.FileWriter;

public class OutputerImpl implements Outputer{

	private String path;
	
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public void writeMessage(String msg) throws Exception {
		FileWriter fw = new FileWriter(path);
		fw.write(msg);
		fw.close();
	}
	
}
