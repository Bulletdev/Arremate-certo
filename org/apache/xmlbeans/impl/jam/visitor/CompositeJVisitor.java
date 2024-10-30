/*    */ package org.apache.xmlbeans.impl.jam.visitor;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JComment;
/*    */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*    */ import org.apache.xmlbeans.impl.jam.JField;
/*    */ import org.apache.xmlbeans.impl.jam.JMethod;
/*    */ import org.apache.xmlbeans.impl.jam.JPackage;
/*    */ import org.apache.xmlbeans.impl.jam.JParameter;
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
/*    */ public class CompositeJVisitor
/*    */   extends JVisitor
/*    */ {
/*    */   private JVisitor[] mVisitors;
/*    */   
/*    */   public CompositeJVisitor(JVisitor[] paramArrayOfJVisitor) {
/* 42 */     if (paramArrayOfJVisitor == null) throw new IllegalArgumentException("null visitors"); 
/* 43 */     this.mVisitors = paramArrayOfJVisitor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void visit(JPackage paramJPackage) {
/* 50 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJPackage); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JClass paramJClass) {
/* 54 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJClass); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JConstructor paramJConstructor) {
/* 58 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJConstructor); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JField paramJField) {
/* 62 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJField); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JMethod paramJMethod) {
/* 66 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJMethod); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JParameter paramJParameter) {
/* 70 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJParameter); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JAnnotation paramJAnnotation) {
/* 74 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJAnnotation); b++; }
/*    */   
/*    */   }
/*    */   public void visit(JComment paramJComment) {
/* 78 */     for (byte b = 0; b < this.mVisitors.length; ) { this.mVisitors[b].visit(paramJComment); b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\CompositeJVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */