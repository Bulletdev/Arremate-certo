/*    */ package org.passay;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   implements D
/*    */ {
/*    */   public static final String mk = "ALLOWED_MATCH";
/*    */   protected final Pattern pattern;
/*    */   
/*    */   public d(String paramString) {
/* 32 */     this.pattern = Pattern.compile(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Pattern b() {
/* 43 */     return this.pattern;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E a(x paramx) {
/* 50 */     E e = new E(true);
/* 51 */     Matcher matcher = this.pattern.matcher(paramx.getPassword());
/* 52 */     if (!matcher.find()) {
/* 53 */       e.aR(false);
/* 54 */       e.bB().add(new F("ALLOWED_MATCH", V()));
/*    */     } 
/* 56 */     return e;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Map<String, Object> V() {
/* 67 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 68 */     linkedHashMap.put("pattern", this.pattern);
/* 69 */     return (Map)linkedHashMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 76 */     return String.format("%s@%h::pattern=%s", new Object[] { getClass().getName(), Integer.valueOf(hashCode()), this.pattern });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */