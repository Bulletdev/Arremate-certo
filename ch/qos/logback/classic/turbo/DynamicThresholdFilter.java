/*     */ package ch.qos.logback.classic.turbo;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.core.spi.FilterReply;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.slf4j.MDC;
/*     */ import org.slf4j.Marker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DynamicThresholdFilter
/*     */   extends TurboFilter
/*     */ {
/* 128 */   private Map<String, Level> valueLevelMap = new HashMap<String, Level>();
/* 129 */   private Level defaultThreshold = Level.ERROR;
/*     */   
/*     */   private String key;
/* 132 */   private FilterReply onHigherOrEqual = FilterReply.NEUTRAL;
/* 133 */   private FilterReply onLower = FilterReply.DENY;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 141 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/* 148 */     this.key = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Level getDefaultThreshold() {
/* 157 */     return this.defaultThreshold;
/*     */   }
/*     */   
/*     */   public void setDefaultThreshold(Level paramLevel) {
/* 161 */     this.defaultThreshold = paramLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterReply getOnHigherOrEqual() {
/* 171 */     return this.onHigherOrEqual;
/*     */   }
/*     */   
/*     */   public void setOnHigherOrEqual(FilterReply paramFilterReply) {
/* 175 */     this.onHigherOrEqual = paramFilterReply;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterReply getOnLower() {
/* 185 */     return this.onLower;
/*     */   }
/*     */   
/*     */   public void setOnLower(FilterReply paramFilterReply) {
/* 189 */     this.onLower = paramFilterReply;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMDCValueLevelPair(MDCValueLevelPair paramMDCValueLevelPair) {
/* 196 */     if (this.valueLevelMap.containsKey(paramMDCValueLevelPair.getValue())) {
/* 197 */       addError(paramMDCValueLevelPair.getValue() + " has been already set");
/*     */     } else {
/* 199 */       this.valueLevelMap.put(paramMDCValueLevelPair.getValue(), paramMDCValueLevelPair.getLevel());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 208 */     if (this.key == null) {
/* 209 */       addError("No key name was specified");
/*     */     }
/* 211 */     super.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterReply decide(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 237 */     String str = MDC.get(this.key);
/* 238 */     if (!isStarted()) {
/* 239 */       return FilterReply.NEUTRAL;
/*     */     }
/*     */     
/* 242 */     Level level = null;
/* 243 */     if (str != null) {
/* 244 */       level = this.valueLevelMap.get(str);
/*     */     }
/* 246 */     if (level == null) {
/* 247 */       level = this.defaultThreshold;
/*     */     }
/* 249 */     if (paramLevel.isGreaterOrEqual(level)) {
/* 250 */       return this.onHigherOrEqual;
/*     */     }
/* 252 */     return this.onLower;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\turbo\DynamicThresholdFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */