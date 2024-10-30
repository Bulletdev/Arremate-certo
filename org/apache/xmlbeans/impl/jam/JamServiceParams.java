package org.apache.xmlbeans.impl.jam;

import java.io.File;
import java.io.PrintWriter;
import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

public interface JamServiceParams {
  void includeSourceFile(File paramFile);
  
  void includeSourcePattern(File[] paramArrayOfFile, String paramString);
  
  void excludeSourcePattern(File[] paramArrayOfFile, String paramString);
  
  void includeClassPattern(File[] paramArrayOfFile, String paramString);
  
  void excludeClassPattern(File[] paramArrayOfFile, String paramString);
  
  void includeSourceFile(File[] paramArrayOfFile, File paramFile);
  
  void excludeSourceFile(File[] paramArrayOfFile, File paramFile);
  
  void includeClassFile(File[] paramArrayOfFile, File paramFile);
  
  void excludeClassFile(File[] paramArrayOfFile, File paramFile);
  
  void includeClass(String paramString);
  
  void excludeClass(String paramString);
  
  void addSourcepath(File paramFile);
  
  void addClasspath(File paramFile);
  
  void setLoggerWriter(PrintWriter paramPrintWriter);
  
  void setJamLogger(JamLogger paramJamLogger);
  
  void setVerbose(Class paramClass);
  
  void setShowWarnings(boolean paramBoolean);
  
  void setParentClassLoader(JamClassLoader paramJamClassLoader);
  
  void addToolClasspath(File paramFile);
  
  void setPropertyInitializer(MVisitor paramMVisitor);
  
  void addInitializer(MVisitor paramMVisitor);
  
  void setJavadocTagParser(JavadocTagParser paramJavadocTagParser);
  
  void setUseSystemClasspath(boolean paramBoolean);
  
  void addClassBuilder(JamClassBuilder paramJamClassBuilder);
  
  void addClassLoader(ClassLoader paramClassLoader);
  
  void setProperty(String paramString1, String paramString2);
  
  void set14WarningsEnabled(boolean paramBoolean);
  
  void setVerbose(boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JamServiceParams.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */