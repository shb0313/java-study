package prob6;

public class RectTriangle extends Shape {
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

	public RectTriangle(double i, double j) {
		this.width = i;
		this.hight = j;
	}

	public double getArea() {
		double area = getWidth() * getHight() * 0.5;
		return area;
	}

	public double getPerimeter() {
		double perimeter = width + hight + Math.sqrt(Math.pow(width, 2) + Math.pow(hight, 2));
		return perimeter;
	}
}