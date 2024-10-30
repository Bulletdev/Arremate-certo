/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BitFieldFactory
/*    */ {
/* 27 */   private static Map<Integer, BitField> instances = new HashMap<Integer, BitField>();
/*    */   
/*    */   public static BitField getInstance(int paramInt) {
/* 30 */     BitField bitField = instances.get(Integer.valueOf(paramInt));
/* 31 */     if (bitField == null) {
/* 32 */       bitField = new BitField(paramInt);
/* 33 */       instances.put(Integer.valueOf(paramInt), bitField);
/*    */     } 
/* 35 */     return bitField;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\BitFieldFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */