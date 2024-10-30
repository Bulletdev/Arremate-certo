package org.h2.index;

import org.h2.result.Row;
import org.h2.result.SearchRow;

public interface Cursor {
  Row get();
  
  SearchRow getSearchRow();
  
  boolean next();
  
  boolean previous();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\Cursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */