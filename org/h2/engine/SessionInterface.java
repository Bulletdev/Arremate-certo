package org.h2.engine;

import java.io.Closeable;
import java.util.ArrayList;
import org.h2.command.CommandInterface;
import org.h2.message.Trace;
import org.h2.store.DataHandler;
import org.h2.value.Value;

public interface SessionInterface extends Closeable {
  ArrayList<String> getClusterServers();
  
  CommandInterface prepareCommand(String paramString, int paramInt);
  
  void close();
  
  Trace getTrace();
  
  boolean isClosed();
  
  int getPowerOffCount();
  
  void setPowerOffCount(int paramInt);
  
  DataHandler getDataHandler();
  
  boolean hasPendingTransaction();
  
  void cancel();
  
  boolean isReconnectNeeded(boolean paramBoolean);
  
  SessionInterface reconnect(boolean paramBoolean);
  
  void afterWriting();
  
  boolean getAutoCommit();
  
  void setAutoCommit(boolean paramBoolean);
  
  void addTemporaryLob(Value paramValue);
  
  boolean isRemote();
  
  void setCurrentSchemaName(String paramString);
  
  String getCurrentSchemaName();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\SessionInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */