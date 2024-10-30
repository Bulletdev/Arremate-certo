package org.apache.poi.poifs.filesystem;

public interface Entry {
  String getName();
  
  boolean isDirectoryEntry();
  
  boolean isDocumentEntry();
  
  DirectoryEntry getParent();
  
  boolean delete();
  
  boolean renameTo(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */