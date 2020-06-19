package technology.sola.safecracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DialTest {
  @Test
  public void whenGettingValue_withPositiveValue_shouldReturnValue() {
    Dial dial = new Dial(
      createTestArray(),
      null,
      null
    );

    assertEquals(0, dial.getValueAtColumn(0));
  }

  @Test
  public void whenTurning_shouldGetNextValue() {
    Dial dial = new Dial(
      createTestArray(),
      null,
      null
    );

    dial.turn();

    assertEquals(1, dial.getValueAtColumn(0));
  }

  @Test
  public void whenGettingValue_withNegativeValue_shouldReturnParentValue() {
    int[] parentFallbackArray = createTestArray();
    parentFallbackArray[0] = 5;
    Dial parent = new Dial(
      createTestArray(),
      parentFallbackArray,
      null
    );
    int[] rowArray = createTestArray();
    rowArray[0] = Dial.PARENT_FALLBACK;
    Dial dial = new Dial(
      rowArray,
      null,
      parent
    );

    assertEquals(5, dial.getValueAtColumn(0));
  }

  private int[] createTestArray() {
    int[] testArray = new int[16];

    for (int i = 0; i < testArray.length; i++) {
      testArray[i] = i;
    }

    return testArray;
  }
}
