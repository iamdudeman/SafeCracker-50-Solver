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
    Row row3 = new Row(
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
      row2
    );
    Row row4 = new Row(
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
      row3
    );
    Row row5 = new Row(
      new int[] {
        19, PARENT_FALLBACK, 8, PARENT_FALLBACK,
        17, PARENT_FALLBACK, 6, PARENT_FALLBACK,
        6, PARENT_FALLBACK, 8, PARENT_FALLBACK,
        8, PARENT_FALLBACK, 16, PARENT_FALLBACK,
      },
      null,
      row4
    );

    Row[] rows = {row1, row2, row3, row4, row5};
    RowTurnState rowTurnState = new RowTurnState(rows);
    Column[] columns = new Column[Row.ROW_COUNT];

    for (int i = 0; i < columns.length; i++) {
      columns[i] = new Column(rows, rowTurnState);
    }

    for (int i = 1; i < rows.length; i++) {
      for (int j = 0; j < columns.length; j++) {
        System.out.print(columns[j].sum() + " ");
      }
      System.out.println();
      rowTurnState.turnRow(i);
    }

  }
}
