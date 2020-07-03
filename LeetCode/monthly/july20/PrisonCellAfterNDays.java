import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellAfterNDays {
    private int[] nextState(int[] cells) {
        int newState[] = new int[cells.length];
        for (int i = 1; i < cells.length - 1; ++i)
            newState[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;

        // newState[0] = newState[cells.length - 1] = 0;
        return newState;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0)
            return cells;

        boolean foundLoop = false;
        HashSet<String> set = new HashSet<>();
        int cycles = 0;

        for (int i = 0; i < N; ++i) {
            int next[] = nextState(cells);
            String key = Arrays.toString(next);

            if (!set.contains(key)) {
                set.add(key);
                cycles++;
            } else {
                foundLoop = true;
                break;
            }
            cells = next;
        }

        if (foundLoop) {
            N %= cycles;

            for (int i = 0; i < N; ++i)
                cells = nextState(cells);
        }

        return cells;
    }

    public static void main(String[] args) {
        int cells[] = { 1, 0, 0, 1, 0, 0, 1, 0 };
        int N = 1000000000;

        cells = new PrisonCellAfterNDays().prisonAfterNDays(cells, N);
        for (int i : cells)
            System.out.print(i + " ");
        System.out.println();
    }
}