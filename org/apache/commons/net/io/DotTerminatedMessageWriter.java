/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
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
/*     */ public final class DotTerminatedMessageWriter
/*     */   extends Writer
/*     */ {
/*     */   private static final int NOTHING_SPECIAL_STATE = 0;
/*     */   private static final int LAST_WAS_CR_STATE = 1;
/*     */   private static final int LAST_WAS_NL_STATE = 2;
/*     */   private int state;
/*     */   private Writer output;
/*     */   
/*     */   public DotTerminatedMessageWriter(Writer paramWriter) {
/*  57 */     super(paramWriter);
/*  58 */     this.output = paramWriter;
/*  59 */     this.state = 0;
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
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/*  77 */     synchronized (this.lock) {
/*     */       
/*  79 */       switch (paramInt) {
/*     */         
/*     */         case 13:
/*  82 */           this.state = 1;
/*  83 */           this.output.write(13);
/*     */           return;
/*     */         case 10:
/*  86 */           if (this.state != 1) {
/*  87 */             this.output.write(13);
/*     */           }
/*  89 */           this.output.write(10);
/*  90 */           this.state = 2;
/*     */           return;
/*     */         
/*     */         case 46:
/*  94 */           if (this.state == 2) {
/*  95 */             this.output.write(46);
/*     */           }
/*     */           break;
/*     */       } 
/*  99 */       this.state = 0;
/* 100 */       this.output.write(paramInt);
/*     */     } 
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
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 119 */     synchronized (this.lock) {
/*     */       
/* 121 */       while (paramInt2-- > 0) {
/* 122 */         write(paramArrayOfchar[paramInt1++]);
/*     */       }
/*     */     } 
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
/*     */   public void write(char[] paramArrayOfchar) throws IOException {
/* 138 */     write(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*     */   public void write(String paramString) throws IOException {
/* 152 */     write(paramString.toCharArray());
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
/*     */   public void write(String paramString, int paramInt1, int paramInt2) throws IOException {
/* 168 */     write(paramString.toCharArray(), paramInt1, paramInt2);
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
/*     */   public void flush() throws IOException {
/* 181 */     synchronized (this.lock) {
/*     */       
/* 183 */       this.output.flush();
/*     */     } 
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
/*     */   public void close() throws IOException {
/* 199 */     synchronized (this.lock) {
/*     */       
/* 201 */       if (this.output == null) {
/*     */         return;
/*     */       }
/*     */       
/* 205 */       if (this.state == 1) {
/* 206 */         this.output.write(10);
/* 207 */       } else if (this.state != 2) {
/* 208 */         this.output.write("\r\n");
/*     */       } 
/*     */       
/* 211 */       this.output.write(".\r\n");
/*     */       
/* 213 */       this.output.flush();
/* 214 */       this.output = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\DotTerminatedMessageWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */