/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import java.util.LinkedHashMap;
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
/*    */ public class a
/*    */ {
/* 24 */   private final LinkedHashMap<String, String> a = new LinkedHashMap<>();
/*    */   public a(String paramString) {
/* 26 */     String[] arrayOfString = paramString.split(";");
/*    */ 
/*    */     
/* 29 */     for (String str : arrayOfString) {
/* 30 */       if (str.contains(":")) {
/* 31 */         String[] arrayOfString1 = str.split(":");
/* 32 */         this.a.put(arrayOfString1[0].trim(), arrayOfString1[1].trim());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue(String paramString) {
/* 44 */     String str = this.a.get(paramString);
/*    */     
/* 46 */     if (str != null && 
/* 47 */       str.contains(" ")) {
/* 48 */       str = str.substring(0, str.indexOf(" "));
/*    */     }
/*    */ 
/*    */     
/* 52 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */