/*     */ package org.passay;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class q
/*     */   implements D
/*     */ {
/*     */   public static final String mk = "ILLEGAL_MATCH";
/*     */   protected final Pattern pattern;
/*     */   protected boolean dq;
/*     */   
/*     */   public q(String paramString) {
/*  37 */     this(paramString, true);
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
/*     */   public q(String paramString, boolean paramBoolean) {
/*  49 */     this.pattern = Pattern.compile(paramString);
/*  50 */     this.dq = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pattern b() {
/*  61 */     return this.pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/*  68 */     E e = new E(true);
/*  69 */     Matcher matcher = this.pattern.matcher(paramx.getPassword());
/*  70 */     HashSet<String> hashSet = new HashSet();
/*  71 */     while (matcher.find()) {
/*  72 */       String str = matcher.group();
/*  73 */       if (!hashSet.contains(str)) {
/*  74 */         e.aR(false);
/*  75 */         e.bB().add(new F("ILLEGAL_MATCH", c(str)));
/*  76 */         if (!this.dq) {
/*     */           break;
/*     */         }
/*  79 */         hashSet.add(str);
/*     */       } 
/*     */     } 
/*  82 */     return e;
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
/*     */   protected Map<String, Object> c(String paramString) {
/*  95 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*  96 */     linkedHashMap.put("match", paramString);
/*  97 */     linkedHashMap.put("pattern", this.pattern);
/*  98 */     return (Map)linkedHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 105 */     return String.format("%s@%h::pattern=%s", new Object[] { getClass().getName(), Integer.valueOf(hashCode()), this.pattern });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */