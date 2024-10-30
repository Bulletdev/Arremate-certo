package org.apache.http.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ManagedClientConnection extends ConnectionReleaseTrigger, HttpRoutedConnection, ManagedHttpClientConnection {
  boolean isSecure();
  
  HttpRoute getRoute();
  
  SSLSession getSSLSession();
  
  void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException;
  
  void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams) throws IOException;
  
  void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException;
  
  void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException;
  
  void markReusable();
  
  void unmarkReusable();
  
  boolean isMarkedReusable();
  
  void setState(Object paramObject);
  
  Object getState();
  
  void setIdleDuration(long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ManagedClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */