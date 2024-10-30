/*    */ package ch.qos.logback.core.recovery;
/*    */ 
/*    */ import ch.qos.logback.core.net.SyslogOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.net.SocketException;
/*    */ import java.net.UnknownHostException;
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
/*    */ public class ResilientSyslogOutputStream
/*    */   extends ResilientOutputStreamBase
/*    */ {
/*    */   String syslogHost;
/*    */   int port;
/*    */   
/*    */   public ResilientSyslogOutputStream(String paramString, int paramInt) throws UnknownHostException, SocketException {
/* 29 */     this.syslogHost = paramString;
/* 30 */     this.port = paramInt;
/* 31 */     this.os = (OutputStream)new SyslogOutputStream(paramString, paramInt);
/* 32 */     this.presumedClean = true;
/*    */   }
/*    */ 
/*    */   
/*    */   String getDescription() {
/* 37 */     return "syslog [" + this.syslogHost + ":" + this.port + "]";
/*    */   }
/*    */ 
/*    */   
/*    */   OutputStream openNewOutputStream() throws IOException {
/* 42 */     return (OutputStream)new SyslogOutputStream(this.syslogHost, this.port);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     return "c.q.l.c.recovery.ResilientSyslogOutputStream@" + System.identityHashCode(this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\recovery\ResilientSyslogOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */