package org.h2.mvstore.type;

import java.nio.ByteBuffer;
import org.h2.mvstore.WriteBuffer;

public interface DataType {
  int compare(Object paramObject1, Object paramObject2);
  
  int getMemory(Object paramObject);
  
  void write(WriteBuffer paramWriteBuffer, Object paramObject);
  
  void write(WriteBuffer paramWriteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean);
  
  Object read(ByteBuffer paramByteBuffer);
  
  void read(ByteBuffer paramByteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\type\DataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */