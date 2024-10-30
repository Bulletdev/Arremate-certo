package org.apache.poi.hssf.record.common;

import org.apache.poi.ss.util.CellRangeAddress;

public interface FutureRecord {
  short getFutureRecordType();
  
  FtrHeader getFutureHeader();
  
  CellRangeAddress getAssociatedRange();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\FutureRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */