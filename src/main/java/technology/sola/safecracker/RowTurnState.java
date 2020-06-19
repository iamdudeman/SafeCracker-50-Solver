package technology.sola.safecracker;

import java.util.Arrays;

public class RowTurnState {
  private int[] rowIndexes = new int[] {0, 0, 0, 0, 0};
  private Row[] rows;

  public RowTurnState(Row[] rows) {
    this.rows = rows;
  }

  public int getRowValueForColumn(int columnIndex, int rowIndex) {
    Row row = rows[rowIndex];

    return row.getValueAtIndex((columnIndex + rowIndexes[rowIndex]) % Row.ROW_COUNT);
  }

  public void turnRow(int row) {
    rowIndexes[row] = (rowIndexes[row] + 1) % Row.ROW_COUNT;
  }

  @Override
  public String toString() {
    return Arrays.toString(rowIndexes);
  }
}
