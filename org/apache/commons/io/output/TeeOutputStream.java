/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ public class TeeOutputStream
/*     */   extends ProxyOutputStream
/*     */ {
/*     */   protected OutputStream branch;
/*     */   
/*     */   public TeeOutputStream(OutputStream paramOutputStream1, OutputStream paramOutputStream2) {
/*  37 */     super(paramOutputStream1);
/*  38 */     this.branch = paramOutputStream2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(byte[] paramArrayOfbyte) throws IOException {
/*  48 */     super.write(paramArrayOfbyte);
/*  49 */     this.branch.write(paramArrayOfbyte);
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
/*     */   public synchronized void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  61 */     super.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  62 */     this.branch.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(int paramInt) throws IOException {
/*  72 */     super.write(paramInt);
/*  73 */     this.branch.write(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*  82 */     super.flush();
/*  83 */     this.branch.flush();
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
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/* 100 */       super.close();
/*     */     } finally {
/* 102 */       this.branch.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\TeeOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */