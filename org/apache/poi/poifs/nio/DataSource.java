package org.apache.poi.poifs.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public abstract class DataSource {
  public abstract ByteBuffer read(int paramInt, long paramLong) throws IOException;
  
  public abstract void write(ByteBuffer paramByteBuffer, long paramLong) throws IOException;
  
  public abstract long size() throws IOException;
  
  public abstract void close() throws IOException;
  
  public abstract void copyTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\nio\DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */