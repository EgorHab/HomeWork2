package Lesson4;

public class TriangleSq {


    int p;
    int s;
    //int a = 4;
    //int b = 8;
    //int c = 10;

    public boolean testValue(int a,int b,int c) {
        return a>0 & b>0 & c>0 &
                (a+b)>c & (a+c)>b & (c+b)>a;

    }
    public void sq(int a, int b, int c) throws MyException {
        if(testValue(a,b,c)!=true) {throw new MyException("Введено неверное значение");
        }else {
            p = (a + b + c) / 2;
            s = (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Площадь треугольника: " + s);
        }
    }


    public static void main(String[] args) throws MyException {
        TriangleSq triangleSq = new TriangleSq();
        triangleSq.sq(-4, 8, 10);


    }
}
