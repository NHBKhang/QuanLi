/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.quanly;

import static com.mycompany.quanly.SanhCuoi.cacSanh;
import static com.mycompany.quanly.SanhCuoi.hienThi;
import static com.mycompany.quanly.SanhCuoi.hienThiFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author KHANG
 */
public class QuanLy {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner scanner = new Scanner(System.in);

        SanhCuoi sc = new SanhCuoi();
        init();
        
//        System.out.print("Hãy nhập tên sảnh:");
//        String tenSanh = scanner.nextLine();
//        System.out.print("Hãy vị trí sảnh:");
//        int viTri = scanner.nextInt();
//        System.out.print("Hãy sức chứa sảnh:");
//        long sucChua = scanner.nextInt();


//        String ngay = "30/1/2022";
//        GiaThue gia = new GiaThue(new HeSoGiaThue(1), ngay);
//        hienThiFile(sc);
//        hienThi(sc.tim("r", 0), sc);
//        System.out.println(sc.getMaSanh());
//        System.out.println(sc.getTenSanh());
//        System.out.println(sc.getViTri());
//        System.out.println(sc.getSucChua());

        


    }
    
    /**
     *
     */
    private static void init(){
        SanhCuoi sc = new SanhCuoi();
        try (Scanner scanner = new Scanner(sc.getFile())){
            scanner.useDelimiter(sc.getNgatFile());
            while (scanner.hasNextLine()){
                String maSC = scanner.next();
                String tenSanh = scanner.next();
                int viTri = Integer.parseInt(scanner.next());
                long sucChua = Long.parseLong(scanner.next());
                long giaThue = Long.parseLong(scanner.next());
                SanhCuoi sanh = new SanhCuoi(maSC, tenSanh, viTri, sucChua, giaThue);
                cacSanh.add(sanh);
                scanner.nextLine();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
