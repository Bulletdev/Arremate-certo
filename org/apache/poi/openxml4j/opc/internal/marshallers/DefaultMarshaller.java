/*    */ package org.apache.poi.openxml4j.opc.internal.marshallers;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
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
/*    */ public final class DefaultMarshaller
/*    */   implements PartMarshaller
/*    */ {
/*    */   public boolean marshall(PackagePart paramPackagePart, OutputStream paramOutputStream) throws OpenXML4JException {
/* 43 */     return paramPackagePart.save(paramOutputStream);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\marshallers\DefaultMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */