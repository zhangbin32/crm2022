package com.bjpowernode.crm.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.io.OutputStream;

/*
    使用Apache-poi生成excel文件
 */
public class CreateExcelTest {
    public static void main(String[] args) throws Exception{
        //创建HSSFWorkbook对象,对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //使用wb创建HSSFSheet对象,对应wb文件中的一页
        HSSFSheet sheet = wb.createSheet("学生列表");
        //使用sheet创建HSSFRow对象,对应sheet中的一行
        HSSFRow row = sheet.createRow(0);  //行号,从0开始,依次增加
        //使用row创建HSSFCell对象,对应row中的列
        HSSFCell cell = row.createCell(0);//列号,从0开始,依次增加
        cell.setCellValue("学号");
        cell=row.createCell(1); //cell指向新的对象,之前指向的对象并不会被回收
        cell.setCellValue("姓名");     //插件保持内部是有引用继续指向对象的
        cell=row.createCell(2);
        cell.setCellValue("年龄");

        //生成HSSFCellStyle对象
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);  //样式:居中

        //使用sheet创建10个HSSFRow对象,对应sheet中的10行
        for (int i = 1; i <= 10; i++){
            row = sheet.createRow(i);

            cell = row.createCell(0);
            cell.setCellValue(100+i);
            cell=row.createCell(1);
            cell.setCellValue("name"+i);
            cell=row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(20+i);
        }

        //调用工具函数生成excel文件
        //目录必须提前创建好
        OutputStream os = new FileOutputStream("D:\\framework\\crm_ssm\\resources\\Excel\\student.xls");
        wb.write(os);

        //关闭资源
        os.close();
        wb.close();

        System.out.println("==========创建成功===========");
    }

}
