package jdk8;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateFormat {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		System.out.println(getFormatIdWith(TableTypeEnum.User,11,1,PropertyCodeEnum.ManualPC,ActionTypeEnum.Update));
		int getProPerty =getPropertyCodeFrom(getFormatIdWith(TableTypeEnum.User,11,1,PropertyCodeEnum.ManualPC,ActionTypeEnum.Update));
		NumberFormat formatter = new DecimalFormat("#00");
		System.out.println(formatter.format(getProPerty));
		System.out.println(setPropertyCodeFrom(getFormatIdWith(TableTypeEnum.User,11,1,PropertyCodeEnum.ManualPC,ActionTypeEnum.Update),"00M"));
		/*Date input = new Date();
		LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(date);*/
		
		//System.out.println(convertToDate("150101"));
		/*String date="2015-10-01";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=formatter.parse(date);
		System.out.println(date1);*/
		
	}
	
	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyMMdd");
		return (Date)formatter.parse(date);
	}
	
	private static String getFormatIdWith(TableTypeEnum tableType,int lastNumberOfSequence,int lastNumberOfProperty, PropertyCodeEnum propertyCode, ActionTypeEnum actionType) {
		return tableType.getStatusCode()+getCurrentDate()+getSequenceCode(lastNumberOfSequence,actionType)+getPropertyCode(lastNumberOfProperty, propertyCode,actionType);
	}

	private static String getSequenceCode(int lastNumber,ActionTypeEnum actionType) {
		NumberFormat formatter = new DecimalFormat("#00000000");
		String code="";
		if(actionType==ActionTypeEnum.Update){
			code=formatter.format(lastNumber);
		}else if(actionType==ActionTypeEnum.Insert){
			code=formatter.format(++lastNumber);
		}
		return code;
	}

	private static String getPropertyCode(int lastNumber,PropertyCodeEnum propertyCode,ActionTypeEnum actionType) {
		NumberFormat formatter = new DecimalFormat("#00");
		String code="";
		if(actionType==ActionTypeEnum.Update){
			code=formatter.format(++lastNumber);
		}else if(actionType==ActionTypeEnum.Insert){
			code=formatter.format(lastNumber);
		}
		return code+propertyCode.getStatusCode(); 
	}

	private static String getCurrentDate() {
		String s;
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = (new Date());
		formatter = new SimpleDateFormat("yyMMdd");
		s = formatter.format(date1);
		return s;
	}
	
	public static int getSequenceCodeFrom(String index_no_table) {
		int indexFirst = getCurrentDate().toString().length() + 1;
		return Integer.parseInt(index_no_table.substring(indexFirst, indexFirst + 8));
	}

	public static int getPropertyCodeFrom(String index_no_table) {
		int indexFirst = getCurrentDate().toString().length() + 1;
		return Integer.parseInt(index_no_table.substring(indexFirst + 8,index_no_table.length()-1));
	}
	
	public static String setPropertyCodeFrom(String index_no_table,String propertyCode) {
		int indexFirst = getCurrentDate().toString().length() + 1;
		String idNoProperty=index_no_table.substring(0,indexFirst + 8);
		return idNoProperty+propertyCode;
	}
	
	
	public static int getDateFrom(String index_no_table) {
		int indexFirst = getCurrentDate().toString().length() + 1;
		return Integer.parseInt(index_no_table.substring(1, indexFirst));
	}

}

enum PropertyCodeEnum {
	ShootingApp("P"), ManualPC("N"), Migration("M"), Scanner("S");

	private String statusCode;

	private PropertyCodeEnum(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}

}
enum TableTypeEnum {
	User("Ｕ"), Company("Ｃ"),CardInfor("I"),ImageInfor("Ｐ") ;

	private String statusCode;

	private TableTypeEnum(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}

}
enum ActionTypeEnum {
	Delete("D"), Update("U"),Insert("I");

	private String statusCode;

	private ActionTypeEnum(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}

}