/*     */ package org.h2.server.web;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PageParser
/*     */ {
/*     */   private static final int TAB_WIDTH = 4;
/*     */   private final String page;
/*     */   private int pos;
/*     */   private final Map<String, Object> settings;
/*     */   private final int len;
/*     */   private StringBuilder result;
/*     */   
/*     */   private PageParser(String paramString, Map<String, Object> paramMap, int paramInt) {
/*  28 */     this.page = paramString;
/*  29 */     this.pos = paramInt;
/*  30 */     this.len = paramString.length();
/*  31 */     this.settings = paramMap;
/*  32 */     this.result = new StringBuilder(this.len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String parse(String paramString, Map<String, Object> paramMap) {
/*  43 */     PageParser pageParser = new PageParser(paramString, paramMap, 0);
/*  44 */     return pageParser.replaceTags();
/*     */   }
/*     */   
/*     */   private void setError(int paramInt) {
/*  48 */     String str = this.page.substring(0, paramInt) + "####BUG####" + this.page.substring(paramInt);
/*  49 */     str = escapeHtml(str);
/*  50 */     this.result = new StringBuilder();
/*  51 */     this.result.append(str);
/*     */   }
/*     */   
/*     */   private String parseBlockUntil(String paramString) throws ParseException {
/*  55 */     PageParser pageParser = new PageParser(this.page, this.settings, this.pos);
/*  56 */     pageParser.parseAll();
/*  57 */     if (!pageParser.readIf(paramString)) {
/*  58 */       throw new ParseException(this.page, pageParser.pos);
/*     */     }
/*  60 */     this.pos = pageParser.pos;
/*  61 */     return pageParser.result.toString();
/*     */   }
/*     */   
/*     */   private String replaceTags() {
/*     */     try {
/*  66 */       parseAll();
/*  67 */       if (this.pos != this.len) {
/*  68 */         setError(this.pos);
/*     */       }
/*  70 */     } catch (ParseException parseException) {
/*  71 */       setError(this.pos);
/*     */     } 
/*  73 */     return this.result.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void parseAll() throws ParseException {
/*  78 */     StringBuilder stringBuilder = this.result;
/*  79 */     String str = this.page;
/*  80 */     int i = this.pos;
/*  81 */     for (; i < this.len; i++) {
/*  82 */       char c = str.charAt(i);
/*  83 */       switch (c) {
/*     */         case '<':
/*  85 */           if (str.charAt(i + 3) == ':' && str.charAt(i + 1) == '/') {
/*     */             
/*  87 */             this.pos = i; return;
/*     */           } 
/*  89 */           if (str.charAt(i + 2) == ':') {
/*  90 */             this.pos = i;
/*  91 */             if (readIf("<c:forEach")) {
/*  92 */               String str1 = readParam("var");
/*  93 */               String str2 = readParam("items");
/*  94 */               read(">");
/*  95 */               int j = this.pos;
/*  96 */               List list = (List)get(str2);
/*  97 */               if (list == null) {
/*  98 */                 this.result.append("?items?");
/*  99 */                 list = New.arrayList();
/*     */               } 
/* 101 */               if (list.size() == 0) {
/* 102 */                 parseBlockUntil("</c:forEach>");
/*     */               }
/* 104 */               for (Object object : list) {
/* 105 */                 this.settings.put(str1, object);
/* 106 */                 this.pos = j;
/* 107 */                 String str3 = parseBlockUntil("</c:forEach>");
/* 108 */                 this.result.append(str3);
/*     */               } 
/* 110 */             } else if (readIf("<c:if")) {
/* 111 */               String str1 = readParam("test");
/* 112 */               int j = str1.indexOf("=='");
/* 113 */               if (j < 0) {
/* 114 */                 setError(i);
/*     */                 return;
/*     */               } 
/* 117 */               String str2 = str1.substring(j + 3, str1.length() - 1);
/* 118 */               str1 = str1.substring(0, j);
/* 119 */               String str3 = (String)get(str1);
/* 120 */               read(">");
/* 121 */               String str4 = parseBlockUntil("</c:if>");
/* 122 */               this.pos--;
/* 123 */               if (str3.equals(str2)) {
/* 124 */                 this.result.append(str4);
/*     */               }
/*     */             } else {
/* 127 */               setError(i);
/*     */               return;
/*     */             } 
/* 130 */             i = this.pos; break;
/*     */           } 
/* 132 */           stringBuilder.append(c);
/*     */           break;
/*     */ 
/*     */         
/*     */         case '$':
/* 137 */           if (str.length() > i + 1 && str.charAt(i + 1) == '{') {
/* 138 */             i += 2;
/* 139 */             int j = str.indexOf('}', i);
/* 140 */             if (j < 0) {
/* 141 */               setError(i);
/*     */               return;
/*     */             } 
/* 144 */             String str1 = str.substring(i, j).trim();
/* 145 */             i = j;
/* 146 */             String str2 = (String)get(str1);
/* 147 */             replaceTags(str2); break;
/*     */           } 
/* 149 */           stringBuilder.append(c);
/*     */           break;
/*     */         
/*     */         default:
/* 153 */           stringBuilder.append(c);
/*     */           break;
/*     */       } 
/*     */     } 
/* 157 */     this.pos = i;
/*     */   }
/*     */ 
/*     */   
/*     */   private Object get(String paramString) {
/* 162 */     int i = paramString.indexOf('.');
/* 163 */     if (i >= 0) {
/* 164 */       String str = paramString.substring(i + 1);
/* 165 */       paramString = paramString.substring(0, i);
/* 166 */       HashMap hashMap = (HashMap)this.settings.get(paramString);
/* 167 */       if (hashMap == null) {
/* 168 */         return "?" + paramString + "?";
/*     */       }
/* 170 */       return hashMap.get(str);
/*     */     } 
/* 172 */     return this.settings.get(paramString);
/*     */   }
/*     */   
/*     */   private void replaceTags(String paramString) {
/* 176 */     if (paramString != null) {
/* 177 */       this.result.append(parse(paramString, this.settings));
/*     */     }
/*     */   }
/*     */   
/*     */   private String readParam(String paramString) throws ParseException {
/* 182 */     read(paramString);
/* 183 */     read("=");
/* 184 */     read("\"");
/* 185 */     int i = this.pos;
/* 186 */     while (this.page.charAt(this.pos) != '"') {
/* 187 */       this.pos++;
/*     */     }
/* 189 */     int j = this.pos;
/* 190 */     read("\"");
/* 191 */     String str = this.page.substring(i, j);
/* 192 */     return parse(str, this.settings);
/*     */   }
/*     */   
/*     */   private void skipSpaces() {
/* 196 */     while (this.page.charAt(this.pos) == ' ') {
/* 197 */       this.pos++;
/*     */     }
/*     */   }
/*     */   
/*     */   private void read(String paramString) throws ParseException {
/* 202 */     if (!readIf(paramString)) {
/* 203 */       throw new ParseException(paramString, this.pos);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean readIf(String paramString) {
/* 208 */     skipSpaces();
/* 209 */     if (this.page.regionMatches(this.pos, paramString, 0, paramString.length())) {
/* 210 */       this.pos += paramString.length();
/* 211 */       skipSpaces();
/* 212 */       return true;
/*     */     } 
/* 214 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String escapeHtmlData(String paramString) {
/* 224 */     return escapeHtml(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeHtml(String paramString) {
/* 234 */     return escapeHtml(paramString, true);
/*     */   }
/*     */   
/*     */   private static String escapeHtml(String paramString, boolean paramBoolean) {
/* 238 */     if (paramString == null) {
/* 239 */       return null;
/*     */     }
/* 241 */     if (paramBoolean && 
/* 242 */       paramString.length() == 0) {
/* 243 */       return "&nbsp;";
/*     */     }
/*     */     
/* 246 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 247 */     boolean bool = true;
/* 248 */     for (byte b = 0; b < paramString.length(); b++) {
/* 249 */       char c = paramString.charAt(b);
/* 250 */       if (c == ' ' || c == '\t') {
/*     */         
/* 252 */         for (byte b1 = 0; b1 < ((c == ' ') ? 1 : 4); b1++) {
/* 253 */           if (bool && paramBoolean) {
/* 254 */             stringBuilder.append("&nbsp;");
/*     */           } else {
/* 256 */             stringBuilder.append(' ');
/* 257 */             bool = true;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 262 */         bool = false;
/* 263 */         switch (c) {
/*     */           
/*     */           case '$':
/* 266 */             stringBuilder.append("&#36;");
/*     */             break;
/*     */           case '<':
/* 269 */             stringBuilder.append("&lt;");
/*     */             break;
/*     */           case '>':
/* 272 */             stringBuilder.append("&gt;");
/*     */             break;
/*     */           case '&':
/* 275 */             stringBuilder.append("&amp;");
/*     */             break;
/*     */           case '"':
/* 278 */             stringBuilder.append("&quot;");
/*     */             break;
/*     */           case '\'':
/* 281 */             stringBuilder.append("&#39;");
/*     */             break;
/*     */           case '\n':
/* 284 */             if (paramBoolean) {
/* 285 */               stringBuilder.append("<br />");
/* 286 */               bool = true; break;
/*     */             } 
/* 288 */             stringBuilder.append(c);
/*     */             break;
/*     */           
/*     */           default:
/* 292 */             if (c >= '') {
/* 293 */               stringBuilder.append("&#").append(c).append(';'); break;
/*     */             } 
/* 295 */             stringBuilder.append(c);
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 300 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String escapeJavaScript(String paramString) {
/* 310 */     if (paramString == null) {
/* 311 */       return null;
/*     */     }
/* 313 */     if (paramString.length() == 0) {
/* 314 */       return "";
/*     */     }
/* 316 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 317 */     for (byte b = 0; b < paramString.length(); b++) {
/* 318 */       char c = paramString.charAt(b);
/* 319 */       switch (c) {
/*     */         case '"':
/* 321 */           stringBuilder.append("\\\"");
/*     */           break;
/*     */         case '\'':
/* 324 */           stringBuilder.append("\\'");
/*     */           break;
/*     */         case '\\':
/* 327 */           stringBuilder.append("\\\\");
/*     */           break;
/*     */         case '\n':
/* 330 */           stringBuilder.append("\\n");
/*     */           break;
/*     */         case '\r':
/* 333 */           stringBuilder.append("\\r");
/*     */           break;
/*     */         case '\t':
/* 336 */           stringBuilder.append("\\t");
/*     */           break;
/*     */         default:
/* 339 */           stringBuilder.append(c);
/*     */           break;
/*     */       } 
/*     */     } 
/* 343 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\PageParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */