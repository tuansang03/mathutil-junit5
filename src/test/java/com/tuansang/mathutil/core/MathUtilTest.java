/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tuansang.mathutil.core;

import com.tuansang.mathutil.junit5.core.MathUtil;
import static com.tuansang.mathutil.junit5.core.MathUtil.getFactorial;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

/**
 *
 * @author ADMIN
 */
public class MathUtilTest {

    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    // vào trong câu lệnh kiểm thử
    //chuẩ bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 720}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData")//tên hàm cung cấp data, ngầm định thứ tự
    //của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long excepted) {
        assertEquals(excepted, getFactorial(input));

    }

//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(120, getFactorial(5));
//    
//    }
    //Bắt ngoại lệ khi đưa data cà chớn!!!
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //xài biểu thức lambda
        //hàm nhận tham số thứ 2 là 1 cái object/ có code implement cái
        //function interface tên là Excecutable - có 1 hàm duy nhất không code
        // tên là execute()
        //chơi chậm
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

        //assertThrows(IllegalArgumentException.class, excObject);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }

}
