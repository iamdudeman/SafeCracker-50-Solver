package technology.sola.safecracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RowTest {
  @Test
  public void whenGettingValue_withPositiveValue_shouldReturnValue() {
    Row row = new Row(
      createTestArray(),
      null,
      null
    );

    assertEquals(0, row.getValueAtIndex(0));
  }

  @Test
  public void whenGettingValue_withNegativeValue_shouldReturnParentValue() {
    int[] parentFallbackArray = createTestArray();
    parentFallbackArray[0] = 5;
    Row parent = new Row(
      createTestArray(),
      parentFallbackArray,
      null
    );
    int[] rowArray = createTestArray();
    rowArray[0] = Row.PARENT_FALLBACK;
    Row row = new Row(
      rowArray,
      null,
      parent
    );

    assertEquals(5, row.getValueAtIndex(0));
  }

  private int[] createTestArray() {
    int[] testArray = new int[16];

    for (int i = 0; i < testArray.length; i++) {
      testArray[i] = i;
    }

    return testArray;
  }
}
