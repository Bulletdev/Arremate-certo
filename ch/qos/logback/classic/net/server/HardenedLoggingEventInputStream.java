/*    */ package ch.qos.logback.classic.net.server;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.classic.spi.ClassPackagingData;
/*    */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*    */ import ch.qos.logback.classic.spi.LoggerContextVO;
/*    */ import ch.qos.logback.classic.spi.LoggerRemoteView;
/*    */ import ch.qos.logback.classic.spi.LoggingEventVO;
/*    */ import ch.qos.logback.classic.spi.StackTraceElementProxy;
/*    */ import ch.qos.logback.classic.spi.ThrowableProxy;
/*    */ import ch.qos.logback.classic.spi.ThrowableProxyVO;
/*    */ import ch.qos.logback.core.net.HardenedObjectInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.slf4j.helpers.BasicMarker;
/*    */ 
/*    */ 
/*    */ public class HardenedLoggingEventInputStream
/*    */   extends HardenedObjectInputStream
/*    */ {
/*    */   static final String ARRAY_PREFIX = "[L";
/*    */   
/*    */   public static List<String> getWhilelist() {
/* 27 */     ArrayList<String> arrayList = new ArrayList();
/* 28 */     arrayList.add(LoggingEventVO.class.getName());
/* 29 */     arrayList.add(LoggerContextVO.class.getName());
/* 30 */     arrayList.add(LoggerRemoteView.class.getName());
/* 31 */     arrayList.add(ThrowableProxyVO.class.getName());
/* 32 */     arrayList.add(BasicMarker.class.getName());
/* 33 */     arrayList.add(Level.class.getName());
/* 34 */     arrayList.add(Logger.class.getName());
/* 35 */     arrayList.add(StackTraceElement.class.getName());
/* 36 */     arrayList.add(StackTraceElement[].class.getName());
/* 37 */     arrayList.add(ThrowableProxy.class.getName());
/* 38 */     arrayList.add(ThrowableProxy[].class.getName());
/* 39 */     arrayList.add(IThrowableProxy.class.getName());
/* 40 */     arrayList.add(IThrowableProxy[].class.getName());
/* 41 */     arrayList.add(StackTraceElementProxy.class.getName());
/* 42 */     arrayList.add(StackTraceElementProxy[].class.getName());
/* 43 */     arrayList.add(ClassPackagingData.class.getName());
/*    */     
/* 45 */     return arrayList;
/*    */   }
/*    */   
/*    */   public HardenedLoggingEventInputStream(InputStream paramInputStream) throws IOException {
/* 49 */     super(paramInputStream, getWhilelist());
/*    */   }
/*    */   
/*    */   public HardenedLoggingEventInputStream(InputStream paramInputStream, List<String> paramList) throws IOException {
/* 53 */     this(paramInputStream);
/* 54 */     addToWhitelist(paramList);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\server\HardenedLoggingEventInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */