package org.apache.poi.poifs.storage;

import java.io.IOException;

public interface BlockList {
  void zap(int paramInt);
  
  ListManagedBlock remove(int paramInt) throws IOException;
  
  ListManagedBlock[] fetchBlocks(int paramInt1, int paramInt2) throws IOException;
  
  void setBAT(BlockAllocationTableReader paramBlockAllocationTableReader) throws IOException;
  
  int blockCount();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\BlockList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */