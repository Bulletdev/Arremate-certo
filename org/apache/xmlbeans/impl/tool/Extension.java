/*    */ package org.apache.xmlbeans.impl.tool;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class Extension
/*    */ {
/*    */   private Class className;
/* 28 */   private List params = new ArrayList();
/*    */   
/*    */   public Class getClassName() {
/* 31 */     return this.className;
/*    */   }
/*    */   
/*    */   public void setClassName(Class paramClass) {
/* 35 */     this.className = paramClass;
/*    */   }
/*    */   public List getParams() {
/* 38 */     return this.params;
/*    */   }
/*    */   
/*    */   public Param createParam() {
/* 42 */     Param param = new Param();
/* 43 */     this.params.add(param);
/* 44 */     return param;
/*    */   }
/*    */ 
/*    */   
/*    */   public class Param
/*    */   {
/*    */     private String name;
/*    */     private String value;
/*    */     private final Extension this$0;
/*    */     
/*    */     public String getName() {
/* 55 */       return this.name;
/*    */     }
/*    */     
/*    */     public void setName(String param1String) {
/* 59 */       this.name = param1String;
/*    */     }
/*    */     
/*    */     public String getValue() {
/* 63 */       return this.value;
/*    */     }
/*    */     
/*    */     public void setValue(String param1String) {
/* 67 */       this.value = param1String;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\Extension.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */