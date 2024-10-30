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
/*    */ public class XmlValueNotSupportedException
/*    */   extends XmlValueOutOfRangeException
/*    */ {
/*    */   public XmlValueNotSupportedException() {}
/*    */   
/*    */   public XmlValueNotSupportedException(String paramString) {
/* 23 */     super(paramString); } public XmlValueNotSupportedException(String paramString, Object[] paramArrayOfObject) {
/* 24 */     super(XmlError.formattedMessage(paramString, paramArrayOfObject));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlValueNotSupportedException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */