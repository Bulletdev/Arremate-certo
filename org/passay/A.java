/*     */ package org.passay;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import org.passay.dictionary.d;
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
/*     */ public abstract class a
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "ILLEGAL_WORD";
/*     */   public static final String ml = "ILLEGAL_WORD_REVERSED";
/*     */   private d a;
/*     */   private boolean dp;
/*     */   
/*     */   public void a(d paramd) {
/*  36 */     if (paramd == null) {
/*  37 */       throw new NullPointerException("Dictionary cannot be null");
/*     */     }
/*  39 */     this.a = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d a() {
/*  50 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aO(boolean paramBoolean) {
/*  61 */     this.dp = paramBoolean;
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
/*     */   public boolean gB() {
/*  73 */     return this.dp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/*  80 */     E e = new E(true);
/*  81 */     String str1 = paramx.getPassword();
/*  82 */     String str2 = br(str1);
/*  83 */     if (str2 != null) {
/*  84 */       e.aR(false);
/*  85 */       e.bB().add(new F("ILLEGAL_WORD", c(str2)));
/*     */     } 
/*  87 */     if (this.dp && str1.length() > 1) {
/*  88 */       str1 = (new StringBuilder(paramx.getPassword())).reverse().toString();
/*  89 */       str2 = br(str1);
/*  90 */       if (str2 != null) {
/*  91 */         e.aR(false);
/*  92 */         e.bB().add(new F("ILLEGAL_WORD_REVERSED", 
/*  93 */               c(str2)));
/*     */       } 
/*     */     } 
/*  96 */     return e;
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
/*     */   protected Map<String, Object> c(String paramString) {
/* 109 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 110 */     linkedHashMap.put("matchingWord", paramString);
/* 111 */     return (Map)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String br(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 128 */     return 
/* 129 */       String.format("%s@%h::dictionary=%s,matchBackwards=%s", new Object[] {
/*     */           
/* 131 */           getClass().getName(), 
/* 132 */           Integer.valueOf(hashCode()), this.a, 
/*     */           
/* 134 */           Boolean.valueOf(this.dp)
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */