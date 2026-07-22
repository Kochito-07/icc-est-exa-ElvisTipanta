package models;

public class ProjectMetrics {
  private double estimatedHours;
  private int teamSize;
  private int completedTasks;
  private int pendingTasks;
  
  public ProjectMetrics() {
  }

  public ProjectMetrics(double estimatedHours, int teamSize, int completedTasks, int pendingTasks) {
    this.estimatedHours = estimatedHours;
    this.teamSize = teamSize;
    this.completedTasks = completedTasks;
    this.pendingTasks = pendingTasks;
  }

  public double getEstimatedHours() {
    return estimatedHours;
  }

  public void setEstimatedHours(double estimatedHours) {
    this.estimatedHours = estimatedHours;
  }

  public int getTeamSize() {
    return teamSize;
  }

  public void setTeamSize(int teamSize) {
    this.teamSize = teamSize;
  }

  public int getCompletedTasks() {
    return completedTasks;
  }

  public void setCompletedTasks(int completedTasks) {
    this.completedTasks = completedTasks;
  }

  public int getPendingTasks() {
    return pendingTasks;
  }

  public void setPendingTasks(int pendingTasks) {
    this.pendingTasks = pendingTasks;
  }

  public double getWorkload() {
    return estimatedHours * teamSize;
  }

  @Override
  public String toString() {
    return "ProjectMetrics [estimatedHours=" + estimatedHours + ", teamSize=" + teamSize + ", completedTasks="
        + completedTasks + ", pendingTasks=" + pendingTasks + "]";
  }

  
  
}
