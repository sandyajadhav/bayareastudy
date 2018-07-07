public class NQueenProblem{
	
	private boolean placeQueen(Position [] positions, int row, int n){
	
		if(row == n){
			return true;
		}
		for(int c = 0; c< n; c++){
			boolean isSafeToPlace = true;
			for(int queen= 0; queen < row; queen++){
				int qR = positions[queen].row;
				int qC = positions[queen].column;
				if(c == qC || (qR-qC) == (row-c) || (qR + qC) == (row + c) ){
					isSafeToPlace = false;
					break;
				}
				
				
			}
			if(isSafeToPlace){
				positions[row] = new Position(row,c);
				if(placeQueen(positions,row+1,n)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		int n = Integer.valueOf(args[0]);
		Position [] positions = new Position[n];
		
		NQueenProblem nQueenProblem = new NQueenProblem();
		nQueenProblem.placeQueen(positions,0,n);
		System.out.println("Queens positions");

		for(Position position:positions){
			System.out.println(position.row+", "+position.column);
		}
		
	}
}

class Position {
	int row;
	int column;
	
	public Position(int row, int column){
		this.row = row;
		this.column = column;
	}
}