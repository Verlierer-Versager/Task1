package DrawPolygon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyForm {
    private JPanel mainPanel;
    private static JFrame frame;
    private Polygon polygon = new Polygon();
    private MyPanel paint = new MyPanel();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        frame = new JFrame("NewForm");
        frame.setContentPane(new MyForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    public MyForm() {
        mainPanel.setLayout(new GridLayout());

        try {
            polygon.addPoint(200, 50);
            polygon.addPoint(110, 100);
            polygon.addPoint(70, 115);
            polygon.addPoint(50, 100);
            polygon.addPoint(20, 70);
            polygon.addPoint(50, 50);
        }catch (Exception e){
        }

        mainPanel.add(paint);
        paint.addPolygon(polygon);
        frame.repaint();

        System.out.println("Изначальный периметр: " + polygon.getPerimeter());
        System.out.println("Изначальная площадь: " + polygon.getSquare());

        polygon.moving(70, 50);
        polygon.scale(2);
        frame.repaint();

        System.out.println("Периметр после масштабирования: " + polygon.getPerimeter());
        System.out.println("Площадь после масштабирования: " + polygon.getSquare());

        Polygon rectangle = polygon.findRectangle();
        ArrayList<Polygon.Point> points = rectangle.getPoints();
        System.out.print("Координаты точек прямоугольника, описывающего многоугольник: ");
        for (Polygon.Point point : points) {
            System.out.print("(" + point.x + "," + point.y + ") ");
        }
    }
}
