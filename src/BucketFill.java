
public class BucketFill extends Shape {
	Canvas canvas;
	int x,  y;
	char fill;
	
	public BucketFill(int x, int y, char fill, Canvas canvas){
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.fill = fill;
		
	}
	
	boolean can_plot(int x, int y) throws Exception{
		if (this.canvas == null){
			throw new Exception("Cannot perform any action without a Canvas. Please try again by creating a Canvas");			
		}
		else{
			if ((x > this.canvas.width) || (y > this.canvas.height)){
				throw new Exception(String.format("Cannot perform this action since the dimensions provided are beyond the limits of the canvas. Please try again by providing range within the limits of :- width = %d and height = %d", this.canvas.width, this.canvas.height));
			}			
		}
		return true;
	}
	
	@Override
	void plot() throws Exception {
		if (can_plot(this.x, this.y)){
			char to_be_replaced_fill = this.canvas.canvas_plot[this.y][this.x];
			bucket_fill(this.x,this.y,to_be_replaced_fill);
		}

	}
	
	void bucket_fill(int x, int y, char to_be_replaced_fill) throws Exception{
		if (this.canvas.canvas_plot[y][x] == to_be_replaced_fill){
			this.canvas.canvas_plot[y][x] = this.fill;
			// check top, left, bottom, right cell to perform bucket fill
			bucket_fill(x,y-1,to_be_replaced_fill);
			bucket_fill(x-1,y,to_be_replaced_fill);
			bucket_fill(x,y+1,to_be_replaced_fill);
			bucket_fill(x+1,y,to_be_replaced_fill);
		}
		
	}

}
