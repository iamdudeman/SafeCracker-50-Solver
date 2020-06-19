package technology.sola.safecracker;

import static technology.sola.safecracker.Dial.PARENT_FALLBACK;

public class Main {
  public static final Dial dial1 = new Dial(
    new int[] {
      1, 10, 4, 5,
      3, 15, 16, 4,
      7, 0, 16, 8,
      4, 15, 7, 10,
    },
    new int[] {
      10, 10, 15, 7,
      19, 18, 2, 9,
      27, 13, 11, 13,
      10, 18, 10, 10,
    },
    null
  );
  public static final Dial dial2 = new Dial(
    new int[] {
      10, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      10, PARENT_FALLBACK, 9, PARENT_FALLBACK,
      8, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      9, PARENT_FALLBACK, 6, PARENT_FALLBACK,
    },
    new int[] {
      24, 8, 10, 20,
      7, 20, 12, 1,
      10, 12, 22, 0,
      5, 8, 5, 1
    },
    dial1
  );
  public static final Dial dial3 = new Dial(
    new int[] {
      0, PARENT_FALLBACK, 11, PARENT_FALLBACK,
      8, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      8, PARENT_FALLBACK, 10, PARENT_FALLBACK,
      11, PARENT_FALLBACK, 10, PARENT_FALLBACK,
    },
    new int[] {
      20, 8, 19, 10,
      15, 20, 12, 20,
      13, 13, 0, 22,
      19, 10, 0, 5,
    },
    dial2
  );
  public static final Dial dial4 = new Dial(
    new int[] {
      3, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      10, PARENT_FALLBACK, 14, PARENT_FALLBACK,
      11, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      12, PARENT_FALLBACK, 11, PARENT_FALLBACK,
    },
    new int[] {
      10, 17, 10, 5,
      6, 18, 8, 17,
      4, 20, 4, 14,
      4, 5, 1, 14,
    },
    dial3
  );
  public static final Dial dial5 = new Dial(
    new int[] {
      19, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      17, PARENT_FALLBACK, 6, PARENT_FALLBACK,
      6, PARENT_FALLBACK, 8, PARENT_FALLBACK,
      8, PARENT_FALLBACK, 16, PARENT_FALLBACK,
    },
    null,
    dial4
  );

  public static void main(String[] args) {
    Dial[] dials = {dial1, dial2, dial3, dial4, dial5};
    Column[] columns = new Column[Dial.VALUES_PER_DIAL_COUNT];

    for (int i = 0; i < columns.length; i++) {
      columns[i] = new Column(dials);
    }

    bruteForceSolve(columns, dials);
  }

  private static void bruteForceSolve(Column[] columns, Dial[] dials) {
    bruteForceSolve(columns, dials, 1);
  }

  private static void bruteForceSolve(Column[] columns, Dial[] dials, int dialToIterate) {
    for (int i = 0; i < Dial.VALUES_PER_DIAL_COUNT; i++) {
      if (dialToIterate < 4) {
        bruteForceSolve(columns, dials, dialToIterate + 1);
      }

      boolean isValidSolution = true;

      for (Column column : columns) {
        int sum = column.sum();
        if (sum != 50) {
          isValidSolution = false;
          break;
        }
      }


      if (isValidSolution) {
        outputSolution(dials);
      }

      dials[dialToIterate].turn();
    }
  }

  private static void outputSolution(Dial[] dials) {
    String solution = "[";

    for (Dial dial : dials) {
      solution += dial.getState() + ", ";
    }

    solution += "]";
    System.out.println("Solution: " + solution);
  }
}
// 1 8 8 15 18
