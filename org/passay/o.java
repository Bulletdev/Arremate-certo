/*    */ package org.passay;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class o
/*    */   implements D
/*    */ {
/*    */   public static final String mk = "HISTORY_VIOLATION";
/*    */   protected boolean dq;
/*    */   
/*    */   public o() {
/* 29 */     this(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public o(boolean paramBoolean) {
/* 40 */     this.dq = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E a(x paramx) {
/* 47 */     E e = new E(true);
/* 48 */     List<x.b> list = paramx.d(x.b.class);
/*    */     
/* 50 */     int i = list.size();
/* 51 */     if (i == 0) {
/* 52 */       return e;
/*    */     }
/*    */     
/* 55 */     String str = paramx.getPassword();
/* 56 */     if (this.dq) {
/* 57 */       list.stream().filter(paramb -> a(paramString, paramb)).forEach(paramb -> {
/*    */             paramE.aR(false);
/*    */             paramE.bB().add(new F("HISTORY_VIOLATION", f(paramInt)));
/*    */           });
/*    */     } else {
/* 62 */       list.stream().filter(paramb -> a(paramString, paramb)).findFirst().ifPresent(paramb -> {
/*    */             paramE.aR(false);
/*    */             paramE.bB().add(new F("HISTORY_VIOLATION", f(paramInt)));
/*    */           });
/*    */     } 
/* 67 */     return e;
/*    */   }
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
/*    */   protected boolean a(String paramString, x.d paramd) {
/* 81 */     return paramString.equals(paramd.getPassword());
/*    */   }
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
/*    */   protected Map<String, Object> f(int paramInt) {
/* 94 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 95 */     linkedHashMap.put("historySize", Integer.valueOf(paramInt));
/* 96 */     return (Map)linkedHashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */