package org.example;

import Lesson4.MyException;
import Lesson4.TriangleSq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangleSq {
    @Test
    void test() throws MyException {
        TriangleSq triangleSq = new TriangleSq();

        Assertions.assertThrows(MyException.class, ()-> triangleSq.sq(-4,5,6) );
        Assertions.assertThrows(MyException.class, ()-> triangleSq.sq(4,8,10) );
        Assertions.assertThrows(MyException.class, ()-> triangleSq.sq(3,4,5) );

    }
}
