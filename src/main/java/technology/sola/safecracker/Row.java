package technology.sola.safecracker;

public class Row {
  public static final int PARENT_FALLBACK = -1;
  private final int[] values;
  private final int[] childRowValues;
  private final Row parentRow;

  public Row(int[] values, int[] childRowValues, Row parentRow) {
    if (values.length != 16) {
      throw new IllegalArgumentException("values must be 16");
    }
    if (childRowValues != null && childRowValues.length != 16) {
      throw new IllegalArgumentException("childRowValues must be 16 or null");
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
