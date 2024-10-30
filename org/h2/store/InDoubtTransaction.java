package org.h2.store;

public interface InDoubtTransaction {
  public static final int IN_DOUBT = 0;
  
  public static final int COMMIT = 1;
  
  public static final int ROLLBACK = 2;
  
  void setState(int paramInt);
  
  String getState();
  
  String getTransactionName();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\InDoubtTransaction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */