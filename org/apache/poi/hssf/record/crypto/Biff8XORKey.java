/*    */ package org.apache.poi.hssf.record.crypto;
/*    */ 
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ import org.apache.poi.poifs.crypt.CryptoFunctions;
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
/*    */ public class Biff8XORKey
/*    */   extends Biff8EncryptionKey
/*    */ {
/*    */   final int _xorKey;
/*    */   
/*    */   public Biff8XORKey(String paramString, int paramInt) {
/* 29 */     this._xorKey = paramInt;
/* 30 */     byte[] arrayOfByte = CryptoFunctions.createXorArray1(paramString);
/* 31 */     this._secretKey = new SecretKeySpec(arrayOfByte, "XOR");
/*    */   }
/*    */   
/*    */   public static Biff8XORKey create(String paramString, int paramInt) {
/* 35 */     return new Biff8XORKey(paramString, paramInt);
/*    */   }
/*    */   
/*    */   public boolean validate(String paramString, int paramInt) {
/* 39 */     int i = CryptoFunctions.createXorKey1(paramString);
/* 40 */     int j = CryptoFunctions.createXorVerifier1(paramString);
/*    */     
/* 42 */     return (this._xorKey == i && j == paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8XORKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */