/*     */ package org.d;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import org.d.b.a;
/*     */ import org.d.b.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements g
/*     */ {
/*     */   public g a(String paramString) {
/*  18 */     append(paramString);
/*  19 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(m paramm) {
/*  24 */     paramm.a(this);
/*  25 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(Object paramObject) {
/*  30 */     if (paramObject == null) {
/*  31 */       append("null");
/*  32 */     } else if (paramObject instanceof String) {
/*  33 */       bJ((String)paramObject);
/*  34 */     } else if (paramObject instanceof Character) {
/*  35 */       append('"');
/*  36 */       a(((Character)paramObject).charValue());
/*  37 */       append('"');
/*  38 */     } else if (paramObject instanceof Short) {
/*  39 */       append('<');
/*  40 */       append(l(paramObject));
/*  41 */       append("s>");
/*  42 */     } else if (paramObject instanceof Long) {
/*  43 */       append('<');
/*  44 */       append(l(paramObject));
/*  45 */       append("L>");
/*  46 */     } else if (paramObject instanceof Float) {
/*  47 */       append('<');
/*  48 */       append(l(paramObject));
/*  49 */       append("F>");
/*  50 */     } else if (paramObject.getClass().isArray()) {
/*  51 */       a("[", ", ", "]", (Iterator<?>)new a(paramObject));
/*     */     } else {
/*  53 */       append('<');
/*  54 */       append(l(paramObject));
/*  55 */       append('>');
/*     */     } 
/*  57 */     return this;
/*     */   }
/*     */   
/*     */   private String l(Object paramObject) {
/*     */     try {
/*  62 */       return String.valueOf(paramObject);
/*     */     }
/*  64 */     catch (Exception exception) {
/*  65 */       return paramObject.getClass().getName() + "@" + Integer.toHexString(paramObject.hashCode());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> g a(String paramString1, String paramString2, String paramString3, T... paramVarArgs) {
/*  71 */     return a(paramString1, paramString2, paramString3, Arrays.asList((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> g a(String paramString1, String paramString2, String paramString3, Iterable<T> paramIterable) {
/*  76 */     return a(paramString1, paramString2, paramString3, paramIterable.iterator());
/*     */   }
/*     */   
/*     */   private <T> g a(String paramString1, String paramString2, String paramString3, Iterator<T> paramIterator) {
/*  80 */     return b(paramString1, paramString2, paramString3, (Iterator<? extends m>)new d(paramIterator));
/*     */   }
/*     */ 
/*     */   
/*     */   public g b(String paramString1, String paramString2, String paramString3, Iterable<? extends m> paramIterable) {
/*  85 */     return b(paramString1, paramString2, paramString3, paramIterable.iterator());
/*     */   }
/*     */   
/*     */   private g b(String paramString1, String paramString2, String paramString3, Iterator<? extends m> paramIterator) {
/*  89 */     boolean bool = false;
/*     */     
/*  91 */     append(paramString1);
/*  92 */     while (paramIterator.hasNext()) {
/*  93 */       if (bool) append(paramString2); 
/*  94 */       a(paramIterator.next());
/*  95 */       bool = true;
/*     */     } 
/*  97 */     append(paramString3);
/*     */     
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void append(String paramString) {
/* 108 */     for (byte b = 0; b < paramString.length(); b++) {
/* 109 */       append(paramString.charAt(b));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void append(char paramChar);
/*     */ 
/*     */   
/*     */   private void bJ(String paramString) {
/* 119 */     append('"');
/* 120 */     for (byte b = 0; b < paramString.length(); b++) {
/* 121 */       a(paramString.charAt(b));
/*     */     }
/* 123 */     append('"');
/*     */   }
/*     */   
/*     */   private void a(char paramChar) {
/* 127 */     switch (paramChar) {
/*     */       case '"':
/* 129 */         append("\\\"");
/*     */         return;
/*     */       case '\n':
/* 132 */         append("\\n");
/*     */         return;
/*     */       case '\r':
/* 135 */         append("\\r");
/*     */         return;
/*     */       case '\t':
/* 138 */         append("\\t");
/*     */         return;
/*     */     } 
/* 141 */     append(paramChar);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */