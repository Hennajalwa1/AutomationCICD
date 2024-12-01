package Riowalacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonMapToData() throws IOException
	{
		//read Json to String
		String JsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir"+"C:\\Users\\hjalwauk\\eclipse-workspace\\Seleniumjio\\src\\test\\java\\Riowalacademy\\data\\PurchaseOrder.json"))
		,StandardCharsets.UTF_8);
	//String to hash map -> Jackson Databind
		ObjectMapper mapper= new  ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
	}
}