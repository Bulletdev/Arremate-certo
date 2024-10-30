/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import java.io.StringWriter;
/*    */ import java.lang.reflect.Modifier;
/*    */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*    */ import org.apache.xmlbeans.impl.jam.JParameter;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
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
/*    */ 
/*    */ public final class ConstructorImpl
/*    */   extends InvokableImpl
/*    */   implements MConstructor
/*    */ {
/*    */   ConstructorImpl(ClassImpl paramClassImpl) {
/* 36 */     super(paramClassImpl);
/* 37 */     setSimpleName(paramClassImpl.getSimpleName());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void accept(MVisitor paramMVisitor) {
/* 43 */     paramMVisitor.visit(this);
/*    */   } public void accept(JVisitor paramJVisitor) {
/* 45 */     paramJVisitor.visit((JConstructor)this);
/*    */   }
/*    */   public String getQualifiedName() {
/* 48 */     StringWriter stringWriter = new StringWriter();
/* 49 */     stringWriter.write(Modifier.toString(getModifiers()));
/* 50 */     stringWriter.write(32);
/* 51 */     stringWriter.write(getSimpleName());
/* 52 */     stringWriter.write(40);
/*    */     
/* 54 */     JParameter[] arrayOfJParameter = getParameters();
/* 55 */     if (arrayOfJParameter != null && arrayOfJParameter.length > 0) {
/* 56 */       for (byte b = 0; b < arrayOfJParameter.length; b++) {
/* 57 */         stringWriter.write(arrayOfJParameter[b].getType().getQualifiedName());
/* 58 */         if (b < arrayOfJParameter.length - 1) stringWriter.write(44);
/*    */       
/*    */       } 
/*    */     }
/* 62 */     stringWriter.write(41);
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
/* 76 */     return stringWriter.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\ConstructorImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */