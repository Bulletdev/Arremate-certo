package org.h2.index;

import java.util.HashSet;
import org.h2.engine.Session;
import org.h2.result.Row;
import org.h2.result.SearchRow;
import org.h2.result.SortOrder;
import org.h2.schema.SchemaObject;
import org.h2.table.Column;
import org.h2.table.IndexColumn;
import org.h2.table.Table;
import org.h2.table.TableFilter;

public interface Index extends SchemaObject {
  String getPlanSQL();
  
  void close(Session paramSession);
  
  void add(Session paramSession, Row paramRow);
  
  void remove(Session paramSession, Row paramRow);
  
  Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2);
  
  Cursor find(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2);
  
  double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet);
  
  void remove(Session paramSession);
  
  void truncate(Session paramSession);
  
  boolean canGetFirstOrLast();
  
  boolean canFindNext();
  
  Cursor findNext(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2);
  
  Cursor findFirstOrLast(Session paramSession, boolean paramBoolean);
  
  boolean needRebuild();
  
  long getRowCount(Session paramSession);
  
  long getRowCountApproximation();
  
  long getDiskSpaceUsed();
  
  int compareRows(SearchRow paramSearchRow1, SearchRow paramSearchRow2);
  
  int getColumnIndex(Column paramColumn);
  
  IndexColumn[] getIndexColumns();
  
  Column[] getColumns();
  
  IndexType getIndexType();
  
  Table getTable();
  
  void commit(int paramInt, Row paramRow);
  
  Row getRow(Session paramSession, long paramLong);
  
  boolean isRowIdIndex();
  
  boolean canScan();
  
  void setSortedInsertMode(boolean paramBoolean);
  
  IndexLookupBatch createLookupBatch(TableFilter[] paramArrayOfTableFilter, int paramInt);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\Index.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */