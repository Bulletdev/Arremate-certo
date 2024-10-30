/*    */ package org.apache.poi.poifs.crypt.dsig;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
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
/*    */ public class DigestInfo
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public final byte[] digestValue;
/*    */   public final String description;
/*    */   public final HashAlgorithm hashAlgo;
/*    */   
/*    */   public DigestInfo(byte[] paramArrayOfbyte, HashAlgorithm paramHashAlgorithm, String paramString) {
/* 46 */     this.digestValue = (byte[])paramArrayOfbyte.clone();
/* 47 */     this.hashAlgo = paramHashAlgorithm;
/* 48 */     this.description = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\DigestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */