package com.rama.app.shapes;

class shapes {
    void area(){
        System.out.println("Area of the Shapes");
    }
}

class circle extends shapes {
    void area(){
        System.out.println("Area of the Circle");
    }
}
class triangle extends shapes {
    void area(){
        System.out.println("Area of the Triangle");
    }
}
class rectangle extends shapes {
    void area(){
        System.out.println("Area of the Rectangle");
    }
}
public class Shape {
    public static void main ( String[] arga ) {
        shapes shape1 = new circle();
        shape1.area();

        shapes shape2 = new triangle();
        shape2.area();

        shapes shape3 = new rectangle();
        shape3.area();
    }
}