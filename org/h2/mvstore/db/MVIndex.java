package org.h2.mvstore.db;

import java.util.List;
import org.h2.index.Index;
import org.h2.result.Row;

public interface MVIndex extends Index {
  void addRowsToBuffer(List<Row> paramList, String paramString);
  
  void addBufferedRows(List<String> paramList);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */