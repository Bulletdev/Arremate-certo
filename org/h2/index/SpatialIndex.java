package org.h2.index;

import org.h2.result.SearchRow;
import org.h2.table.TableFilter;

public interface SpatialIndex extends Index {
  Cursor findByGeometry(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2, SearchRow paramSearchRow3);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\SpatialIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */