class Solution {
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, -1, 1, -1, 1};
    int[][] select = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            char[][] c = new char[5][5];
            
            for (int j = 0; j < 5; j++)
                c[j] = places[i][j].toCharArray();
    
            answer[i] = check(c);
        }
        
        return answer;
    }
    
    public int check(char[][] c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (c[i][j] == 'P') {
                    for (int l = 1; l <= 2; l++) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k] * l, ny = j + dy[k] * l;
                            if (range(nx, ny) && c[nx][ny] == 'P' && c[nx - dx[k]][ny - dy[k]] != 'X') {
                                return 0;
                            }
                        }
                    }
                    
                    for (int k = 4; k < 8; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (range(nx, ny) && c[nx][ny] == 'P') {
                            int f = 0;
                            for (int l = 0; l < 2; l++) {
                                int tx = i + dx[select[k][l]], ty = j + dy[select[k][l]];
                                if (range(tx, ty) && c[tx][ty] == 'X')
                                    f++;
                            }
                            if (f != 2)
                                return 0;
                        }
                    }
                }
            }
        }
        
        return 1;
    }
    
    public boolean range(int nx, int ny) {
        return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
    }
}
