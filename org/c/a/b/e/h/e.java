/*     */ package org.c.a.b.e.h;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ import org.c.a.b.q.d;
/*     */ import org.c.a.b.q.j;
/*     */ import org.c.a.b.r.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends j
/*     */ {
/*     */   private static final String kU = "DELIMITER";
/*  32 */   private static final String[] l = new String[] { "ARMSCII8", "ASCII", "BIG5", "BINARY", "CP1250", "CP1251", "CP1256", "CP1257", "CP850", "CP852", "CP866", "CP932", "DEC8", "EUCJPMS", "EUCKR", "GB2312", "GBK", "GEOSTD8", "GREEK", "HEBREW", "HP8", "KEYBCS2", "KOI8R", "KOI8U", "LATIN1", "LATIN2", "LATIN5", "LATIN7", "MACCE", "MACROMAN", "SJIS", "SWE7", "TIS620", "UCS2", "UJIS", "UTF8", "UTF8MB4" };
/*     */ 
/*     */ 
/*     */   
/*     */   boolean cI = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public e() {
/*  41 */     super(d.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public d a(String paramString) {
/*  46 */     if (!this.cZ && !this.cW && !this.cX && paramString
/*  47 */       .toUpperCase().startsWith("DELIMITER")) {
/*  48 */       return new d(paramString.substring("DELIMITER".length()).trim(), false);
/*     */     }
/*     */     
/*  51 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected d a(String paramString, d paramd) {
/*  56 */     if (paramString.toUpperCase().startsWith("DELIMITER")) {
/*  57 */       return new d(paramString.substring("DELIMITER".length()).trim(), false);
/*     */     }
/*     */     
/*  60 */     return paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean N(String paramString) {
/*  66 */     if (paramString.matches("^" + Pattern.quote("/*!") + "\\d{5} .*" + Pattern.quote("*/") + "\\s*;?")) {
/*  67 */       return true;
/*     */     }
/*     */     
/*  70 */     if (paramString.matches("^" + Pattern.quote("/*!") + "\\d{5} .*")) {
/*  71 */       this.cI = true;
/*  72 */       return true;
/*     */     } 
/*     */     
/*  75 */     if (this.cI && paramString.matches(".*" + Pattern.quote("*/") + "\\s*;?")) {
/*  76 */       this.cI = false;
/*  77 */       return true;
/*     */     } 
/*  79 */     return this.cI;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean K(String paramString) {
/*  84 */     return (paramString.startsWith("--") || (paramString.startsWith("#") && (!"#".equals(this.d.eL()) || !"#".equals(paramString))));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aQ(String paramString) {
/*  89 */     String str1 = n.replaceAll(paramString, "\\\\", "");
/*  90 */     String str2 = n.replaceAll(n.replaceAll(str1, "\\'", ""), "\\\"", "");
/*  91 */     return n.replaceAll(str2, "''", "").replace("'", " ' ");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aP(String paramString) {
/*  96 */     if (paramString.startsWith("B'") || paramString.startsWith("X'")) {
/*  97 */       return paramString.substring(paramString.indexOf("'"));
/*     */     }
/*     */     
/* 100 */     if (paramString.startsWith("_")) {
/* 101 */       for (String str1 : l) {
/* 102 */         String str2 = "_" + str1;
/* 103 */         if (paramString.startsWith(str2)) {
/* 104 */           return paramString.substring(str2.length());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 110 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aO(String paramString) {
/* 115 */     if (paramString.startsWith("\"")) {
/* 116 */       return "\"";
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\h\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */