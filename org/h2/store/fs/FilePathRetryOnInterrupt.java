/*    */ package org.h2.store.fs;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.channels.FileChannel;
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
/*    */ public class FilePathRetryOnInterrupt
/*    */   extends FilePathWrapper
/*    */ {
/*    */   static final String SCHEME = "retry";
/*    */   
/*    */   public FileChannel open(String paramString) throws IOException {
/* 29 */     return new FileRetryOnInterrupt(this.name.substring(getScheme().length() + 1), paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getScheme() {
/* 34 */     return "retry";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathRetryOnInterrupt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */