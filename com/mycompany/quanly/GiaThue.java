package com.mycompany.quanly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class GiaThue {
        
        private final static double giaCuoiTuan = 1.2;
        private double heSoGiaThue = 1;
        private double heSoKhac = 1;
        private double heSoTong = 0;

        

	private boolean cuoiTuan;
        
        private SanhCuoi sanhCuoi;
        
        private final  String url = "D:\\Data\\GiaThue.txt";
        File file = new File(url);
        
        private String date;
        private HeSoGiaThue buoi;
        
    /**
     *
     * @param gia
     * @throws java.io.IOException
     */
        public void them() throws IOException {       
            if (file.length() == 0 || !ngayDaTonTai(date)) {
                try(FileWriter fileWriter = new FileWriter(file, true)){
                        try(PrintWriter writer = new PrintWriter(fileWriter)){
                            writer.printf("%s\s",this.date);
                            writer.print(this.heSoKhac);
                            writer.println();
                        } catch (Exception ex){
                            System.out.print(ex);
                        }
                    } catch (Exception ex){
                        System.out.print(ex);
                    }
            }
            else {
//                System.out.println("Ban muon viet lai ngay " + this.date + "?");
//                System.out.println("1.Co | 2.Khong");
//                Scanner jout = new Scanner(System.in);
//                String i = jout.next();
//                if (i == "1"){
//                    try(FileWriter fileWriter = new FileWriter(file, true)){
//                        try(PrintWriter writer = new PrintWriter(fileWriter)){
//                            writer.printf("%s\s",this.date);
//                            writer.print(this.heSoKhac);
//                            writer.println();
//                        } catch (Exception ex){
//                            System.out.print(ex);
//                        }
//                    } catch (Exception ex){
//                        System.out.print(ex);
//                    }
//                }
//                else {
//                    ;
//                }
            }   
	}
        
        private boolean ngayDaTonTai(String date) throws FileNotFoundException{
            try (Scanner scanner = new Scanner(file)){
                while (scanner.hasNextLine()){
                    String ngay = scanner.next();
                    if (ngay == null ? date == null : ngay.equals(date)){
                        return true;
                    }
                    else {
                        scanner.nextLine();
                    }
                }
                
            } catch (Exception e) {
                System.out.print(e);
            }
            return false;
        }

	public GiaThue(HeSoGiaThue heSoGia, String date,  double heSoKhac) {
            this.heSoGiaThue = heSoGia.getHeSoThoiDiem();
            this.buoi = heSoGia;
            this.date = date;
            this.heSoKhac = heSoKhac;
            if (isCuoiTuan(date)){
                this.heSoTong = giaCuoiTuan + this.heSoGiaThue + this.heSoKhac - 2;
            } 
            else {
                this.heSoTong = this.heSoGiaThue + this.heSoKhac - 1;
            }         
	}
        public GiaThue(HeSoGiaThue heSoGia, String date) throws FileNotFoundException {
            this.heSoGiaThue = heSoGia.getHeSoThoiDiem();
            this.buoi = heSoGia;
            this.date = date;
            try (Scanner scanner = new Scanner (file)){
                while (scanner.hasNextLine()){
                    if (file.length() == 0) break;
                    String ngay = scanner.next();
                    if (this.date == null ? ngay == null : this.date.equals(ngay)){
                        double heSo = Double.parseDouble(scanner.next());
                        this.heSoKhac = heSo;
                        break;
                    }
                    else {
                        scanner.nextLine();
                    }
                }
            } catch (Exception e) {
                System.out.print(e);
            }
            if (isCuoiTuan(date)){
                this.heSoTong = giaCuoiTuan + this.heSoGiaThue + this.heSoKhac - 2;
            } 
            else {
                this.heSoTong = this.heSoGiaThue + this.heSoKhac - 1;
            }            
        }
        

        
    /**
     *
     * @return
     */
        
    /**
     * @return the cuoiTuan
     */
    public static boolean isCuoiTuan(String date) {
        String[] ngay = date.split("/");
        ArrayList<Integer> arrList = new ArrayList<>();
        for (String i: ngay){
            int j = Integer.parseInt(i);
            arrList.add(j);            
        }
        int[] arr = arrList.stream().mapToInt(i->i).toArray();
        LocalDate localDate = LocalDate.of(arr[2],arr[1],arr[0]);
        DayOfWeek day = localDate.getDayOfWeek();
        if (day.getValue() ==7 || day.getValue() == 6){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return the heSoKhac
     * @throws java.io.FileNotFoundException
     */
    public double getHeSoKhac() {
        return heSoKhac;
    }

    /**
     * @param heSoKhac the heSoKhac to set
     */
    public void setHeSoKhac(double heSoKhac) {
        this.heSoKhac = heSoKhac;
    }


    /**
     * @return the heSoTong
     * @throws java.io.FileNotFoundException
     */
    public double getHeSoTong(){
        return heSoTong;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
        if (isCuoiTuan(date)){
            this.heSoTong = giaCuoiTuan + this.heSoGiaThue + this.heSoKhac - 2;
        }
        else{
            this.heSoTong = this.heSoGiaThue + this.heSoKhac - 1;
        }
    }

    /**
     * @return the buoi
     */
    public HeSoGiaThue getBuoi() {
        return buoi;
    }



}
