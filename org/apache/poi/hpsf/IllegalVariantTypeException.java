/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public class IllegalVariantTypeException
/*    */   extends VariantTypeException
/*    */ {
/*    */   public IllegalVariantTypeException(long paramLong, Object paramObject, String paramString) {
/* 39 */     super(paramLong, paramObject, paramString);
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
/*    */   public IllegalVariantTypeException(long paramLong, Object paramObject) {
/* 51 */     this(paramLong, paramObject, "The variant type " + paramLong + " (" + Variant.getVariantName(paramLong) + ", " + HexDump.toHex(paramLong) + ") is illegal in this context.");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\IllegalVariantTypeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */