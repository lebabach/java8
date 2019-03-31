package jdk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class RestFull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getAddressByZipcode("7830060"));
		/*String bach="東京都昭島市松原町４－３－１８石川ビル  null null";
		System.out.println(bach.replaceAll("null", "").trim());*/
	}
	public static String getAddressByZipcode(String zipcode) {
		try {
			URL url = new URL("http://zipcloud.ibsnet.co.jp/api/search?zipcode="+zipcode);
			String query = "{'zipcode': '" + zipcode + "'}";

			// make connection
			URLConnection urlc;

			urlc = url.openConnection();

			// use post mode
			urlc.setDoOutput(true);
			urlc.setAllowUserInteraction(false);
			//urlc.setRequestProperty("content-type", "pplication/x-www-form-urlencoded; charset=utf-8");
			// send query
			PrintStream ps = new PrintStream(urlc.getOutputStream());
			ps.print(query);
			ps.close();

			// get result
			BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream(), "UTF-8"));
			String l = null;
			StringBuilder sb = new StringBuilder();
			while ((l = br.readLine()) != null) {
				//System.out.println(l);
				sb.append(l);
			}
			br.close();
			
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
