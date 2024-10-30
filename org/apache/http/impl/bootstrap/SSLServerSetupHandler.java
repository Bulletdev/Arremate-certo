package org.apache.http.impl.bootstrap;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;

public interface SSLServerSetupHandler {
  void initialize(SSLServerSocket paramSSLServerSocket) throws SSLException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\bootstrap\SSLServerSetupHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */