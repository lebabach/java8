/*package jdk8;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.*;
import org.supercsv.cellprocessor.ift.*;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class OpenCSVParserExample {

	public static void main(String[] args) throws Exception {

		//List<CompanyDepartmentSCV> emps = parseCSVFileLineByLine();
//		System.out.println("**********");
//		parseCSVFileAsList();
//		System.out.println("**********");
//		parseCSVToBeanList();
//		System.out.println("**********");
//		writeCSVData(emps);
		
		readWithCsvBeanReader();
	}
	
private static CellProcessor[] getProcessors() {
        
        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // DepartmentName
        };
        
        return processors;
}
	private static void readWithCsvBeanReader() throws Exception {

		ICsvBeanReader beanReader = null;
		try {
			beanReader = new CsvBeanReader(new FileReader("E:\\csv\\bac1.xlsx"), CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the values to the bean (names
			// must match)
			final String[] header = beanReader.getHeader(true);
			final CellProcessor[] processors = getProcessors();

			CompanyDepartmentSCV customer;
			while ((customer = beanReader.read(CompanyDepartmentSCV.class, header, processors)) != null) {
//				System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
//						beanReader.getRowNumber(), customer));
				System.out.println("ok");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
	}
	
	private static void parseCSVToBeanList() throws IOException {

		HeaderColumnNameTranslateMappingStrategy<CompanyDepartmentSCV> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<CompanyDepartmentSCV>();
		beanStrategy.setType(CompanyDepartmentSCV.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Department", "department");

		beanStrategy.setColumnMapping(columnMapping);

		CsvToBean<CompanyDepartmentSCV> csvToBean = new CsvToBean<CompanyDepartmentSCV>();
		CSVReader reader = new CSVReader(new FileReader("E:\\csv\\bach.xlsx"), ',');
		List<CompanyDepartmentSCV> emps = csvToBean.parse(beanStrategy, reader);
		emps.forEach(d -> {
			System.out.println(d.getDepartment());
		});
	}

	private static void writeCSVData(List<CompanyDepartmentSCV> emps) throws IOException {
		StringWriter writer = new StringWriter();
		CSVWriter csvWriter = new CSVWriter(writer, '#');
		List<String[]> data = toStringArray(emps);
		csvWriter.writeAll(data);
		csvWriter.close();
		System.out.println(writer);
	}

	private static List<String[]> toStringArray(List<CompanyDepartmentSCV> emps) {
		List<String[]> records = new ArrayList<String[]>();
		// add header record
		records.add(new String[] { "ID", "Name", "Role", "Salary" });
		Iterator<CompanyDepartmentSCV> it = emps.iterator();
		while (it.hasNext()) {
			CompanyDepartmentSCV emp = it.next();
			records.add(new String[] { emp.getDepartment() });
		}
		return records;
	}

	private static List<CompanyDepartmentSCV> parseCSVFileLineByLine() throws IOException {
		// create CSVReader object
		CSVReader reader = new CSVReader(new FileReader("E:\\csv\\bach.xlsx"), ',');

		List<CompanyDepartmentSCV> emps = new ArrayList<CompanyDepartmentSCV>();
		// read line by line
		String[] record = null;
		// skip header row
		reader.readNext();

		while ((record = reader.readNext()) != null) {
			CompanyDepartmentSCV emp = new CompanyDepartmentSCV();
			emp.setDepartment(record[0]);
			emps.add(emp);
		}

		reader.close();

		System.out.println(emps);
		return emps;
	}

	private static void parseCSVFileAsList() throws IOException {
		// create CSVReader object
		CSVReader reader = new CSVReader(new FileReader("employees.csv"), ',');

		List<CompanyDepartmentSCV> emps = new ArrayList<CompanyDepartmentSCV>();
		// read all lines at once
		List<String[]> records = reader.readAll();

		Iterator<String[]> iterator = records.iterator();
		// skip header row
		iterator.next();

		while (iterator.hasNext()) {
			String[] record = iterator.next();
			CompanyDepartmentSCV emp = new CompanyDepartmentSCV();
			emp.setDepartment(record[0]);
			emps.add(emp);
		}

		reader.close();

		System.out.println(emps);
	}
	
	 public static List<Object> readCsv(String csvFileName, Object o, CellProcessor[] processors) throws IOException {

	        ICsvBeanReader beanReader = null;
	        try {
	            beanReader = new CsvBeanReader(new FileReader(csvFileName), CsvPreference.STANDARD_PREFERENCE);

	            // the header elements are used to map the values to the bean (names must match)
	            final String[] header = beanReader.getHeader(true);
//	            final CellProcessor[] processors = getProcessors();
	            List<Object> li=new ArrayList<Object>();
	            Object newObject;
	            while ((newObject = beanReader.read(o.getClass(), header, processors)) != null) {
	                // process course
	                System.out.println(newObject);
	                li.add(newObject);
	            }
	            return li;
	        } finally {
	            if (beanReader != null) {
	                beanReader.close();
	            }
	        }
	    }

}
*/