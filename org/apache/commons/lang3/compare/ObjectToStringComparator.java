/*    */ package org.apache.commons.lang3.compare;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Comparator;
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
/*    */ public final class ObjectToStringComparator
/*    */   implements Serializable, Comparator<Object>
/*    */ {
/* 37 */   public static final ObjectToStringComparator INSTANCE = new ObjectToStringComparator();
/*    */ 
/*    */ 
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(Object paramObject1, Object paramObject2) {
/* 46 */     if (paramObject1 == null && paramObject2 == null) {
/* 47 */       return 0;
/*    */     }
/* 49 */     if (paramObject1 == null) {
/* 50 */       return 1;
/*    */     }
/* 52 */     if (paramObject2 == null) {
/* 53 */       return -1;
/*    */     }
/* 55 */     String str1 = paramObject1.toString();
/* 56 */     String str2 = paramObject2.toString();
/*    */     
/* 58 */     if (str1 == null && str2 == null) {
/* 59 */       return 0;
/*    */     }
/* 61 */     if (str1 == null) {
/* 62 */       return 1;
/*    */     }
/* 64 */     if (str2 == null) {
/* 65 */       return -1;
/*    */     }
/* 67 */     return str1.compareTo(str2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\compare\ObjectToStringComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */