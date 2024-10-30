/*    */ package org.apache.poi.poifs.crypt;
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
/*    */ public enum EncryptionMode
/*    */ {
/* 30 */   binaryRC4("org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionInfoBuilder", 1, 1, 0),
/*    */   
/* 32 */   cryptoAPI("org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionInfoBuilder", 4, 2, 4),
/*    */   
/* 34 */   standard("org.apache.poi.poifs.crypt.standard.StandardEncryptionInfoBuilder", 4, 2, 36),
/*    */   
/* 36 */   agile("org.apache.poi.poifs.crypt.agile.AgileEncryptionInfoBuilder", 4, 4, 64);
/*    */   
/*    */   public final String builder;
/*    */   
/*    */   public final int versionMajor;
/*    */   public final int versionMinor;
/*    */   public final int encryptionFlags;
/*    */   
/*    */   EncryptionMode(String paramString1, int paramInt1, int paramInt2, int paramInt3) {
/* 45 */     this.builder = paramString1;
/* 46 */     this.versionMajor = paramInt1;
/* 47 */     this.versionMinor = paramInt2;
/* 48 */     this.encryptionFlags = paramInt3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\EncryptionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */