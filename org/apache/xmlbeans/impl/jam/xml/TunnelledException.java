/*    */ package org.apache.xmlbeans.impl.jam.xml;
/*    */ 
/*    */ import javax.xml.stream.XMLStreamException;
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
/*    */ public class TunnelledException
/*    */   extends RuntimeException
/*    */ {
/* 24 */   private XMLStreamException mXSE = null;
/*    */   
/*    */   public TunnelledException(XMLStreamException paramXMLStreamException) {
/* 27 */     this.mXSE = paramXMLStreamException;
/*    */   }
/*    */   public XMLStreamException getXMLStreamException() {
/* 30 */     return this.mXSE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\xml\TunnelledException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */