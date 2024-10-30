/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
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
/*    */ public class XMLStreamValidationException
/*    */   extends XMLStreamException
/*    */ {
/*    */   private XmlError _xmlError;
/*    */   
/*    */   public XMLStreamValidationException(XmlError paramXmlError) {
/* 30 */     super(paramXmlError.toString());
/*    */     
/* 32 */     this._xmlError = paramXmlError;
/*    */   }
/*    */ 
/*    */   
/*    */   public XmlError getXmlError() {
/* 37 */     return this._xmlError;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XMLStreamValidationException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */