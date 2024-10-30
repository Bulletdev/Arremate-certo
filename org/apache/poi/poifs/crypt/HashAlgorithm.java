/*    */ package org.apache.poi.poifs.crypt;
/*    */ 
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
/*    */ public enum HashAlgorithm
/*    */ {
/* 23 */   none("", 0, "", 0, "", false),
/* 24 */   sha1("SHA-1", 32772, "SHA1", 20, "HmacSHA1", false),
/* 25 */   sha256("SHA-256", 32780, "SHA256", 32, "HmacSHA256", false),
/* 26 */   sha384("SHA-384", 32781, "SHA384", 48, "HmacSHA384", false),
/* 27 */   sha512("SHA-512", 32782, "SHA512", 64, "HmacSHA512", false),
/*    */   
/* 29 */   md5("MD5", -1, "MD5", 16, "HmacMD5", false),
/*    */   
/* 31 */   md2("MD2", -1, "MD2", 16, "Hmac-MD2", true),
/* 32 */   md4("MD4", -1, "MD4", 16, "Hmac-MD4", true),
/* 33 */   ripemd128("RipeMD128", -1, "RIPEMD-128", 16, "HMac-RipeMD128", true),
/* 34 */   ripemd160("RipeMD160", -1, "RIPEMD-160", 20, "HMac-RipeMD160", true),
/* 35 */   whirlpool("Whirlpool", -1, "WHIRLPOOL", 64, "HMac-Whirlpool", true),
/*    */   
/* 37 */   sha224("SHA-224", -1, "SHA224", 28, "HmacSHA224", true);
/*    */   
/*    */   public final String jceId;
/*    */   public final int ecmaId;
/*    */   public final String ecmaString;
/*    */   public final int hashSize;
/*    */   public final String jceHmacId;
/*    */   public final boolean needsBouncyCastle;
/*    */   
/*    */   HashAlgorithm(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean) {
/* 47 */     this.jceId = paramString1;
/* 48 */     this.ecmaId = paramInt1;
/* 49 */     this.ecmaString = paramString2;
/* 50 */     this.hashSize = paramInt2;
/* 51 */     this.jceHmacId = paramString3;
/* 52 */     this.needsBouncyCastle = paramBoolean;
/*    */   }
/*    */   
/*    */   public static HashAlgorithm fromEcmaId(int paramInt) {
/* 56 */     for (HashAlgorithm hashAlgorithm : values()) {
/* 57 */       if (hashAlgorithm.ecmaId == paramInt) return hashAlgorithm; 
/*    */     } 
/* 59 */     throw new EncryptedDocumentException("hash algorithm not found");
/*    */   }
/*    */   
/*    */   public static HashAlgorithm fromEcmaId(String paramString) {
/* 63 */     for (HashAlgorithm hashAlgorithm : values()) {
/* 64 */       if (hashAlgorithm.ecmaString.equals(paramString)) return hashAlgorithm; 
/*    */     } 
/* 66 */     throw new EncryptedDocumentException("hash algorithm not found");
/*    */   }
/*    */   
/*    */   public static HashAlgorithm fromString(String paramString) {
/* 70 */     for (HashAlgorithm hashAlgorithm : values()) {
/* 71 */       if (hashAlgorithm.ecmaString.equalsIgnoreCase(paramString) || hashAlgorithm.jceId.equalsIgnoreCase(paramString)) return hashAlgorithm; 
/*    */     } 
/* 73 */     throw new EncryptedDocumentException("hash algorithm not found");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\HashAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */