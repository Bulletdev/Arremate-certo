/*    */ package ch.qos.logback.core.joran.spi;
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
/*    */ public class HostClassAndPropertyDouble
/*    */ {
/*    */   final Class<?> hostClass;
/*    */   final String propertyName;
/*    */   
/*    */   public HostClassAndPropertyDouble(Class<?> paramClass, String paramString) {
/* 32 */     this.hostClass = paramClass;
/* 33 */     this.propertyName = paramString;
/*    */   }
/*    */   
/*    */   public Class<?> getHostClass() {
/* 37 */     return this.hostClass;
/*    */   }
/*    */   
/*    */   public String getPropertyName() {
/* 41 */     return this.propertyName;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 46 */     byte b = 31;
/* 47 */     int i = 1;
/* 48 */     i = 31 * i + ((this.hostClass == null) ? 0 : this.hostClass.hashCode());
/* 49 */     i = 31 * i + ((this.propertyName == null) ? 0 : this.propertyName.hashCode());
/* 50 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 55 */     if (this == paramObject)
/* 56 */       return true; 
/* 57 */     if (paramObject == null)
/* 58 */       return false; 
/* 59 */     if (getClass() != paramObject.getClass())
/* 60 */       return false; 
/* 61 */     HostClassAndPropertyDouble hostClassAndPropertyDouble = (HostClassAndPropertyDouble)paramObject;
/* 62 */     if (this.hostClass == null) {
/* 63 */       if (hostClassAndPropertyDouble.hostClass != null)
/* 64 */         return false; 
/* 65 */     } else if (!this.hostClass.equals(hostClassAndPropertyDouble.hostClass)) {
/* 66 */       return false;
/* 67 */     }  if (this.propertyName == null) {
/* 68 */       if (hostClassAndPropertyDouble.propertyName != null)
/* 69 */         return false; 
/* 70 */     } else if (!this.propertyName.equals(hostClassAndPropertyDouble.propertyName)) {
/* 71 */       return false;
/* 72 */     }  return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\HostClassAndPropertyDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */