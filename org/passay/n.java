/*    */ package org.passay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum n
/*    */   implements H
/*    */ {
/* 12 */   a("ILLEGAL_ALPHABETICAL_SEQUENCE", new h[] { new h(new String[] { "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
/*    */         
/*    */         })
/*    */     
/*    */     }),
/* 17 */   b("ILLEGAL_NUMERICAL_SEQUENCE", new h[] { new h(new String[] { "0123456789"
/*    */         
/*    */         })
/*    */     
/*    */     }),
/* 22 */   c("ILLEGAL_QWERTY_SEQUENCE", new h[] { new h(new String[] { "`1234567890-=", "~!@#$%^&*()_+", "\000¡™£¢∞§¶•ªº–≠", "`⁄€‹›ﬁﬂ‡°·‚—±" }), new h(new String[] { "qwertyuiop[]\\", "QWERTYUIOP{}|", "œ∑\000®†¥\000\000øπ“‘«", "Œ„´‰ˇÁ¨ˆØ∏”’»" }), new h(new String[] { "asdfghjkl;'", "ASDFGHJKL:\"", "åß∂ƒ©˙∆˚¬…æ", "ÅÍÎÏ˝ÓÔÒÚÆ" }), new h(new String[] { "zxcvbnm,./", "ZXCVBNM<>?", "Ω≈ç√∫\000µ≤≥÷", "¸˛Ç◊ı˜Â¯˘¿" }) });
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
/*    */   private final String errorCode;
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
/*    */   private final h[] a;
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
/*    */   n(String paramString1, h[] paramArrayOfh) {
/* 63 */     this.errorCode = paramString1;
/* 64 */     this.a = (n[])paramArrayOfh;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getErrorCode() {
/* 70 */     return this.errorCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public h[] a() {
/* 76 */     return (h[])this.a;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */