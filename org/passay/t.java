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
/*     */ public class t
/*     */   implements D
/*     */ {
/*     */   public static final String mo = "TOO_SHORT";
/*     */   public static final String mp = "TOO_LONG";
/*     */   private int ja;
/*     */   private int jb;
/*     */   
/*     */   public t() {
/*  32 */     this(0, 2147483647);
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
/*     */   public t(int paramInt) {
/*  44 */     this(paramInt, paramInt);
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
/*     */   public t(int paramInt1, int paramInt2) {
/*  56 */     this.ja = paramInt1;
/*  57 */     this.jb = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bx(int paramInt) {
/*  68 */     this.ja = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int cf() {
/*  79 */     return this.ja;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void by(int paramInt) {
/*  90 */     this.jb = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int cg() {
/* 101 */     return this.jb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 108 */     E e = new E();
/* 109 */     int i = paramx.getPassword().length();
/* 110 */     if (i >= this.ja && i <= this.jb) {
/* 111 */       e.aR(true);
/*     */     } else {
/* 113 */       e.aR(false);
/* 114 */       if (i < this.ja) {
/* 115 */         e.bB().add(new F("TOO_SHORT", V()));
/*     */       } else {
/* 117 */         e.bB().add(new F("TOO_LONG", V()));
/*     */       } 
/*     */     } 
/* 120 */     e.a(a(paramx));
/* 121 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, Object> V() {
/* 132 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 133 */     linkedHashMap.put("minimumLength", Integer.valueOf(this.ja));
/* 134 */     linkedHashMap.put("maximumLength", Integer.valueOf(this.jb));
/* 135 */     return (Map)linkedHashMap;
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
/*     */   protected G a(x paramx) {
/* 148 */     return new G((G.a)G.a.a, paramx.getPassword().length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     return 
/* 156 */       String.format("%s@%h::minimumLength=%s,maximumLength=%s", new Object[] {
/*     */           
/* 158 */           getClass().getName(), 
/* 159 */           Integer.valueOf(hashCode()), 
/* 160 */           Integer.valueOf(this.ja), 
/* 161 */           Integer.valueOf(this.jb)
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */