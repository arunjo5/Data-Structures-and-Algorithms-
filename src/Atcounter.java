import static java.lang.System.*;

public class Atcounter
{
    public static final String TEXT_RED = "\u001B[31m";

    private String[][] atMat;

    public Atcounter()
    {
        int rows = 5;
        int col  =5;
        atMat = new String[rows][col];
        for (int x=0; x<atMat.length;x++) {
            for (int y=0; y<atMat[0].length;y++) {
                int rand = (int)Math.round(Math.random()*2);
                if (rand==1) {
                    atMat[x][y] = "@";
                }
                else {
                    atMat[x][y] = "-";
                }
            }
        }
//size the matrix
//use nested loops to randomly load the matrix
//you will need to use Math.random()
    }

    public int countAts(int r, int c)
    {
        if(r < 0 || r > atMat.length - 1 || c < 0 || c > atMat[0].length - 1) {
            return 0;
        }
        if (atMat[r][c].equals("-")) {
            return 0;
        }
        if(atMat[r][c].equals("@")) {
            atMat[r][c] = "-";
            int count = 1 + countAts(r-1,c) + countAts(r,c-1) + countAts(r+1, c) + countAts(r, c+1);
            return count;
        }
        return 0;
    }
    /*
     *this method will return all values in the matrix
     *this method should return a view of the matrix
     *that looks like a matrix
     */
    public String toString()
    {
        String s = "";
        for(int i = 0; i < atMat.length; i++) {
            for(int j = 0; j < atMat[0].length; j++) {
                s += atMat[i][j];
            }
            s += "\n";
        }
        return s;
    }
}