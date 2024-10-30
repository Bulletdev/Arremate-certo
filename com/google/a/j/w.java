/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.b.a.a;
/*     */ import java.io.IOException;
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
/*     */ @c
/*     */ abstract class w
/*     */ {
/*  35 */   private StringBuilder b = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean bb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/*  50 */     int i = paramInt1;
/*  51 */     if (this.bb && paramInt2 > 0)
/*     */     {
/*  53 */       if (b((paramArrayOfchar[i] == '\n'))) {
/*  54 */         i++;
/*     */       }
/*     */     }
/*     */     
/*  58 */     int j = i;
/*  59 */     for (int k = paramInt1 + paramInt2; i < k; i++) {
/*  60 */       switch (paramArrayOfchar[i]) {
/*     */         case '\r':
/*  62 */           this.b.append(paramArrayOfchar, j, i - j);
/*  63 */           this.bb = true;
/*  64 */           if (i + 1 < k && 
/*  65 */             b((paramArrayOfchar[i + 1] == '\n'))) {
/*  66 */             i++;
/*     */           }
/*     */           
/*  69 */           j = i + 1;
/*     */           break;
/*     */         
/*     */         case '\n':
/*  73 */           this.b.append(paramArrayOfchar, j, i - j);
/*  74 */           b(true);
/*  75 */           j = i + 1;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  82 */     this.b.append(paramArrayOfchar, j, paramInt1 + paramInt2 - j);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   private boolean b(boolean paramBoolean) throws IOException {
/*  88 */     String str = this.bb ? (paramBoolean ? "\r\n" : "\r") : (paramBoolean ? "\n" : "");
/*  89 */     g(this.b.toString(), str);
/*  90 */     this.b = new StringBuilder();
/*  91 */     this.bb = false;
/*  92 */     return paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finish() throws IOException {
/* 102 */     if (this.bb || this.b.length() > 0)
/* 103 */       b(false); 
/*     */   }
/*     */   
/*     */   protected abstract void g(String paramString1, String paramString2) throws IOException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */