package technology.sola.safecracker;

import static technology.sola.safecracker.Row.PARENT_FALLBACK;

public class Main {
  public static void main(String[] args) {
    Row row1 = new Row(
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
    Row row2 = new Row(
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
      row1
    );
    
  }
}
