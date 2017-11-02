package jdk8;

import java.io.*;
import java.util.*;
 
/*import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.*;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;*/

public class DDWordReader {

	/*public static void main (String[] args) throws Exception {
        String fileName = "E://test.doc";
 
        if (args.length > 0) {
            fileName = args[0];
        }
 
        InputStream fis = new FileInputStream(fileName);
        System.out.println("111111111111111111");
        POIFSFileSystem fs = new POIFSFileSystem(fis);
        System.out.println("222222222222222");
        HWPFDocument doc = new HWPFDocument(fs);
        System.out.println("33333333333333333");
        Range range = doc.getRange();
 
        for (int i=0; i<range.numParagraphs(); i++) {
            Paragraph par = range.getParagraph(i);
            System.out.println("paragraph "+(i+1));
            System.out.println("is in table: "+par.isInTable());
            System.out.println("is table row end: "+par.isTableRowEnd());
            System.out.println(par.text());
        }
 
        Paragraph tablePar = range.getParagraph(0);
        if (tablePar.isInTable()) {
            Table table = range.getTable(tablePar);
            for (int rowIdx=0; rowIdx<table.numRows(); rowIdx++) {
                TableRow row = table.getRow(rowIdx);
                System.out.println("row "+(rowIdx+1)+", is table header: "+row.isTableHeader());
                for (int colIdx=0; colIdx<row.numCells(); colIdx++) {
                    TableCell cell = row.getCell(colIdx);
                    System.out.println("column "+(colIdx+1)+", text="+cell.getParagraph(0).text());
                }
            }
        }
    }*/

}
