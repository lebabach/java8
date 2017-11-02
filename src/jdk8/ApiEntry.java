package jdk8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;


public class ApiEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readFile1(new File("E://apiEntryBefore.txt"));
			//getEntry("abc","abc","abc","abc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		String name=StringUtils.EMPTY;
		String url=StringUtils.EMPTY;
		String typeRequest=StringUtils.EMPTY;
		String className=StringUtils.EMPTY;
		String word1=StringUtils.EMPTY;
		String word2=StringUtils.EMPTY;
		String word1Upper=StringUtils.EMPTY;
		String word2Upper=StringUtils.EMPTY;
		String firstWordInUrl=StringUtils.EMPTY;
		while ((line = br.readLine()) != null) {
			word2=StringUtils.EMPTY;
			String[] arrayString=line.split("	");
			typeRequest=arrayString[0];
			url=arrayString[1];
			String[] itemUrls= url.split("/");
			word2=itemUrls[itemUrls.length-1];
			word2Upper=word2.substring(0, 1).toUpperCase()+word2.substring(1);
			firstWordInUrl=itemUrls[1];
			if(itemUrls.length-2>0){
				word1=itemUrls[itemUrls.length-2];
				word1Upper=word1.substring(0, 1).toUpperCase()+word1.substring(1);	
			}
			name=mergerStringEitherAWord(word1Upper,word2Upper,"");
			className=mergerStringEitherAWord(name,"Request","");
			className=mergerStringEitherAWord("jp.co.dac.advr."+firstWordInUrl.replace("-", "_")+".models.form.", className, "");
			getEntry(name,url,typeRequest,className);
		}
	 
		br.close();
	}
	private static String getEntry(String name,String url,String typeRequest,String className){
		String entryFormat="{\r\n\t\"name\": \""+name+"\",\r\n\t\"url\" : \""+url+"\",\r\n\t\"typeRequest\": \""+typeRequest+"\",\r\n\t\"className\": \""+className+"\"\r\n}";
		System.out.println(entryFormat);
		return entryFormat;
	}
	public static String mergerStringEitherAWord(String firstName,String lastName,String word){
		List<String> list=new ArrayList<String>();
		list.add(firstName);
		list.add(lastName);
		return list.stream().filter(x->x!=null).collect(Collectors.joining(word));
	}
}
