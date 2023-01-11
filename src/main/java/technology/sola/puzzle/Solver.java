package technology.sola.puzzle;

public class Solver {
  private final int solutionSum;

  public Solver(int solutionSum) {
    this.solutionSum = solutionSum;
  }

  public void bruteForceSolve(Column[] columns, Dial[] dials) {
    // We start at 1 since the outermost dial does not turn
    bruteForceSolve(columns, dials, 1);
  }

  private void bruteForceSolve(Column[] columns, Dial[] dials, int dialToIterate) {
    // Loop through each turn of the dial
    for (int i = 0; i < columns.length; i++) {
      // Recurse down through every combination of dial until we finish at the innermost dial
      if (dialToIterate < dials.length - 1) {
        bruteForceSolve(columns, dials, dialToIterate + 1);
      }

      boolean isValidSolution = true;

      // Calculate sum for each column with current dial configuration
      for (Column column : columns) {
        int sum = column.sum();

        // If sum is not 50 then this solution is not valid and we can break out
        if (sum != solutionSum) {
          isValidSolution = false;
          break;
        }
      }

      if (isValidSolution) {
        outputSolution(dials);
      }

      dials[dialToIterate].turn();
    }
  }

  private static void outputSolution(Dial[] dials) {
    StringBuilder solution = new StringBuilder("[");

    for (Dial dial : dials) {
      solution.append(dial.getState()).append(", ");
    }

    // Cleanup extra ", "
    solution.delete(solution.length() - 2, solution.length());
    solution.append("]");
    System.out.println("Solution: " + solution);
  }
}
