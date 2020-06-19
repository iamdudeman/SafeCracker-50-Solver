package technology.sola.safecracker;

public class Column {
  private static int count = 0;
  private final int columnIndex;
  private final Dial[] dials;

  public Column(Dial[] dials) {
    this.dials = dials;
    this.columnIndex = count++;
  }

  public int sum() {
    int sum = 0;

    for (Dial dial : dials) {
      sum += dial.getValueAtColumn(columnIndex);
    }

    return sum;
  }
}
