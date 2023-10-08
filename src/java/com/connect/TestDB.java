/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connect;

//import Dao.MagazineDAO;
//import java.util.List;
//import model.Magazine;



/**
 *
 * @author OS
 */
public class TestDB {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        MagazineDAO dao = new MagazineDAO();
//         List<Magazine> arr = dao.getAllMagazines();
//        for(Magazine ma: arr){
//            System.out.println(ma.toString());
//        }
        DBContext.getConnection();
       

    }
}
