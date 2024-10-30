package org.apache.commons.net;

import java.util.EventListener;

public interface ProtocolCommandListener extends EventListener {
  void protocolCommandSent(ProtocolCommandEvent paramProtocolCommandEvent);
  
  void protocolReplyReceived(ProtocolCommandEvent paramProtocolCommandEvent);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ProtocolCommandListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */