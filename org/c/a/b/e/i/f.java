/*     */ package org.c.a.b.e.i;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
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
/*     */ public class f
/*     */   extends j
/*     */ {
/*  34 */   private static final a a = c.b(j.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private static final Pattern g = Pattern.compile("^(N|DATE|IF|ELSIF|SELECT|IMMEDIATE|RETURN|IS)('.*)");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   private static final Pattern e = Pattern.compile("(.*')(USING|THEN|FROM|AND|OR|AS)(?!.)");
/*     */   
/*     */   private static Pattern a(String... paramVarArgs) {
/*  48 */     return Pattern.compile(f(paramVarArgs));
/*     */   }
/*     */   
/*     */   private static String f(String... paramVarArgs) {
/*  52 */     return "^(" + n.d("|", (Object[])paramVarArgs) + ")(\\s.*)?";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   private static final Pattern h = a(new String[] { "DECLARE|BEGIN" });
/* 140 */   private static final Pattern i = Pattern.compile("^CREATE(\\s+OR\\s+REPLACE)?(\\s+(NON)?EDITIONABLE)?\\s+(VIEW)\\s+.*\\s+AS\\s+WITH.*");
/*     */   
/* 142 */   private static final Pattern j = Pattern.compile("^CREATE(\\s+OR\\s+REPLACE)?(\\s+(NON)?EDITIONABLE)?\\s+(FUNCTION|PROCEDURE|PACKAGE|TYPE|TRIGGER).*");
/*     */   
/* 144 */   private static final Pattern k = Pattern.compile("^CREATE(\\s+OR\\s+REPLACE)?(\\s+AND\\s+(RESOLVE|COMPILE))?(\\s+NOFORCE)?\\s+JAVA\\s+(SOURCE|RESOURCE|CLASS).*");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   static final d b = new d("/", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   private String kV = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f() {
/* 172 */     super(d.e);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bD(String paramString) {
/* 234 */     super.bD(paramString);
/*     */     
/* 236 */     if (fV() && n.c(this.kV, " ") < 8) {
/* 237 */       this.kV += paramString;
/* 238 */       this.kV += " ";
/* 239 */       this.kV = n.bg(this.kV);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected d a(String paramString, d paramd) {
/* 245 */     if (h.matcher(paramString).matches()) {
/* 246 */       return b;
/*     */     }
/*     */     
/* 249 */     if (j.matcher(this.kV).matches() || k
/* 250 */       .matcher(this.kV).matches() || i
/* 251 */       .matcher(this.kV).matches()) {
/* 252 */       return b;
/*     */     }
/*     */     
/* 255 */     return paramd;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aP(String paramString) {
/* 260 */     if (paramString.startsWith("'") && paramString.endsWith("'")) {
/* 261 */       return paramString;
/*     */     }
/*     */     
/* 264 */     Matcher matcher1 = g.matcher(paramString);
/* 265 */     if (matcher1.find()) {
/* 266 */       paramString = matcher1.group(2);
/*     */     }
/*     */     
/* 269 */     Matcher matcher2 = e.matcher(paramString);
/* 270 */     if (matcher2.find()) {
/* 271 */       paramString = matcher2.group(1);
/*     */     }
/*     */     
/* 274 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aS(String paramString) {
/* 279 */     String str = n.replaceAll(n.replaceAll(paramString, "q'(", "q'["), ")'", "]'");
/* 280 */     return super.aS(str);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aO(String paramString) {
/* 285 */     if (paramString.startsWith("Q'") && paramString.length() >= 3) {
/* 286 */       return paramString.substring(0, 3);
/*     */     }
/* 288 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aT(String paramString) {
/* 293 */     char c = paramString.charAt(2);
/* 294 */     switch (c) {
/*     */       case '[':
/* 296 */         return "]'";
/*     */       case '(':
/* 298 */         return ")'";
/*     */       case '{':
/* 300 */         return "}'";
/*     */       case '<':
/* 302 */         return ">'";
/*     */     } 
/* 304 */     return c + "'";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fO() {
/* 310 */     return (super.fO() || this.kV
/*     */ 
/*     */ 
/*     */       
/* 314 */       .equals("/ "));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\i\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */