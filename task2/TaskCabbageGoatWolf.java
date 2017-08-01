package home.task2;

/**
 * Created by Дмитрий on 24.06.2017.
 */
public class TaskCabbageGoatWolf {

    private static final int DELAY = 5000;

    private static final String[] CABBAGE = {
            "",
            "C A B B A G E",
            "  .-~~~~-.",
            " / /( ( '\\\\",
            "| ( ) || )  |",
            "\\ ) ) ' } / /",
            "(` \\ , /  ~)",
            " `-.`\\/_.-'",
            "     `\"\""
    };

    private static final String[] GOAT = {
            "",
            "     G   O   A   T",
            " ___.",
            " //  \\",
            " ((   ''",
            "   \\__,",
            " /6 (%)\\,",
            "(__/:\";,;\\--____----_",
            "  ;; :';,:';`;,';,;';`,`_",
            "   ;:,;;';';,;':,';';,-Y\\",
            "      ;,;,;';';,;':;';'; Z/",
            "     / ;,';';,;';,;';;'",
            "    / / |';/~~~~~\\';;'",
            "   ( K  | |      || |",
            "    \\_\\ | |      || |",
            "     \\Z | |      || |",
            "       L|_|      LL_|",
            "      LW/      LLW/"
    };
    private static final String[] WOLF = {
            "",
            "      W    O    L    F",
            "                     ,     ,",
            "                     |\\---/|",
            "                    /  , , |",
            "              __ .-'|  / \\ /",
            "     __ ___.-'        ._O|",
            "  ._'  '       :      _/",
            " / ,    .        .     |",
            ":  ;    :        :   _/",
            "|  |   .'     __:   /",
            "|  :   /'----'| \\  |",
            "\\  |\\       | /| |",
            " '.'| /       || \\ |",
            " | /|.'       '.l \\_",
            " || ||            '-'",
            " '-''-'`"
    };

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Task about 'CABBAGE', 'GOAT' and 'WOLF'");
        getSpaces(1);
        System.out.println("Condition: you need to transport to the other river side cabbage, goat and wolf. \n" +
                "The goat can eat the cabbage, but the wolf can eat the goat. \n" +
                "How to implement it correctly?");
        Thread.sleep(DELAY);
        getSpaces(2);
        Thread.sleep(DELAY);

        //draw cabbage
        //drawCabbage(CABBAGE);
        drawEntity(CABBAGE);
        getSpaces(2);
        Thread.sleep(DELAY);

        //draw goat
        //drawGoat(GOAT);
        drawEntity(GOAT);
        getSpaces(2);
        Thread.sleep(DELAY);

        //draw wolf
        //drawWolf(WOLF);
        drawEntity(WOLF);
        getSpaces(2);
        Thread.sleep(DELAY);

        //1 step
        System.out.println("1. Step");
        System.out.println("Transported the goat to the RIGHT and leave the cabbage and the wolf to the LEFT.");
        Thread.sleep(DELAY);
        //drawCabbage(CABBAGE);
        drawEntity(CABBAGE);
        System.out.println("v--------------- CABBAGE -> DO NOT TOUCH THE LEFT");
        getSpaces(2);
        Thread.sleep(DELAY);
        //drawWolf(WOLF);
        drawEntity(WOLF);
        System.out.println("v--------------- WOLF -> DO NOT TOUCH THE LEFT");
        getSpaces(2);
        Thread.sleep(DELAY);
        drawEntity(GOAT);
        System.out.println("GOAT");
        System.out.println("---------------> GOAT -> TRANSPORTED AND LEAVE TO THE RIGHT");
        getSpaces(3);

        //2 step
        System.out.println("2. Step");
        System.out.println("Transported and leave the cabbage to the RIGHT.\n " +
                "Return the goat to the LEFT.");
        Thread.sleep(DELAY);
        //drawCabbage(WOLF);
        drawEntity(WOLF);
        System.out.println("v--------------- WOLF -> DO NOT TOUCH THE LEFT");
        getSpaces(2);
        Thread.sleep(DELAY);
        //drawWolf(GOAT);
        drawEntity(GOAT);
        System.out.println("<--------------- GOAT -> RETURN TO LEFT");
        getSpaces(2);
        Thread.sleep(DELAY);
        System.out.println("CABBAGE");
        //drawCabbage(CABBAGE);
        drawEntity(CABBAGE);
        System.out.println("---------------> CABBAGE -> TRANSPORTED AND LEAVE TO THE RIGHT");
        getSpaces(3);

        //3 step
        System.out.println("3. Step");
        System.out.println("Transported and leave the wolf to the RIGHT");
        Thread.sleep(DELAY);
        //drawCabbage(WOLF);
        drawEntity(WOLF);
        System.out.println("---------------> WOLF -> TRANSPORTED AND LEAVE TO THE RIGHT");
        getSpaces(2);
        Thread.sleep(DELAY);
        //drawWolf(GOAT);
        drawEntity(GOAT);
        System.out.println("v--------------- GOAT -> DO NOT TOUCH THE LEFT");
        getSpaces(2);
        Thread.sleep(DELAY);
        drawEntity(CABBAGE);
        System.out.println("CABBAGE");
        System.out.println("v--------------- CABBAGE -> DO NOT TOUCH THE RIGHT");
        getSpaces(3);

        //4 step
        System.out.println("4. Step");
        System.out.println("Transported the goat to the RIGHT");
        Thread.sleep(DELAY);
        drawEntity(WOLF);
        System.out.println("v--------------- WOLF -> DO NOT TOUCH THE RIGHT");
        getSpaces(2);
        Thread.sleep(DELAY);
        //drawWolf(GOAT);
        drawEntity(GOAT);
        System.out.println("---------------> GOAT -> TRANSPORTED AND LEAVE TO THE RIGHT");
        getSpaces(2);
        Thread.sleep(DELAY);
        drawEntity(CABBAGE);
        System.out.println("CABBAGE");
        System.out.println("v--------------- CABBAGE -> DO NOT TOUCH THE RIGHT");
        getSpaces(3);
    }

    // method of drawing a cabbage in console
    private static void drawCabbage(String[] cabbage) {
        for (String s : cabbage) {
            System.out.println(s);
        }
    }

    // method of drawing a goat in console
    private static void drawGoat(String[] goat) {
        for (String s : goat) {
            System.out.println(s);
        }
    }

    // method of drawing a wolf in console
    private static void drawWolf(String[] wolf) {
        for (String s : wolf) {
            System.out.println(s);
        }
    }

    // method of printing spaces
    private static void getSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    // method of drawing string-array in console - universal drawing method
    private static void drawEntity(String[] entity) {
        for (String s: entity) {
            System.out.println(s);
        }
    }

}