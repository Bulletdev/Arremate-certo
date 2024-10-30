package org.apache.poi.hssf.eventusermodel;

import org.apache.poi.hssf.record.Record;

public abstract class AbortableHSSFListener implements HSSFListener {
  public void processRecord(Record paramRecord) {}
  
  public abstract short abortableProcessRecord(Record paramRecord) throws HSSFUserException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\AbortableHSSFListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */