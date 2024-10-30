/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.XmlError;
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
/*    */ public class XmlValueOutOfRangeException
/*    */   extends IllegalArgumentException
/*    */ {
/*    */   public XmlValueOutOfRangeException() {}
/*    */   
/*    */   public XmlValueOutOfRangeException(String paramString) {
/* 23 */     super(paramString); } public XmlValueOutOfRangeException(String paramString, Object[] paramArrayOfObject) {
/* 24 */     super(XmlError.formattedMessage(paramString, paramArrayOfObject));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlValueOutOfRangeException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */