/*     */ package org.passay;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
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
/*     */ public class w
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "ILLEGAL_NUMBER_RANGE";
/*     */   protected boolean dq;
/*     */   private final int jc;
/*     */   private final int jd;
/*     */   private final u a;
/*     */   
/*     */   public w(int paramInt1, int paramInt2) {
/*  39 */     this(paramInt1, paramInt2, u.d, true);
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
/*     */   public w(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  52 */     this(paramInt1, paramInt2, u.d, paramBoolean);
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
/*     */   public w(int paramInt1, int paramInt2, u paramu) {
/*  65 */     this(paramInt1, paramInt2, paramu, true);
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
/*     */   public w(int paramInt1, int paramInt2, u paramu, boolean paramBoolean) {
/*  79 */     if (paramInt1 >= paramInt2) {
/*  80 */       throw new IllegalArgumentException("lower must be less than upper");
/*     */     }
/*  82 */     this.jc = paramInt1;
/*  83 */     this.jd = paramInt2;
/*  84 */     this.a = paramu;
/*  85 */     this.dq = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int ch() {
/*  96 */     return this.jc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int ci() {
/* 107 */     return this.jd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u a() {
/* 118 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 125 */     E e = new E(true);
/* 126 */     String str = paramx.getPassword();
/* 127 */     for (int i = this.jc; i < this.jd; i++) {
/* 128 */       if (this.a.i(str, Integer.toString(i))) {
/* 129 */         e.aR(false);
/* 130 */         e.bB().add(new F("ILLEGAL_NUMBER_RANGE", f(i)));
/* 131 */         if (!this.dq) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 136 */     return e;
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
/*     */   protected Map<String, Object> f(int paramInt) {
/* 149 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 150 */     linkedHashMap.put("number", Integer.valueOf(paramInt));
/* 151 */     linkedHashMap.put("matchBehavior", this.a);
/* 152 */     return (Map)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 159 */     return 
/* 160 */       String.format("%s@%h::lowerRange=%s,upperRange=%s,matchBehavior=%s", new Object[] {
/*     */           
/* 162 */           getClass().getName(), 
/* 163 */           Integer.valueOf(hashCode()), 
/* 164 */           Integer.valueOf(this.jc), 
/* 165 */           Integer.valueOf(this.jd), this.a
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */