
public class Rectangle extends Shape {
	Canvas canvas;
	int x_start,  y_start,  x_end,  y_end;
	char fill;
	public Rectangle(int x_start, int y_start, int x_end, int y_end, char fill, Canvas canvas){
		this.canvas = canvas;
		this.x_start = x_start;
		this.x_end = x_end;
		this.y_start = y_start;
		this.y_end = y_end;
		this.fill = fill;
	}
	
	boolean can_plot(int x_start, int x_end, int y_start, int y_end) throws Exception{
		if (this.canvas == null){
			throw new Exception("Cannot perform any action without a Canvas. Please try again by creating a Canvas");			
		}
		else{
			if ((x_start > this.canvas.width) || (x_end > this.canvas.width) || (y_start > this.canvas.height) || (y_end > this.canvas.height)){
				throw new Exception(String.format("Cannot perform this action since the dimensions provided are beyond the limits of the canvas. Please try again by providing range within the limits of :- width = %d and height = %d", this.canvas.width, this.canvas.height));
			}
			else {
				if ((x_start == x_end) && (y_start == y_end)) {
					throw new Exception("Cannot perform this action since the co-ordinates to form a rectangle is not correct");
				}
			}
		}
		return true;
	}
	
	@Override
	void plot() throws Exception {
		if (can_plot(this.x_start, this.x_end, this.y_start, this.y_end)){
			Line line = new Line(this.x_start, this.y_start, this.x_end, this.y_start, this.fill, this.canvas);
			line.plot();
			
			line = new Line(this.x_start, this.y_start, this.x_start, this.y_end, this.fill, this.canvas);
			line.plot();
			
			line = new Line(this.x_start, this.y_end, this.x_end, this.y_end, this.fill, this.canvas);
			line.plot();
			
			line = new Line(this.x_end, this.y_start, this.x_end, this.y_end, this.fill, this.canvas);
			line.plot();
		}
	}

}
