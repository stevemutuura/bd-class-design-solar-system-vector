package math;

public class Vector {
    private float x;
    private float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this.x = 0.0f;
        this.y = 0.0f;
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
        return new Vector(this.x + other.x , this.y - other.y);
    }

    public Vector minus(Vector other) {
        return new Vector(this.x - other.x, this.y -other.y);
    }

    public Vector times(float value) {
        return new Vector(this.x * value, this.y * value);
    }

    @Override
    public String toString() {
        return String.format("<(%f, %f)>", x, y);
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
        Vector v = new Vector(x, y);
        v.normalize();
        return v;
    }

    public float dot(Vector other) {
        Vector normalizedThis = this.normalized();
        Vector normalizedOther = other.normalized();
        return normalizedThis.x * normalizedOther.x +
                normalizedThis.y * normalizedOther.y;
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

}
