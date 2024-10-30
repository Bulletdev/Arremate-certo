/*     */ package ch.qos.logback.core.encoder;
/*     */ 
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.Layout;
/*     */ import ch.qos.logback.core.OutputStreamAppender;
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import java.nio.charset.Charset;
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
/*     */ public class LayoutWrappingEncoder<E>
/*     */   extends EncoderBase<E>
/*     */ {
/*     */   protected Layout<E> layout;
/*     */   private Charset charset;
/*     */   ContextAware parent;
/*  38 */   Boolean immediateFlush = null;
/*     */   
/*     */   public Layout<E> getLayout() {
/*  41 */     return this.layout;
/*     */   }
/*     */   
/*     */   public void setLayout(Layout<E> paramLayout) {
/*  45 */     this.layout = paramLayout;
/*     */   }
/*     */   
/*     */   public Charset getCharset() {
/*  49 */     return this.charset;
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
/*     */   public void setCharset(Charset paramCharset) {
/*  63 */     this.charset = paramCharset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImmediateFlush(boolean paramBoolean) {
/*  74 */     addWarn("As of version 1.2.0 \"immediateFlush\" property should be set within the enclosing Appender.");
/*  75 */     addWarn("Please move \"immediateFlush\" property into the enclosing appender.");
/*  76 */     this.immediateFlush = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] headerBytes() {
/*  81 */     if (this.layout == null) {
/*  82 */       return null;
/*     */     }
/*  84 */     StringBuilder stringBuilder = new StringBuilder();
/*  85 */     appendIfNotNull(stringBuilder, this.layout.getFileHeader());
/*  86 */     appendIfNotNull(stringBuilder, this.layout.getPresentationHeader());
/*  87 */     if (stringBuilder.length() > 0)
/*     */     {
/*     */ 
/*     */       
/*  91 */       stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     }
/*  93 */     return convertToBytes(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] footerBytes() {
/*  98 */     if (this.layout == null) {
/*  99 */       return null;
/*     */     }
/* 101 */     StringBuilder stringBuilder = new StringBuilder();
/* 102 */     appendIfNotNull(stringBuilder, this.layout.getPresentationFooter());
/* 103 */     appendIfNotNull(stringBuilder, this.layout.getFileFooter());
/* 104 */     return convertToBytes(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   private byte[] convertToBytes(String paramString) {
/* 108 */     if (this.charset == null) {
/* 109 */       return paramString.getBytes();
/*     */     }
/* 111 */     return paramString.getBytes(this.charset);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] encode(E paramE) {
/* 116 */     String str = this.layout.doLayout(paramE);
/* 117 */     return convertToBytes(str);
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public void start() {
/* 125 */     if (this.immediateFlush != null) {
/* 126 */       if (this.parent instanceof OutputStreamAppender) {
/* 127 */         addWarn("Setting the \"immediateFlush\" property of the enclosing appender to " + this.immediateFlush);
/*     */         
/* 129 */         OutputStreamAppender outputStreamAppender = (OutputStreamAppender)this.parent;
/* 130 */         outputStreamAppender.setImmediateFlush(this.immediateFlush.booleanValue());
/*     */       } else {
/* 132 */         addError("Could not set the \"immediateFlush\" property of the enclosing appender.");
/*     */       } 
/*     */     }
/* 135 */     this.started = true;
/*     */   }
/*     */   
/*     */   public void stop() {
/* 139 */     this.started = false;
/*     */   }
/*     */   
/*     */   private void appendIfNotNull(StringBuilder paramStringBuilder, String paramString) {
/* 143 */     if (paramString != null) {
/* 144 */       paramStringBuilder.append(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(ContextAware paramContextAware) {
/* 155 */     this.parent = paramContextAware;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\encoder\LayoutWrappingEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */