package org.apache.poi.ddf;

public interface EscherSerializationListener {
  void beforeRecordSerialize(int paramInt, short paramShort, EscherRecord paramEscherRecord);
  
  void afterRecordSerialize(int paramInt1, short paramShort, int paramInt2, EscherRecord paramEscherRecord);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherSerializationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */