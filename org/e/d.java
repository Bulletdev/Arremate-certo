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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*     */   public static final String lO = "\r\n";
/*     */   
/*     */   public static i i(String paramString) throws g {
/*  72 */     i i = new i();
/*  73 */     e e = new e(paramString);
/*     */ 
/*     */     
/*  76 */     String str = e.nextToken();
/*  77 */     if (str.toUpperCase(Locale.ROOT).startsWith("HTTP")) {
/*     */ 
/*     */ 
/*     */       
/*  81 */       i.c("HTTP-Version", str);
/*  82 */       i.c("Status-Code", e.nextToken());
/*  83 */       i.c("Reason-Phrase", e.d(false));
/*  84 */       e.next();
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  90 */       i.c("Method", str);
/*  91 */       i.c("Request-URI", e.nextToken());
/*  92 */       i.c("HTTP-Version", e.nextToken());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  97 */     while (e.ge()) {
/*  98 */       String str1 = e.d(':');
/*  99 */       e.d(':');
/* 100 */       i.c(str1, e.d(false));
/* 101 */       e.next();
/*     */     } 
/* 103 */     return i;
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
/*     */   public static String d(i parami) throws g {
/* 128 */     StringBuilder stringBuilder = new StringBuilder();
/* 129 */     if (parami.has("Status-Code") && parami.has("Reason-Phrase")) {
/* 130 */       stringBuilder.append(parami.getString("HTTP-Version"));
/* 131 */       stringBuilder.append(' ');
/* 132 */       stringBuilder.append(parami.getString("Status-Code"));
/* 133 */       stringBuilder.append(' ');
/* 134 */       stringBuilder.append(parami.getString("Reason-Phrase"));
/* 135 */     } else if (parami.has("Method") && parami.has("Request-URI")) {
/* 136 */       stringBuilder.append(parami.getString("Method"));
/* 137 */       stringBuilder.append(' ');
/* 138 */       stringBuilder.append('"');
/* 139 */       stringBuilder.append(parami.getString("Request-URI"));
/* 140 */       stringBuilder.append('"');
/* 141 */       stringBuilder.append(' ');
/* 142 */       stringBuilder.append(parami.getString("HTTP-Version"));
/*     */     } else {
/* 144 */       throw new g("Not enough material for an HTTP header.");
/*     */     } 
/* 146 */     stringBuilder.append("\r\n");
/*     */     
/* 148 */     for (String str1 : parami.keySet()) {
/* 149 */       String str2 = parami.bl(str1);
/* 150 */       if (!"HTTP-Version".equals(str1) && !"Status-Code".equals(str1) && 
/* 151 */         !"Reason-Phrase".equals(str1) && !"Method".equals(str1) && 
/* 152 */         !"Request-URI".equals(str1) && !i.NULL.equals(str2)) {
/* 153 */         stringBuilder.append(str1);
/* 154 */         stringBuilder.append(": ");
/* 155 */         stringBuilder.append(parami.bl(str1));
/* 156 */         stringBuilder.append("\r\n");
/*     */       } 
/*     */     } 
/* 159 */     stringBuilder.append("\r\n");
/* 160 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */