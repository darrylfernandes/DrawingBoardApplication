
class Canvas extends Shape{
	
	public int width;
	public int height;
	char [][] canvas_plot;
	
	public Canvas(int width,int height){
		this.width = width;
		this.height = height+2;
		canvas_plot = new char[this.height][this.width];		
	}	
	
	
	@Override
	public void plot() throws Exception{
		// 1) Draw a horizontal line on x axis from  0 to width-1 (y axis will remain 0)
		Line line = new Line(0, 0, this.width-1, 0, '-', this);
		line.plot();
		
		// 2) Draw vertical line on y axis from 1 to height-2 (x axis will remain 0)		
		line = new Line(0,1,0,this.height-2,'|',this);
		line.plot();
		
		// 3) Draw another horizontal line on x axis from 0 to width-1 (y axis will be height-1)
		line = new Line(0,this.height-1,this.width-1,this.height-1,'-',this);
		line.plot();
		
		// 4) Draw final vertical line on y axis from  1 to height-2 (x axis will be width-1)		
		line = new Line(this.width-1,1,this.width-1,this.height-2,'|',this);
		line.plot();
		
	}
	
	
}

