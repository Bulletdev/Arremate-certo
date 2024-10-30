package org.h2.message;

interface TraceWriter {
  void setName(String paramString);
  
  void write(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  void write(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable);
  
  boolean isEnabled(int paramInt);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\message\TraceWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */