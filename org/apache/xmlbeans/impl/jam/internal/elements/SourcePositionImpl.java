/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import java.net.URI;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
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
/*    */ public final class SourcePositionImpl
/*    */   implements MSourcePosition
/*    */ {
/* 32 */   private int mColumn = -1;
/* 33 */   private int mLine = -1;
/* 34 */   private URI mURI = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColumn(int paramInt) {
/* 44 */     this.mColumn = paramInt;
/*    */   } public void setLine(int paramInt) {
/* 46 */     this.mLine = paramInt;
/*    */   } public void setSourceURI(URI paramURI) {
/* 48 */     this.mURI = paramURI;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getColumn() {
/* 53 */     return this.mColumn;
/*    */   } public int getLine() {
/* 55 */     return this.mLine;
/*    */   } public URI getSourceURI() {
/* 57 */     return this.mURI;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\SourcePositionImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */