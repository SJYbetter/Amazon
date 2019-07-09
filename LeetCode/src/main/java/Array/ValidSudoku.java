package Array;
import java.util.HashSet;
import java.util.Set;


public class ValidSudoku {
	public static boolean isValid(String[][] board) {
		//check row
		for (int i = 0; i < 9; i++) {
			Set<String> row = new HashSet<String>();
			for (int j = 0; j < 9; j++) {
				String c = board[i][j];
				if (".".equals(c)) continue;
				if (row.contains(c)) return false;
				row.add(c);
			}
		}
		
		//check col
		for (int i = 0; i < 9; i++) {
			Set<String> col = new HashSet<String>();
			for (int j = 0; j < 9; j++) {
				String c = board[j][i];
				if (".".equals(c)) continue;
				if (col.contains(c)) return false;
				col.add(c);
			}
		}
		//check 3 * 3 board
		for (int i = 0; i < 9; i++) {
			Set<String> set = new HashSet<String>();
			for (int j = 0; j < 9; j++) {
				int m = i/3*3 + j/3;
				int n = i%3*3 + j%3;
				String c = board[m][n];
				if (".".equals(c)) continue;
				if (set.contains(c)) return false;
				set.add(c);
			}
		}
		return true;
	}
	
	public boolean isValid2(char[][] board) {
		if (board.length != board[0].length) return false;
		for (int i = 0; i < 9; i ++) {
			Set<Character> cols = new HashSet<Character>();
			Set<Character> rows = new HashSet<Character>();
			Set<Character> cube = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				
				//row check
				if (board[i][j] != '.' && !rows.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !cols.add(board[j][i])) {
					return false;
				}
				//0, 0, 0,3,3,3,6,6,6,
				int rowIndex = 3 * (i/3);
				//0, 3, 6, 0,3,6,0, 3, 6
				int colIndex = 3 * (i%3);
				
				char cur_cube = board[rowIndex + j/3][colIndex + j%3];
				if (cur_cube != '.' && !cube.add(cur_cube )) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] board1 =  {			
				{"8","3",".",".","7",".",".",".","."},
				{"6",".",".","1","9","5",".",".","."},
				{".","9","8",".",".",".",".","6","."},
				{"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}			
		                     };
		boolean test1 = isValid(board1);
		System.out.print(test1);
		
		

	}

}
