package org.apache.commons.collections4.sequence;

public interface CommandVisitor<T> {
  void visitInsertCommand(T paramT);
  
  void visitKeepCommand(T paramT);
  
  void visitDeleteCommand(T paramT);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\sequence\CommandVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */