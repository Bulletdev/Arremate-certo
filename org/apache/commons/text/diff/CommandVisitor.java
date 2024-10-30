package org.apache.commons.text.diff;

public interface CommandVisitor<T> {
  void visitInsertCommand(T paramT);
  
  void visitKeepCommand(T paramT);
  
  void visitDeleteCommand(T paramT);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\CommandVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */