package technology.sola.safecracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
  @Test
  void issue_dial3_state3() {
    // Solution: [0, 6, 5, 5, 10, ]
    turnDial(Main.dial2, 6);
    turnDial(Main.dial3, 5);
    turnDial(Main.dial4, 5);
    turnDial(Main.dial5, 10);

    assertEquals(9, Main.dial2.getValueAtColumn(0));
    assertEquals(12, Main.dial3.getValueAtColumn(0));
    assertEquals(20, Main.dial4.getValueAtColumn(0));
    assertEquals(8, Main.dial5.getValueAtColumn(0));
  }

  private void turnDial(Dial dial, int times) {
    for (int i = 0; i < times; i++) {
      dial.turn();
    }
  }
}
