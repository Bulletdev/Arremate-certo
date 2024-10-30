/*    */ package org.apache.xmlbeans.impl.config;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.UserType;
/*    */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*    */ import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserTypeImpl
/*    */   implements UserType
/*    */ {
/*    */   private b _name;
/*    */   private String _javaName;
/*    */   private String _staticHandler;
/*    */   
/*    */   static UserTypeImpl newInstance(JamClassLoader paramJamClassLoader, Usertypeconfig paramUsertypeconfig) {
/* 18 */     UserTypeImpl userTypeImpl = new UserTypeImpl();
/*    */     
/* 20 */     userTypeImpl._name = paramUsertypeconfig.getName();
/* 21 */     userTypeImpl._javaName = paramUsertypeconfig.getJavaname();
/* 22 */     userTypeImpl._staticHandler = paramUsertypeconfig.getStaticHandler();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 28 */     return userTypeImpl;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getJavaName() {
/* 34 */     return this._javaName;
/*    */   }
/*    */ 
/*    */   
/*    */   public b getName() {
/* 39 */     return this._name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getStaticHandler() {
/* 44 */     return this._staticHandler;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\config\UserTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */