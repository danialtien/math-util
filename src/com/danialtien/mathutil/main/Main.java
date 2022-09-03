/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danialtien.mathutil.main;

import com.danialtien.mathutil.core.MathUtil;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        // Thử nghiệm hàm tính giai thừa coi đúng như thiết kế hay ko
        // ta phải đưa ra các tình huống sử dụng hàm trong thực tế 
        //ví dụ: -5 coi tính dc hok
        //        0 = ?, 20 = ?, 21 = ?
        //Test case: một tình huống hàm app/ màn hình/tính năng dc đưa vào sử dụng
        //giả lập hành vi xài của ai đó!!!
        
        //Test case: là 1 tình huống sử dụng,xài app (hàm) mà nó bao hàm
        //Data đầu vào cụ thể nào đó
        //Output đầu ra ứng với xử lí của hàm/ chức năng của App, dĩ nhiên dùng đầu vào đê xử lí
        //Kì vọng: Mong hàm sẽ trả về value nào đó ứng với INPUT ở trên
        // So sánh đê xem Kết quả có như kì vọng hay ko
        
        long expected = 120; //tao kì cọng hàm ói về 120 nếu 5!
        int n = 5;           //input 
        long actual = MathUtil.getFactorial(5);
        System.out.println("5! = " + expected + " expected");
        System.out.println("5! = " + actual + " actual");
        
    }
    
}
