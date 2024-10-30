/*    */ package ch.qos.logback.classic.spi;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoggerContextVO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5488023392483144387L;
/*    */   final String name;
/*    */   final Map<String, String> propertyMap;
/*    */   final long birthTime;
/*    */   
/*    */   public LoggerContextVO(LoggerContext paramLoggerContext) {
/* 45 */     this.name = paramLoggerContext.getName();
/* 46 */     this.propertyMap = paramLoggerContext.getCopyOfPropertyMap();
/* 47 */     this.birthTime = paramLoggerContext.getBirthTime();
/*    */   }
/*    */   
/*    */   public LoggerContextVO(String paramString, Map<String, String> paramMap, long paramLong) {
/* 51 */     this.name = paramString;
/* 52 */     this.propertyMap = paramMap;
/* 53 */     this.birthTime = paramLong;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 57 */     return this.name;
/*    */   }
/*    */   
/*    */   public Map<String, String> getPropertyMap() {
/* 61 */     return this.propertyMap;
/*    */   }
/*    */   
/*    */   public long getBirthTime() {
/* 65 */     return this.birthTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     return "LoggerContextVO{name='" + this.name + '\'' + ", propertyMap=" + this.propertyMap + ", birthTime=" + this.birthTime + '}';
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 75 */     if (this == paramObject)
/* 76 */       return true; 
/* 77 */     if (!(paramObject instanceof LoggerContextVO)) {
/* 78 */       return false;
/*    */     }
/* 80 */     LoggerContextVO loggerContextVO = (LoggerContextVO)paramObject;
/*    */     
/* 82 */     if (this.birthTime != loggerContextVO.birthTime)
/* 83 */       return false; 
/* 84 */     if ((this.name != null) ? !this.name.equals(loggerContextVO.name) : (loggerContextVO.name != null))
/* 85 */       return false; 
/* 86 */     if ((this.propertyMap != null) ? !this.propertyMap.equals(loggerContextVO.propertyMap) : (loggerContextVO.propertyMap != null)) {
/* 87 */       return false;
/*    */     }
/* 89 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 94 */     int i = (this.name != null) ? this.name.hashCode() : 0;
/* 95 */     i = 31 * i + ((this.propertyMap != null) ? this.propertyMap.hashCode() : 0);
/* 96 */     i = 31 * i + (int)(this.birthTime ^ this.birthTime >>> 32L);
/*    */     
/* 98 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\LoggerContextVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */