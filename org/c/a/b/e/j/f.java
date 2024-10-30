/*     */ package org.c.a.b.e.j;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.c.a.b.q.d;
/*     */ import org.c.a.b.q.i;
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
/*     */ 
/*     */ public class f
/*     */   extends j
/*     */ {
/*  35 */   static final Pattern l = Pattern.compile("(\\$[A-Za-z0-9_]*\\$).*");
/*     */   
/*  37 */   private static final Pattern m = Pattern.compile("^(CREATE|DROP) (DATABASE|TABLESPACE|SUBSCRIPTION) .*");
/*  38 */   private static final Pattern n = Pattern.compile("^ALTER SYSTEM .*");
/*  39 */   private static final Pattern o = Pattern.compile("^(CREATE|DROP)( UNIQUE)? INDEX CONCURRENTLY .*");
/*  40 */   private static final Pattern p = Pattern.compile("^REINDEX( VERBOSE)? (SCHEMA|DATABASE|SYSTEM) .*");
/*  41 */   private static final Pattern q = Pattern.compile("^VACUUM .*");
/*  42 */   private static final Pattern r = Pattern.compile("^DISCARD ALL .*");
/*  43 */   private static final Pattern s = Pattern.compile("^ALTER TYPE .* ADD VALUE .*");
/*  44 */   private static final Pattern t = Pattern.compile("^COPY|COPY\\s.*");
/*  45 */   private static final Pattern u = Pattern.compile("^CREATE( OR REPLACE)? RULE .* DO (ALSO|INSTEAD) \\(.*;\\s?\\)\\s?;\\s?");
/*  46 */   private static final Pattern v = Pattern.compile("^CREATE( OR REPLACE)? RULE .* DO (ALSO|INSTEAD) \\([^;]+\\)\\s?;\\s?");
/*  47 */   private static final Pattern w = Pattern.compile("^CREATE( OR REPLACE)? RULE .* DO (ALSO|INSTEAD) \\(.*");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String ld;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cJ;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private String kV = "";
/*     */   
/*     */   public f() {
/*  65 */     super(d.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i a() {
/*  74 */     if (this.cJ) {
/*  75 */       return (i)new c(this.lines.subList(this.iH, this.lines.size()));
/*     */     }
/*  77 */     return super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bD(String paramString) {
/*  82 */     if (this.cJ) {
/*     */       return;
/*     */     }
/*     */     
/*  86 */     super.bD(paramString);
/*     */     
/*  88 */     if (!this.da || !fV()) {
/*     */       return;
/*     */     }
/*     */     
/*  92 */     if (n.c(this.kV, " ") < 256) {
/*  93 */       this.kV += paramString;
/*  94 */       this.kV += " ";
/*  95 */       this.kV = n.bg(this.kV);
/*     */     } 
/*     */     
/*  98 */     if (m.matcher(this.kV).matches() || n
/*  99 */       .matcher(this.kV).matches() || o
/* 100 */       .matcher(this.kV).matches() || p
/* 101 */       .matcher(this.kV).matches() || q
/* 102 */       .matcher(this.kV).matches() || r
/* 103 */       .matcher(this.kV).matches() || s
/* 104 */       .matcher(this.kV).matches())
/*     */     {
/* 106 */       this.da = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<String> a(String paramString) {
/* 112 */     return n.f(paramString, " @<>;:=|(),+{}[]");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aS(String paramString) {
/* 117 */     return super.aS(paramString.replace("$$", " $$ "));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aO(String paramString) {
/* 122 */     Matcher matcher = l.matcher(paramString);
/* 123 */     if (matcher.find()) {
/* 124 */       return matcher.group(1);
/*     */     }
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected d a(String paramString, d paramd) {
/* 131 */     if (this.cJ) {
/* 132 */       return c.c;
/*     */     }
/*     */     
/* 135 */     if (t.matcher(paramString).matches()) {
/* 136 */       this.ld = paramString;
/* 137 */     } else if (this.ld != null) {
/* 138 */       this.ld += " " + paramString;
/*     */     } 
/*     */     
/* 141 */     if (this.ld != null && this.ld.contains(" FROM STDIN")) {
/* 142 */       this.cJ = true;
/* 143 */       return c.c;
/*     */     } 
/*     */     
/* 146 */     if (v.matcher(this.kV).matches()) {
/* 147 */       return d.e;
/*     */     }
/*     */     
/* 150 */     if (u.matcher(this.kV).matches()) {
/* 151 */       return d.e;
/*     */     }
/*     */     
/* 154 */     if (w.matcher(this.kV).matches()) {
/* 155 */       return null;
/*     */     }
/*     */     
/* 158 */     return paramd;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aP(String paramString) {
/* 163 */     if (paramString.startsWith("E'")) {
/* 164 */       return paramString.substring(paramString.indexOf("'"));
/*     */     }
/*     */     
/* 167 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\j\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */