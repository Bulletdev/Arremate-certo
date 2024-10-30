package org.apache.commons.io.monitor;

import java.io.File;

public class FileAlterationListenerAdaptor implements FileAlterationListener {
  public void onStart(FileAlterationObserver paramFileAlterationObserver) {}
  
  public void onDirectoryCreate(File paramFile) {}
  
  public void onDirectoryChange(File paramFile) {}
  
  public void onDirectoryDelete(File paramFile) {}
  
  public void onFileCreate(File paramFile) {}
  
  public void onFileChange(File paramFile) {}
  
  public void onFileDelete(File paramFile) {}
  
  public void onStop(FileAlterationObserver paramFileAlterationObserver) {}
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\monitor\FileAlterationListenerAdaptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */