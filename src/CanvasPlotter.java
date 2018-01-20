import java.util.Scanner;

/*
 *  Purpose:	1) Check if Canvas is plotted. If not, do not perform any task.
 *  			2) Check if any command to draw (line, rectangle) is within the dimensions of the canvas.
 *  			3) Plot the actions (line, rectangle, etc) into the canvas plot array
 */
public class CanvasPlotter {
	Canvas canvas;
	
	private void setCanvas(Canvas canvas){
		this.canvas = canvas;
	}	
	
	void draw_canvas(int width,int height) throws Exception{
		if (this.canvas != null){
			System.out.println("A canvas is already created. Cannot re-create Canvas in this open session. Restart the application to create new Canvas");
			return;
		}
		canvas = new Canvas(width, height);
		setCanvas(canvas);
		this.canvas.plot();
		draw();
	}
	
	void draw_line(int x_start, int y_start, int x_end, int y_end) throws Exception{
		Line line = new Line(x_start, y_start, x_end, y_end, 'x', this.canvas);
		line.plot();
		draw();
	}

	void draw_rectangle(int x_start, int y_start, int x_end, int y_end) throws Exception{		
		Rectangle rectangle = new Rectangle(x_start, y_start, x_end, y_end, 'x', this.canvas);
		rectangle.plot();
		draw();
	}
	
	void draw_bucketfill(int x, int y, char fill) throws Exception{
		BucketFill bucketfill = new BucketFill(x, y, fill, this.canvas);
		bucketfill.plot();
		draw();
	}
	
	public void draw() {			
		for(int i=0;i<this.canvas.height;i++) {
			for(int j=0;j<this.canvas.width;j++) {				 
				System.out.print(this.canvas.canvas_plot[i][j]);				
			}
			System.out.println();
		}
	}
}
