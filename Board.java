public class Board {
    private String[] cells;

    public Board() {
        cells = new String[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = String.valueOf(i + 1);
        }
    }

    public boolean placeMove(int position, String player) {
        if (position < 1 || position > 9 || !cells[position - 1].equals(String.valueOf(position))) {
            return false;
        }
        cells[position - 1] = player;
        return true;
    }

    public String checkWinner() {
        String[][] lines = {
            {cells[0], cells[1], cells[2]},
            {cells[3], cells[4], cells[5]},
            {cells[6], cells[7], cells[8]},
            {cells[0], cells[3], cells[6]},
            {cells[1], cells[4], cells[7]},
            {cells[2], cells[5], cells[8]},
            {cells[0], cells[4], cells[8]},
            {cells[2], cells[4], cells[6]}
        };

        for (String[] line : lines) {
            if (line[0].equals(line[1]) && line[1].equals(line[2])) {
                return line[0];
            }
        }

        for (int i = 0; i < 9; i++) {
            if (cells[i].equals(String.valueOf(i + 1))) {
                return null; // game ongoing
            }
        }

        return "draw";
    }

    public void print() {
        System.out.println("|---|---|---|");
        for (int i = 0; i < 9; i += 3) {
            System.out.printf("| %s | %s | %s |\n", cells[i], cells[i+1], cells[i+2]);
            if (i < 6) {
                System.out.println("|-----------|");
            }
        }
        System.out.println("|---|---|---|");
    }
}
