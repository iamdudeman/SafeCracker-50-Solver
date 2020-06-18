package technology.sola.safecracker;

public class Row {
  private final int[] values;
  private final int[] childRowValues;
  private final Row parentRow;

  public Row(int[] values, int[] childRowValues, Row parentRow) {
    if (values.length != 12) {
      throw new IllegalArgumentException("values must be 12");
    }
    if (childRowValues != null && childRowValues.length != 12) {
      throw new IllegalArgumentException("childRowValues must be 12 or null");
    }

    this.values = values;
    this.childRowValues = childRowValues;
    this.parentRow = parentRow;
  }

  public int getValueAtIndex(int index) {
    int value = values[index];

    return value < 0 ? parentRow.childRowValues[index] : value;
  }
}
