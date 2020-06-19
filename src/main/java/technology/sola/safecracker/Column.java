package technology.sola.safecracker;

public class Column {
  private static int count = 0;
  private int columnIndex;
  private Row[] rows;
  private RowTurnState rowTurnState;

  public Column(Row[] rows, RowTurnState rowTurnState) {
    this.rows = rows;
    this.rowTurnState = rowTurnState;
    this.columnIndex = count++;
  }

  public int sum() {
    int sum = 0;

    for (int i = 0; i < rows.length; i++) {
      int currentValue = rowTurnState.getRowValueForColumn(columnIndex, i);
      sum += currentValue;
    }

    return sum;
  }
}
