package chess;

public class CharUtill {
    public static int chessCharToInt(char c) {
        return Character.getNumericValue(c) - 10;
    }

    public static char chessIntToChar(int n) {
        return (char)(n + 97);
    }
}
