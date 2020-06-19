package technology.sola.safecracker;

public class Row {
  public static final int PARENT_FALLBACK = -1;
  public static final int ROW_COUNT = 16;
  private final int[] values;
  private final int[] childRowValues;
  private final Row parentRow;

  public Row(int[] values, int[] childRowValues, Row parentRow) {
    if (values.length != ROW_COUNT) {
      throw new IllegalArgumentException("values must be " + ROW_COUNT);
    }
    if (childRowValues != null && childRowValues.length != ROW_COUNT) {
      throw new IllegalArgumentException("childRowValues must be " + ROW_COUNT + " or null");
    }

    this.values = values;
    this.childRowValues = childRowValues;
    this.parentRow = parentRow;
  }

  public int getValueAtIndex(int index) {
    int value = values[index];

    return value == PARENT_FALLBACK ? parentRow.childRowValues[index] : value;
  }
}
