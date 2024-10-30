/*    */ package org.apache.http.config;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ import org.apache.http.util.Args;
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
/*    */ public final class RegistryBuilder<I>
/*    */ {
/*    */   private final Map<String, I> items;
/*    */   
/*    */   public static <I> RegistryBuilder<I> create() {
/* 46 */     return new RegistryBuilder<I>();
/*    */   }
/*    */ 
/*    */   
/*    */   RegistryBuilder() {
/* 51 */     this.items = new HashMap<String, I>();
/*    */   }
/*    */   
/*    */   public RegistryBuilder<I> register(String paramString, I paramI) {
/* 55 */     Args.notEmpty(paramString, "ID");
/* 56 */     Args.notNull(paramI, "Item");
/* 57 */     this.items.put(paramString.toLowerCase(Locale.ROOT), paramI);
/* 58 */     return this;
/*    */   }
/*    */   
/*    */   public Registry<I> build() {
/* 62 */     return new Registry<I>(this.items);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 67 */     return this.items.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\config\RegistryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */