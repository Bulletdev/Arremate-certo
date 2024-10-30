/*    */ package org.apache.xmlbeans.impl.jam.visitor;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MComment;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MPackage;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
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
/*    */ public class CompositeMVisitor
/*    */   extends MVisitor
/*    */ {
/*    */   private MVisitor[] mVisitors;
/*    */   
/*    */   public CompositeMVisitor(MVisitor[] paramArrayOfMVisitor) {
/* 42 */     if (paramArrayOfMVisitor == null) throw new IllegalArgumentException("null visitors"); 
/* 43 */     this.mVisitors = paramArrayOfMVisitor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void visit(MPackage paramMPackage) {
/* 50 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMPackage); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MClass paramMClass) {
/* 54 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMClass); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MConstructor paramMConstructor) {
/* 58 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMConstructor); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MField paramMField) {
/* 62 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMField); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MMethod paramMMethod) {
/* 66 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMMethod); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MParameter paramMParameter) {
/* 70 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMParameter); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MAnnotation paramMAnnotation) {
/* 74 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMAnnotation); b++; }
/*    */   
/*    */   }
/*    */   public void visit(MComment paramMComment) {
/* 78 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramMComment); b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\CompositeMVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */