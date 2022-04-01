package math;

public class Vector {
    private float x;
    private float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public void add(Vector other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void sub(Vector other) {
        this.x -= other.x;
        this.y -= other.y;
    }

    public void mult(float value) {
        this.x *= value;
        this.y *= value;
    }

    public Vector plus(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector minus(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    public Vector times(float value) {
        return new Vector(this.x * value, this.y * value);
    }

    public float magnitude() {
        return (float) Math.sqrt(magSq());
    }

    public float magSq() {
        return x * x + y * y;
    }

    public void normalize() {
        float mag = magnitude();
        this.x /= mag;
        this.y /= mag;
    }

    public Vector normalized() {
        Vector vector = new Vector(this.x, this.y);
        vector.normalize();
        return vector;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float dot(Vector other) {
        Vector a = this.normalized();
        Vector b = other.normalized();
        return a.x * b.x + a.y * b.y;
    }
}
