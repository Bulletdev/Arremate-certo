package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public interface LayeredSchemeSocketFactory extends SchemeSocketFactory {
  Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException, UnknownHostException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\LayeredSchemeSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */