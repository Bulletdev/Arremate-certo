/*    */ package org.apache.xmlbeans.impl.piccolo.xml;
/*    */ 
/*    */ import org.xml.sax.SAXException;
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
/*    */ class FatalParsingException
/*    */   extends SAXException
/*    */ {
/*    */   FatalParsingException(String paramString) {
/* 23 */     super(paramString); } FatalParsingException(String paramString, Exception paramException) {
/* 24 */     super(paramString, paramException);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\FatalParsingException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */