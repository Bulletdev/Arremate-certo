/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JComment;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MComment;
/*    */ import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
/*    */ import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
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
/*    */ public final class CommentImpl
/*    */   extends ElementImpl
/*    */   implements MComment
/*    */ {
/* 31 */   private String mText = null;
/*    */ 
/*    */ 
/*    */   
/*    */   CommentImpl(ElementImpl paramElementImpl) {
/* 36 */     super(paramElementImpl);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 41 */     this.mText = paramString;
/*    */   } public String getText() {
/* 43 */     return (this.mText == null) ? "" : this.mText;
/*    */   }
/*    */ 
/*    */   
/*    */   public void accept(MVisitor paramMVisitor) {
/* 48 */     paramMVisitor.visit(this);
/*    */   } public void accept(JVisitor paramJVisitor) {
/* 50 */     paramJVisitor.visit((JComment)this);
/*    */   }
/*    */   public String getQualifiedName() {
/* 53 */     return getParent().getQualifiedName() + ".{comment}";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\CommentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */