/*    */ package org.apache.poi.hssf.record.crypto;
/*    */ 
/*    */ import javax.crypto.SecretKey;
/*    */ import org.apache.poi.EncryptedDocumentException;
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
/*    */ public abstract class Biff8EncryptionKey
/*    */ {
/*    */   protected SecretKey _secretKey;
/*    */   
/*    */   public static Biff8EncryptionKey create(byte[] paramArrayOfbyte) {
/* 33 */     return Biff8RC4Key.create("VelvetSweatshop", paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   public static Biff8EncryptionKey create(String paramString, byte[] paramArrayOfbyte) {
/* 37 */     return Biff8RC4Key.create(paramString, paramArrayOfbyte);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean validate(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 44 */     throw new EncryptedDocumentException("validate is not supported (in super-class).");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 52 */   private static final ThreadLocal<String> _userPasswordTLS = new ThreadLocal<String>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setCurrentUserPassword(String paramString) {
/* 60 */     _userPasswordTLS.set(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getCurrentUserPassword() {
/* 68 */     return _userPasswordTLS.get();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8EncryptionKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */