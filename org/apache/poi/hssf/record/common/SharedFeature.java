package org.apache.poi.hssf.record.common;

import org.apache.poi.util.LittleEndianOutput;

public interface SharedFeature {
  String toString();
  
  void serialize(LittleEndianOutput paramLittleEndianOutput);
  
  int getDataSize();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\SharedFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */