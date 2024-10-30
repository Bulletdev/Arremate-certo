package org.h2.index;

import java.util.List;
import java.util.concurrent.Future;
import org.h2.result.SearchRow;

public interface IndexLookupBatch {
  boolean addSearchRows(SearchRow paramSearchRow1, SearchRow paramSearchRow2);
  
  boolean isBatchFull();
  
  List<Future<Cursor>> find();
  
  String getPlanSQL();
  
  void reset(boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\IndexLookupBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */