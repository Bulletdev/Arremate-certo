/*     */ package com.google.a.e;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @b
/*     */ public final class g
/*     */ {
/*     */   public static f b() {
/*  42 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  47 */   private static final f b = new d()
/*     */     {
/*     */       public String escape(String param1String)
/*     */       {
/*  51 */         return (String)D.checkNotNull(param1String);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected char[] a(char param1Char) {
/*  57 */         return null;
/*     */       }
/*     */     };
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
/*     */   public static a a() {
/*  79 */     return new a();
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
/*     */   @a
/*     */   public static final class a
/*     */   {
/*  95 */     private final Map<Character, String> Y = new HashMap<>();
/*  96 */     private char j = Character.MIN_VALUE;
/*  97 */     private char k = Character.MAX_VALUE;
/*  98 */     private String gG = null;
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
/*     */     @com.google.b.a.a
/*     */     public a a(char param1Char1, char param1Char2) {
/* 114 */       this.j = param1Char1;
/* 115 */       this.k = param1Char2;
/* 116 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String) {
/* 129 */       this.gG = param1String;
/* 130 */       return this;
/*     */     }
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
/*     */     @com.google.b.a.a
/*     */     public a a(char param1Char, String param1String) {
/* 145 */       D.checkNotNull(param1String);
/*     */       
/* 147 */       this.Y.put(Character.valueOf(param1Char), param1String);
/* 148 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public f c() {
/* 153 */       return new a(this, this.Y, this.j, this.k)
/*     */         {
/* 155 */           private final char[] e = (g.a.a(this.a) != null) ? g.a.a(this.a).toCharArray() : null;
/*     */ 
/*     */           
/*     */           protected char[] b(char param2Char) {
/* 159 */             return this.e;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static i a(f paramf) {
/* 180 */     D.checkNotNull(paramf);
/* 181 */     if (paramf instanceof i)
/* 182 */       return (i)paramf; 
/* 183 */     if (paramf instanceof d) {
/* 184 */       return a((d)paramf);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 189 */     String.valueOf(paramf.getClass().getName()); throw new IllegalArgumentException((String.valueOf(paramf.getClass().getName()).length() != 0) ? "Cannot create a UnicodeEscaper from: ".concat(String.valueOf(paramf.getClass().getName())) : new String("Cannot create a UnicodeEscaper from: "));
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
/*     */   public static String a(d paramd, char paramChar) {
/* 202 */     return a(paramd.a(paramChar));
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
/*     */   public static String a(i parami, int paramInt) {
/* 215 */     return a(parami.a(paramInt));
/*     */   }
/*     */   
/*     */   private static String a(char[] paramArrayOfchar) {
/* 219 */     return (paramArrayOfchar == null) ? null : new String(paramArrayOfchar);
/*     */   }
/*     */ 
/*     */   
/*     */   private static i a(d paramd) {
/* 224 */     return new i(paramd)
/*     */       {
/*     */         protected char[] a(int param1Int)
/*     */         {
/* 228 */           if (param1Int < 65536) {
/* 229 */             return this.a.a((char)param1Int);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 235 */           char[] arrayOfChar1 = new char[2];
/* 236 */           Character.toChars(param1Int, arrayOfChar1, 0);
/* 237 */           char[] arrayOfChar2 = this.a.a(arrayOfChar1[0]);
/* 238 */           char[] arrayOfChar3 = this.a.a(arrayOfChar1[1]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 244 */           if (arrayOfChar2 == null && arrayOfChar3 == null)
/*     */           {
/* 246 */             return null;
/*     */           }
/*     */           
/* 249 */           byte b1 = (arrayOfChar2 != null) ? arrayOfChar2.length : 1;
/* 250 */           byte b2 = (arrayOfChar3 != null) ? arrayOfChar3.length : 1;
/* 251 */           char[] arrayOfChar4 = new char[b1 + b2];
/* 252 */           if (arrayOfChar2 != null) {
/*     */             
/* 254 */             for (byte b = 0; b < arrayOfChar2.length; b++) {
/* 255 */               arrayOfChar4[b] = arrayOfChar2[b];
/*     */             }
/*     */           } else {
/* 258 */             arrayOfChar4[0] = arrayOfChar1[0];
/*     */           } 
/* 260 */           if (arrayOfChar3 != null) {
/* 261 */             for (byte b = 0; b < arrayOfChar3.length; b++) {
/* 262 */               arrayOfChar4[b1 + b] = arrayOfChar3[b];
/*     */             }
/*     */           } else {
/* 265 */             arrayOfChar4[b1] = arrayOfChar1[1];
/*     */           } 
/* 267 */           return arrayOfChar4;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */