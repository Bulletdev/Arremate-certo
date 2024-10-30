/*    */ package ch.qos.logback.classic.spi;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class ClassPackagingData
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -804643281218337001L;
/*    */   final String codeLocation;
/*    */   final String version;
/*    */   private final boolean exact;
/*    */   
/*    */   public ClassPackagingData(String paramString1, String paramString2) {
/* 26 */     this.codeLocation = paramString1;
/* 27 */     this.version = paramString2;
/* 28 */     this.exact = true;
/*    */   }
/*    */   
/*    */   public ClassPackagingData(String paramString1, String paramString2, boolean paramBoolean) {
/* 32 */     this.codeLocation = paramString1;
/* 33 */     this.version = paramString2;
/* 34 */     this.exact = paramBoolean;
/*    */   }
/*    */   
/*    */   public String getCodeLocation() {
/* 38 */     return this.codeLocation;
/*    */   }
/*    */   
/*    */   public String getVersion() {
/* 42 */     return this.version;
/*    */   }
/*    */   
/*    */   public boolean isExact() {
/* 46 */     return this.exact;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 51 */     byte b = 31;
/* 52 */     int i = 1;
/* 53 */     i = 31 * i + ((this.codeLocation == null) ? 0 : this.codeLocation.hashCode());
/* 54 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 59 */     if (this == paramObject)
/* 60 */       return true; 
/* 61 */     if (paramObject == null)
/* 62 */       return false; 
/* 63 */     if (getClass() != paramObject.getClass())
/* 64 */       return false; 
/* 65 */     ClassPackagingData classPackagingData = (ClassPackagingData)paramObject;
/* 66 */     if (this.codeLocation == null) {
/* 67 */       if (classPackagingData.codeLocation != null)
/* 68 */         return false; 
/* 69 */     } else if (!this.codeLocation.equals(classPackagingData.codeLocation)) {
/* 70 */       return false;
/* 71 */     }  if (this.exact != classPackagingData.exact)
/* 72 */       return false; 
/* 73 */     if (this.version == null) {
/* 74 */       if (classPackagingData.version != null)
/* 75 */         return false; 
/* 76 */     } else if (!this.version.equals(classPackagingData.version)) {
/* 77 */       return false;
/* 78 */     }  return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\ClassPackagingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */