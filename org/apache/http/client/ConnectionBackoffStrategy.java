package org.apache.http.client;

import org.apache.http.HttpResponse;

public interface ConnectionBackoffStrategy {
  boolean shouldBackoff(Throwable paramThrowable);
  
  boolean shouldBackoff(HttpResponse paramHttpResponse);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\ConnectionBackoffStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */