package org.apache.poi.util;

public interface DelayableLittleEndianOutput extends LittleEndianOutput {
  LittleEndianOutput createDelayedOutput(int paramInt);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\DelayableLittleEndianOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */