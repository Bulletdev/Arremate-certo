package org.apache.commons.net.nntp;

public interface Threadable {
  boolean isDummy();
  
  String messageThreadId();
  
  String[] messageThreadReferences();
  
  String simplifiedSubject();
  
  boolean subjectIsReply();
  
  void setChild(Threadable paramThreadable);
  
  void setNext(Threadable paramThreadable);
  
  Threadable makeDummy();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\Threadable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */