package org.apache.poi.hssf.record;

public interface BiffHeaderInput {
  int readRecordSID();
  
  int readDataSize();
  
  int available();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BiffHeaderInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */