/*     */ package org.e;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ public class j
/*     */ {
/*     */   private static final String ENCODING = "utf-8";
/*     */   private final List<String> av;
/*     */   
/*     */   public static class a
/*     */   {
/*  66 */     private final List<String> av = new ArrayList<String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public j a() {
/*  74 */       return new j(this.av);
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
/*     */ 
/*     */     
/*     */     public a a(String param1String) {
/*  90 */       if (param1String == null) {
/*  91 */         throw new NullPointerException("token cannot be null");
/*     */       }
/*  93 */       this.av.add(param1String);
/*  94 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a a(int param1Int) {
/* 105 */       this.av.add(String.valueOf(param1Int));
/* 106 */       return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a() {
/* 126 */     return new a();
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
/*     */   public j(String paramString) {
/*     */     String str;
/* 141 */     if (paramString == null) {
/* 142 */       throw new NullPointerException("pointer cannot be null");
/*     */     }
/* 144 */     if (paramString.isEmpty() || paramString.equals("#")) {
/* 145 */       this.av = Collections.emptyList();
/*     */       
/*     */       return;
/*     */     } 
/* 149 */     if (paramString.startsWith("#/")) {
/* 150 */       str = paramString.substring(2);
/*     */       try {
/* 152 */         str = URLDecoder.decode(str, "utf-8");
/* 153 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 154 */         throw new RuntimeException(unsupportedEncodingException);
/*     */       } 
/* 156 */     } else if (paramString.startsWith("/")) {
/* 157 */       str = paramString.substring(1);
/*     */     } else {
/* 159 */       throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
/*     */     } 
/* 161 */     this.av = new ArrayList<String>();
/* 162 */     int i = -1;
/* 163 */     int k = 0;
/*     */     do {
/* 165 */       k = i + 1;
/* 166 */       i = str.indexOf('/', k);
/* 167 */       if (k == i || k == str.length()) {
/*     */ 
/*     */         
/* 170 */         this.av.add("");
/* 171 */       } else if (i >= 0) {
/* 172 */         String str1 = str.substring(k, i);
/* 173 */         this.av.add(unescape(str1));
/*     */       } else {
/*     */         
/* 176 */         String str1 = str.substring(k);
/* 177 */         this.av.add(unescape(str1));
/*     */       } 
/* 179 */     } while (i >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(List<String> paramList) {
/* 187 */     this.av = new ArrayList<String>(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String unescape(String paramString) {
/* 193 */     return paramString.replace("~1", "/").replace("~0", "~").replace("\\\"", "\"").replace("\\\\", "\\");
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
/*     */   public Object N(Object paramObject) throws k {
/* 207 */     if (this.av.isEmpty()) {
/* 208 */       return paramObject;
/*     */     }
/* 210 */     Object object = paramObject;
/* 211 */     for (String str : this.av) {
/* 212 */       if (object instanceof i) {
/* 213 */         object = ((i)object).d(unescape(str)); continue;
/* 214 */       }  if (object instanceof f) {
/* 215 */         object = a(object, str); continue;
/*     */       } 
/* 217 */       throw new k(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", new Object[] { object, str }));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 222 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object a(Object paramObject, String paramString) throws k {
/*     */     try {
/* 234 */       int i = Integer.parseInt(paramString);
/* 235 */       f f = (f)paramObject;
/* 236 */       if (i >= f.length()) {
/* 237 */         throw new k(String.format("index %s is out of bounds - the array has %d elements", new Object[] { paramString, 
/* 238 */                 Integer.valueOf(f.length()) }));
/*     */       }
/*     */       try {
/* 241 */         return f.get(i);
/* 242 */       } catch (g g) {
/* 243 */         throw new k("Error reading value at index position " + i, g);
/*     */       } 
/* 245 */     } catch (NumberFormatException numberFormatException) {
/* 246 */       throw new k(String.format("%s is not an array index", new Object[] { paramString }), numberFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 256 */     StringBuilder stringBuilder = new StringBuilder("");
/* 257 */     for (String str : this.av) {
/* 258 */       stringBuilder.append('/').append(escape(str));
/*     */     }
/* 260 */     return stringBuilder.toString();
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
/*     */   private static String escape(String paramString) {
/* 275 */     return paramString.replace("~", "~0").replace("/", "~1").replace("\\", "\\\\").replace("\"", "\\\"");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eP() {
/*     */     try {
/* 285 */       StringBuilder stringBuilder = new StringBuilder("#");
/* 286 */       for (String str : this.av) {
/* 287 */         stringBuilder.append('/').append(URLEncoder.encode(str, "utf-8"));
/*     */       }
/* 289 */       return stringBuilder.toString();
/* 290 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 291 */       throw new RuntimeException(unsupportedEncodingException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */