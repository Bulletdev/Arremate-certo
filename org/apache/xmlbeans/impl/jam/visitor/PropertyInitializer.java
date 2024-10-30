/*    */ package org.apache.xmlbeans.impl.jam.visitor;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JMethod;
/*    */ import org.apache.xmlbeans.impl.jam.JProperty;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.PropertyImpl;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
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
/*    */ public class PropertyInitializer
/*    */   extends MVisitor
/*    */ {
/*    */   public void visit(MClass paramMClass) {
/* 38 */     addProperties(paramMClass, true);
/* 39 */     addProperties(paramMClass, false);
/*    */   }
/*    */   
/*    */   private void addProperties(MClass paramMClass, boolean paramBoolean) {
/* 43 */     JMethod[] arrayOfJMethod = paramBoolean ? paramMClass.getDeclaredMethods() : paramMClass.getMethods();
/*    */     
/* 45 */     HashMap hashMap = new HashMap();
/* 46 */     for (byte b = 0; b < arrayOfJMethod.length; b++) {
/* 47 */       String str = arrayOfJMethod[b].getSimpleName();
/*    */ 
/*    */ 
/*    */       
/* 51 */       if ((str.startsWith("get") && str.length() > 3) || (str.startsWith("is") && str.length() > 2)) {
/*    */         
/* 53 */         JClass jClass = arrayOfJMethod[b].getReturnType();
/*    */ 
/*    */         
/* 56 */         if (jClass == null || (
/* 57 */           arrayOfJMethod[b].getParameters()).length > 0)
/* 58 */           continue;  if (str.startsWith("get")) {
/* 59 */           str = str.substring(3);
/*    */         } else {
/* 61 */           str = str.substring(2);
/*    */         } 
/* 63 */         JProperty jProperty = (JProperty)hashMap.get(str);
/* 64 */         if (jProperty == null) {
/* 65 */           jProperty = paramBoolean ? paramMClass.addNewDeclaredProperty(str, arrayOfJMethod[b], null) : paramMClass.addNewProperty(str, arrayOfJMethod[b], null);
/*    */           
/* 67 */           hashMap.put(str, jProperty);
/*    */         }
/* 69 */         else if (jClass.equals(jProperty.getType())) {
/* 70 */           ((PropertyImpl)jProperty).setGetter(arrayOfJMethod[b]);
/*    */         } 
/*    */       } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 78 */       if (str.startsWith("set") && str.length() > 3 && (
/* 79 */         arrayOfJMethod[b].getParameters()).length == 1) {
/* 80 */         JClass jClass = arrayOfJMethod[b].getParameters()[0].getType();
/* 81 */         str = str.substring(3);
/* 82 */         JProperty jProperty = (JProperty)hashMap.get(str);
/* 83 */         if (jProperty == null) {
/* 84 */           jProperty = paramBoolean ? paramMClass.addNewDeclaredProperty(str, null, arrayOfJMethod[b]) : paramMClass.addNewProperty(str, null, arrayOfJMethod[b]);
/*    */           
/* 86 */           hashMap.put(str, jProperty);
/*    */         }
/* 88 */         else if (jClass.equals(jProperty.getType())) {
/*    */           
/* 90 */           ((PropertyImpl)jProperty).setSetter(arrayOfJMethod[b]);
/*    */         } 
/*    */       } 
/*    */       continue;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\PropertyInitializer.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */