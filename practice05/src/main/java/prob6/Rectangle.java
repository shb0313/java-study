package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double hight;

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public Rectangle(double i, double j) {
		this.width = i;
		this.hight = j;
	}

	public double getArea() {
		double area = getWidth() * getHight();
		return area;
	}

	public double getPerimeter() {
		double perimeter = ((getWidth() + getHight()) * 2);
		return perimeter;
	}

	public void resize(double s) {
		this.width *= s;
		this.hight *= s;

	}
}
