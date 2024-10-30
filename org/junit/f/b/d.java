/*    */ package org.junit.f.b;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.junit.c.c;
/*    */ import org.junit.f.a.m;
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
/*    */ public class d
/*    */ {
/*    */   private final String name;
/*    */   private final m a;
/*    */   private final List<Object> parameters;
/*    */   
/*    */   public d(String paramString, m paramm, List<Object> paramList) {
/* 27 */     c.notNull(paramString, "The name is missing.");
/* 28 */     c.notNull(paramm, "The test class is missing.");
/* 29 */     c.notNull(paramList, "The parameters are missing.");
/* 30 */     this.name = paramString;
/* 31 */     this.a = paramm;
/* 32 */     this.parameters = Collections.unmodifiableList(new ArrayList(paramList));
/*    */   }
/*    */   
/*    */   public String getName() {
/* 36 */     return this.name;
/*    */   }
/*    */   
/*    */   public m a() {
/* 40 */     return this.a;
/*    */   }
/*    */   
/*    */   public List<Object> getParameters() {
/* 44 */     return this.parameters;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 49 */     char c = '㦛';
/* 50 */     int i = c + this.name.hashCode();
/* 51 */     i = c * i + this.a.hashCode();
/* 52 */     return c * i + this.parameters.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 57 */     if (this == paramObject) {
/* 58 */       return true;
/*    */     }
/* 60 */     if (paramObject == null) {
/* 61 */       return false;
/*    */     }
/* 63 */     if (getClass() != paramObject.getClass()) {
/* 64 */       return false;
/*    */     }
/* 66 */     d d1 = (d)paramObject;
/* 67 */     return (this.name.equals(d1.name) && this.parameters.equals(d1.parameters) && this.a.equals(d1.a));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     return this.a.getName() + " '" + this.name + "' with parameters " + this.parameters;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\b\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */