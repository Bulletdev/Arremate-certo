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
/*     */ public class c
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "ALLOWED_CHAR";
/*     */   protected boolean dq;
/*     */   private final char[] k;
/*     */   private final u a;
/*     */   
/*     */   public c(char[] paramArrayOfchar) {
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
/*     */   public c(char[] paramArrayOfchar, u paramu) {
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
/*     */   public c(char[] paramArrayOfchar, boolean paramBoolean) {
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
/*     */   public c(char[] paramArrayOfchar, u paramu, boolean paramBoolean) {
/*  76 */     if (paramArrayOfchar.length > 0) {
/*  77 */       this.k = paramArrayOfchar;
/*     */     } else {
/*  79 */       throw new IllegalArgumentException("allowed characters length must be greater than zero");
/*     */     } 
/*  81 */     Arrays.sort(this.k);
/*  82 */     this.a = paramu;
/*  83 */     this.dq = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] e() {
/*  94 */     return this.k;
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
/* 105 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 112 */     E e = new E(true);
/* 113 */     HashSet<Character> hashSet = new HashSet();
/* 114 */     String str = paramx.getPassword();
/* 115 */     for (char c1 : str.toCharArray()) {
/* 116 */       if (Arrays.binarySearch(this.k, c1) < 0 && !hashSet.contains(Character.valueOf(c1)) && (
/* 117 */         u.d.equals(this.a) || this.a.a(str, c1))) {
/* 118 */         e.aR(false);
/* 119 */         e.bB().add(new F("ALLOWED_CHAR", a(c1)));
/* 120 */         if (!this.dq) {
/*     */           break;
/*     */         }
/* 123 */         hashSet.add(Character.valueOf(c1));
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     e.a(a(paramx));
/* 128 */     return e;
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
/* 141 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 142 */     linkedHashMap.put("illegalCharacter", Character.valueOf(paramChar));
/* 143 */     linkedHashMap.put("matchBehavior", this.a);
/* 144 */     return (Map)linkedHashMap;
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
/* 157 */     return new G(G.a.g, 
/*     */         
/* 159 */         z.d(String.valueOf(this.k), paramx.getPassword()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return 
/* 167 */       String.format("%s@%h::reportAllFailures=%s,matchBehavior=%s,allowedCharacters=%s", new Object[] {
/* 168 */           getClass().getName(), 
/* 169 */           Integer.valueOf(hashCode()), 
/* 170 */           Boolean.valueOf(this.dq), this.a, (this.k != null) ? 
/*     */           
/* 172 */           Arrays.toString(this.k) : null
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */