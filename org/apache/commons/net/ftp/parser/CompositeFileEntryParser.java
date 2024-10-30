/*    */ package org.apache.commons.net.ftp.parser;
/*    */ 
/*    */ import org.apache.commons.net.ftp.FTPFile;
/*    */ import org.apache.commons.net.ftp.FTPFileEntryParser;
/*    */ import org.apache.commons.net.ftp.FTPFileEntryParserImpl;
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
/*    */ public class CompositeFileEntryParser
/*    */   extends FTPFileEntryParserImpl
/*    */ {
/*    */   private final FTPFileEntryParser[] ftpFileEntryParsers;
/*    */   private FTPFileEntryParser cachedFtpFileEntryParser;
/*    */   
/*    */   public CompositeFileEntryParser(FTPFileEntryParser[] paramArrayOfFTPFileEntryParser) {
/* 38 */     this.cachedFtpFileEntryParser = null;
/* 39 */     this.ftpFileEntryParsers = paramArrayOfFTPFileEntryParser;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FTPFile parseFTPEntry(String paramString) {
/* 45 */     if (this.cachedFtpFileEntryParser != null) {
/*    */       
/* 47 */       FTPFile fTPFile = this.cachedFtpFileEntryParser.parseFTPEntry(paramString);
/* 48 */       if (fTPFile != null)
/*    */       {
/* 50 */         return fTPFile;
/*    */       }
/*    */     }
/*    */     else {
/*    */       
/* 55 */       for (FTPFileEntryParser fTPFileEntryParser : this.ftpFileEntryParsers) {
/*    */         
/* 57 */         FTPFile fTPFile = fTPFileEntryParser.parseFTPEntry(paramString);
/* 58 */         if (fTPFile != null) {
/*    */           
/* 60 */           this.cachedFtpFileEntryParser = fTPFileEntryParser;
/* 61 */           return fTPFile;
/*    */         } 
/*    */       } 
/*    */     } 
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\CompositeFileEntryParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */