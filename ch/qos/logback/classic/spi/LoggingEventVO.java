/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import java.io.IOException;
/*     */ import java.io.InvalidObjectException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Marker;
/*     */ import org.slf4j.helpers.MessageFormatter;
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
/*     */ public class LoggingEventVO
/*     */   implements ILoggingEvent, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 6553722650255690312L;
/*     */   private static final int NULL_ARGUMENT_ARRAY = -1;
/*     */   private static final String NULL_ARGUMENT_ARRAY_ELEMENT = "NULL_ARGUMENT_ARRAY_ELEMENT";
/*     */   private static final int ARGUMENT_ARRAY_DESERIALIZATION_LIMIT = 128;
/*     */   private String threadName;
/*     */   private String loggerName;
/*     */   private LoggerContextVO loggerContextVO;
/*     */   private transient Level level;
/*     */   private String message;
/*     */   private transient String formattedMessage;
/*     */   private transient Object[] argumentArray;
/*     */   private ThrowableProxyVO throwableProxy;
/*     */   private StackTraceElement[] callerDataArray;
/*     */   private Marker marker;
/*     */   private Map<String, String> mdcPropertyMap;
/*     */   private long timeStamp;
/*     */   
/*     */   public static LoggingEventVO build(ILoggingEvent paramILoggingEvent) {
/*  65 */     LoggingEventVO loggingEventVO = new LoggingEventVO();
/*  66 */     loggingEventVO.loggerName = paramILoggingEvent.getLoggerName();
/*  67 */     loggingEventVO.loggerContextVO = paramILoggingEvent.getLoggerContextVO();
/*  68 */     loggingEventVO.threadName = paramILoggingEvent.getThreadName();
/*  69 */     loggingEventVO.level = paramILoggingEvent.getLevel();
/*  70 */     loggingEventVO.message = paramILoggingEvent.getMessage();
/*  71 */     loggingEventVO.argumentArray = paramILoggingEvent.getArgumentArray();
/*  72 */     loggingEventVO.marker = paramILoggingEvent.getMarker();
/*  73 */     loggingEventVO.mdcPropertyMap = paramILoggingEvent.getMDCPropertyMap();
/*  74 */     loggingEventVO.timeStamp = paramILoggingEvent.getTimeStamp();
/*  75 */     loggingEventVO.throwableProxy = ThrowableProxyVO.build(paramILoggingEvent.getThrowableProxy());
/*     */ 
/*     */     
/*  78 */     if (paramILoggingEvent.hasCallerData()) {
/*  79 */       loggingEventVO.callerDataArray = paramILoggingEvent.getCallerData();
/*     */     }
/*  81 */     return loggingEventVO;
/*     */   }
/*     */   
/*     */   public String getThreadName() {
/*  85 */     return this.threadName;
/*     */   }
/*     */   
/*     */   public LoggerContextVO getLoggerContextVO() {
/*  89 */     return this.loggerContextVO;
/*     */   }
/*     */   
/*     */   public String getLoggerName() {
/*  93 */     return this.loggerName;
/*     */   }
/*     */   
/*     */   public Level getLevel() {
/*  97 */     return this.level;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 101 */     return this.message;
/*     */   }
/*     */   
/*     */   public String getFormattedMessage() {
/* 105 */     if (this.formattedMessage != null) {
/* 106 */       return this.formattedMessage;
/*     */     }
/*     */     
/* 109 */     if (this.argumentArray != null) {
/* 110 */       this.formattedMessage = MessageFormatter.arrayFormat(this.message, this.argumentArray).getMessage();
/*     */     } else {
/* 112 */       this.formattedMessage = this.message;
/*     */     } 
/*     */     
/* 115 */     return this.formattedMessage;
/*     */   }
/*     */   
/*     */   public Object[] getArgumentArray() {
/* 119 */     return this.argumentArray;
/*     */   }
/*     */   
/*     */   public IThrowableProxy getThrowableProxy() {
/* 123 */     return this.throwableProxy;
/*     */   }
/*     */   
/*     */   public StackTraceElement[] getCallerData() {
/* 127 */     return this.callerDataArray;
/*     */   }
/*     */   
/*     */   public boolean hasCallerData() {
/* 131 */     return (this.callerDataArray != null);
/*     */   }
/*     */   
/*     */   public Marker getMarker() {
/* 135 */     return this.marker;
/*     */   }
/*     */   
/*     */   public long getTimeStamp() {
/* 139 */     return this.timeStamp;
/*     */   }
/*     */   
/*     */   public long getContextBirthTime() {
/* 143 */     return this.loggerContextVO.getBirthTime();
/*     */   }
/*     */   
/*     */   public LoggerContextVO getContextLoggerRemoteView() {
/* 147 */     return this.loggerContextVO;
/*     */   }
/*     */   
/*     */   public Map<String, String> getMDCPropertyMap() {
/* 151 */     return this.mdcPropertyMap;
/*     */   }
/*     */   
/*     */   public Map<String, String> getMdc() {
/* 155 */     return this.mdcPropertyMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareForDeferredProcessing() {}
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 162 */     paramObjectOutputStream.defaultWriteObject();
/* 163 */     paramObjectOutputStream.writeInt(this.level.levelInt);
/* 164 */     if (this.argumentArray != null) {
/* 165 */       int i = this.argumentArray.length;
/* 166 */       paramObjectOutputStream.writeInt(i);
/* 167 */       for (byte b = 0; b < this.argumentArray.length; b++) {
/* 168 */         if (this.argumentArray[b] != null) {
/* 169 */           paramObjectOutputStream.writeObject(this.argumentArray[b].toString());
/*     */         } else {
/* 171 */           paramObjectOutputStream.writeObject("NULL_ARGUMENT_ARRAY_ELEMENT");
/*     */         } 
/*     */       } 
/*     */     } else {
/* 175 */       paramObjectOutputStream.writeInt(-1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 181 */     paramObjectInputStream.defaultReadObject();
/* 182 */     int i = paramObjectInputStream.readInt();
/* 183 */     this.level = Level.toLevel(i);
/*     */     
/* 185 */     int j = paramObjectInputStream.readInt();
/*     */     
/* 187 */     if (j < -1 || j > 128) {
/* 188 */       throw new InvalidObjectException("Argument array length is invalid: " + j);
/*     */     }
/*     */     
/* 191 */     if (j != -1) {
/* 192 */       this.argumentArray = (Object[])new String[j];
/* 193 */       for (byte b = 0; b < j; b++) {
/* 194 */         Object object = paramObjectInputStream.readObject();
/* 195 */         if (!"NULL_ARGUMENT_ARRAY_ELEMENT".equals(object)) {
/* 196 */           this.argumentArray[b] = object;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 204 */     byte b = 31;
/* 205 */     int i = 1;
/* 206 */     i = 31 * i + ((this.message == null) ? 0 : this.message.hashCode());
/* 207 */     i = 31 * i + ((this.threadName == null) ? 0 : this.threadName.hashCode());
/* 208 */     i = 31 * i + (int)(this.timeStamp ^ this.timeStamp >>> 32L);
/* 209 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 214 */     if (this == paramObject)
/* 215 */       return true; 
/* 216 */     if (paramObject == null)
/* 217 */       return false; 
/* 218 */     if (getClass() != paramObject.getClass())
/* 219 */       return false; 
/* 220 */     LoggingEventVO loggingEventVO = (LoggingEventVO)paramObject;
/* 221 */     if (this.message == null) {
/* 222 */       if (loggingEventVO.message != null)
/* 223 */         return false; 
/* 224 */     } else if (!this.message.equals(loggingEventVO.message)) {
/* 225 */       return false;
/*     */     } 
/* 227 */     if (this.loggerName == null) {
/* 228 */       if (loggingEventVO.loggerName != null)
/* 229 */         return false; 
/* 230 */     } else if (!this.loggerName.equals(loggingEventVO.loggerName)) {
/* 231 */       return false;
/*     */     } 
/* 233 */     if (this.threadName == null) {
/* 234 */       if (loggingEventVO.threadName != null)
/* 235 */         return false; 
/* 236 */     } else if (!this.threadName.equals(loggingEventVO.threadName)) {
/* 237 */       return false;
/* 238 */     }  if (this.timeStamp != loggingEventVO.timeStamp) {
/* 239 */       return false;
/*     */     }
/* 241 */     if (this.marker == null) {
/* 242 */       if (loggingEventVO.marker != null)
/* 243 */         return false; 
/* 244 */     } else if (!this.marker.equals(loggingEventVO.marker)) {
/* 245 */       return false;
/*     */     } 
/* 247 */     if (this.mdcPropertyMap == null) {
/* 248 */       if (loggingEventVO.mdcPropertyMap != null)
/* 249 */         return false; 
/* 250 */     } else if (!this.mdcPropertyMap.equals(loggingEventVO.mdcPropertyMap)) {
/* 251 */       return false;
/* 252 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\LoggingEventVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */