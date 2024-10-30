/*     */ package org.c.a.b.e.c;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.regex.Matcher;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends j
/*     */ {
/*     */   private static final String kU = "--#SET TERMINATOR";
/*  38 */   private static final Pattern e = Pattern.compile("(.*')(DO)(?!.)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   private static final Pattern f = Pattern.compile("^CREATE( OR REPLACE)? (FUNCTION|PROCEDURE|TRIGGER)(\\s.*)?");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private String kV = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private d a = this.g;
/*     */   
/*  57 */   private String kW = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e() {
/*  63 */     super(d.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public d a(String paramString) {
/*  68 */     if (paramString.toUpperCase().startsWith("--#SET TERMINATOR")) {
/*  69 */       return new d(paramString.substring("--#SET TERMINATOR".length()).trim(), false);
/*     */     }
/*     */     
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean K(String paramString) {
/*  77 */     return (paramString.startsWith("--") && !paramString.startsWith("--#SET TERMINATOR"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aP(String paramString) {
/*  82 */     if (paramString.startsWith("X'")) {
/*  83 */       return paramString.substring(paramString.indexOf("'"));
/*     */     }
/*     */     
/*  86 */     Matcher matcher = e.matcher(paramString);
/*  87 */     if (matcher.find()) {
/*  88 */       paramString = matcher.group(1);
/*     */     }
/*     */     
/*  91 */     return super.aP(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected d a(String paramString, d paramd) {
/*  96 */     if (paramd != null && !paramd.equals(this.a))
/*     */     {
/*     */       
/*  99 */       this.a = paramd;
/*     */     }
/*     */     
/* 102 */     if (fV() && n.c(this.kV, " ") < 4) {
/* 103 */       this.kV += paramString;
/* 104 */       this.kV += " ";
/*     */     } 
/*     */     
/* 107 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fD() {
/* 112 */     return f.matcher(this.kV).matches();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean L(String paramString) {
/* 117 */     return ("BEGIN".equals(paramString) || "CASE"
/* 118 */       .equals(paramString) || "IF"
/* 119 */       .equals(paramString) || "DO"
/* 120 */       .equals(paramString) || "LOOP"
/* 121 */       .equals(paramString) || "REPEAT"
/* 122 */       .equals(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean M(String paramString) {
/* 127 */     return "END".equals(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<String> a(String paramString) {
/* 132 */     String str = paramString;
/* 133 */     if (this.kW.endsWith("END")) {
/* 134 */       if (paramString.startsWith("IF")) {
/* 135 */         str = str.substring(2);
/* 136 */       } else if (paramString.startsWith("FOR")) {
/* 137 */         str = str.substring(3);
/* 138 */       } else if (paramString.startsWith("CASE")) {
/* 139 */         str = str.substring(4);
/* 140 */       } else if (paramString.startsWith("LOOP")) {
/* 141 */         str = str.substring(4);
/* 142 */       } else if (paramString.startsWith("WHILE")) {
/* 143 */         str = str.substring(5);
/* 144 */       } else if (paramString.startsWith("REPEAT")) {
/* 145 */         str = str.substring(6);
/*     */       } 
/*     */     }
/*     */     
/* 149 */     if (n.W(paramString)) {
/* 150 */       this.kW = paramString;
/*     */     }
/*     */     
/* 153 */     return super.a(str
/* 154 */         .replaceAll("END (IF|FOR|CASE|LOOP|WHILE|REPEAT)", "END"));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\c\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */