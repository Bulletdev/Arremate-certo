package org.apache.xmlbeans.impl.jam.provider;

import java.io.File;
import java.io.IOException;
import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

public interface JamServiceContext extends JamLogger {
  ResourcePath getInputClasspath();
  
  ResourcePath getInputSourcepath();
  
  ResourcePath getToolClasspath();
  
  String getProperty(String paramString);
  
  MVisitor getInitializer();
  
  ClassLoader[] getReflectionClassLoaders();
  
  File[] getSourceFiles() throws IOException;
  
  String[] getAllClassnames() throws IOException;
  
  JamLogger getLogger();
  
  JamClassBuilder getBaseBuilder();
  
  JavadocTagParser getTagParser();
  
  boolean is14WarningsEnabled();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\provider\JamServiceContext.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */