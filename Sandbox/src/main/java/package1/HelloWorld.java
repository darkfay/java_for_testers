package package1;



class HelloWorld {
    public static void main(String[] args) {
        hello("world");

        Square s = new Square (5);
         System.out.println("Площадь квадрата cо cтороной " + s.l + " = " + s.area());

         Rectangle r = new Rectangle(4,6);
        System.out.println("Площадь прмоугольника cо cторонами " + r.a + " и " + r.b + " = " + r.area());

    }



    public static void hello(String somebody) {

        System.out.println("Hello, "+somebody+"!");
    }




}
