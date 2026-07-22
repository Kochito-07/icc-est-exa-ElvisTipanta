package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.SoftwareProject;

public class ProjectController {
  public Set<SoftwareProject> filterAndOrderProjects(
    List<SoftwareProject> projects, 
    double minimumWorkload) {
    Set<SoftwareProject> result = new TreeSet<>((p1, p2) -> {
      int cmp = Double.compare(p2.getWorkload(), p1.getWorkload());
      if (cmp != 0) return cmp;
      return p1.getProjectCode().compareToIgnoreCase(p2.getProjectCode());
    });
    if (projects == null) return result;
    for (SoftwareProject p : projects) {
      if (p.getWorkload() >= minimumWorkload) {
        result.add(p);
      }
    }
    return result;
  }
  public List<SoftwareProject> classifyAndExtractProjects(
    List<SoftwareProject> projects,
    String requestedCategory) {
    List<SoftwareProject> list = new ArrayList<>();
    if (projects == null || requestedCategory == null) return list;
    String cat = requestedCategory.trim().toUpperCase();
    if (cat.isEmpty()) return list;

    Map<String, Set<SoftwareProject>> map = new TreeMap<>();
    Comparator<SoftwareProject> comp = (p1, p2) -> {
      int cmp = Integer.compare(p2.getPriority(), p1.getPriority());
      if (cmp != 0) return cmp;
      return p1.getProjectCode().compareToIgnoreCase(p2.getProjectCode());
    };
    map.put("CRITICAL", new TreeSet<>());
    map.put("SMALL", new TreeSet<>());
    map.put("STANDARD", new TreeSet<>());

    for (SoftwareProject p : projects) {
      double work = p.getWorkload();
      int tasks = p.getMetrics().getPendingTasks();
      if (work >= 900 || tasks >= 18) {
        map.get("CRITICAL").add(p);
      } else if (work >= 350) {
        map.get("STANDARD").add(p);
      } else {
        map.get("SMALL").add(p);
      }
    }
    Set<SoftwareProject> target = map.get(cat);
    if ( target != null) {
      list.addAll(target);
    }
    return list;
  }
}
