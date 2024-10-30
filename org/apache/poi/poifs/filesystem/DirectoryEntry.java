package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.hpsf.ClassID;

public interface DirectoryEntry extends Iterable<Entry>, Entry {
  Iterator<Entry> getEntries();
  
  Set<String> getEntryNames();
  
  boolean isEmpty();
  
  int getEntryCount();
  
  boolean hasEntry(String paramString);
  
  Entry getEntry(String paramString) throws FileNotFoundException;
  
  DocumentEntry createDocument(String paramString, InputStream paramInputStream) throws IOException;
  
  DocumentEntry createDocument(String paramString, int paramInt, POIFSWriterListener paramPOIFSWriterListener) throws IOException;
  
  DirectoryEntry createDirectory(String paramString) throws IOException;
  
  ClassID getStorageClsid();
  
  void setStorageClsid(ClassID paramClassID);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\DirectoryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */