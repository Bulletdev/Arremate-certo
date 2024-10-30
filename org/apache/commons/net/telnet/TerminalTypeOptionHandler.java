/*     */ package org.apache.commons.net.telnet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TerminalTypeOptionHandler
/*     */   extends TelnetOptionHandler
/*     */ {
/*     */   private final String termType;
/*     */   protected static final int TERMINAL_TYPE = 24;
/*     */   protected static final int TERMINAL_TYPE_SEND = 1;
/*     */   protected static final int TERMINAL_TYPE_IS = 0;
/*     */   
/*     */   public TerminalTypeOptionHandler(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*  63 */     super(24, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*     */     
/*  65 */     this.termType = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TerminalTypeOptionHandler(String paramString) {
/*  76 */     super(24, false, false, false, false);
/*  77 */     this.termType = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] answerSubnegotiation(int[] paramArrayOfint, int paramInt) {
/*  91 */     if (paramArrayOfint != null && paramInt > 1 && this.termType != null)
/*     */     {
/*     */       
/*  94 */       if (paramArrayOfint[0] == 24 && paramArrayOfint[1] == 1) {
/*     */ 
/*     */         
/*  97 */         int[] arrayOfInt = new int[this.termType.length() + 2];
/*     */         
/*  99 */         arrayOfInt[0] = 24;
/* 100 */         arrayOfInt[1] = 0;
/*     */         
/* 102 */         for (byte b = 0; b < this.termType.length(); b++)
/*     */         {
/* 104 */           arrayOfInt[b + 2] = this.termType.charAt(b);
/*     */         }
/*     */         
/* 107 */         return arrayOfInt;
/*     */       } 
/*     */     }
/* 110 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\TerminalTypeOptionHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */