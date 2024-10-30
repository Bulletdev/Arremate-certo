/*    */ package org.passay;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.cryptacular.bean.EncodingHashBean;
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
/*    */ public class l
/*    */   extends I
/*    */ {
/*    */   private final EncodingHashBean a;
/* 22 */   private Charset charset = StandardCharsets.UTF_8;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public l(EncodingHashBean paramEncodingHashBean) {
/* 32 */     this.a = paramEncodingHashBean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCharset(Charset paramCharset) {
/* 43 */     if (paramCharset == null) {
/* 44 */       throw new NullPointerException("Character set cannot be null");
/*    */     }
/* 46 */     this.charset = paramCharset;
/*    */   }
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
/*    */   protected boolean a(String paramString, x.d paramd) {
/* 61 */     return this.a.compare(paramd.getPassword(), new Object[] { paramString.getBytes(this.charset) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */