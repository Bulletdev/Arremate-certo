/*    */ package org.apache.commons.io.filefilter;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileFilter;
/*    */ import java.io.FilenameFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IOFileFilter
/*    */   extends FileFilter, FilenameFilter
/*    */ {
/* 35 */   public static final String[] EMPTY_STRING_ARRAY = new String[0];
/*    */   
/*    */   boolean accept(File paramFile);
/*    */   
/*    */   boolean accept(File paramFile, String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\IOFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */