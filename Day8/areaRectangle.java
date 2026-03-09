package Day8;

public class areaRectangle {
    int length = 65;
    int breath = 6;
    int area = length * breath;

    public static void main(String[] args) {
        areaRectangle aRectangle = new areaRectangle();
        System.out.println("Length is: " + aRectangle.length);
        System.out.println("Width is: " + aRectangle.breath);
        System.out.println("Area of the rectangle is: " + aRectangle.area);
    }
}
