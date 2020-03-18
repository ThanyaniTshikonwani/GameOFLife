public class MainProgram {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife ( 10 , 10 );

        System.out.println ( "  Input" );

        game.aliveCell ( 4, 0 );
        game.deadCell ( 0,0 );
        game.deadCell ( 5,0 );
        game.deadCell ( 2,0 );
        game.aliveCell ( 2 , 1 );
        game.aliveCell ( 2 , 1 );
        game.aliveCell ( 4 , 1 );

        game.showBoard ();

        System.out.println ( "  generation " );
        game.generation ();

        game.showBoard ();
    }
}
