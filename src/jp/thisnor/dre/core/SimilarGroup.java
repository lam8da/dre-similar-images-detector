package jp.thisnor.dre.core;

import java.util.Comparator;
import java.util.List;

public class SimilarGroup {
  public static final Comparator<? super SimilarGroup> FIRST_DISTANCE_COMPARATOR =
      new Comparator<SimilarGroup>() {
        @Override
        public int compare(SimilarGroup o1, SimilarGroup o2) {
          int d =
              Integer.signum(
                  o1.similarList.get(0).getDistance() - o2.similarList.get(0).getDistance());
          return d != 0 ? d : Integer.signum(getMinHash(o1) - getMinHash(o2));
        }

        private int getMinHash(SimilarGroup g) {
          int min = g.fileEntry.hashCode();
          for (SimilarEntry e : g.getSimilarList()) {
            if (e.getFileEntry().hashCode() < min) min = e.getFileEntry().hashCode();
          }
          return min;
        }
      };

  // This is always a target file entry, not a storage file entry (source)
  private final FileEntry fileEntry;
  // These are always storage file entries (source), not targets
  private final List<SimilarEntry> similarList;

  public SimilarGroup(FileEntry fileEntry, List<SimilarEntry> similarList) {
    this.fileEntry = fileEntry;
    this.similarList = similarList;
  }

  public FileEntry getFileEntry() {
    return fileEntry;
  }

  public List<SimilarEntry> getSimilarList() {
    return similarList;
  }
}
