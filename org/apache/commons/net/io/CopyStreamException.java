/*    */ package org.apache.commons.net.io;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CopyStreamException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = -2602899129433221532L;
/*    */   private final long totalBytesTransferred;
/*    */   
/*    */   public CopyStreamException(String paramString, long paramLong, IOException paramIOException) {
/* 46 */     super(paramString);
/* 47 */     initCause(paramIOException);
/* 48 */     this.totalBytesTransferred = paramLong;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getTotalBytesTransferred() {
/* 59 */     return this.totalBytesTransferred;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IOException getIOException() {
/* 68 */     return (IOException)getCause();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\CopyStreamException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */