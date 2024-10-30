/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.OutputStream;
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
/*     */ public class CountingOutputStream
/*     */   extends ProxyOutputStream
/*     */ {
/*  32 */   private long count = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CountingOutputStream(OutputStream paramOutputStream) {
/*  40 */     super(paramOutputStream);
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
/*     */   protected synchronized void beforeWrite(int paramInt) {
/*  53 */     this.count += paramInt;
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
/*     */   
/*     */   public int getCount() {
/*  68 */     long l = getByteCount();
/*  69 */     if (l > 2147483647L) {
/*  70 */       throw new ArithmeticException("The byte count " + l + " is too large to be converted to an int");
/*     */     }
/*  72 */     return (int)l;
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
/*     */   public int resetCount() {
/*  86 */     long l = resetByteCount();
/*  87 */     if (l > 2147483647L) {
/*  88 */       throw new ArithmeticException("The byte count " + l + " is too large to be converted to an int");
/*     */     }
/*  90 */     return (int)l;
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
/*     */   public synchronized long getByteCount() {
/* 104 */     return this.count;
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
/*     */   public synchronized long resetByteCount() {
/* 118 */     long l = this.count;
/* 119 */     this.count = 0L;
/* 120 */     return l;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\CountingOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */