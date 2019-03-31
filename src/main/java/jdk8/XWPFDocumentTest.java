/*package jdk8;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class XWPFDocumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readWordDocument();
	}
	public static void readWordDocument() { 
	    try { 
	            String fileName = "E:\\test.doc"; 
	          
	            if(!(fileName.endsWith(".doc") || fileName.endsWith(".docx"))) { 
	                   System.out.println("wrong files");
	            } else { 
	            
	            XWPFDocument doc = new XWPFDocument(new FileInputStream(fileName));      
	                    List<XWPFTable> table = doc.getTables();         
	                    
	                    for (XWPFTable xwpfTable : table) { 
	                                                        List<XWPFTableRow> row = xwpfTable.getRows(); 
	                                                        for (XWPFTableRow xwpfTableRow : row) { 
	                                                                List<XWPFTableCell> cell = xwpfTableRow.getTableCells(); 
	                                                                for (XWPFTableCell xwpfTableCell : cell) { 
	                                                                        if(xwpfTableCell!=null) 
	                                                                        { 
	                                                                                System.out.println(xwpfTableCell.getText()); 
	                                                                                List<XWPFTable> itable = xwpfTableCell.getTables(); 
	                                                                                if(itable.size()!=0) 
	                                                                                { 
	                                                                                        for (XWPFTable xwpfiTable : itable) { 
	                                                                                                List<XWPFTableRow> irow = xwpfiTable.getRows(); 
	                                                                                                for (XWPFTableRow xwpfiTableRow : irow) { 
	                                                                                                        List<XWPFTableCell> icell = xwpfiTableRow.getTableCells(); 
	                                                                                                        for (XWPFTableCell xwpfiTableCell : icell) { 
	                                                                                                                if(xwpfiTableCell!=null) 
	                                                                                                                {   
	                                                                                                                        System.out.println(xwpfiTableCell.getText()); 
	                                                                                                                } 
	                                                                                                        } 
	                                                                                                } 
	                                                                                        } 
	                                                                                } 
	                                                                        } 
	                                                                } 
	                                                        } 
	                    } 
	            } 
	    } catch(Exception e) { 
	            e.printStackTrace(); 
	    }
	    
	  }	

}
*/