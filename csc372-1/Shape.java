public abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle: Area = " + area() + ", Perimeter = " + perimeter();
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: Area = " + area() + ", Perimeter = " + perimeter();
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: Area = " + area() + ", Perimeter = " + perimeter();
    }
}

class main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(5, 5, 6);
        Shape circle = new Circle(4);
        Shape square = new Rectangle(2.5, 9);

        Shape[] shapeArray = {triangle, circle, square};

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}
