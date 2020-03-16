package dao;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Orders;
//import model.Products;
//import dao.Operations;

public class orderOperations {
//	Operations op = new Operations();
	static String[] columns = {"Id","Name","Price","Quantity","Total"};
	static List<Orders> ordersList = new ArrayList<Orders>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void addOrders(Orders o) throws IOException {
		if(ordersList.add(o))
			System.out.println("\tOrder Placed Sucessfully");
		
	}
	
//	public void order() throws IOException{
//		System.out.println("\t\t Products in availability\n");
//		op.displayList();
//		System.out.print("How many products Do You Want :");
//		byte n=Byte.parseByte(br.readLine());
//		if(n>op.size() || n<op.size()) {
//			System.out.println("out of range");
//			order();
//		}
//		else
//		{
//		String selection[]= new String[n];
//		for(byte i=0;i<n;i++) {
//			System.out.print("Enter name of the product - "+(i+1)+": ");
//			selection[i]=br.readLine();
//		}
//		for (byte i=0;i<n;i++) {
//			for(Products p: list) {
//				
//			}
//		}
//		
//		}
//	}
	
	public void displayOrders() {
		if(ordersList.isEmpty())
			System.out.println("\n\tNo orders placed\n");
		else {
			System.out.println("\n\t\tId\t\tName\t\tPrice\t\tQuantity\t\tTotal");
			for (Orders o : ordersList) {
				System.out.print("\t\t"+o.getId());
				System.out.print("\t\t"+o.getName());
				System.out.print("\t\t"+o.getPrice());
				System.out.print("\t\t"+o.getQuantity());
				System.out.println("\t\t"+o.getTotal());
			}
		}

	}
	public void genereateReports() throws IOException {
		if(ordersList.isEmpty())
			System.out.println("\n\tNo orders placed\n");
		else {
		Workbook workbook= new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("orders");
		Row headerRow=sheet.createRow(0);
		for(int i=0;i<columns.length;i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}
		
		int rowNum=1;
		for(Orders o : ordersList ) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(o.getId());
			row.createCell(1).setCellValue(o.getName());
			row.createCell(2).setCellValue(o.getPrice());
			row.createCell(3).setCellValue(o.getQuantity());
			row.createCell(4).setCellValue(o.getTotal());
		}
		FileOutputStream fos=new FileOutputStream("orders.xlsx");
		workbook.write(fos);
		fos.close();
		workbook.close();
		}
	}
}
