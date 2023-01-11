package technology.sola.puzzle;

public class Dial {
  public static final int PARENT_FALLBACK = -1;

  private int state = 0;
  private final int[] values;
  private final int[] innerDialValues;
  private final Dial parentDial;

  public Dial(int[] values, int[] innerDialValues, Dial parentDial) {
    this.values = values;
    this.innerDialValues = innerDialValues;
    this.parentDial = parentDial;
  }

  public int getValueAtColumn(int columnIndex) {
    int index = (columnIndex + state) % values.length;
    int value = values[index];

    if (value == PARENT_FALLBACK) {
      index = (columnIndex + parentDial.state) % values.length;
      return parentDial.innerDialValues[index];
    }

    return value;
  }

  public void turn() {
    state = (state + 1) % values.length;
  }

  public int getState() {
    // We want minimum amount of turns (negative is counterclockwise
    return -(state > (values.length / 2) ? state - values.length : state);
  }
}
