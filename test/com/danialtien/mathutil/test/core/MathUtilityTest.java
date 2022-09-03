/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danialtien.mathutil.test.core;

import com.danialtien.mathutil.core.MathUtil;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author DELL
 */
public class MathUtilityTest {

    // Đây là class sẽ sử dụng các hàm của thư viện/framwork JUnit
    // để kiểm thử/kiểm tra code chính - hàm tínhGiaiThua() bên class core.MathUtil
    //viết code đẻ test code chính bên kia
//    Có nhiều quy tắc đặt tên hàm kiểm thử
//    Nhưng thường sẽ là nói lên mục đích của các case/ tình huống kiểm thử
//    tình huống xài hàm theo kiểu thành công và thất bại!!!
//    hàm dưới đây là tình huống test hàm chạy thành công trả về ngon
//    ta sẽ xài hàm kiểu well - đưa 5! 6! hok chơi đưa -5!, 30!
//    Test JUnit sẽ phối hợp với JVM để chạy hàm này
//    @Test phía hậu trường chính là public static void main(). chạy từ lúc deploy lên tomcat , nó active trong ram khi gọi request đầu tiên
//    Có @Test sẽ chạy thằng đó khi deploy
//    Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; // Test thử tình huống tử tế đàu
        long expected = 1;
//        long actual = '; //gọi hàm cần test bên core/app chính 
        long actual = MathUtil.getFactorial(n);

//        So sánh expected vs.actual dùng xanh xanh đỏ đỏ, framework 
//        Hàm giúp so sánh 2 giá trị nào đó có giống nhau ko
//        Nếu giống nhau -> thay màu xanh đèn đường - đươg thông code ngon
//             ít nhất cho case đang test
//          Nếu KO giống nhau-> thay bằng màu ĐỎ
//                   expected và actual ko giống nhau
        Assert.assertEquals(expected, actual);

//        gộp thêm vài case thành công/ 
        Assert.assertEquals(1, MathUtil.getFactorial(1)); // tui muon 1! = 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); // tui muon 2! = 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); // tui muon 3! = 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); // tui muon 4! = 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); // tui muon 5! = 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); // tui muon 6! = 720

    }

//    hàm getF(0 ta thiết kế có 2 tình huống xử lí
//    1. đưa data tử tế trong [0...20] -> tính đúng dc n! - done
//    2. đưa dât vào cà chớn, âm > 20; thiết kế của hàm là ném ra ngoại lệ 
//    kỳ vọng ngoại lệ xuất hiện khi N < 0 || N > 20
//    rất mong ngoại lệ xuất hiện với n cà chớn này 
//    nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ -> hàm chạy đúng như thiết kế -> XANH phải xuất hiện 
//    Nếu hàm nhận vào n < 0 || n > 20 va ko ném ra ngoại lệ -> hàm chạy SAI thiết kế, SAI kỳ vọng -> Màu ĐỎ 
//    Test case 
//    Input: -5
//    Expected: IllegalArgumentException xuất hiện 
//    tình huống bất thường, ngoại lệ, ngoài dự tính, dữ liệu
//    là những thứ ko thể đo lường - cách chúng có xuất hiện hay ko
//    assertEquals() ko dùng để so sánh 2 ngoại lệ 
//     equals() là bằng nhau hay ko trên value 
//    Màu đỏ do hàm đúng là có ném ngoại lệ, nhung ko phaie ngoại lệ như kì vọng 
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException(){
//        MathUtil.getFactorial(-5); // hàm @Test chạy, hàm getF() chạy 
//    }                               // sẽ ném ngoại lệ NumberFormatException
//    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); // hàm @Test chạy, hàm getF() chạy 
    }

//    cách khác để bắt ngoại lệ xuất hiện , viết tự nhiên hơn !!!
//    xài Lambda 
//    Test case: hàm sẽ ném về ngoại lệ xuất hiện nếu nhận vào 21
//    tui cần thấy màu xanh khi chơi với 21! 
    
//    @Test
//    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion() {
//        Assert.assertThrows(IllegalArgumentException.class, 
//                () -> MathUtil.getFactorial(-5));
//                
//        //MathUtil.getFactorial(-5); // hàm @Test chạy, hàm getF() chạy 
//    }
    
    
    
//    Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn 
//    có ném, tức là hàm chạy đúng thiết kế -> XANH 
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {
        
//        chủ động kiểm soát ngoại lệ 
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
//            Bắt try catch thì JUnit sẽ ra màu xanh do đã chủ động kiểm soát ngoại lệ
//              nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko???
//           có đoạn code kiểm tra đúng ngoại lệ IllegalArgumentException  xh
            Assert.assertEquals("Invalid argument. N must between 0..20", e.getMessage());
            
        }
//        Clean - Build: biên dịch biến đổi đoạn code thành .class. 
//          Sau đó biến đổi thành file .war nếu là app java web và .jar nếu là kiểu console truyền thống hay thư viện
//          Clean: xóa sạch những đồ build, đóng gói, biên dịch chữ ko phải xóa code sau đó biến đổi file class mới 
//          
        
    }

}
