package l5;

import java.util.Scanner;

public class Point3d {
    private double x, y, z;

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3d() {
        this(0.0, 0.0, 0.0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distanceTo(Point3d other) {
        double dist = Math.sqrt(Math.pow(this.x - other.x, 2) +
                Math.pow(this.y - other.y, 2) +
                Math.pow(this.z - other.z, 2));
        return Math.round(dist * 100.0) / 100.0; // Округление до 2 знаков
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point3d point3d = (Point3d) obj;
        return Double.compare(point3d.x, x) == 0 &&
                Double.compare(point3d.y, y) == 0 &&
                Double.compare(point3d.z, z) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}