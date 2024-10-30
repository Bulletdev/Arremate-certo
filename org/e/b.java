/*     */ package org.e;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ public class b
/*     */ {
/*     */   public static String escape(String paramString) {
/*  52 */     String str = paramString.trim();
/*  53 */     int i = str.length();
/*  54 */     StringBuilder stringBuilder = new StringBuilder(i);
/*  55 */     for (byte b1 = 0; b1 < i; b1++) {
/*  56 */       char c = str.charAt(b1);
/*  57 */       if (c < ' ' || c == '+' || c == '%' || c == '=' || c == ';') {
/*  58 */         stringBuilder.append('%');
/*  59 */         stringBuilder.append(Character.forDigit((char)(c >>> 4 & 0xF), 16));
/*  60 */         stringBuilder.append(Character.forDigit((char)(c & 0xF), 16));
/*     */       } else {
/*  62 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/*  65 */     return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static i i(String paramString) {
/*  90 */     i i = new i();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     p p = new p(paramString);
/*     */     
/*  97 */     String str = unescape(p.d('=').trim());
/*     */     
/*  99 */     if ("".equals(str)) {
/* 100 */       throw new g("Cookies must have a 'name'");
/*     */     }
/* 102 */     i.c("name", str);
/*     */ 
/*     */     
/* 105 */     p.d('=');
/* 106 */     i.c("value", unescape(p.d(';')).trim());
/*     */     
/* 108 */     p.next();
/*     */     
/* 110 */     while (p.ge()) {
/* 111 */       String str1; str = unescape(p.bm("=;")).trim().toLowerCase(Locale.ROOT);
/*     */       
/* 113 */       if ("name".equalsIgnoreCase(str)) {
/* 114 */         throw new g("Illegal attribute name: 'name'");
/*     */       }
/* 116 */       if ("value".equalsIgnoreCase(str)) {
/* 117 */         throw new g("Illegal attribute name: 'value'");
/*     */       }
/*     */       
/* 120 */       if (p.next() != '=') {
/* 121 */         Boolean bool = Boolean.TRUE;
/*     */       } else {
/* 123 */         str1 = unescape(p.d(';')).trim();
/* 124 */         p.next();
/*     */       } 
/*     */       
/* 127 */       if (!"".equals(str) && !"".equals(str1)) {
/* 128 */         i.c(str, str1);
/*     */       }
/*     */     } 
/* 131 */     return i;
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
/*     */   public static String d(i parami) throws g {
/* 147 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 149 */     String str1 = null;
/* 150 */     String str2 = null;
/* 151 */     for (String str : parami.keySet()) {
/* 152 */       if ("name".equalsIgnoreCase(str)) {
/* 153 */         str1 = parami.getString(str).trim();
/*     */       }
/* 155 */       if ("value".equalsIgnoreCase(str)) {
/* 156 */         str2 = parami.getString(str).trim();
/*     */       }
/* 158 */       if (str1 != null && str2 != null) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 163 */     if (str1 == null || "".equals(str1.trim())) {
/* 164 */       throw new g("Cookie does not have a name");
/*     */     }
/* 166 */     if (str2 == null) {
/* 167 */       str2 = "";
/*     */     }
/*     */     
/* 170 */     stringBuilder.append(escape(str1));
/* 171 */     stringBuilder.append("=");
/* 172 */     stringBuilder.append(escape(str2));
/*     */     
/* 174 */     for (String str : parami.keySet()) {
/* 175 */       if ("name".equalsIgnoreCase(str) || "value"
/* 176 */         .equalsIgnoreCase(str)) {
/*     */         continue;
/*     */       }
/*     */       
/* 180 */       Object object = parami.d(str);
/* 181 */       if (object instanceof Boolean) {
/* 182 */         if (Boolean.TRUE.equals(object)) {
/* 183 */           stringBuilder.append(';').append(escape(str));
/*     */         }
/*     */         continue;
/*     */       } 
/* 187 */       stringBuilder.append(';')
/* 188 */         .append(escape(str))
/* 189 */         .append('=')
/* 190 */         .append(escape(object.toString()));
/*     */     } 
/*     */ 
/*     */     
/* 194 */     return stringBuilder.toString();
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
/*     */   public static String unescape(String paramString) {
/* 206 */     int i = paramString.length();
/* 207 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 208 */     for (byte b1 = 0; b1 < i; b1++) {
/* 209 */       char c = paramString.charAt(b1);
/* 210 */       if (c == '+') {
/* 211 */         c = ' ';
/* 212 */       } else if (c == '%' && b1 + 2 < i) {
/* 213 */         int j = p.e(paramString.charAt(b1 + 1));
/* 214 */         int k = p.e(paramString.charAt(b1 + 2));
/* 215 */         if (j >= 0 && k >= 0) {
/* 216 */           c = (char)(j * 16 + k);
/* 217 */           b1 += 2;
/*     */         } 
/*     */       } 
/* 220 */       stringBuilder.append(c);
/*     */     } 
/* 222 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */