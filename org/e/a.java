/*     */ package org.e;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*     */   private static String a(p paramp) throws g {
/*     */     char c;
/*     */     char c1;
/*     */     StringBuilder stringBuilder;
/*     */     do {
/*  60 */       c = paramp.next();
/*  61 */     } while (c == ' ' || c == '\t');
/*  62 */     switch (c) {
/*     */       case '\000':
/*  64 */         return null;
/*     */       case '"':
/*     */       case '\'':
/*  67 */         c1 = c;
/*  68 */         stringBuilder = new StringBuilder();
/*     */         while (true) {
/*  70 */           c = paramp.next();
/*  71 */           if (c == c1) {
/*     */             
/*  73 */             char c2 = paramp.next();
/*  74 */             if (c2 != '"') {
/*     */               
/*  76 */               if (c2 > '\000') {
/*  77 */                 paramp.il();
/*     */               }
/*     */               break;
/*     */             } 
/*     */           } 
/*  82 */           if (c == '\000' || c == '\n' || c == '\r') {
/*  83 */             throw paramp.a("Missing close quote '" + c1 + "'.");
/*     */           }
/*  85 */           stringBuilder.append(c);
/*     */         } 
/*  87 */         return stringBuilder.toString();
/*     */       case ',':
/*  89 */         paramp.il();
/*  90 */         return "";
/*     */     } 
/*  92 */     paramp.il();
/*  93 */     return paramp.d(',');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static f a(p paramp) throws g {
/* 104 */     f f = new f();
/*     */     while (true) {
/* 106 */       String str = a(paramp);
/* 107 */       char c = paramp.next();
/* 108 */       if (str == null || (f
/* 109 */         .length() == 0 && str.length() == 0 && c != ',')) {
/* 110 */         return null;
/*     */       }
/* 112 */       f.a(str);
/*     */       
/* 114 */       while (c != ',') {
/*     */ 
/*     */         
/* 117 */         if (c != ' ') {
/* 118 */           if (c == '\n' || c == '\r' || c == '\000') {
/* 119 */             return f;
/*     */           }
/* 121 */           throw paramp.a("Bad character '" + c + "' (" + c + ").");
/*     */         } 
/*     */         
/* 124 */         c = paramp.next();
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
/*     */   
/*     */   public static i a(f paramf, p paramp) throws g {
/* 141 */     f f1 = a(paramp);
/* 142 */     return (f1 != null) ? f1.a(paramf) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(f paramf) {
/* 153 */     StringBuilder stringBuilder = new StringBuilder();
/* 154 */     for (byte b = 0; b < paramf.length(); b++) {
/* 155 */       if (b > 0) {
/* 156 */         stringBuilder.append(',');
/*     */       }
/* 158 */       Object object = paramf.h(b);
/* 159 */       if (object != null) {
/* 160 */         String str = object.toString();
/* 161 */         if (str.length() > 0 && (str.indexOf(',') >= 0 || str
/* 162 */           .indexOf('\n') >= 0 || str.indexOf('\r') >= 0 || str
/* 163 */           .indexOf(false) >= 0 || str.charAt(0) == '"')) {
/* 164 */           stringBuilder.append('"');
/* 165 */           int i = str.length();
/* 166 */           for (byte b1 = 0; b1 < i; b1++) {
/* 167 */             char c = str.charAt(b1);
/* 168 */             if (c >= ' ' && c != '"') {
/* 169 */               stringBuilder.append(c);
/*     */             }
/*     */           } 
/* 172 */           stringBuilder.append('"');
/*     */         } else {
/* 174 */           stringBuilder.append(str);
/*     */         } 
/*     */       } 
/*     */     } 
/* 178 */     stringBuilder.append('\n');
/* 179 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static f b(String paramString) throws g {
/* 190 */     return b(new p(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static f b(p paramp) throws g {
/* 201 */     return a(a(paramp), paramp);
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
/*     */   public static f a(f paramf, String paramString) throws g {
/* 214 */     return a(paramf, new p(paramString));
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
/*     */   public static f a(f paramf, p paramp) throws g {
/* 227 */     if (paramf == null || paramf.length() == 0) {
/* 228 */       return null;
/*     */     }
/* 230 */     f f1 = new f();
/*     */     while (true) {
/* 232 */       i i = a(paramf, paramp);
/* 233 */       if (i == null) {
/*     */         break;
/*     */       }
/* 236 */       f1.a(i);
/*     */     } 
/* 238 */     if (f1.length() == 0) {
/* 239 */       return null;
/*     */     }
/* 241 */     return f1;
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
/*     */   public static String b(f paramf) throws g {
/* 254 */     i i = paramf.c(0);
/* 255 */     if (i != null) {
/* 256 */       f f1 = i.h();
/* 257 */       if (f1 != null) {
/* 258 */         return a(f1) + a(f1, paramf);
/*     */       }
/*     */     } 
/* 261 */     return null;
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
/*     */   public static String a(f paramf1, f paramf2) throws g {
/* 275 */     if (paramf1 == null || paramf1.length() == 0) {
/* 276 */       return null;
/*     */     }
/* 278 */     StringBuilder stringBuilder = new StringBuilder();
/* 279 */     for (byte b = 0; b < paramf2.length(); b++) {
/* 280 */       i i = paramf2.c(b);
/* 281 */       if (i != null) {
/* 282 */         stringBuilder.append(a(i.b(paramf1)));
/*     */       }
/*     */     } 
/* 285 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */