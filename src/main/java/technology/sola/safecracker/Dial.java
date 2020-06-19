package technology.sola.safecracker;

public class Dial {
  public static final int PARENT_FALLBACK = -1;
  public static final int VALUES_PER_DIAL_COUNT = 16;

  private int state = 0;
  private final int[] values;
  private final int[] innerDialValues;
  private final Dial parentDial;

  public Dial(int[] values, int[] innerDialValues, Dial parentDial) {
    if (values.length != VALUES_PER_DIAL_COUNT) {
      throw new IllegalArgumentException("values must be " + VALUES_PER_DIAL_COUNT);
    }
    if (innerDialValues != null && innerDialValues.length != VALUES_PER_DIAL_COUNT) {
      throw new IllegalArgumentException("innerDialValues must be " + VALUES_PER_DIAL_COUNT + " or null");
    }

    this.values = values;
    this.innerDialValues = innerDialValues;
    this.parentDial = parentDial;
  }

  public int getValueAtColumn(int columnIndex) {
    int index = (columnIndex + state) % VALUES_PER_DIAL_COUNT;
    int value = values[index];

    return value == PARENT_FALLBACK ? parentDial.innerDialValues[index] : value;
  }

  public void turn() {
    state = (state + 1) % VALUES_PER_DIAL_COUNT;
  }

  public int getState() {
    return state;
  }
}
