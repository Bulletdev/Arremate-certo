package org.h2.store.fs;

public interface Recorder {
  public static final int CREATE_NEW_FILE = 2;
  
  public static final int CREATE_TEMP_FILE = 3;
  
  public static final int DELETE = 4;
  
  public static final int OPEN_OUTPUT_STREAM = 5;
  
  public static final int RENAME = 6;
  
  public static final int TRUNCATE = 7;
  
  public static final int WRITE = 8;
  
  void log(int paramInt, String paramString, byte[] paramArrayOfbyte, long paramLong);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\Recorder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */