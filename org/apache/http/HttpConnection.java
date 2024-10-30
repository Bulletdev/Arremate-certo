package org.apache.http;

import java.io.Closeable;
import java.io.IOException;

public interface HttpConnection extends Closeable {
  void close() throws IOException;
  
  boolean isOpen();
  
  boolean isStale();
  
  void setSocketTimeout(int paramInt);
  
  int getSocketTimeout();
  
  void shutdown() throws IOException;
  
  HttpConnectionMetrics getMetrics();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */