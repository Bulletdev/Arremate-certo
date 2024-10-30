/*    */ package org.apache.poi.poifs.crypt;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.security.GeneralSecurityException;
/*    */ import javax.crypto.SecretKey;
/*    */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*    */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*    */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*    */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
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
/*    */ public abstract class Encryptor
/*    */ {
/*    */   protected static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
/*    */   private SecretKey secretKey;
/*    */   
/*    */   public abstract OutputStream getDataStream(DirectoryNode paramDirectoryNode) throws IOException, GeneralSecurityException;
/*    */   
/*    */   public abstract void confirmPassword(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5);
/*    */   
/*    */   public abstract void confirmPassword(String paramString);
/*    */   
/*    */   public static Encryptor getInstance(EncryptionInfo paramEncryptionInfo) {
/* 49 */     return paramEncryptionInfo.getEncryptor();
/*    */   }
/*    */   
/*    */   public OutputStream getDataStream(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException, GeneralSecurityException {
/* 53 */     return getDataStream(paramNPOIFSFileSystem.getRoot());
/*    */   }
/*    */   public OutputStream getDataStream(OPOIFSFileSystem paramOPOIFSFileSystem) throws IOException, GeneralSecurityException {
/* 56 */     return getDataStream(paramOPOIFSFileSystem.getRoot());
/*    */   }
/*    */   public OutputStream getDataStream(POIFSFileSystem paramPOIFSFileSystem) throws IOException, GeneralSecurityException {
/* 59 */     return getDataStream(paramPOIFSFileSystem.getRoot());
/*    */   }
/*    */   
/*    */   public SecretKey getSecretKey() {
/* 63 */     return this.secretKey;
/*    */   }
/*    */   
/*    */   protected void setSecretKey(SecretKey paramSecretKey) {
/* 67 */     this.secretKey = paramSecretKey;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\Encryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */