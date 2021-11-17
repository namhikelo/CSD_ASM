/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NamPHSE150923;

public class Menu {
    public static int getChoice(Object[] options) {//2
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "-" + options[i]);//in phải xuống dòng không tù vl
        }
        System.out.print("Choose 1.." + options.length + ": ");
        return Check.getAnInteger("\nnhap 1 lua chon :", "nhap lai :");
    }
}


