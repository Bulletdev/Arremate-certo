/*     */ package org.passay;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
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
/*     */ public class p
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "ILLEGAL_CHAR";
/*     */   protected boolean dq;
/*     */   private final char[] l;
/*     */   private final u a;
/*     */   
/*     */   public p(char[] paramArrayOfchar) {
/*  39 */     this(paramArrayOfchar, u.d, true);
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
/*     */   public p(char[] paramArrayOfchar, u paramu) {
/*  51 */     this(paramArrayOfchar, paramu, true);
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
/*     */   public p(char[] paramArrayOfchar, boolean paramBoolean) {
/*  63 */     this(paramArrayOfchar, u.d, paramBoolean);
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
/*     */   public p(char[] paramArrayOfchar, u paramu, boolean paramBoolean) {
/*  76 */     if (paramArrayOfchar.length > 0) {
/*  77 */       this.l = paramArrayOfchar;
/*     */     } else {
/*  79 */       throw new IllegalArgumentException("illegal characters length must be greater than zero");
/*     */     } 
/*  81 */     this.a = paramu;
/*  82 */     this.dq = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] f() {
/*  93 */     return this.l;
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
/* 104 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 111 */     E e = new E(true);
/* 112 */     HashSet<Character> hashSet = new HashSet();
/* 113 */     String str = paramx.getPassword();
/* 114 */     for (char c : this.l) {
/* 115 */       if (this.a.a(str, c) && !hashSet.contains(Character.valueOf(c))) {
/* 116 */         e.aR(false);
/* 117 */         e.bB().add(new F("ILLEGAL_CHAR", a(c)));
/* 118 */         if (!this.dq) {
/*     */           break;
/*     */         }
/* 121 */         hashSet.add(Character.valueOf(c));
/*     */       } 
/*     */     } 
/* 124 */     e.a(a(paramx));
/* 125 */     return e;
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
/*     */   protected Map<String, Object> a(char paramChar) {
/* 138 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 139 */     linkedHashMap.put("illegalCharacter", Character.valueOf(paramChar));
/* 140 */     linkedHashMap.put("matchBehavior", this.a);
/* 141 */     return (Map)linkedHashMap;
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
/* 154 */     return new G(G.a.h, 
/*     */         
/* 156 */         z.d(String.valueOf(this.l), paramx.getPassword()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     return 
/* 164 */       String.format("%s@%h::reportAllFailures=%s,matchBehavior=%s,illegalCharacters=%s", new Object[] {
/*     */           
/* 166 */           getClass().getName(), 
/* 167 */           Integer.valueOf(hashCode()), 
/* 168 */           Boolean.valueOf(this.dq), this.a, (this.l != null) ? 
/*     */           
/* 170 */           Arrays.toString(this.l) : null
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */