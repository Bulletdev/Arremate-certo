package org.h2.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.h2.value.Value;
import org.h2.value.ValueLobDb;

public interface LobStorageInterface {
  Value createClob(Reader paramReader, long paramLong);
  
  Value createBlob(InputStream paramInputStream, long paramLong);
  
  ValueLobDb copyLob(ValueLobDb paramValueLobDb, int paramInt, long paramLong);
  
  InputStream getInputStream(ValueLobDb paramValueLobDb, byte[] paramArrayOfbyte, long paramLong) throws IOException;
  
  void setTable(ValueLobDb paramValueLobDb, int paramInt);
  
  void removeLob(ValueLobDb paramValueLobDb);
  
  void removeAllForTable(int paramInt);
  
  void init();
  
  boolean isReadOnly();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\LobStorageInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */