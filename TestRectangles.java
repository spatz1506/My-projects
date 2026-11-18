public class TestRectangles {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(2, 3, 4, 5);
		Rectangle r3 = new Rectangle(1.3, 4.4, 5.5, 6);
		
		System.out.println("r1 is centered at " + r1.getX() + ", " + r1.getY());
		System.out.println("r1 has width  of " + r1.getWidth());
		System.out.println("r1 has height of " + r1.getHeight()); 
		System.out.println("r2's area is " + r2.getArea());
		System.out.println("r2's perimeter is " + r2.getPerimeter());

		if (r2.contains(3,2))
			System.out.println("r2 contains point (3,2)");
		else
			System.out.println("r2 does not contain point (3,2)");

		if (r3.contains(r2)) 
			System.out.println("r3 contains r2");
		else 
			System.out.println("r3 does not contain r2");
         		
	}
	 
}

	class Rectangle {
		
		private double x;
		private double y;
		private double width;
		private double height;

		Rectangle () {
			this(0.0, 0.0, 1.0, 1.0);
		}

		public Rectangle (double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
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

		public double getWidth() {
			return width;
		}

		public void setWidth(double width) {
			this.width = width;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}
		public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    // extents
    public double getLeftX() {
        return x - (width / 2.0);
    }

    public double getRightX() {
        return x + (width / 2.0);
    }

    public double getTopY() {
        return y + (height / 2.0);
    }

    public double getBottomY() {
        return y - (height / 2.0);
    }

    // check if the point is inside the rectangular
    public boolean contains(double x, double y) {
        return (x >= getLeftX() && x <= getRightX()) &&
               (y >= getBottomY() && y <= getTopY());
    }

    
    public boolean contains(Rectangle r) {
        return r.getLeftX() >= this.getLeftX() &&
               r.getRightX() <= this.getRightX() &&
               r.getTopY() <= this.getTopY() &&
               r.getBottomY() >= this.getBottomY();
    }
}



	