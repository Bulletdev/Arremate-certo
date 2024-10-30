package org.apache.http.conn;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;
import org.apache.http.config.SocketConfig;
import org.apache.http.protocol.HttpContext;

public interface HttpClientConnectionOperator {
  void connect(ManagedHttpClientConnection paramManagedHttpClientConnection, HttpHost paramHttpHost, InetSocketAddress paramInetSocketAddress, int paramInt, SocketConfig paramSocketConfig, HttpContext paramHttpContext) throws IOException;
  
  void upgrade(ManagedHttpClientConnection paramManagedHttpClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\HttpClientConnectionOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */