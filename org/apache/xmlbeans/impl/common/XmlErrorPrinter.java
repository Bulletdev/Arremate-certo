/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import java.net.URI;
/*    */ import java.util.AbstractCollection;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlErrorPrinter
/*    */   extends AbstractCollection
/*    */ {
/*    */   private boolean _noisy;
/*    */   private URI _baseURI;
/*    */   
/*    */   public XmlErrorPrinter(boolean paramBoolean, URI paramURI) {
/* 32 */     this._noisy = paramBoolean;
/* 33 */     this._baseURI = paramURI;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean add(Object paramObject) {
/* 38 */     if (paramObject instanceof XmlError) {
/*    */       
/* 40 */       XmlError xmlError = (XmlError)paramObject;
/* 41 */       if (xmlError.getSeverity() == 0 || xmlError.getSeverity() == 1) {
/*    */         
/* 43 */         System.err.println(xmlError.toString(this._baseURI));
/* 44 */       } else if (this._noisy) {
/* 45 */         System.out.println(xmlError.toString(this._baseURI));
/*    */       } 
/* 47 */     }  return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator iterator() {
/* 52 */     return Collections.EMPTY_LIST.iterator();
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 57 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlErrorPrinter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */