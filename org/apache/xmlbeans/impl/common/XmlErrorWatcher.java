/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import java.util.AbstractCollection;
/*    */ import java.util.Collection;
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
/*    */ public class XmlErrorWatcher
/*    */   extends AbstractCollection
/*    */ {
/*    */   private Collection _underlying;
/*    */   private XmlError _firstError;
/*    */   
/*    */   public XmlErrorWatcher(Collection paramCollection) {
/* 32 */     this._underlying = paramCollection;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean add(Object paramObject) {
/* 37 */     if (this._firstError == null && paramObject instanceof XmlError && ((XmlError)paramObject).getSeverity() == 0)
/* 38 */       this._firstError = (XmlError)paramObject; 
/* 39 */     if (this._underlying == null)
/* 40 */       return false; 
/* 41 */     return this._underlying.add(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator iterator() {
/* 46 */     if (this._underlying == null) {
/* 47 */       return Collections.EMPTY_LIST.iterator();
/*    */     }
/* 49 */     return this._underlying.iterator();
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 54 */     if (this._underlying == null) {
/* 55 */       return 0;
/*    */     }
/* 57 */     return this._underlying.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasError() {
/* 62 */     return (this._firstError != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public XmlError firstError() {
/* 67 */     return this._firstError;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlErrorWatcher.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */