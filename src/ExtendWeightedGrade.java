import java.util.ArrayList;

/**
 * ExtendWeightedGrade
 */
public class ExtendWeightedGrade {
  private ArrayList<Integer> totals;
  private ArrayList<Integer> percentages;
  private ArrayList<Integer> earnedPoints;
  private int size; // record the arraylist's current size
  
  public ExtendWeightedGrade(int capacity) {
    this.size = 0;
    this.totals = new ArrayList<>(capacity);
    this.percentages = new ArrayList<>(capacity);
    this.earnedPoints = new ArrayList<>(capacity);
  }

  public void addAssignment(int num, int earnedPoint, int totalPoint, int percent) {
    int index = num - 1;
    this.earnedPoints.add(index, earnedPoint);
    this.totals.add(index, totalPoint);
    this.percentages.add(index, percent);
    this.size++;
  }

  public int getSize() {
    return this.size;
  }
  // verify if the weights add up to 100
  public boolean validWeights() {
    int totalWeight = 0;
    for (Integer percent: percentages) {
      totalWeight += percent;
    }
    return totalWeight == 100;
  }

  // remove the input assignment's point, total and weight
  public int[] removeAssignment(int num) {
    int index = num - 1;
    int removePoint = this.earnedPoints.remove(index);
    int removeTotal = this.totals.remove(index);
    int removePercent = this.percentages.remove(index);
    this.size--;
    System.out.println("Remove the " + num + " assignment from the program");
    // display the removed item to users
    return new int[]{removePoint, removeTotal, removePercent};
  }

  // get the input assignment's point, total and weight
  public int[] getAssignment(int num) {
    if (num > this.size || num < 0) return new int[]{-1, -1, -1};
    int index = num - 1;
    int point = this.earnedPoints.get(index);
    int total = this.totals.get(index);
    int percent = this.percentages.get(index);
    return new int[]{point, total, percent};
  }

  // edit the input assignment's point, total and weight
  public void editAssignment(int num, int earnedPoint, int totalPoint, int percent) {
    int[] removeAssignment = this.removeAssignment(num);
    System.out.println("The removed assignment's earnedPoint is " + removeAssignment[0]);
    System.out.println("The removed assignment's totalPoint is " + removeAssignment[1]);
    System.out.println("The removed assignment's weight is " + removeAssignment[2]);
    int index = num - 1;
    this.addAssignment(index, earnedPoint, totalPoint, percent);
  }

  public int getFinalWeightedGrade() {
    // check if the over add to 100
    if (!validWeights()) return -1;
    double ans = 0;
    for (int i = 0; i < size; i++) {
      double weightedGrade = ((double) this.earnedPoints.get(i) / this.totals.get(i)) * (this.percentages.get(i) / 100.0) * 100.0;
      ans += weightedGrade;
    }
    return (int) Math.round(ans);
  }
}