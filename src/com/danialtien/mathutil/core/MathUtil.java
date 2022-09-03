/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danialtien.mathutil.core;

/**
 *
 * @author DELL
 */
public class MathUtil {
    // Trong class này cung cấp cho ai đó nhiều hàm xử lí toán học
    // Clone class Math của JDK
    // hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng thái/ giá trị
    //chọn thiết kế là hàm static
    
    // hàm tính giai thừa!!!
    //n! = 1.2.3.4....n
    // Ko có giai thừa cho số âm 
    //0! = 1! -1 quy ước
    // Giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
    // 20 giai thừa 18 con số 0, vừa kịp đủ cho kiểu long của java
    // 21 giai thừa tràn kiểu long 
    // bài này quy ước tính n! trog khoảng từ 0..20
    public static long getFactorial(int n){
//        Cách viết để quy để dành sau: Regresstion test
            if(n < 0 || n > 20){
                throw new IllegalArgumentException("Invalid argument. N must between 0..20");
            }
            
            if(n == 0 || n == 1)
                return 1; // kết thức cuộc chơi sớm nếu nhận những đầu vào đặc biệt 
            long product = 1; //tích nhân dồn,
            for(int i = 2; i <= n; i++)
                product *=i;
                
        return product;
    }
    
}
