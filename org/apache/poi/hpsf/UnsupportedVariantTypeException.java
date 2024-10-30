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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class UnsupportedVariantTypeException
/*    */   extends VariantTypeException
/*    */ {
/*    */   public UnsupportedVariantTypeException(long paramLong, Object paramObject) {
/* 42 */     super(paramLong, paramObject, "HPSF does not yet support the variant type " + paramLong + " (" + Variant.getVariantName(paramLong) + ", " + HexDump.toHex(paramLong) + "). If you want support for " + "this variant type in one of the next POI releases please " + "submit a request for enhancement (RFE) to " + "<http://issues.apache.org/bugzilla/>! Thank you!");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\UnsupportedVariantTypeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */