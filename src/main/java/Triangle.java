public class Triangle {
    public Boolean isTriangleExist(double a,double b ,double c) {
        return Math.max(a, Math.max(b,c)) < a+b+c - Math.max(a,Math.max(b,c));
    }
}
