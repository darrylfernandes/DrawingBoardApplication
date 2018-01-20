import java.util.Scanner;

public class DrawingBoardApplication {
	private CanvasPlotter canvas_plotter = null;
	
	DrawingBoardApplication(){
		canvas_plotter = new CanvasPlotter();
	}
	
	public void draw(String[] command_tokens){
		
		try {
		
			switch (command_tokens[0].toLowerCase()) {
				case "c":
					if (command_tokens.length == 3){						
						canvas_plotter.draw_canvas(Integer.parseInt(command_tokens[1]),Integer.parseInt(command_tokens[2]));
						break;
					}
					else{
						throw new Exception("Invalid Command. Please try again");
					}
				case "l":					
					if (command_tokens.length == 5){						
						canvas_plotter.draw_line(Integer.parseInt(command_tokens[1]),Integer.parseInt(command_tokens[2]), Integer.parseInt(command_tokens[3]),Integer.parseInt(command_tokens[4]));
						break;
					}
					else{
						throw new Exception("Invalid Command. Please try again");
					}
				
				case "r":					
					if (command_tokens.length == 5){						
						canvas_plotter.draw_rectangle(Integer.parseInt(command_tokens[1]),Integer.parseInt(command_tokens[2]), Integer.parseInt(command_tokens[3]),Integer.parseInt(command_tokens[4]));
						break;
					}
					else{
						throw new Exception("Invalid Command. Please try again");
					}
				case "b":
					if (command_tokens.length == 4){						
						canvas_plotter.draw_bucketfill(Integer.parseInt(command_tokens[1]),Integer.parseInt(command_tokens[2]), command_tokens[3].charAt(0));
						break;
					}
					else{
						throw new Exception("Invalid Command. Please try again");
					}
				case "q":
					System.out.println("Application terminated");
					break;
				default:
					System.out.println("Invalid Command. Please try again");
					break;
				
			}
				
		} 
		catch (NumberFormatException n){
			System.out.println("Invalid co-ordinates passed in the Command. Please try again");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return;
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String command = new String();
		DrawingBoardApplication db = new DrawingBoardApplication();
		while (!command.equalsIgnoreCase("q")){			
			System.out.print("Enter a command: ");
			command = sc.nextLine();
			String[] command_tokens = command.split(" ");
			db.draw(command_tokens);
		}
		sc.close();
		
	}

}
