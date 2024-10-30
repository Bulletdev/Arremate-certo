/*    */ package org.apache.commons.net.ftp;
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
/*    */ public class FTPFileFilters
/*    */ {
/* 30 */   public static final FTPFileFilter ALL = new FTPFileFilter()
/*    */     {
/*    */       public boolean accept(FTPFile param1FTPFile) {
/* 33 */         return true;
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   public static final FTPFileFilter NON_NULL = new FTPFileFilter()
/*    */     {
/*    */       public boolean accept(FTPFile param1FTPFile) {
/* 43 */         return (param1FTPFile != null);
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   public static final FTPFileFilter DIRECTORIES = new FTPFileFilter()
/*    */     {
/*    */       public boolean accept(FTPFile param1FTPFile) {
/* 53 */         return (param1FTPFile != null && param1FTPFile.isDirectory());
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPFileFilters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */