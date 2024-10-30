package org.apache.poi.ss.usermodel;

public interface Drawing {
  Picture createPicture(ClientAnchor paramClientAnchor, int paramInt);
  
  Comment createCellComment(ClientAnchor paramClientAnchor);
  
  Chart createChart(ClientAnchor paramClientAnchor);
  
  ClientAnchor createAnchor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Drawing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */