package org.apache.poi.ss.usermodel;

import java.util.Iterator;

public interface CellRange<C extends Cell> extends Iterable<C> {
  int getWidth();
  
  int getHeight();
  
  int size();
  
  String getReferenceText();
  
  C getTopLeftCell();
  
  C getCell(int paramInt1, int paramInt2);
  
  C[] getFlattenedCells();
  
  C[][] getCells();
  
  Iterator<C> iterator();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\CellRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */