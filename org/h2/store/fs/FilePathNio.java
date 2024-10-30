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
/*    */ public class FilePathNio
/*    */   extends FilePathWrapper
/*    */ {
/*    */   public FileChannel open(String paramString) throws IOException {
/* 23 */     return new FileNio(this.name.substring(getScheme().length() + 1), paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getScheme() {
/* 28 */     return "nio";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathNio.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */