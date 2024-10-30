package org.apache.http.client.methods;

import org.apache.http.concurrent.Cancellable;

public interface HttpExecutionAware {
  boolean isAborted();
  
  void setCancellable(Cancellable paramCancellable);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\HttpExecutionAware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */