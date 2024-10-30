/*     */ package ch.qos.logback.core;
/*     */ 
/*     */ import ch.qos.logback.core.joran.spi.ConsoleTarget;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ import ch.qos.logback.core.util.EnvUtil;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
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
/*     */ public class ConsoleAppender<E>
/*     */   extends OutputStreamAppender<E>
/*     */ {
/*  40 */   protected ConsoleTarget target = ConsoleTarget.SystemOut;
/*     */ 
/*     */   
/*     */   protected boolean withJansi = false;
/*     */ 
/*     */   
/*     */   private static final String WindowsAnsiOutputStream_CLASS_NAME = "org.fusesource.jansi.WindowsAnsiOutputStream";
/*     */ 
/*     */   
/*     */   public void setTarget(String paramString) {
/*  50 */     ConsoleTarget consoleTarget = ConsoleTarget.findByName(paramString.trim());
/*  51 */     if (consoleTarget == null) {
/*  52 */       targetWarn(paramString);
/*     */     } else {
/*  54 */       this.target = consoleTarget;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTarget() {
/*  65 */     return this.target.getName();
/*     */   }
/*     */   
/*     */   private void targetWarn(String paramString) {
/*  69 */     WarnStatus warnStatus = new WarnStatus("[" + paramString + "] should be one of " + Arrays.toString((Object[])ConsoleTarget.values()), this);
/*  70 */     warnStatus.add((Status)new WarnStatus("Using previously set target, System.out by default.", this));
/*  71 */     addStatus((Status)warnStatus);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  76 */     OutputStream outputStream = this.target.getStream();
/*     */     
/*  78 */     if (EnvUtil.isWindows() && this.withJansi) {
/*  79 */       outputStream = getTargetStreamForWindows(outputStream);
/*     */     }
/*  81 */     setOutputStream(outputStream);
/*  82 */     super.start();
/*     */   }
/*     */   
/*     */   private OutputStream getTargetStreamForWindows(OutputStream paramOutputStream) {
/*     */     try {
/*  87 */       addInfo("Enabling JANSI WindowsAnsiOutputStream for the console.");
/*  88 */       Object object = OptionHelper.instantiateByClassNameAndParameter("org.fusesource.jansi.WindowsAnsiOutputStream", Object.class, this.context, OutputStream.class, paramOutputStream);
/*     */       
/*  90 */       return (OutputStream)object;
/*  91 */     } catch (Exception exception) {
/*  92 */       addWarn("Failed to create WindowsAnsiOutputStream. Falling back on the default stream.", exception);
/*     */       
/*  94 */       return paramOutputStream;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWithJansi() {
/* 101 */     return this.withJansi;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWithJansi(boolean paramBoolean) {
/* 111 */     this.withJansi = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\ConsoleAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */