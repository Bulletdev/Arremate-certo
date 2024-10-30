/*    */ package org.apache.poi.ddf;
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
/*    */ public class EscherShapePathProperty
/*    */   extends EscherSimpleProperty
/*    */ {
/*    */   public static final int LINE_OF_STRAIGHT_SEGMENTS = 0;
/*    */   public static final int CLOSED_POLYGON = 1;
/*    */   public static final int CURVES = 2;
/*    */   public static final int CLOSED_CURVES = 3;
/*    */   public static final int COMPLEX = 4;
/*    */   
/*    */   public EscherShapePathProperty(short paramShort, int paramInt) {
/* 35 */     super(paramShort, false, false, paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherShapePathProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */