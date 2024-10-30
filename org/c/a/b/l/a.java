/*     */ package org.c.a.b.l;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.TreeSet;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements c
/*     */ {
/*     */   private final Map<String, String> aq;
/*     */   private final String jN;
/*     */   private final String jO;
/*     */   private final Pattern A;
/*     */   
/*     */   public a(Map<String, String> paramMap, String paramString1, String paramString2) {
/*  59 */     this.aq = paramMap;
/*  60 */     this.jN = paramString1;
/*  61 */     this.jO = paramString2;
/*  62 */     this.A = Pattern.compile(Pattern.quote(paramString1) + "(.+?)" + Pattern.quote(paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> R() {
/*  67 */     return this.aq;
/*     */   }
/*     */ 
/*     */   
/*     */   public String bc(String paramString) {
/*  72 */     String str = paramString;
/*     */     
/*  74 */     for (Map.Entry<String, String> entry : R().entrySet()) {
/*  75 */       String str1 = this.jN + (String)entry.getKey() + this.jO;
/*  76 */       String str2 = (entry.getValue() == null) ? "" : (String)entry.getValue();
/*  77 */       str = n.replace(str, str1, str2);
/*     */     } 
/*  79 */     bG(str);
/*     */     
/*  81 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void bG(String paramString) {
/*  92 */     Matcher matcher = this.A.matcher(paramString);
/*     */     
/*  94 */     TreeSet<String> treeSet = new TreeSet();
/*  95 */     while (matcher.find()) {
/*  96 */       treeSet.add(matcher.group());
/*     */     }
/*     */     
/*  99 */     if (!treeSet.isEmpty())
/* 100 */       throw new org.c.a.a.a("No value provided for placeholder expressions: " + 
/* 101 */           n.b(treeSet) + ".  Check your configuration!"); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */