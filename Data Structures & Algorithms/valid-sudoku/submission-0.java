class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check row valid
        for(char []row: board) {
            if (!isValidUnit(row)) return false;
        }

        // Check column valid
        for (int i = 0; i < 9; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < 9; j ++){
                list.add(board[j][i]);
            }
            char[] charArray = list.stream()
                    .map(String::valueOf)      // Character -> String
                    .collect(Collectors.joining())  // Ghép thành String
                    .toCharArray();            // String -> char[]
            if (!isValidUnit(charArray)) return false;
        }


        // Check 3x3
        for(int row = 0; row <9; row +=3 ) {
            for (int col = 0; col<9; col+=3) {
                if (!check3X3Valid(board, row, col)) return false;
            }
        }

        return true;
    }

    // Check 3X3
    private boolean check3X3Valid(char[][] board, int startRow, int startCol) {
        Set<Character> set = new HashSet<>();
        for(int row = startRow; row < startRow + 3; row ++) {
            for (int col = startCol; col < startCol + 3; col ++) {
                char c = board[row] [col];
                if(c=='.') continue;
                if(c < '1' || c >'9') return false;
                if (!set.add(c)) return false;
            }
        }

        return true;
    }

    // Check duplicate on a list
    private boolean isValidUnit(char [] list) {
        Set<Character> set = new HashSet<>();
        for(char character: list) {
            if(character == '.') continue;
            if(character < '1' || character > '9') return false;
            if (!set.add(character)) return false;
        }
        return true;
    }
}