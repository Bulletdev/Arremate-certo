/*    */ package org.apache.poi.ss.usermodel;
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
/*    */ 
/*    */ 
/*    */ public class ConditionType
/*    */ {
/* 29 */   private static Map<Integer, ConditionType> lookup = new HashMap<Integer, ConditionType>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   public static final ConditionType CELL_VALUE_IS = new ConditionType(1, "cellIs");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 42 */   public static final ConditionType FORMULA = new ConditionType(2, "expression");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   public static final ConditionType COLOR_SCALE = new ConditionType(3, "colorScale");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 56 */   public static final ConditionType DATA_BAR = new ConditionType(4, "dataBar");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 62 */   public static final ConditionType FILTER = new ConditionType(5, null);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 69 */   public static final ConditionType ICON_SET = new ConditionType(6, "iconSet");
/*    */   
/*    */   public final byte id;
/*    */   
/*    */   public final String type;
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     return this.id + " - " + this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public static ConditionType forId(byte paramByte) {
/* 82 */     return forId(paramByte);
/*    */   }
/*    */   public static ConditionType forId(int paramInt) {
/* 85 */     return lookup.get(Integer.valueOf(paramInt));
/*    */   }
/*    */   
/*    */   private ConditionType(int paramInt, String paramString) {
/* 89 */     this.id = (byte)paramInt; this.type = paramString;
/* 90 */     lookup.put(Integer.valueOf(paramInt), this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ConditionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */