/*    */ package ch.qos.logback.classic.turbo;
/*    */ 
/*    */ import java.util.LinkedHashMap;
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
/*    */ 
/*    */ class a
/*    */   extends LinkedHashMap<String, Integer>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   final int cacheSize;
/*    */   
/*    */   a(int paramInt) {
/* 29 */     super((int)(paramInt * 1.3333334F), 0.75F, true);
/* 30 */     if (paramInt < 1) {
/* 31 */       throw new IllegalArgumentException("Cache size cannot be smaller than 1");
/*    */     }
/* 33 */     this.cacheSize = paramInt;
/*    */   }
/*    */   
/*    */   int c(String paramString) {
/*    */     Integer integer;
/* 38 */     if (paramString == null) {
/* 39 */       return 0;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 44 */     synchronized (this) {
/* 45 */       integer = (Integer)get(paramString);
/* 46 */       if (integer == null) {
/* 47 */         integer = Integer.valueOf(0);
/*    */       } else {
/* 49 */         integer = Integer.valueOf(integer.intValue() + 1);
/*    */       } 
/* 51 */       put((K)paramString, (V)integer);
/*    */     } 
/* 53 */     return integer.intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean removeEldestEntry(Map.Entry paramEntry) {
/* 59 */     return (size() > this.cacheSize);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void clear() {
/* 64 */     super.clear();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\turbo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */