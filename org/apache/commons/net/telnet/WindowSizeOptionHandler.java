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
/*     */ public class WindowSizeOptionHandler
/*     */   extends TelnetOptionHandler
/*     */ {
/*  29 */   private int width = 80;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   private int height = 24;
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
/*     */   protected static final int WINDOW_SIZE = 31;
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
/*     */   public WindowSizeOptionHandler(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*  62 */     super(31, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     this.width = paramInt1;
/*  71 */     this.height = paramInt2;
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
/*     */   public WindowSizeOptionHandler(int paramInt1, int paramInt2) {
/*  85 */     super(31, false, false, false, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.width = paramInt1;
/*  94 */     this.height = paramInt2;
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
/*     */   public int[] startSubnegotiationLocal() {
/* 106 */     int i = this.width * 65536 + this.height;
/* 107 */     byte b1 = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     if (this.width % 256 == 255) {
/* 113 */       b1++;
/*     */     }
/*     */     
/* 116 */     if (this.width / 256 == 255) {
/* 117 */       b1++;
/*     */     }
/*     */     
/* 120 */     if (this.height % 256 == 255) {
/* 121 */       b1++;
/*     */     }
/*     */     
/* 124 */     if (this.height / 256 == 255) {
/* 125 */       b1++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     int[] arrayOfInt = new int[b1];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     arrayOfInt[0] = 31;
/*     */ 
/*     */     
/* 144 */     byte b2 = 1, b3 = 24;
/* 145 */     for (; b2 < b1; 
/* 146 */       b2++, b3 -= 8) {
/*     */       
/* 148 */       int j = 255;
/* 149 */       j <<= b3;
/* 150 */       arrayOfInt[b2] = (i & j) >>> b3;
/*     */       
/* 152 */       if (arrayOfInt[b2] == 255) {
/* 153 */         b2++;
/* 154 */         arrayOfInt[b2] = 255;
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return arrayOfInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\WindowSizeOptionHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */